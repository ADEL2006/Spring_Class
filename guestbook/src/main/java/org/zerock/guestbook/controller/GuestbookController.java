package org.zerock.guestbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.guestbook.service.GuestbookService;

@RestController
@RequestMapping("/guestbook")
@RequiredArgsConstructor
@Log4j
public class GuestbookController {
    private final GuestbookService guestbookService;
}