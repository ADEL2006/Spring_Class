package org.zerock.guestbook.sample;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Restaurant {

    @Autowired
    private Chef chef;
}
