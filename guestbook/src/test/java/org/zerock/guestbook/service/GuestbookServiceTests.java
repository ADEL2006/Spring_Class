package org.zerock.guestbook.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.GuestbookEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GuestbookServiceTests {
    @Autowired
    private GuestbookService guestbookService;

    @Test
    void testRegister() {
        GuestbookDTO guestbookDTO = GuestbookDTO.builder()
                .title("Title .......")
                .content("Content ........")
                .writer("Test .......")
                .build();
        guestbookService.register(guestbookDTO);
    }

    @Test
    void testRead() {
        Long gno = 303L;
        GuestbookDTO guestbookDTO
                = guestbookService.read(gno);
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

    @Test
    void testGetList() {
        PageRequestDTO pageRequestDTO
                = new PageRequestDTO();
        pageRequestDTO.setPage(1);
        pageRequestDTO.setSize(100);
        PageResultDTO<GuestbookDTO, GuestbookEntity> result = guestbookService.getList(pageRequestDTO);

        System.out.println(result);
        System.out.println("=========================================================");
        result.getDtoList().forEach(dto -> {
            System.out.println(dto);
        });

    }


}