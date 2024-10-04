package com.armand.Banking.dto;


import com.armand.Banking.models.Account;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@Builder

public class AccountDto {

    private int id;
    private String iban;
    private UserDto user;

    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .iban(account.getIban())
                .user(UserDto.formEntity(account.getUser()))
                .id(account.getId())
                .build();
    }

    public static Account toEntity(AccountDto account) {
        return Account.builder()
                .iban(account.getIban())
                .user(UserDto.toEntity(account.getUser()))
                .build();
    }

}
