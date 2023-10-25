package org.zerock.guestbook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.entity.GuestbookEntity;

import java.util.Optional;
import java.util.stream.IntStream;

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

    @Test
    void testInsertDummies() {
        IntStream
                .rangeClosed(1, 300)
                .forEach(i -> {
                    GuestbookEntity guestbookEntity = GuestbookEntity.builder()
                            .title("title...." + i)
                            .content("content...." + i)
                            .writer("user" + (i % 10))
                            .build();
                    guestbookRepository.save(guestbookEntity);
                });
    }

    @Test
    void testUpdate() {
        Long gno = 300L;
        Optional<GuestbookEntity> result =
                guestbookRepository.findById(gno);
        if(result.isPresent()){
            GuestbookEntity guestbookEntity =
                    result.get();
            guestbookEntity.changeTitle("update...");
            guestbookEntity.changeContent("update");
            guestbookRepository.save(guestbookEntity);
        }
    }
}