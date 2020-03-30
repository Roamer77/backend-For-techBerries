package val.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import val.project.DTO.AdvertisingToClient;
import val.project.DTO.ProductFroGridViewToClient;
import val.project.dao.AdvertisingDAO;
import val.project.dao.ImageDao;
import val.project.dao.ProductCategoriesDao;
import val.project.dao.ProductDao;
import val.project.entities.Advertising;
import val.project.entities.Images;
import val.project.entities.Product;
import val.project.entities.ProductCategories;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

@Service
public class ImageConvertingService {
    private Logger logger = Logger.getLogger(ImageConvertingService.class.getName());

    @Autowired
    ProductDao productDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    ProductCategoriesDao productCategoriesDao;

    @Autowired
    AdvertisingDAO advertisingDao;

    private Product product;

    private ByteArrayInputStream inputStream;

    private BufferedImage decodeImage;


    private final String fileFolder = "resources/";

    private String convertImageToBase64String(String imageName) {

        String imageUrl = getAbsolutePathToFile(fileFolder, imageName);

        BufferedImage image;
        File fileName = new File(imageUrl);
        ByteArrayOutputStream imageInByts = new ByteArrayOutputStream();

        byte[] bytes;
        try {
            image = ImageIO.read(fileName);
            ImageIO.write(image, "jpg", imageInByts);
            image.flush();
            bytes = imageInByts.toByteArray();
            imageInByts.close();

            String res = Base64.getEncoder().encodeToString(bytes);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Пусто";
    }

    public void chooseNecessaryProduct(String productName) {
        this.product = productDao.myFindProductByName(productName);
    }

    private String getSmallSizeImageURl() {
        String imageSizeSmall1Url = product.getImages().getSmallSizeImage();
        return imageSizeSmall1Url;
    }

    private List<String> getBigSizeImageURLs() {
        String imageBigSizeUrl1 = product.getImages().getBigSizeImage1();
        String imageBigSizeUrl2 = product.getImages().getBigSizeImage2();
        String imageBigSizeUrl3 = product.getImages().getBigSizeImage3();
        List<String> resData = new ArrayList<>();
        Collections.addAll(resData, imageBigSizeUrl1, imageBigSizeUrl2, imageBigSizeUrl3);
        return resData;
    }

    private List<String> getAllSmallImagesURLs(ProductCategories productCategories) {
        List<Product> images = productDao.findAllByProductCategories(productCategories);
        List<String> resData = new ArrayList<>();
        for (Product image : images) {
            resData.add(image.getImages().getSmallSizeImage());
        }
        return resData;
    }

    //придумать нориальное название
    private Map<String, String> getFullInfo_test(ProductCategories productCategories) {
        Map<String, String> res = new HashMap<>();
        List<Product> images = productDao.findAllByProductCategories(productCategories);
        for (int i = 0; i < images.size(); i++) {
            res.put(images.get(i).getName(), convertImageToBase64String(images.get(i).getImages().getSmallSizeImage()));//ёюаный ад переписать
        }
        return res;
    }

    private Map<String, String> getImagesByName(String name) {
        Map<String, String> res = new HashMap<>();
        List<Product> images = productDao.findAllByNameContainingIgnoreCase(name);

        for (int i = 0; i < images.size(); i++) {
            res.put(images.get(i).getName(), convertImageToBase64String(images.get(i).getImages().getSmallSizeImage()));//ёюаный ад переписать
        }
        return res;
    }

    private List<AdvertisingToClient> makeSimpleAdvertising() {

        List<Advertising> images = advertisingDao.findAll();
        List<AdvertisingToClient> res = new ArrayList<>();

        AdvertisingToClient advertisingToClient = new AdvertisingToClient();

        for (int i = 0; i < images.size(); i++) {
           /* advertisingToClient.setId(images.get(i).getId());
            advertisingToClient.setAdvImage(convertImageToBase64String(images.get(i).getImageName()));*/
            res.add(new AdvertisingToClient(images.get(i).getId(), convertImageToBase64String(images.get(i).getImageName())));

        }
        System.out.println("reclamme" + res.toString());
        return res;
    }

    private Map<String, String> convertListOfBigSizeImagesInBase64(List<String> urls, String jsonNameForImage) {
        List<String> tmpListOfUrls = urls;
        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < tmpListOfUrls.size(); i++) {
            data.put(jsonNameForImage + i, convertImageToBase64String(tmpListOfUrls.get(i)));
        }
        logger.info("Преобразование в base64 закончено");
        return data;
    }

