package org.zerock.guestbook.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.guestbook.dto.Member;
import org.zerock.guestbook.dto.MemberDTO;
import org.zerock.guestbook.service.MemberService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody MemberDTO dto) {
        memberService.register(dto);
        return "";
    }

    @GetMapping("/{mno}")
    
}
