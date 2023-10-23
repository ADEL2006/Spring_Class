package org.zerock.guestbook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.guestbook.entity.GuestbookEntity;

import static org.junit.jupiter.api.Assertions.*;

class GuestbookRepositoryTests {

    @Autowired
    private GuestbookRepository guestbookRepository;

    @Test
    void testInsert(){
        GuestbookEntity guestbookEntity =
                GuestbookEntity.builder()
                        .title("TEST")
                        .content("TEST")
                        .writer("TESTER")
                        .build();

        guestbookRepository.save(guestbookEntity);
    }
}