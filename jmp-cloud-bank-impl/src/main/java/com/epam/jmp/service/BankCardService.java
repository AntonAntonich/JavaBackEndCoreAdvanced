package com.epam.jmp.service;

import com.epam.jmp.dto.entity.bank_card.BankCard;
import com.epam.jmp.dto.entity.bank_card.BankCardType;
import com.epam.jmp.dto.entity.user.User;

import java.util.List;
import java.util.Map;

public interface BankCardService {
    BankCard createBankCard(User user, BankCardType cardType);

    Map<User, List<BankCard>> findBankCardsByUserId(String userId);

}
