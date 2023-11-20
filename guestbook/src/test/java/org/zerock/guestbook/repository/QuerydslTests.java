package org.zerock.guestbook.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.entity.QGuestbookEntity;

import static org.zerock.guestbook.entity.QGuestbookEntity.guestbookEntity;

@SpringBootTest
public class QuerydslTests {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void testQuerydsl1() {


        // where title
        guestbookEntity.title.contains("1");
        guestbookEntity.gno.eq(1L);

        jpaQueryFactory
                .from(guestbookEntity)
                .where();



    }

}
