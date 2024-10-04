package com.armand.Banking.impl;

import com.armand.Banking.dto.UserDto;
import com.armand.Banking.models.User;
import com.armand.Banking.repositories.UserRepositories;
import com.armand.Banking.services.UserService;
import com.armand.Banking.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositories repositories;

    private final ObjectValidator<UserDto> validator;

    @Override
    public Integer save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        return repositories.save(user).getUserId();
    }

    @Override
    public List<UserDto> findAll() {
        return repositories.findAll()
                .stream()
                .map(UserDto::formEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return repositories.findById(id)
                .map(UserDto::formEntity)
                .orElseThrow(() -> new EntityNotFoundException("no user found with the provided ID : " +id));
    }

    @Override
    public void delete(Integer id) {

        //todo check before delete
        repositories.deleteById(id);



    }
}
