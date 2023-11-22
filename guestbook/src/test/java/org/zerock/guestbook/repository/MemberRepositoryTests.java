package org.zerock.guestbook.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.entity.MemberEntity;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void testInsertDummies() {
        IntStream.rangeClosed(1, 9).forEach(i -> {

            MemberEntity memberEntity = MemberEntity.builder()
                    .address("대구광역시 달성군 구지면")
                    .name("홍길동" + i)
                    .phone("010-1234-123" + i)
                    .build();
            memberRepository.save(memberEntity);


        });
    }


}