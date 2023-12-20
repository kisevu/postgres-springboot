package com.ameda.kevin.crud.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserModel {
    private String name;
    private String county;
    private String gender;
    private Integer age;
}

