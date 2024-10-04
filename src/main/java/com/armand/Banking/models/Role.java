package com.armand.Banking.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Role {

    @Id
    @GeneratedValue
    private int Id;
    private String roleName;

    @OneToOne
    @JoinColumn(name = "user_Id")
    private User user;

}
