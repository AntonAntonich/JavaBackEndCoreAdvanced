package com.epam.jmp.constants;

public class Messages {
    public static final String USER_OPERATION_MESSAGE = "choose:" +
            "\n1 - get all users" +
            "\n2 - find user by id" +
            "\n3 - create new user" +
            "\n4 - updated user" +
            "\n5 - delete user" +
            "\n6 - get average age of users" +
            "\n7 - is user adult(payable)" +
            "\n0 - main menu";
    public static final String BANK_CARD_OPERATION_MESSAGE = "choose:" +
            "\n1 - get all bank cards" +
            "\n2 - find bank card by id" +
            "\n3 - create new bank card" +
            "\n4 - delete bank card" +
            "\n5 - find bank cards by user id" +
            "\n0 - main menu";
    public static final String SUBSCRIPTION_OPERATION_MESSAGE = "choose:" +
            "\n1 - get all subscription" +
            "\n2 - find subscription by bank card id" +
            "\n3 - find subscription by query" +
            "\n0 - main menu";
    public static final String ENTER_USER_NAME_MESSAGE = "Enter user name:";
    public static final String ENTER_USER_SURNAME_MESSAGE = "Enter user surname:";
    public static final String ENTER_USER_BIRTH_MESSAGE = "Enter date of birth in number format \"yyyy-mm-dd\"";
    public static final String ENTER_USER_ID_MESSAGE = "enter user id:";
    public static final String CHOOSE_OPERATION_MESSAGE = "Choose operation:\n0 - exit" +
            "\n1 - operations with users" +
            "\n2 - operations with bank cards" +
            "\n3 - operations with subscriptions";
    public static final String ENTER_CARD_ID_FOR_SUBSCRIPTION_FIND_MESSAGE = "Enter card id to find it subscription";
    public static final String NO_CARD_ID_MESSAGE = "No card with id = %s";
    public static final String SUBSCRIPTION_MESSAGE = "Subscription: %s%n";
    public static final String CHOOSE_PREDICATE_MESSAGE = "choose predicate:" +
            "\n1 - between dates" +
            "\n2 - after date" +
            "\n3 - before date" +
            "\n0 - exit";
    public static final String USER_UPDATED_MESSAGE = "User has been updated %s %n";
    public static final String USER_DELETION_MESSAGE = "User %s has been created successfully%n";
    public static final String END_MESSAGE = "End of application";
    public static final String ENTER_USER_ID_TO_FIND_CARDS_MESSAGE = "Enter user id which is owner of cards to see the list of cards that" +
            " belongs to him";
    public static final String ENTER_BANK_CARD_ID_TO_DELETE_MESSAGE = "Enter bank card id to delete";
    public static final String DELETION_SUCCESS_CARD_MESSAGE = "Bank card with id: %s has been deleted%n";
    public static final String ENTER_ID_FOR_USER_ID_TO_CREATE_CARD_MESSAGE = "Enter id for user is potential owner of bank card";
    public static final String SELECT_CARD_TYPE_MESSAGE = "Select card type:\n1 - Debit card\n2 - Credit card";
    public static final String CREATION_CARD_SUCCESS_MESSAGE = "Bank card has been created and saved. Bank card: %s%n";
    public static final String ENTER_BANK_CARD_ID_MESSAGE = "Enter bank card id";
    public static final String AVERAGE_AGE_OF_USERS_MESSAGE = "Average age of all users is %s years%n";
    public static final String USER_IS_PAYABLE_MESSAGE = "User is payable";
    public static final String USER_IS_NOT_PAYABLE_MESSAGE = "User is not payable";
    public static final String USER_DELETED_SUCCESS_MESSAGE = "User with id = %s has been deleted successfully%n";
    public static final String SUBSCRIPTIONS_BY_QUERY_NOT_FOUND_ERROR_MESSAGE = "Subscriptions by query not found";
    public static final String ENTER_START_DATE_MESSAGE = "Enter start date in format \"yyyy-mm-dd\"";
    public static final String ENTER_END_DATE_MESSAGE = "Enter end date in format \"yyyy-mm-dd\"";

}
