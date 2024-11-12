package com.epam.jmp.service.impl;

import com.epam.jmp.dto.entity.bank_card.*;
import com.epam.jmp.dto.entity.exception.BankCardException;
import com.epam.jmp.dto.entity.user.User;
import com.epam.jmp.impl.BankCardSubscriptionServiceImpl;
import com.epam.jmp.service.BankCardService;
import com.epam.jmp.service.BankCardSubscriptionService;
import org.example.util.BankUtil;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BankCardServiceImpl implements BankCardService {

    private static final String CARD_TYPE_ERROR_MESSAGE = "No such card type: %s";
    private static final String NULL_USER_ERROR_MESSAGE = "User is null. Bank card can't be created without user";
    private final BankCardSubscriptionService bankCardSubscriptionService
            = new BankCardSubscriptionServiceImpl();
    private final BankCardWarHouse bankCardWarHouse = BankCardWarHouseImpl.getInstance();

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        BankCard bankCard;
        switch (cardType) {
            case DEBIT -> bankCard = new DebitBankCard();
            case CREDIT -> bankCard = new CreditBankCard();
            default -> throw new BankCardException(String.format(CARD_TYPE_ERROR_MESSAGE, cardType));
        }
        if (Objects.isNull(user)) {
            throw new BankCardException(NULL_USER_ERROR_MESSAGE);
        }
        bankCard.setId(BankUtil.generateId(BankCardWarHouseImpl.getInstance().getAllBankCards()));
        bankCard.setUser(user);
        BankCard addedCard = bankCardWarHouse.addBankCard(bankCard);
        bankCardSubscriptionService.subscribe(addedCard);
        return bankCard;
    }

    @Override
    public Map<User, List<BankCard>> findBankCardsByUserId(String userId) {
        return BankCardWarHouseImpl.getInstance().getAllBankCards().stream()
                .filter(bankCard -> ((BankCard) bankCard).getUser().getId().equals(userId))
                .map(bankCard -> (BankCard) bankCard)
                .collect(Collectors.groupingBy(BankCard::getUser, Collectors.mapping(bankCard -> bankCard,
                        Collectors.toList())));
    }
}