    private List<ProductFroGridViewToClient> makeSmallImagesByCategoryAndSex(String sex, Long categotyId) {
        Map<String, String> res = new HashMap<>();
        List<Product> images = productDao.customfindAll(sex, categotyId);
        List<ProductFroGridViewToClient> resultData = new ArrayList<>();

        for (int i = 0; i < images.size(); i++) {
            ProductFroGridViewToClient tmpProd = new ProductFroGridViewToClient();
            tmpProd.setName(images.get(i).getName());
            tmpProd.setCost(images.get(i).getCost());
            tmpProd.setImage(convertImageToBase64String(images.get(i).getImages().getSmallSizeImage()));
            resultData.add(tmpProd);
        }
        return resultData;
    }

    public Map<String, String> getListOfBigImages() {
        return convertListOfBigSizeImagesInBase64(getBigSizeImageURLs(), "big");
    }

    public String getSmallSizeImage() {
        return convertImageToBase64String(getSmallSizeImageURl());
    }

    public Map<String, String> getSmallImagesByCategory(int categoryId) {
        ProductCategories productCategory = productCategoriesDao.getById(categoryId);
        return convertListOfBigSizeImagesInBase64(getAllSmallImagesURLs(productCategory), "small");
    }

    public List<ProductFroGridViewToClient> getSmallImagesByCategoryAndSex(String sex, Long categotyId) {
        return makeSmallImagesByCategoryAndSex(sex, categotyId);
    }

    //тестовый
    public Map<String, String> getSmallImagesTEST(int categoryId) {
        ProductCategories productCategory = productCategoriesDao.getById(categoryId);

        return getFullInfo_test(productCategory);
    }

    public Map<String, String> getSmallImagesByName(String name) {

        return getImagesByName(name);
    }

    public List<AdvertisingToClient> getSimpleAdvertising() {
        return makeSimpleAdvertising();
    }


    public String getAbsolutePathToFile(String fileFolder, String fileName) {
        Path pasth = Paths.get(fileFolder + fileName);
        Path res = pasth.toAbsolutePath();
        String uri = res.toString().replace("\\", "\\\\");
        System.out.println(uri);
        return uri;
    }

    public String createImageFromBase64(String data, String imgName,int imgNumber, boolean bigOrSmall) {

        String smallImageName= imgName  + ".1" + "_small" + ".jpg";
        String bigImageName=imgName  + ".1" + "_big"+imgNumber+ ".jpg";

        File smallImage = new File("C:\\Users\\Valiantsin.Vorykhau\\IdeaProjects\\techBarries\\resources\\" + imgName  + ".1" + "_small" + ".jpg");
        File bigImage = new File("C:\\Users\\Valiantsin.Vorykhau\\IdeaProjects\\techBarries\\resources\\" + imgName  + ".1" + "_big"+imgNumber+ ".jpg");

        try {
                byte[] decodeImageByts = Base64.getDecoder().decode(data);
                inputStream = new ByteArrayInputStream(decodeImageByts);
                decodeImage = ImageIO.read(inputStream);

                if(bigOrSmall){
                    writeImage(smallImage);
                    return smallImage.getName();
                }else {
                    writeImage(bigImage);
                    return bigImage.getName();
                }

        } catch (IOException e) {
            logger.warning("Ошибка при создании картинки из Base64" + " в классе ImageConvertingService в методе crateImageFromBase64 207 строка ");
        }
        return null;
    }
    private void writeImage(File file) throws IOException {
        ImageIO.write(decodeImage, "jpg", file);
        decodeImage.flush();
        inputStream.close();
    }
}
