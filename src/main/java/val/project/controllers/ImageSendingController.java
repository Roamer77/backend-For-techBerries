package val.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import val.project.DTO.ProductFroGridViewToClient;
import val.project.services.ImageConvertingService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageSendingController {
    @Autowired
    ImageConvertingService imageConvertingService;

    @PostMapping("/getSmallImage")
    public String getSmallImage(@RequestParam String productName) {
        imageConvertingService.chooseNecessaryProduct(productName);
        String resData = imageConvertingService.getSmallSizeImage();
        return resData;
    }

    //конвертнуть в json
    @PostMapping("/getListOfBigImage")
    public String getListOfBigImages(@RequestParam String productName) {
        imageConvertingService.chooseNecessaryProduct(productName);
        String result = "";
        Map<String, String> data = imageConvertingService.getListOfBigImages();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(data);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Я уже отправил список больших картинок");
        return "";
    }

    @GetMapping("/getListOfSmallImages")
    public String getListOfSmallImages(@RequestParam int categoryId) {

        String result = "";
        Map<String, String> data = imageConvertingService.getSmallImagesTEST(categoryId);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(data);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }


    @GetMapping("/getListOfSmallImagesByName")
    public String getListOfSmallImagesByName(@RequestParam String name) {

        String result = "";
        Map<String, String> data = imageConvertingService.getSmallImagesByName(name);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            result = objectMapper.writeValueAsString(data);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @PostMapping("/getSmallImagesByCategoryAndSex")
    public  List<ProductFroGridViewToClient> getListOfImagesByCategoryAndSex(@RequestParam String sex, Long categotyId) {
        List<ProductFroGridViewToClient> data = imageConvertingService.getSmallImagesByCategoryAndSex(sex, categotyId);
        return data;
    }
}
