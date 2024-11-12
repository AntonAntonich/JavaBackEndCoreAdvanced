package com.epam.jmp.impl;

import com.epam.jmp.dto.entity.user.User;
import com.epam.jmp.dto.entity.user.UserWarHouseImpl;
import com.epam.jmp.service.UserService;
import org.example.util.BankUtil;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static int countAgeOfUser(User user) {
        return Period.between(user.getBirthday(), LocalDate.now()).getYears();
    }

    @Override
    public List<User> getAllUsers() {
        return UserWarHouseImpl.userWarHouse().getAllUsers().stream()
                .map(baseEntity -> (User) baseEntity)
                .toList();
    }

    @Override
    public User createUser(String name, String surname, LocalDate birthday) {
        return User.builder()
                .id(BankUtil.generateId(UserWarHouseImpl.userWarHouse().getAllUsers()))
                .name(name)
                .surname(surname)
                .birthday(birthday)
                .build();
    }

    @Override
    public double getAverageUserAge() {
        return UserWarHouseImpl.userWarHouse().getAllUsers().stream()
                .mapToInt(user -> countAgeOfUser((User) user))
                .average()
                .orElse(0);
    }
}
