package org.zerock.guestbook.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfig {
    @Bean
    public School school() {
        return new School();
    }

}


