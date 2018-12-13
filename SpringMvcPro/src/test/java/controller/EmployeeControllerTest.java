package controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration()
@ContextConfiguration(locations = {"classpath*:/controller/springmvc-test.xml"})
public class EmployeeControllerTest {
//"file:/SpringMvcPro/web/WEB-INF/config/springmvc-configuration.xml"
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void inputEmp() throws Exception {

        mockMvc.perform(get("/input-emp"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("emp"))
                .andDo(print());
    }

    @Test
    public void addEmp() throws Exception {

        mockMvc.perform(get("/input-emp"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("emp"))
                .andDo(print());
    }

}