package org.zerock.guestbook.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGuestbookEntity is a Querydsl query type for GuestbookEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGuestbookEntity extends EntityPathBase<GuestbookEntity> {

    private static final long serialVersionUID = 1575943098L;

    public static final QGuestbookEntity guestbookEntity = new QGuestbookEntity("guestbookEntity");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath content = createString("content");

    public final NumberPath<Long> gno = createNumber("gno", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath title = createString("title");

    public final StringPath writer = createString("writer");

    public QGuestbookEntity(String variable) {
        super(GuestbookEntity.class, forVariable(variable));
    }

    public QGuestbookEntity(Path<? extends GuestbookEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGuestbookEntity(PathMetadata metadata) {
        super(GuestbookEntity.class, metadata);
    }

}

