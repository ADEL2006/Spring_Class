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
}