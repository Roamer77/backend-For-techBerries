package val.project.MailUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import val.project.dao.MailQueueDao;

import javax.mail.MessagingException;

@Service
public class TaskManager {

    @Autowired
    MailSenderService sendSimpleMail;
    @Autowired
    MailQueueDao mailQueueDao;

    @Scheduled(initialDelay = 6*1000, fixedDelay =  10 * 1000)
    public void testDelay() {
        if(areThereAnyMailtoSend()){
            try {
                sendSimpleMail.sendSimpleMail();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Нет писем на отправку");
            sendSimpleMail.deleteTrashMails();
        }
    }

    private boolean areThereAnyMailtoSend() {
        long counter = mailQueueDao.countAllByMainStatus(2);
        if (counter > 0) {
            return true;
        }
        return false;
    }
}
