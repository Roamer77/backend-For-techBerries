package val.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import val.project.dao.ProductDao;
import val.project.entities.Product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

@Service
public class ImageConvertingService {
    private Logger logger = Logger.getLogger(ImageConvertingService.class.getName());

    @Autowired
    ProductDao productDao;

    private Product product;

    private String convertImageToBase64String(String url) {
        BufferedImage image;
        File fileName = new File(url);
        ByteArrayOutputStream imageInByts = new ByteArrayOutputStream();

        byte[] bytes;
        try {
            image = ImageIO.read(fileName);
            ImageIO.write(image, "png", imageInByts);
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

    private Map<String,String> convertListOfBigSizeImagesInBase64(List<String> urls) {
        List<String> tmpListOfUrls = urls;
        Map<String,String> data = new HashMap<>();
        for (int i = 0; i < tmpListOfUrls.size(); i++) {
            data.put("big "+i,convertImageToBase64String(tmpListOfUrls.get(i)));
        }
        logger.info("Преобразование в base64 закончено");
        return data;
    }


    public Map<String,String> getListOfBigImages() {
        return convertListOfBigSizeImagesInBase64(getBigSizeImageURLs());
    }
    public  String getSmallSizeImage(){
        return convertImageToBase64String(getSmallSizeImageURl());
    }
}
