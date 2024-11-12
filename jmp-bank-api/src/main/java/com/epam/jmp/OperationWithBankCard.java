package com.epam.jmp;

import com.epam.jmp.dto.entity.bank_card.BankCardWarHouse;
import com.epam.jmp.dto.entity.bank_card.BankCardWarHouseImpl;
import com.epam.jmp.dto.entity.user.User;
import com.epam.jmp.dto.entity.user.UserWarHouse;
import com.epam.jmp.dto.entity.user.UserWarHouseImpl;
import com.epam.jmp.service.BankCardService;
import com.epam.jmp.service.impl.BankCardServiceImpl;

import java.util.Scanner;

import static com.epam.jmp.constants.Messages.*;
import static com.epam.jmp.dto.entity.bank_card.BankCardType.CREDIT;
import static com.epam.jmp.dto.entity.bank_card.BankCardType.DEBIT;

public class OperationWithBankCard {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BankCardWarHouse bankCardWarHouse = BankCardWarHouseImpl.getInstance();
    private static final UserWarHouse userWarHouse = UserWarHouseImpl.userWarHouse();
    private static final BankCardService bankCardService = new BankCardServiceImpl();

    public static void operationsWithBankCards() {
        while (true) {
            try {
                System.out.println(BANK_CARD_OPERATION_MESSAGE);
                int operation = scanner.nextInt();
                if (operation == 1) {
                    allCardsAction();
                } else if (operation == 2) {
                    getCardByIdAction();
                } else if (operation == 3) {
                    createCardAction();
                } else if (operation == 4) {
                    deleteCardByIdAction();
                } else if (operation == 5) {
                    findCardsByUserIdAction();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void findCardsByUserIdAction() {
        System.out.println(ENTER_USER_ID_TO_FIND_CARDS_MESSAGE);
        var userId = scanner.next();
        var bankCardsByUserId = bankCardService.findBankCardsByUserId(userId);
        System.out.println(bankCardsByUserId);
    }

    private static void deleteCardByIdAction() {
        System.out.println(ENTER_BANK_CARD_ID_TO_DELETE_MESSAGE);
        var bankCardId = scanner.next();
        String deletedCardId = bankCardWarHouse.deleteBankCardById(bankCardId);
        System.out.printf(DELETION_SUCCESS_CARD_MESSAGE, deletedCardId);
    }

    private static void createCardAction() {
        System.out.println(ENTER_ID_FOR_USER_ID_TO_CREATE_CARD_MESSAGE);
        var userId = scanner.next();
        System.out.println(SELECT_CARD_TYPE_MESSAGE);
        var cardType = scanner.nextInt();
        var bankCard = bankCardService.createBankCard(
                (User) userWarHouse.getUserById(userId),
                cardType == 1 ? DEBIT : CREDIT);
        System.out.printf(CREATION_CARD_SUCCESS_MESSAGE, bankCard);
    }

    private static void getCardByIdAction() {
        System.out.println(ENTER_BANK_CARD_ID_MESSAGE);
        var bankCardId = scanner.next();
        System.out.println(bankCardWarHouse.getBankCardById(bankCardId));
    }

    private static void allCardsAction() {
        System.out.println(bankCardWarHouse.getAllBankCards());
    }

}
