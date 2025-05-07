package com.jsoft.roomschedule.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.jupiter.api.Assertions.assertNotNull;


@WebMvcTest(UsersController.class)
public class UsersControllerTest {

    @MockitoBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void shouldCreateMvc(){
        assertNotNull(mockMvc);
    }
    @Test
    void shouldReturnGreenting () throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/v1/users/test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello World"))
        ;

    }

}
