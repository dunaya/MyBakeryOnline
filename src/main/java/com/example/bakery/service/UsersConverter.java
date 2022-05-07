package com.example.bakery.service;

import com.example.bakery.dto.UsersDto;
import com.example.bakery.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {
    public Users fromUserDtoToUser(UsersDto usersDto) {
        Users users = new Users();
        users.setUser_connection_id(usersDto.getUser_connection_id());
        users.setUser_type_id(usersDto.getUser_type_id());
        users.setEmail(usersDto.getEmail());
        users.setName(usersDto.getName());
        users.setLogin(usersDto.getLogin());
        return users;
    }
    public UsersDto fromUserToUserDto(Users users) {
        System.out.println(users);
        UsersDto usersDto = new UsersDto();
        usersDto.setUser_connection_id(users.getUser_connection_id());
        usersDto.setUser_type_id(users.getUser_type_id());
        usersDto.setEmail(users.getEmail());
        usersDto.setLogin(users.getLogin());
        usersDto.setName(users.getName());
        return usersDto;
    }
}
