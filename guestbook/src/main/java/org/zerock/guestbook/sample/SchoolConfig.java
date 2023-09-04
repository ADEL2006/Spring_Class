package org.zerock.guestbook.sample;

import org.springframework.context.annotation.Bean;

public class SchoolConfig {

    @Bean
    public School school() {
        return new School();
    }
}
