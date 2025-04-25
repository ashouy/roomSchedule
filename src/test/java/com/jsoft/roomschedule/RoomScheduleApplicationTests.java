package com.jsoft.roomschedule;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class RoomScheduleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void applicationModules () {
        var modules = ApplicationModules.of(RoomScheduleApplication.class).verify();
        new Documenter(modules)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }

}
