package org.zerock.guestbook.config;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.entity.QGuestbookEntity;

import java.awt.*;

import static org.zerock.guestbook.entity.QGuestbookEntity.guestbookEntity;

@SpringBootTest
class QuerydslConfugTests {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void testQuerydsl1() {
        guestbookEntity.title.contains("1");
        guestbookEntity.gno.eq(1L);
        jpaQueryFactory
                .from(guestbookEntity)
                .where()
    }
}