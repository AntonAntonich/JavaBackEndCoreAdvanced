package com.epam.jmp.service;

import com.epam.jmp.dto.entity.user.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public interface UserService {
    int ADULT_AGE = 18;

    static boolean isPayableUser(User user) {
        return Period.between(user.getBirthday(), LocalDate.now()).getYears() >= ADULT_AGE;
    }

    List<User> getAllUsers();

    User createUser(String name, String surname, LocalDate birthday);

    double getAverageUserAge();
}
