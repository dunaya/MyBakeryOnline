package com.example.bakery.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UsersDto {
    private Integer user_connection_id;
    private Integer user_type_id;
    private String name;
    private String login;
    private String email;
}