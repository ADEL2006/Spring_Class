package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.entity.MemoEntity;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

}
