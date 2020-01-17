package val.project.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import val.project.DTO.AdvertisingToClient;
import val.project.services.ImageConvertingService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/advertising")
public class AdvertisingController {
    @Autowired
    ImageConvertingService imageConvertingService;

    @GetMapping(value = "/getAdvertising",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdvertisingToClient> getSimpleAdvertising() {


        List<AdvertisingToClient> data = imageConvertingService.getSimpleAdvertising();
        if(data!=null){
            return data;
        }
        return new ArrayList<>();
    }
}
