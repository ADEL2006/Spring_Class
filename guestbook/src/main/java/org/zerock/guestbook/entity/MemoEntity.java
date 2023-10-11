package org.zerock.guestbook.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_memo")
public class MemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
    @Column(name = "memo_text", nullable = false, length = 200)
    private String memoText;
}
