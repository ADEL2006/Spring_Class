package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
