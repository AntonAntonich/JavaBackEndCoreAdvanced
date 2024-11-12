package com.epam.jmp.dto.entity.subscription;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Subscription {
    private String bankcardId;
    private LocalDate startDate;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Subscription that = (Subscription) o;
        return Objects.equals(bankcardId, that.bankcardId) && Objects.equals(
                startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankcardId, startDate);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "bankcardId='" + bankcardId + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
