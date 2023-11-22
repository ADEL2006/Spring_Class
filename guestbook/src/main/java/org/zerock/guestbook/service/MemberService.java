package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.MemberDTO;
import org.zerock.guestbook.entity.MemberEntity;

import java.lang.reflect.Member;

public interface MemberService {
    // C
    Long register(MemberDTO dto);
    // R
    MemberDTO read(Long mno);
    // U
    void modify(MemberDTO dto);
    // D
    void remove(Long mno);

    // (DTO) -> return Entity
    default MemberEntity dtoToEntity(MemberDTO dto){
        return MemberEntity.builder()
                .mno(dto.getMno())
                .name(dto.getName())
                .phone(dto.getPhone())
                .address(dto.getAddress())
                .build();
    }
    // (Entity) -> return DTO
    default MemberDTO entityToDTO(MemberEntity entity){
        return MemberDTO.builder()
                       .mno(entity.getMno())
                       .name(entity.getName())
                       .phone(entity.getPhone())
                       .address(entity.getAddress())
                       .build();
    }

}
