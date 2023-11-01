package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;

@SpringBootTest
class GuestbookServiceTests {
    @Autowired
    private GuestbookService guestbookService;

    @Test
    void testRegister() {
        GuestbookDTO guestbookDTO =
        GuestbookDTO.builder()
                .title("Title.......")
                .content("Content.......")
                .writer("Test.......")
                .build();
        guestbookService.register(guestbookDTO);
    }

    @Test
    void testRead() {
        Long gno = 302L;
        GuestbookDTO guestbookDTO =
                guestbookService.read(gno);

        System.out.println("====================");
        System.out.println(guestbookDTO);
        System.out.println("====================");
    }

    @Test
    void testModify() {
        GuestbookDTO guestbookDTO =
                GuestbookDTO.builder()
                        .gno(302L)
                        .title("Update ...... ")
                        .content("Update ....... ")
                        .build();
        guestbookService.modify(guestbookDTO);
    }

    @Test
    void testRemove() {
        Long gno = 302L;
        guestbookService.remove(gno);
    }
}