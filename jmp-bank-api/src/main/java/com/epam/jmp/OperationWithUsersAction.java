package com.epam.jmp;

import com.epam.jmp.dto.entity.user.User;
import com.epam.jmp.dto.entity.user.UserWarHouse;
import com.epam.jmp.dto.entity.user.UserWarHouseImpl;
import com.epam.jmp.impl.UserServiceImpl;
import com.epam.jmp.service.UserService;

import java.time.LocalDate;
import java.util.Scanner;

import static com.epam.jmp.constants.Messages.*;

public class OperationWithUsersAction {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserWarHouse userWarHouse = UserWarHouseImpl.userWarHouse();
    private static final UserService userService = new UserServiceImpl();

    public static void operationsWithUsers() {
        while (true) {
            try {
                System.out.println(USER_OPERATION_MESSAGE);
                int operation = scanner.nextInt();
                if (operation == 1) {
                    allUsersAction();
                } else if (operation == 2) {
                    findUserByIdAction();
                } else if (operation == 3) {
                    createNewUserAction();
                } else if (operation == 4) {
                    updateUserAction();
                } else if (operation == 5) {
                    deleteUserByIdAction();
                } else if (operation == 6) {
                    averageAgeOfUsersAction();
                } else if (operation == 7) {
                    isUserPayableAction();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void isUserPayableAction() {
        System.out.println(ENTER_USER_ID_MESSAGE);
        var userId = scanner.next();
        var user = (User) userWarHouse.getUserById(userId);
        System.out.println(UserService.isPayableUser(user)
                ? USER_IS_PAYABLE_MESSAGE
                : USER_IS_NOT_PAYABLE_MESSAGE);
    }

    private static void averageAgeOfUsersAction() {
        System.out.printf(AVERAGE_AGE_OF_USERS_MESSAGE,
                userService.getAverageUserAge());
    }

    private static void deleteUserByIdAction() {
        System.out.println(ENTER_USER_ID_MESSAGE);
        String userId = scanner.next();
        var deletedUserId = userWarHouse.deleteUserById(userId);
        System.out.printf(USER_DELETED_SUCCESS_MESSAGE, deletedUserId);
    }

    private static void allUsersAction() {
        System.out.println(userService.getAllUsers());
    }

    private static void updateUserAction() {
        System.out.println(ENTER_USER_ID_MESSAGE);
        String userId = scanner.next();
        System.out.println(ENTER_USER_NAME_MESSAGE);
        String userName = scanner.next();
        System.out.println(ENTER_USER_SURNAME_MESSAGE);
        String userSurname = scanner.next();
        System.out.println(ENTER_USER_BIRTH_MESSAGE);
        LocalDate birth = LocalDate.parse(scanner.next());
        var user = userWarHouse.updateUser(
                User.builder().id(userId).name(userName).surname(userSurname).birthday(birth).build());
        System.out.printf(USER_UPDATED_MESSAGE, user);
    }

    private static void createNewUserAction() {
        System.out.println(ENTER_USER_NAME_MESSAGE);
        var userName = scanner.next();
        System.out.println(ENTER_USER_SURNAME_MESSAGE);
        String userSurname = scanner.next();
        System.out.println(ENTER_USER_BIRTH_MESSAGE);
        var birth = LocalDate.parse(scanner.next());
        var user = userWarHouse.addUser(userService.createUser(userName, userSurname, birth));
        System.out.printf(USER_DELETION_MESSAGE, user);
    }

    private static void findUserByIdAction() {
        System.out.println(ENTER_USER_ID_MESSAGE);
        var userId = scanner.next();
        System.out.println(userWarHouse.getUserById(userId));
    }
}
