package com.epam.jmp.dto.entity.bank_card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DebitBankCard extends BankCard {
    private BigDecimal balance = BigDecimal.ZERO;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        DebitBankCard that = (DebitBankCard) o;
        return Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), balance);
    }

    @Override
    public String toString() {
        return "DebitBankCard{" +
                "card number = " + getId() + "; " +
                "use = " + getUser().getName() + " " + getUser().getSurname() + "; " +
                "balance = " + balance +
                '}';
    }
}
