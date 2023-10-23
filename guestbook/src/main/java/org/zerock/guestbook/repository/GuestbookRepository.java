package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.entity.GuestbookEntity;

public interface GuestbookRepository  extends JpaRepository<GuestbookEntity, Long> {
}
