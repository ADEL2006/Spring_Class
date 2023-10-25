package org.zerock.guestbook.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_guestbook")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class GuestbookEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }
}
