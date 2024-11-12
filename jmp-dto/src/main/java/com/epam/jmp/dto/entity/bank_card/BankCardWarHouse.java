package com.epam.jmp.dto.entity.bank_card;

import com.epam.jmp.dto.entity.BaseEntity;

import java.util.List;

public interface BankCardWarHouse {
    List<BaseEntity> getAllBankCards();

    BaseEntity getBankCardById(String bankCardId);

    BankCard addBankCard(BankCard bankCard);

    String deleteBankCardById(String bankCardId);
}
