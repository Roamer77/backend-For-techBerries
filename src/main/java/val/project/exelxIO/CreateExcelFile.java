package val.project.exelxIO;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;


public class CreateExcelFile {

    private  String fileName="";
    private String reportsFilePath="C:\\Users\\Valiantsin.Vorykhau\\IdeaProjects\\techBarries\\reports\\";
    private String exp=".xls";
    private File file;

    public CreateExcelFile(String fileName) throws IOException {
        this.fileName=fileName;
        file=new File(reportsFilePath+fileName+exp);
        file.createNewFile();
    }

    public File getFile() {
        return file;
    }
}
