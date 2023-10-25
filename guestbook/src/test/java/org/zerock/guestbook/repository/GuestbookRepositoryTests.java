package org.zerock.guestbook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.entity.GuestbookEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookRepositoryTests {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    void testInsert() {
//        new GuestbookEntity()
        GuestbookEntity guestbookEntity = GuestbookEntity.builder()
                .title("TEST")
                .content("TEST")
                .writer("TESTER")
                .build();
        guestbookRepository.save(guestbookEntity);
    }

}