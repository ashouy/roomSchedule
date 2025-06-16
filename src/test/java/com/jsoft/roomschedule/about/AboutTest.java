package com.jsoft.roomschedule.about;

import com.jsoft.roomschedule.jwt.SystemUserAuthFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@WebMvcTest(AboutController.class)

public class AboutTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SystemUserAuthFilter userAuthFilter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void shouldCreateMvc(){
        assertNotNull(mockMvc);
    }
        @Test
        void shouldReturnVersion () throws Exception {
                this.mockMvc
                        .perform(MockMvcRequestBuilders.get("/api/about/version"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.content().string("v1"))
                        ;


        }
}
