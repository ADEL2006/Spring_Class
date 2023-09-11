package org.zerock.guestbook.sample.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.sample.service.HotelService;


@SpringBootTest
class HotelServiceTests {
    @Qualifier("hotelServiceImplV2")
    @Autowired
    private HotelService hotelService;

    @Test
    void test() {
        System.out.println("============");
        System.out.println(hotelService);
        System.out.println("============");
    }

}