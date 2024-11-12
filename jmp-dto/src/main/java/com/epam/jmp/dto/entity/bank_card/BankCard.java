package com.epam.jmp.dto.entity.bank_card;

import com.epam.jmp.dto.entity.BaseEntity;
import com.epam.jmp.dto.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankCard implements BaseEntity {
    private String id;
    private User user;
}
