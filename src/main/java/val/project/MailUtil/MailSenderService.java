package val.project.MailUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import val.project.dao.MailQueueDao;
import val.project.dao.UserOrderDao;
import val.project.entities.Accounts;
import val.project.entities.MailQueue;
import val.project.entities.Product;
import val.project.entities.UserOrder;

import org.springframework.data.domain.Pageable;
import val.project.services.ImageConvertingService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Configuration
public class MailSenderService {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private UserOrderDao userOrderDao;
    @Autowired
    private MailQueueDao mailQueueDao;

    @Autowired
    private ImageConvertingService imageConvertingService;
    @Autowired
    private SpringTemplateEngine springTemplateEngine;


    private int pageNumber = 0;
    private long maxPageNumber = 2;

    @Transactional
    public void sendSimpleMail() throws MessagingException {

        countMaxPageNumber();

        Pageable page = PageRequest.of(pageNumber, 10);
        List<MailQueue> mailsToSend = mailQueueDao.findAllByMainStatus(2, page);
        List<String> mails = new ArrayList<>();
        List<String> userAddresses=new ArrayList<>();
        List<UserOrder> userOrders=new ArrayList<>();

        for (int i = 0; i < mailsToSend.size(); i++) {
            List<Product> products = mailsToSend.get(i).getUserOrder().getProducts();

            Context context = new Context();
            context.setVariable("title", "Сообзение от магазина TechBarries");
            context.setVariable("description", "Список товаров в вашем заказе");
            context.setVariable("products", products);

            String mail=springTemplateEngine.process("mail/Mail", context);
            mails.add(mail);
            userAddresses.add(mailsToSend.get(i).getUserOrder().getAccount().getMail());
            userOrders.add(mailsToSend.get(i).getUserOrder());
        }

        for(int i=0;i<mails.size();i++){
            MimeMessage mail = emailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mail, true);
            mimeMessageHelper.setTo(userAddresses.get(i));
            mimeMessageHelper.setSubject("Сообзение от магазина TechBarries");
            mimeMessageHelper.setText(mails.get(i), true);
            List<String> images=makeImageUrlsForUserOrder(userOrders.get(i));
            List<Product> products=userOrders.get(i).getProducts();
            for(int j=0;j<products.size();j++){
                mimeMessageHelper.addInline(products.get(j).getImages().getSmallSizeImage(),new File(images.get(j)));
            }
            emailSender.send(mail);
            System.out.println("Очередное письмо отправвлено на почту к: "+ userAddresses.get(i));
        }


        List<MailQueue> notSendMails = mailQueueDao.findAllByMainStatus(2, PageRequest.of(pageNumber, 10));
        changeMailStatus(notSendMails);


        if (pageNumber >= maxPageNumber) {
            pageNumber = 0;
        } else {
            pageNumber += 1;
        }

    }

    private  List<String> makeImageUrlsForUserOrder(UserOrder userOrder){
        List<Product> products = userOrder.getProducts();
        List<String> images = getListURLOfImages(products);
        return images;
    }



    private void changeMailStatus(List<MailQueue> notSendMails) {
        for (int i = 0; i < notSendMails.size(); i++) {
            notSendMails.get(i).setMainStatus(1);
        }
        mailQueueDao.saveAll(notSendMails);
    }

    public void deleteTrashMails() {
        int statusId = 1;
        long numberOfTrashMails = mailQueueDao.countAllByMainStatus(statusId);
        System.out.println("Сколько нужно удалить " + numberOfTrashMails);
        if (numberOfTrashMails > 10) {
            mailQueueDao.deleteMailQueuesByMainStatus(statusId);
            mailQueueDao.flush();
        }
    }

    private long countMaxPageNumber() {
        //2 status of mail that need to send
        maxPageNumber = mailQueueDao.countAllByMainStatus(2) / 10;
        System.out.println("Количества maxPageNumber= " + maxPageNumber);
        return maxPageNumber;
    }


    private List<String> getListURLOfImages(List<Product> products) {
        List<String> data = new ArrayList<>();
        String fileFolder = "resources/";
        for (int i = 0; i < products.size(); i++) {
            String filename = products.get(i).getImages().getSmallSizeImage();
            String fullPath = imageConvertingService.getAbsolutePathToFile(fileFolder, filename);
            data.add(fullPath);
        }
        return data;
    }



}
