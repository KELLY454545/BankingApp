package com.armand.Banking.models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Transaction extends AbstractEntity {

    @Id
    @GeneratedValue
    private int transactionId;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String destinationIban;




    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;


}
