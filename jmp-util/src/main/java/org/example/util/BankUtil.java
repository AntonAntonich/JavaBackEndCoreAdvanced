package org.example.util;

import com.epam.jmp.dto.entity.BaseEntity;

import java.util.List;

public class BankUtil {

    private BankUtil() {
    }

    public static String generateId(List<BaseEntity> collection) {
        int id = collection.stream()
                .mapToInt(user -> Integer.parseInt(user.getId()))
                .max()
                .orElse(0);

        return String.valueOf(++id);
    }
}
