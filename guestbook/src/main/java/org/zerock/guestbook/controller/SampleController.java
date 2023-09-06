package org.zerock.guestbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("")
    public void ex01(){
        log.info(".............ex01" );
    }

    @GetMapping("/ex02")
    public void ex02() {
        log.info(".............ex02" );
    }

    @GetMapping("/ex03/?")
    public void ex03(){
        log.info(".............ex03" );
    }

    @GetMapping("/ex04/*")
    public void ex04(){
        log.info(".............ex04" );
    }

    @GetMapping("/ex05/**")
    public void ex05(){
        log.info(".............ex05" );
    }

    @GetMapping("/ex06/{id}/{name}")
    public void ex06(
            @PathVariable("id") String id,
            @PathVariable("name") String name
    ){
        log.info(".............ex06 id: {}, name: {}", id, name );
    }

    @GetMapping("/ex07")
    public void ex07() {
        log.info(".............ex07");
    }
}
