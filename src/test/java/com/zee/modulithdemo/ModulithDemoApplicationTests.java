package com.zee.modulithdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class ModulithDemoApplicationTests {

    @Test
    void contextLoads() {
        ApplicationModules.of(ModulithDemoApplication.class).verify();
    }

}
