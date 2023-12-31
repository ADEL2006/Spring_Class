package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.GuestbookEntity;

public interface GuestbookService {
    // C
    Long register(GuestbookDTO dto);
    // R
    GuestbookDTO read(Long gno);

    PageResultDTO<GuestbookDTO, GuestbookEntity> getList(PageRequestDTO pageRequestDTO);

    // U
    void modify(GuestbookDTO dto);
    // D
    void remove(Long gno);

    default GuestbookEntity dtoToEntity(GuestbookDTO dto){
        return GuestbookEntity.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    default GuestbookDTO entityToDTO(GuestbookEntity entity){
        return GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
    }

}
