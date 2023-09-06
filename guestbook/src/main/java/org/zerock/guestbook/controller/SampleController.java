package org.zerock.guestbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("")
    public void ex01() {
        log.info(".........ex1");
    }
}
