package com.epam.jmp.dto.entity.user;

import com.epam.jmp.dto.entity.BaseEntity;

import java.util.List;

public interface UserWarHouse {
    List<BaseEntity> getAllUsers();

    BaseEntity getUserById(String userId);

    User addUser(User user);

    User updateUser(User user);

    String deleteUserById(String userId);
}
