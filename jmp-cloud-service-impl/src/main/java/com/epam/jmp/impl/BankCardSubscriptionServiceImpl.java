package com.epam.jmp.impl;

import com.epam.jmp.dto.entity.bank_card.BankCard;
import com.epam.jmp.dto.entity.exception.SubscriptionNotFoundException;
import com.epam.jmp.dto.entity.subscription.Subscription;
import com.epam.jmp.dto.entity.subscription.SubscriptionWarHouse;
import com.epam.jmp.service.BankCardSubscriptionService;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Predicate;

public class BankCardSubscriptionServiceImpl implements BankCardSubscriptionService {

    private static final String CARD_ID_IS_NULL_ERROR_MESSAGE = "card id is null";

    @Override
    public void subscribe(BankCard bankCard) {
        String cardId = Optional.ofNullable(bankCard)
                .map(BankCard::getId)
                .orElseThrow(() -> new SubscriptionNotFoundException(CARD_ID_IS_NULL_ERROR_MESSAGE));
        SubscriptionWarHouse.idToSubscription.putIfAbsent(cardId, new Subscription(bankCard.getId(),
                LocalDate.now()));

    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardId) {
        return Optional.ofNullable(SubscriptionWarHouse.idToSubscription.get(cardId));
    }

    @Override
    public Optional<Subscription> getSubscriptionByQuery(Predicate<Subscription> predicate) {
        return SubscriptionWarHouse.idToSubscription.values().stream()
                .filter(predicate)
                .findFirst();
    }
}
