package org.zerock.guestbook.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberDTO {
    private Long mno;
    private String name;
    private String phone;
    private String address;
}
