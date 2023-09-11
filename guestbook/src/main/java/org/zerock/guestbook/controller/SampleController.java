package org.zerock.guestbook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.zerock.guestbook.dto.SampleDTO;

// localhost:8080/sample
@RestController // @Controller + @ResponseBody
@Slf4j
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("")
    public void ex01() {
        log.info(".............ex01");
    }

    //  Get : localhost:8080/sample/ex02
    @GetMapping("/ex02")
    public void ex02() {
        log.info(".............ex02");
    }

    //locahost:8080/sample/ex03/1
    @GetMapping("/ex03/?")
    public void ex03() {
        log.info(".............ex03");
    }

    @GetMapping("/ex04/*")
    public void ex04() {
        log.info(".............ex04");
    }

    @GetMapping("/ex05/**")
    public void ex05() {
        log.info(".............ex05");
    }

    // GET : localhost:8080/sample/ex06/MEMBER ID
    @GetMapping("/ex06/{id}/{name}")
    public void ex06(
            @PathVariable("id") String id,
            @PathVariable("name") String name
    ) {
        log.info(".............ex06 id : {}, name : {}", id, name);
    }

// GET localhost:8080/sample/ex07?name=kim&id=test&age=20
    @GetMapping("/ex07")
    public void ex07(
            @RequestParam("name") String name,
            @RequestParam("age") int age
            ) {
        log.info(".............ex07 name: {}, age: {}", name, age);
    }

// /sample/ex08?name=kim&age=20
    @GetMapping("/ex08")
    public void ex08(SampleDTO sampleDTO){
        log.info(".............ex08: {}", sampleDTO);
    }

}
