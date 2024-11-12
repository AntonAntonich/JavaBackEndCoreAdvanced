package com.epam.jmp.mock;

import com.epam.jmp.dto.entity.user.UserWarHouseImpl;
import com.epam.jmp.impl.UserServiceImpl;
import com.epam.jmp.service.UserService;

import java.time.LocalDate;

public class MockedData {

    private static final UserService userService = new UserServiceImpl();

    private MockedData() {
    }

    public static void createMockedDate() {
        createMockedUserDate();
    }

    private static void createMockedUserDate() {
        UserWarHouseImpl.userWarHouse().addUser(userService.createUser("Anton", "Ivanov",
                LocalDate.of(1988, 11, 30)));
        UserWarHouseImpl.userWarHouse().addUser(userService.createUser("Ann", "Brown",
                LocalDate.of(1989, 10, 29)));
        UserWarHouseImpl.userWarHouse().addUser(userService.createUser("Bob", "Gala",
                LocalDate.of(1990, 9, 28)));
        UserWarHouseImpl.userWarHouse().addUser(userService.createUser("Kate", "Newman",
                LocalDate.of(1991, 8, 27)));
        UserWarHouseImpl.userWarHouse().addUser(userService.createUser("John", "Smith",
                LocalDate.of(1992, 7, 26)));
    }
}
