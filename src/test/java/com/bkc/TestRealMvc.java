package com.bkc;

import com.bkc.controller.HelloWorldController;
import com.bkc.service.GreetingService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/main/webapp")
@ContextConfiguration("classpath:spring-servlet.xml")
public class TestRealMvc {

    private MockMvc mockMvc;

    @Mock
    private GreetingService greetingService;

    @InjectMocks
    HelloWorldController helloWorldController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void test() throws Exception {
        this.mockMvc
            .perform(post("/test/hello")
                .accept(MediaType.APPLICATION_JSON)
                .param("userName", "bkc")
                .param("password", "123333123"))
            .andDo(print());
    }
}
