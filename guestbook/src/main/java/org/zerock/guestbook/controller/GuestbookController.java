package org.zerock.guestbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.service.GuestbookService;

@RestController
@RequestMapping("/guestbook")
@RequiredArgsConstructor
@Log4j
public class GuestbookController {
    private final GuestbookService guestbookService;

    @GetMapping("/{gno}")
    public GuestbookDTO read(@PathVariable("gno") Long gno){
        return guestbookService.read(gno);
    }

    @GetMapping("/list")
    public ResponseEntity<PageResultDTO> getList(PageRequestDTO pageRequestDTO) {
        return ResponseEntity.ok(guestbookService.getList(pageRequestDTO));

    }
}
