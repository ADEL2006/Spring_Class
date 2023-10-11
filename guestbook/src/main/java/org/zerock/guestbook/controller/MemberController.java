package org.zerock.guestbook.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.guestbook.dto.Member;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {
    private Map<String, Member> userMap;

    @PostConstruct
    public void init() {
        log.info("............... init()");
        userMap = new HashMap<>();
        userMap.put("1", new Member("1", "홍길동1"));
        userMap.put("2", new Member("2", "홍길동2"));
        userMap.put("3", new Member("3", "홍길동3"));
        userMap.put("4", new Member("4", "홍길동4"));
        userMap.put("5", new Member("5", "홍길동5"));
    }

    // {
    //      "id" : "6",
    //      "name" : "홍길동6"
    // }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(
            @RequestBody Member member
    ) {
        userMap.put(
                member.getId(),
                member
        );
    }

    // GET : localhost:8080/member/3
    @GetMapping("/{id}")
    public Member get(
            @PathVariable("id") String id
    ) {
        return userMap.get(id);
    }

    @GetMapping("/all")
    public List<Member> getAll() {
        return userMap
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    //  localhost:8080/member/duplicate/id?id=6
    @GetMapping("/duplicate/id")
    public ResponseEntity duplicate(
            @RequestParam("id") String id
    ) {
        return userMap.containsKey(id)
                ? ResponseEntity.status(HttpStatus.CONFLICT).build()
                : ResponseEntity.ok().build();
    }

    @GetMapping("/duplicate/{id}")
    public ResponseEntity duplicate2(
            @PathVariable("id") String id
    ) {
        return userMap.containsKey(id)
                ? ResponseEntity.status(HttpStatus.CONFLICT).build()
                : ResponseEntity.ok().build();
    }

    @PutMapping("")
    public ResponseEntity<Member> modify(
            @RequestBody Member member
    ) {
        Member uptMember = userMap.get(member.getId());
        uptMember.setName(member.getName());
        return ResponseEntity.ok(uptMember);
    }


    @DeleteMapping("/{id}")
    public void remove(
            @PathVariable("id") String id
    ) {
        userMap.remove(id);
    }


}
