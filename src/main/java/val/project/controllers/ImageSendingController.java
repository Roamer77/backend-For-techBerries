package val.project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import val.project.services.ImageConvertingService;

import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageSendingController {
    @Autowired
    ImageConvertingService imageConvertingService;

    @PostMapping("/getSmallImage")
    public String getSmallImage(@RequestParam String productName){
        imageConvertingService.chooseNecessaryProduct(productName);
        String resData=imageConvertingService.getSmallSizeImage();
        return resData;
    }

    //конвертнуть в json
    @PostMapping("/getListOfBigImage")
    public String getListOfBigImages(@RequestParam String productName){
        imageConvertingService.chooseNecessaryProduct("Name1");
        String result="";
        Map<String,String> data=imageConvertingService.getListOfBigImages();

        ObjectMapper objectMapper=new ObjectMapper();
        try {
            result=objectMapper.writeValueAsString(data);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  "";
    }
}
