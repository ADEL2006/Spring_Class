package org.zerock.guestbook.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchoolConfig {

    @Bean(name = "sch1")
    public School school() {
        return new School();
    }

    @Bean(name = "sch2")
    public School school2() {
        return new School();
    }
}
