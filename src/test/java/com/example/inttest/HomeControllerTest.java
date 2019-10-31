package com.example.inttest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HomeControllerTest {

    MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();

    }

    @Test
    public void index() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view().name("index"))
                .andExpect(status().isOk());

    }

    @Test
    public void login() throws Exception {
        mockMvc.perform(post("/login")
                .param("username", "jon")
                .param("password", "123"))
                .andExpect(view().name("index"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("currentuser", "jon"))
                .andDo(print());

    }



}
