package com.dgswhs.mid.dto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String name;
    private String phone;
    private String address;
}
