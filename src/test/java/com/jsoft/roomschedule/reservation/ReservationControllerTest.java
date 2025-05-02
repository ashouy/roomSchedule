package com.jsoft.roomschedule.reservation;

import com.jsoft.roomschedule.reservations.ReservationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationControllerTest {

        @Autowired
        private ReservationController reservationController;

        @LocalServerPort
        private int port;

        @Autowired
        private TestRestTemplate restTemplate;

        @Test
        public void contextLoads() throws Exception {
            assertThat(reservationController).isNotNull();
        }
        @Test
        void greetingShouldReturnDefaultMessage() throws Exception {
            assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/api/v1/reservations/test",
                    String.class)).contains("Hello World");
        }
}
