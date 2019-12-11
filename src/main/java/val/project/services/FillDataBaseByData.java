package val.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import val.project.dao.*;
import val.project.entities.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Service
public class FillDataBaseByData {
    @Autowired
    ProductCategoriesDao productCategoriesDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    ProductSizesDao productSizesDao;
    @Autowired
    ProductDescriptionDao productDescriptionDao;
    @Autowired
    BrandDao brandDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    ProductDao productDao;

    private Logger logger;
    public void fillProductCategory() {
        ProductCategories productCategories = new ProductCategories();
        productCategories.setCategoryName("sneakers");
        ProductCategories productCategories1 = new ProductCategories();
        productCategories1.setCategoryName("jackets");
        productCategoriesDao.save(productCategories);
        productCategoriesDao.save(productCategories1);
        productCategoriesDao.flush();
    }

    public void fillRoleTable() {
        Role role = new Role("Admin");
        Role role1 = new Role("User");
        roleDao.save(role);
        roleDao.save(role1);
        roleDao.flush();
    }

    public void fillProductSizeTable() {
        ProductSize productSize = new ProductSize(12, "US");
        ProductSize productSize1 = new ProductSize(11, "US");
        ProductSize productSize2 = new ProductSize(9, "US");
        ProductSize productSize3 = new ProductSize(43, "RU");
        ProductSize productSize4 = new ProductSize(44, "RU");
        ProductSize productSize5 = new ProductSize(42, "RU");
        List<ProductSize> productSizes = new ArrayList<>();
        Collections.addAll(productSizes, productSize, productSize1, productSize2, productSize3, productSize4, productSize5);
        productSizesDao.saveAll(productSizes);
        productSizesDao.flush();
    }

    public void fillProductDescription() {


        ProductDescription productDescription = new ProductDescription("leather", "12", "M", "demi");
        ProductDescription productDescription1 = new ProductDescription("plastic", "10", "FM", "summer");
        productDescriptionDao.save(productDescription);
        productDescriptionDao.save(productDescription1);
        productDescriptionDao.flush();
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review());
        List<ProductSize> productSizes = new ArrayList<>();

    }

    public void fillBrandsTable() {
        Brand brand = new Brand("Vans", "USA", "Vietnam", "Address_1");
        Brand brand1 = new Brand("Converse", "USA", "Vietnam", "Address_2");
        Brand brand3 = new Brand("GreesGar", "Greece", "Greece", "Address_3");
        brandDao.save(brand);
        brandDao.save(brand1);
        brandDao.save(brand3);

        List<Brand> brands1 = new ArrayList<>();
        List<Brand> brands2 = new ArrayList<>();
        Collections.addAll(brands1, brand1, brand);
        Collections.addAll(brands2, brand, brand3);
        brandDao.flush();
    }

    public void fillProducts() {

        Product product2 = new Product();
        product2.setName("Кеды1");
        product2.setCost(234);
        productDao.save(product2);
        productDao.flush();
    }

    public void fillImages() {
        try {
            logger=Logger.getLogger(FillDataBaseByData.class.getName());

            String pathToFile = "C:\\Users\\Valiantsin.Vorykhau\\IdeaProjects\\tryBase64withImages\\resources\\ic_flag.png";
            String  pathToSmallImage="C:\\Users\\Valiantsin.Vorykhau\\IdeaProjects\\techBarries\\resources\\product_img1.jpg";
            String res = convertImageToBase64(pathToFile);
            String smallImage=convertImageToBase64(pathToSmallImage);
            logger.info("Длинна res="+res.length());
            logger.info("Длинна smallImage="+smallImage.length());
            Images image1=new Images(res,smallImage);

            imageDao.save(image1);
            imageDao.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convertImageToBase64(String pathToImage) throws IOException {
        BufferedImage image;
        File fileName = new File(pathToImage);
        ByteArrayOutputStream imageInByts = new ByteArrayOutputStream();
        byte[] bytes;

        image = ImageIO.read(fileName);
        ImageIO.write(image, "jpg", imageInByts);
        image.flush();
        bytes = imageInByts.toByteArray();
        imageInByts.close();
        String res = Base64.getEncoder().encodeToString(bytes);
        return res;
    }
}
