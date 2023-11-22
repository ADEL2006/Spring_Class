package org.zerock.guestbook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.MemberDTO;
import org.zerock.guestbook.entity.MemberEntity;
import org.zerock.guestbook.repository.MemberRepository;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
//    private final MemberRepository memberRepository;

    @Override
    public Long register(MemberDTO dto) {
        MemberEntity memberEntity = dtoToEntity(dto);
        memberRepository.save(memberEntity);
        return memberEntity.getMno();
    }

    @Override
    public MemberDTO read(Long mno) {
        Optional<MemberEntity> result = memberRepository.findById(mno);
        if(result.isPresent()){
            MemberEntity memberEntity = result.get();
            return entityToDTO(memberEntity);
        }
        return null;
    }

    @Override
    public void modify(MemberDTO dto) {

    }

    @Override
    public void remove(Long mno) {
        memberRepository.deleteById(mno);
    }

}
