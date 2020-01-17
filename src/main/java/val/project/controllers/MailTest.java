package val.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import val.project.MailUtil.MailSenderService;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/mail")
public class MailTest {

    @Autowired
    MailSenderService mailSenderService;
    @GetMapping("/send")
    public  void sendSimpleMail(){
       /* try {
           // mailSenderService.sendDifficultMail();
        } catch (MessagingException e) {
            e.printStackTrace();
        }*/
    }
    @GetMapping("/test")
    public  void test(){


    }
    @GetMapping("/delete")
    public  void delete(){
        mailSenderService.deleteTrashMails();
    }
}
