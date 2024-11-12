package com.epam.jmp.dto.entity.bank_card;

import com.epam.jmp.dto.entity.BaseEntity;
import com.epam.jmp.dto.entity.exception.BankCardException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class BankCardWarHouseImpl implements BankCardWarHouse {
    private static final List<BankCard> bankCardWarHouse = new ArrayList<>();
    private static final String CARD_NOT_FOUND_MESSAGE = "Bank card with id: %s not not found";
    private static final String BANK_CARD_EXISTS_MESSAGE = "Bank card with id: %s already exists";
    private static final String BANK_CARD_NOT_FOUND_MESSAGE = "Bank card with id: %s not found";
    private static BankCardWarHouseImpl instance;

    private BankCardWarHouseImpl() {
    }

    public static BankCardWarHouseImpl getInstance() {
        return Objects.isNull(instance) ? new BankCardWarHouseImpl() : instance;
    }

    private static void validateBankCardPresence(String bankCardId) {
        if (bankCardWarHouse.stream().noneMatch(bankCard -> bankCard.getId().equals(bankCardId))) {
            throw new BankCardException(String.format(BANK_CARD_NOT_FOUND_MESSAGE, bankCardId));
        }
    }

    private static boolean isBankCardExist(String targetBankCardId) {
        return bankCardWarHouse.stream().anyMatch(filterBankCard(targetBankCardId));
    }

    private static Predicate<BankCard> filterBankCard(String bankCardId) {
        return bankCard -> bankCard.getId().equals(bankCardId);
    }

    public List<BaseEntity> getAllBankCards() {
        return bankCardWarHouse.stream()
                .map(this::mapBankCardToNewBankCard)
                .toList();
    }

    public BaseEntity getBankCardById(String bankCardId) {
        return bankCardWarHouse.stream()
                .filter(filterBankCard(bankCardId))
                .findFirst()
                .map(this::mapBankCardToNewBankCard)
                .orElseThrow(() -> new BankCardException(String.format(CARD_NOT_FOUND_MESSAGE, bankCardId)));
    }

    public BankCard addBankCard(BankCard bankCard) {
        String bankCardId = bankCard.getId();
        if (isBankCardExist(bankCardId)) {
            throw new BankCardException(String.format(BANK_CARD_EXISTS_MESSAGE, bankCardId));
        }
        bankCardWarHouse.add(bankCard);
        return bankCard;
    }

    public String deleteBankCardById(String bankCardId) {
        validateBankCardPresence(bankCardId);
        bankCardWarHouse.remove((BankCard) getBankCardById(bankCardId));
        return bankCardId;
    }

    private BaseEntity mapBankCardToNewBankCard(BankCard bankCard) {
        BankCard newBankCard;
        if (bankCard instanceof DebitBankCard debitBankCard) {
            newBankCard = new DebitBankCard();
            ((DebitBankCard) newBankCard).setBalance(debitBankCard.getBalance());
        } else if (bankCard instanceof CreditBankCard creditBankCard) {
            newBankCard = new CreditBankCard();
            ((CreditBankCard) newBankCard).setCreditLimit(creditBankCard.getCreditLimit());
        } else {
            newBankCard = new BankCard();
        }
        newBankCard.setUser(bankCard.getUser());
        newBankCard.setId(bankCard.getId());
        return newBankCard;
    }

}
