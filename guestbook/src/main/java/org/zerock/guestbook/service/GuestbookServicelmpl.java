package org.zerock.guestbook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.entity.GuestbookEntity;
import org.zerock.guestbook.repository.GuestbookRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuestbookServicelmpl implements GuestbookService{
    private GuestbookRepository guestbookRepository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO: {}", dto);
        GuestbookEntity guestbookEntity = dtoToEntity(dto);
        return guestbookEntity.getGno();
    }
}