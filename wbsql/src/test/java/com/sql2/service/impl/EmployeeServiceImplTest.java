package com.sql2.service.impl;

import com.sql2.entity.Puser;
import com.sql2.service.CreditSystemService;
import com.sql2.service.EmplyeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class EmployeeServiceImplTest {

    private static final Log log = LogFactory.
            getLog(EmployeeServiceImplTest.class);

    @Autowired
    private EmplyeeService es;

    @MockBean
    private CreditSystemService css;

    @Before
    public void setUp() throws Exception {

        log.info("测试方法之前调用");
    }

    @After
    public void tearDown() throws Exception {

        log.info("测试方法之后调用");
    }

    @Test
    public void findUser() throws Exception {

        Puser puser = new Puser();
        puser.setName("王博");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2018-07-23");
        puser.setCreateTime(date);
        puser.setDepartmentId(1001);

        assertEquals("the same",es.findPuser("王博",1001)
                ,puser);
    }

    @Test
    public void saveEmp() throws Exception{

        given(this.css.getUserCredit(anyInt())).willReturn(100);

        assertEquals(100,100);
    }

}