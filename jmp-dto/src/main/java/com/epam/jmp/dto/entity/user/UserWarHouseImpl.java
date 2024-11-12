package com.epam.jmp.dto.entity.user;

import com.epam.jmp.dto.entity.BaseEntity;
import com.epam.jmp.dto.entity.exception.BankCardException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class UserWarHouseImpl implements UserWarHouse {
    private static final String USER_NOT_FOUND_MESSAGE = "User with id: %s not found";
    private static final String USER_EXISTS_MESSAGE = "User with id: %s already exists";
    private static final List<User> userWarHouse = new ArrayList<>();
    private static UserWarHouseImpl instance;

    private UserWarHouseImpl() {
    }

    public static UserWarHouseImpl userWarHouse() {
        return Objects.isNull(instance) ? new UserWarHouseImpl() : instance;
    }

    private static void updateUser(User user, User targetUser) {
        targetUser.setId(user.getId());
        targetUser.setName(user.getName());
        targetUser.setSurname(user.getSurname());
        targetUser.setBirthday(user.getBirthday());
    }

    private static Predicate<User> filterUser(String userId) {
        return user -> user.getId().equals(userId);
    }

    private static void validateUserPresence(String targetUserId) {
        if (userWarHouse.stream().noneMatch(user -> user.getId().equals(targetUserId))) {
            throw new BankCardException(String.format(USER_NOT_FOUND_MESSAGE, targetUserId));
        }
    }

    private static boolean isUserExist(String targetUserId) {
        return userWarHouse.stream().anyMatch(filterUser(targetUserId));
    }

    public List<BaseEntity> getAllUsers() {
        return userWarHouse.stream()
                .map(this::mapUserToNewUser)
                .toList();
    }

    public BaseEntity getUserById(String userId) {
        return userWarHouse.stream()
                .filter(filterUser(userId))
                .findFirst()
                .map(this::mapUserToNewUser)
                .orElseThrow(() -> new BankCardException(String.format(USER_NOT_FOUND_MESSAGE, userId)));
    }

    public User addUser(User user) {
        var userId = user.getId();
        if (isUserExist(userId)) {
            throw new BankCardException(String.format(USER_EXISTS_MESSAGE, userId));
        }
        userWarHouse.add(user);
        return user;
    }

    public User updateUser(User user) {
        validateUserPresence(user.getId());
        var targetUser = userWarHouse.stream()
                .filter(filterUser(user.getId()))
                .findFirst().get();
        updateUser(user, targetUser);

        return targetUser;
    }

    public String deleteUserById(String userId) {
        userWarHouse.remove((User) getUserById(userId));
        return userId;
    }

    private BaseEntity mapUserToNewUser(User user) {
        return User.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .birthday(user.getBirthday())
                .build();
    }

}
