package main;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import val.project.Main;
import val.project.dao.UserOrderDao;
import val.project.exelxIO.CreateExcelFile;
import val.project.exelxIO.WritigToExcelFile;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@Transactional
public class CreateExecleFileTest {
    @InjectMocks
    private CreateExcelFile createExcelFile= new CreateExcelFile("file");
    @Autowired
    UserOrderDao userOrderDao;


    @Autowired
    private WritigToExcelFile writigToExcelFile;

    public CreateExecleFileTest() throws IOException {
    }

    @Test
    public void testGetFile(){
        File file= createExcelFile.getFile();

        Assert.assertTrue(file.canRead());
    }

    @Test
    public void organixeExcelFileTest() throws IOException {

            writigToExcelFile.organizeExcelFile();

    }
}
