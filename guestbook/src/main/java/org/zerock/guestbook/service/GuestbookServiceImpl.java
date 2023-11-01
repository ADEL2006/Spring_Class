package org.zerock.guestbook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.entity.GuestbookEntity;
import org.zerock.guestbook.repository.GuestbookRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuestbookServiceImpl implements GuestbookService {
    private final GuestbookRepository guestbookRepository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO : {}", dto);
        GuestbookEntity guestbookEntity = dtoToEntity(dto);
        guestbookRepository.save(guestbookEntity);
        return guestbookEntity.getGno();
    }

    @Override
    public GuestbookDTO read(Long gno) {
        Optional<GuestbookEntity> result =
        guestbookRepository.findById(gno);
        if(result.isPresent()) {
            GuestbookEntity guestbookEntity =
            result.get();
        }
        return null;
    }

}
