package org.zerock.guestbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tbl_memo")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
    @Column(name = "memo_text", nullable = false, length = 200)
    private String memoText;

}
