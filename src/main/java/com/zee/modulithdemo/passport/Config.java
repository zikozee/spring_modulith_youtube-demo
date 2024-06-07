package com.zee.modulithdemo.passport;

import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 07 Jun, 2024
 */

@Configuration
public class Config {

    @Bean
    public Faker faker(){
        return new Faker();
    }
}
