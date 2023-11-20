package org.zerock.guestbook.service;

import org.zerock.guestbook.dto.MemberDTO;

public interface MemberService {
    // C
    Long register (MemberDTO dto);
    // R
    MemberDTO read(Long mno);
    // U
    void modify(MemberDTO dto);
    // D
    void remove(Long mno);
}
