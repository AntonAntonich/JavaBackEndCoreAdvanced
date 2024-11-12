package com.epam.jmp.service;

import com.epam.jmp.dto.entity.bank_card.BankCard;
import com.epam.jmp.dto.entity.subscription.Subscription;

import java.util.Optional;
import java.util.function.Predicate;

public interface BankCardSubscriptionService {
    void subscribe(BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

    Optional<Subscription> getSubscriptionByQuery(Predicate<Subscription> predicate);
}
