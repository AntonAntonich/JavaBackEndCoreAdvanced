package com.epam.jmp.dto.entity.bank_card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreditBankCard extends BankCard {
    private BigDecimal creditLimit = BigDecimal.ZERO;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        CreditBankCard that = (CreditBankCard) o;
        return Objects.equals(creditLimit, that.creditLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditLimit);
    }

    @Override
    public String toString() {
        return "CreditBankCard{" +
                "card number = " + getId() + "; " +
                "user = " + getUser().getName() + " " + getUser().getSurname() + "; " +
                "creditLimit = " + creditLimit +
                '}';
    }
}
