package com.example.bakery.service;

import com.example.bakery.dto.UsersDto;
import com.example.bakery.entity.Users;
import com.example.bakery.exception.ValidationException;
import com.example.bakery.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class MyUsersService implements UsersService{
    private final UsersRepository usersRepository;
    private final UsersConverter usersConverter;
    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        System.out.println(usersDto);
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        System.out.println(login);
        Users users = usersRepository.findByLogin(login);
        if (users != null) {
            System.out.println("Not null\n");
            return usersConverter.fromUserToUserDto(users);
        } else {

            System.out.println("Found null\n");
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }
}
