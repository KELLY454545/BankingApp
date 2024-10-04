package com.armand.Banking.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity
public class Addressv1 {


    @Id
    @GeneratedValue
    private long Id;
    private String Street;
    private int houseNumber;
    private String ZIPCode;
    private String City;
    private String country;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
