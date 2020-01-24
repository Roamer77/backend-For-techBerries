package main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;
import val.project.Main;
import val.project.controllers.InfoAboutProductController;
import val.project.dao.AdvertisingDAO;
import val.project.dao.ImageDao;
import val.project.dao.ProductCategoriesDao;
import val.project.dao.ProductDao;
import val.project.services.ImageConvertingService;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@Transactional
@AutoConfigureMockMvc
public class InfoAboutProductControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InfoAboutProductController controller;

    @Autowired
    @Mock
    private ImageConvertingService convertingService;


    @Test
    public  void test() throws Exception {
        mockMvc.perform(get("/productInfo/info?productName=Ked1")).andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public  void loginTest() throws Exception{
        mockMvc.perform(get("/logout")).andDo(print())
                .andExpect(status().is3xxRedirection()).andExpect(redirectedUrl("/autharization/logoutSuccess"));
    }
    @Test
    public  void orderMakeTest() throws Exception{
        mockMvc.perform(post("/order/makeOrder")).andDo(print())
                .andExpect(status().is4xxClientError()).andExpect(redirectedUrl("/autharization/auth"));
    }
    @Test
    public  void correctLoginTest() throws Exception{
        mockMvc.perform(formLogin().user("user").password("password")).andDo(print());
    }
    @Test
    public  void tryVarify() throws  Exception{
        System.out.println(convertingService.getSimpleAdvertising());
    }

}
