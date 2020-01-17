package val.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import val.project.exelxIO.CreateExcelFile;
import val.project.exelxIO.WritigToExcelFile;

import java.io.IOException;

@RestController
@RequestMapping("/write")
public class WriteToExcel {



    @Autowired
    WritigToExcelFile writeToExcelFile;

    @GetMapping("/do")
    public  void doWrite(){

    }

    @GetMapping("/create")
    public  void createFile(){
        try {

            writeToExcelFile.organizeExcelFile();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
