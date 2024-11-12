package com.epam.jmp;

import com.epam.jmp.dto.entity.exception.SubscriptionNotFoundException;
import com.epam.jmp.dto.entity.subscription.Subscription;
import com.epam.jmp.dto.entity.subscription.SubscriptionWarHouse;
import com.epam.jmp.impl.BankCardSubscriptionServiceImpl;
import com.epam.jmp.service.BankCardSubscriptionService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Predicate;

import static com.epam.jmp.constants.Messages.*;

public class OperationWithSubscriptions {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BankCardSubscriptionService bankCardSubscriptionService = new BankCardSubscriptionServiceImpl();

    public static void operationWithSubscriptions() {
        while (true) {
            try {
                System.out.println(SUBSCRIPTION_OPERATION_MESSAGE);
                int operation = scanner.nextInt();
                if (operation == 1) {
                    getAllSubscriptionsAction();
                } else if (operation == 2) {
                    getSubscriptionByCardIdAction();
                } else if (operation == 3) {
                    getSubscriptionByQueryAction();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getSubscriptionByQueryAction() {
        while (true) {
            System.out.println(CHOOSE_PREDICATE_MESSAGE);
            String numberOfOperation = scanner.next();
            if (numberOfOperation.equals("0")) {
                break;
            }
            Predicate<Subscription> predicate = getSubscriptionPredicate(numberOfOperation);
            Subscription subscription = bankCardSubscriptionService.getSubscriptionByQuery(predicate)
                    .orElseThrow(() -> new SubscriptionNotFoundException(SUBSCRIPTIONS_BY_QUERY_NOT_FOUND_ERROR_MESSAGE));
            System.out.println(subscription);
        }
    }

    private static Predicate<Subscription> getSubscriptionPredicate(String predicateNumber) {
        Predicate<Subscription> predicate = null;
        switch (predicateNumber) {
            case "1" -> {
                System.out.println(ENTER_START_DATE_MESSAGE);
                LocalDate startDate = LocalDate.parse(scanner.next());
                System.out.println(ENTER_END_DATE_MESSAGE);
                LocalDate endDate = LocalDate.parse(scanner.next());
                predicate = subscription -> subscription.getStartDate().isAfter(startDate)
                        && subscription.getStartDate().isBefore(endDate);
            }
            case "2" -> {
                System.out.println(ENTER_START_DATE_MESSAGE);
                LocalDate startDate = LocalDate.parse(scanner.next());
                predicate = subscription -> subscription.getStartDate().isAfter(startDate);
            }
            case "3" -> {
                System.out.println(ENTER_END_DATE_MESSAGE);
                LocalDate endDate = LocalDate.parse(scanner.next());
                predicate = subscription -> subscription.getStartDate().isBefore(endDate);
            }
        }
        return predicate;
    }

    private static void getSubscriptionByCardIdAction() {
        System.out.println(ENTER_CARD_ID_FOR_SUBSCRIPTION_FIND_MESSAGE);
        var cardId = scanner.next();
        var subscription = bankCardSubscriptionService.getSubscriptionByBankCardNumber(cardId)
                .orElseThrow(() -> new SubscriptionNotFoundException(
                        String.format(NO_CARD_ID_MESSAGE, cardId)));
        System.out.printf(SUBSCRIPTION_MESSAGE, subscription);
    }

    private static void getAllSubscriptionsAction() {
        System.out.println(SubscriptionWarHouse.idToSubscription);
    }
}
