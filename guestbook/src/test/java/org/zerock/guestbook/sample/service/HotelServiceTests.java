package org.zerock.guestbook.sample.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.zerock.guestbook.sample.sevice.HotelService;

@SpringBootTest
public class HotelServiceTests {

    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelservice;
    
    @Test
    void test() {
        System.out.println("===========");
        System.out.println(hotelservice);
        System.out.println("===========");
    }
}
