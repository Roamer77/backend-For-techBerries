package val.project.MailUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import val.project.dao.MailQueueDao;
import val.project.dao.UserOrderDao;
import val.project.entities.MailQueue;
import val.project.entities.UserOrder;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private UserOrderDao userOrderDao;
    @Autowired
    private MailQueueDao mailQueueDao;

    private List<MailQueue> notSendMails;

    public void sendSimpleMail() {
        String subject="test SpringBoot mailing";
        String text="Simple text for testing this shit";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        List<String> mails=getMails();
        for(int i=0;i<mails.size();i++){
            mailMessage.setTo(mails.get(i));
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            //emailSender.send(mailMessage);
            System.out.println("Отправил письмо на "+mails.get(i) +" (Откоментить в MailSender строку с отправкой писем)");
        }
        changeMailStatus();

    }

    private List<String> getMails (){
        notSendMails=mailQueueDao.findByMainStatus(2);
        List<String> mails=new ArrayList<>();
        notSendMails.forEach(s->mails.add(s.getUserOrder().getAccount().getMail()) );
        System.out.println("Mails to which it want to send latter: "+mails.toString());
        return mails;
    }

    private void  changeMailStatus(){
        for (int i=0;i<notSendMails.size();i++){
            notSendMails.get(i).setMainStatus(1);
        }
        mailQueueDao.saveAll(notSendMails);
    }
    public void deleteTrashMails(){
       long numberOfTrashMails= mailQueueDao.countAllByMainStatus(1);
       if(numberOfTrashMails>4){

       }
    }
}
