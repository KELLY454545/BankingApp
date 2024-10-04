package com.armand.Banking.dto;

import com.armand.Banking.models.Transaction;
import com.armand.Banking.models.TransactionType;
import com.armand.Banking.models.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class TransactioDto {




    private int transactionId;
    private BigDecimal amount;

    private TransactionType type;
    private String destinationIban;

    private int userId;


    public static TransactioDto fromEntity(Transaction transaction) {
        return TransactioDto.builder()
                .transactionId(transaction.getTransactionId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .destinationIban(transaction.getDestinationIban())
                .userId(transaction.getUser().getUserId())
                .build();

    }


    public static Transaction fromEntity(TransactioDto transaction) {
        return Transaction.builder()
                .transactionId(transaction.getTransactionId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .destinationIban(transaction.getDestinationIban())
                .user(
                        User.builder()
                        .userId(transaction.getUserId())
                                .build()
                )
                .build();

    }

}
