package org.zerock.guestbook.controller;

import jakarta.annotation.PostConstruct;
import org.zerock.guestbook.dto.Member;

import java.util.HashMap;

public class MemberController {
    private Map<String, Member> userMap;
    @PostConstruct
    public void init(){
        userMap = new HashMap<>();
        userMap.put("1", new Member("1", "홍길동1"));
        userMap.put("2", new Member("2", "홍길동2"));
        userMap.put("3", new Member("3", "홍길동3"));
        userMap.put("4", new Member("4", "홍길동4"));
        userMap.put("5", new Member("5", "홍길동5"));
    }
}
