package val.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import val.project.MailUtil.MailSenderService;
import val.project.dao.*;
import val.project.dao.daosForTestTables.AlianDao;
import val.project.dao.daosForTestTables.HumanDao;
import val.project.entities.Product;
import val.project.entities.ProductSize;
import val.project.entities.Review;
import val.project.entities.testEntites.Alian;
import val.project.entities.testEntites.AlianFullName;
import val.project.entities.testEntites.Human;
import val.project.forCastomIntegfaces.MyStoredProcedurCaller;
import val.project.services.FillDataBaseByData;
import val.project.services.ImageConvertingService;
import val.project.services.ProductInfoService;
import val.project.testEventSystemInSpring.MyEventPablisher;

import java.util.List;

@EnableScheduling
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    FillDataBaseByData fillDataBaseByData;
    @Autowired
    AlianDao alianDao;
    @Autowired
    AccountDao accountDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ProductSizesDao productSize;
    @Autowired
    ProductCategoriesDao productCategoriesDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    ProductDescriptionDao productDescriptionDao;
    @Autowired
    ReviewDao reviewDao;
    @Autowired
    MyStoredProcedurCaller myStoredProcedurCaller;

    @Autowired
    ImageConvertingService convertingService;

    @Autowired
    HumanDao humanDao;
    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    MailSenderService senderService;
    @Autowired
    EPubBook ePubBook;

    @Autowired
    MyEventPablisher eventPablisher;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        eventPablisher.publishEvent();
        eventPablisher.publishSecondEvent();
    }

  /*  @Override
    public void run(String... arg0) throws Exception {
        //fillDataBaseByData.fillProductCategory();
        //fillDataBaseByData.fillRoleTable();
        //fillDataBaseByData.fillBrandsTable();
        // fillDataBaseByData.fillProductSizeTable();
        // fillDataBaseByData.fillProductDescription();
        ///fillDataBaseByData.fillImages();

       *//* Alian alian=new Alian();
        AlianFullName alianFullName=new AlianFullName();
        alianFullName.setName("Ron");
        alianFullName.setSecondName("Colman");
        alianFullName.setLastName("Jackson");

        alian.setColor("green");
        alian.setFullName(alianFullName);
        alianDao.save(alian);*//*

        //List<ProductSize> tmpSizes=productSize.getAllByLocation("en");
       *//* Product product= new Product();
        product.setName("mane1");
        product.setCost(123124);
        product.setAverageRating(5);
        product.setSimilaritiesIndex(7);
        product.setProductCategories(productCategoriesDao.getById(Long.valueOf(2)));
        product.setImages(imageDao.getById(Long.valueOf(2)));
        product.setProductDescription(productDescriptionDao.getById(Long.valueOf(2)));
        product.setProductSizes(tmpSizes);*//*
       // Product product=(Product) productDao.findAllById(Long.valueOf(62));
        //product.setVendorCode("r144qw23");
       // product.setId(2);
       // productDao.save(product);
       *//* Review review1=new Review();
        review1.setAccount(accountDao.findAllById(1));
        review1.setProduct(productDao.findAllById(62));
        review1.setRating(6);
        review1.setReview_text("не очень хорошее качество товара ");
        review1.setUsefulPoints(2);*//*
     *//*  Review review=reviewDao.findAllById(1);
        review.setUsefulPoints(34);
        System.out.println(review.toString());
        reviewDao.save(review);*//*
     // myStoredProcedurCaller.doChangeCostForProduct(62,1500);

     *//*   AlianFullName alianFullName=new AlianFullName();
        alianFullName.setLastName("ewtr");
        alianFullName.setName("Kek");
        alianFullName.setSecondName("Lol");
        Alian alian=new Alian(alianFullName,"Green");
        alian.setId(89);
        Human human=new Human();
        human.setName("Jine");
        humanDao.save(human);
        alian.setSlavedHuman(human);
        alianDao.save(alian);*//*

     productInfoService.getInfoAboutService("Name1");
    }*/


}
