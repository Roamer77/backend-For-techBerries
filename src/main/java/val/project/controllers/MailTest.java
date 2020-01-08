package val.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import val.project.MailUtil.MailSenderService;

@RestController
@RequestMapping("/mail")
public class MailTest {

    @Autowired
    MailSenderService mailSenderService;
    @GetMapping("/send")
    public  void sendSimpleMail(){


    }
    @GetMapping("/test")
    public  void test(){

        mailSenderService.deleteTrashMails();
    }
}