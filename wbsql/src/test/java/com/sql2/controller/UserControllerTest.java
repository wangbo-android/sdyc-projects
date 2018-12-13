package com.sql2.controller;

import com.sql2.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void getCredit() throws Exception {

        int userId = 100;
        int expectedCredit = 100;

        given(this.userService.getCredit(userId)).willReturn(100);
        mvc.perform(get("/user/{id}",userId)).andExpect(content().
                string(String.valueOf(expectedCredit)));
    }

    @Test
    public void getFile() throws Exception {

        mvc.perform(multipart("/doc").
                file("file","文件内容".getBytes("UTF-8")));
    }

    @Test
    public void testParam() throws Exception{

        int userId = 10;
        String name = "wangbo";

        mvc.perform(get("/user/{id}/{name}",userId,name).
                param("message","hello"));
    }

    @Test
    public void testCheckBoxParam()throws Exception{

        int userId = 10;
        String name = "wangbo";

        mvc.perform(get("/test/{id}/{name}",userId,name).
                param("job","IT","gov"));
    }

    @Test
    public void testSessionAttribute() throws Exception{

        mvc.perform(get("/session").
                sessionAttr("username","wangbo"));
    }

    @Test
    @Ignore
    public void testGetCookie() throws Exception{

        mvc.perform(get("/cookie").
                cookie(new Cookie("info","lisi")));
    }

    @Test
    public void testReturnResults() throws Exception{

        mvc.perform(get("/return")).andExpect(status().isOk()).
                andExpect(model().attributeExists("number")).
                andExpect(model().attribute("number",10)).
                andExpect(view().name("test"));
    }
}