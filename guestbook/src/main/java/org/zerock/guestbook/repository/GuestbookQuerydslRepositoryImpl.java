package org.zerock.guestbook.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.guestbook.entity.QGuestbookEntity;

import static org.zerock.guestbook.entity.QGuestbookEntity.guestbookEntity;

@Repository
@RequiredArgsConstructor
public class GuestbookQuerydslRepositoryImpl implements GuestbookQuerydslRepository{

    @Autowired
    private final JPAQueryFactory jpaQueryFactory;

    private BooleanBuilder searchCondition(String type, String keyword) {
        if(type == null || type.trim().length() == 0) {
            return null;
        }
        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(type.contains("t")) {
            conditionBuilder.or(guestbookEntity.title.contains(keyword));
        }
        if(type.contains("c")) {
            conditionBuilder.or(guestbookEntity.content.contains(keyword));
        }
    }
}
