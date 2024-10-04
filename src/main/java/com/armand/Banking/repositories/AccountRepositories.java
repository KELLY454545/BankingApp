package com.armand.Banking.repositories;

import com.armand.Banking.models.Account;
import org.iban4j.Iban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface AccountRepositories extends JpaRepository<Account, Integer> {


    Optional<Account> findByIban(Iban iban);
}
