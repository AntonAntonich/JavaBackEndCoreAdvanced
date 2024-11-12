package com.epam.jmp.dto.entity.user;

import com.epam.jmp.dto.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Data
public class User implements BaseEntity {
    private String id;
    private String name;
    private String surname;
    private LocalDate birthday;
}
