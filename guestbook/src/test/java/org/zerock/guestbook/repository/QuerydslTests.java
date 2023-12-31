package org.zerock.guestbook.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.entity.GuestbookEntity;
import org.zerock.guestbook.entity.QGuestbookEntity;

import java.util.List;

import static org.zerock.guestbook.entity.QGuestbookEntity.guestbookEntity;

@SpringBootTest
public class QuerydslTests {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void testQuerydsl1() {

        String keyword = "1";
            BooleanExpression expression = guestbookEntity.title.contains(keyword);
            List<GuestbookEntity> result =
                jpaQueryFactory
                    .select(guestbookEntity)
                    .from(guestbookEntity)
                    .where(expression)
                    .fetch();
        result.forEach((guestbook) -> {
            System.out.println(guestbook);
        });
    }

    @Test
    void testQuerydsl2() {
        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expression1 = guestbookEntity.title.contains(keyword);
        BooleanExpression expression2 = guestbookEntity.content.contains(keyword);

        BooleanExpression exAll = expression1.or(expression2);

        builder.and(exAll);

        List<GuestbookEntity> result =
        jpaQueryFactory
                .selectFrom(guestbookEntity)
                .where(builder)
                .fetch();

        result.forEach(guestbook -> {
            System.out.println(guestbook);
        });
    }

    @Test
    void testQuerydsl3() {
        List<Tuple> result = jpaQueryFactory
                .select(guestbookEntity.gno, guestbookEntity.title)
                .from(guestbookEntity)
                .fetch();
        result.forEach(tuple -> {
            System.out.println(tuple.get(1, String.class));
            System.out.println(tuple.get(guestbookEntity.gno));
        });
    }

    @Test
    void testQuerydsl4() {
        List<GuestbookDTO> result = jpaQueryFactory
                .select(
                        Projections.constructor(
                                GuestbookDTO.class,
                                guestbookEntity.gno,
                                guestbookEntity.title,
                                guestbookEntity.content,
                                guestbookEntity.writer,
                                guestbookEntity.regDate,
                                guestbookEntity.modDate
                        )
                )
                .from(guestbookEntity)
                .fetch();
        result.forEach(dto -> {
            System.out.println(dto);
        });
    }
}
