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

    // C
    // localhost:8080/member/
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String register(@RequestBody MemberDTO dto) {
        memberService.register(dto);
        return "CREATE OK";
    }

    // R
    // localhost:8080/member/1
    @GetMapping("/{mno}")
    public MemberDTO read(@PathVariable("mno") Long mno) {
        MemberDTO memberDTO = memberService.read(mno);
        return memberDTO;
    }

    // U
    @PutMapping("")
    public String modify(@RequestBody MemberDTO dto) {
        memberService.modify(dto);
        return "UPDATE OK";
    }

    // D
    @DeleteMapping("/{mno}")
    public void remove(@PathVariable("mno") Long mno) {
        memberService.remove(mno);
    }
}
