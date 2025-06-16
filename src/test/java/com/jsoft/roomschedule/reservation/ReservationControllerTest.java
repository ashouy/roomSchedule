package com.jsoft.roomschedule.reservation;

import com.jsoft.roomschedule.jwt.SystemUserAuthFilter;
import com.jsoft.roomschedule.reservations.ReservationController;
import com.jsoft.roomschedule.reservations.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

        @MockitoBean
        private ReservationService reservationService ;

        @MockitoBean
        private SystemUserAuthFilter userAuthFilter;

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private WebApplicationContext webApplicationContext;

        @Test
        void shouldCreateMvc(){
                assertNotNull(mockMvc);
        }
//        @Test
//        void shouldReturnGreenting () throws Exception {
//                this.mockMvc
//                        .perform(MockMvcRequestBuilders.get("/api/v1/reservations/test"))
//                        .andExpect(MockMvcResultMatchers.status().isOk())
//                        .andExpect(MockMvcResultMatchers.content().string("Hello World"))
//                        ;
//
//
//        }

}
