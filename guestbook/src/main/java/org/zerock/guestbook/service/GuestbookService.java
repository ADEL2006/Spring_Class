package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.entity.GuestbookEntity;
import org.zerock.guestbook.sample.Guest;

public interface GuestbookService {
    Long register(GuestbookDTO dto);
    default GuestbookEntity dtoToEntity(GuestbookDTO dto) {
         return GuestbookEntity.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }
}
