package com.bkc;

import com.bkc.controller.HelloWorldController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class TsedAll {


    @InjectMocks
    private HelloWorldController demoController;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        // initialize mock object
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }

    @Test
    public void test() throws Exception {
        //construct http request and expect response
        this.mockMvc
            .perform(post("/test/hello")
                .accept(MediaType.APPLICATION_JSON)
                .param("userName", "bkc")
                .param("password", "123333123"))
            .andDo(print());
    }


}
