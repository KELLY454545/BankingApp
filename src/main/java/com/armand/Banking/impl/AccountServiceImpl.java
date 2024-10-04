package com.armand.Banking.impl;

import com.armand.Banking.dto.AccountDto;
import com.armand.Banking.execption.OperationNonPermitedExeption;
import com.armand.Banking.models.Account;
import com.armand.Banking.repositories.AccountRepositories;
import com.armand.Banking.services.AbstractService;
import com.armand.Banking.services.AccountService;
import com.armand.Banking.validator.ObjectValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.iban4j.IbanFormatException;
import org.iban4j.IbanUtil;
import java.util.Random;
import javax.swing.text.html.parser.Entity;
import javax.xml.validation.Validator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepositories repositories;
    private final ObjectValidator<AccountDto> validator;

    @Override
    public Integer save(AccountDto dto) {
        if (dto.getIban() != null){
            throw new OperationNonPermitedExeption(
                    "Account cannot be update",
                    "save account",
                    "Account",
                     "Update not permitted");
        }
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        // GERENERATED RAMDOM IBAN
        Account.builder().iban(generateRandomIBAN()).build();
        return repositories.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return repositories.findAll()
                .stream()
                .map(AccountDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public AccountDto findById(Integer id) {
        return repositories.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No account found with the provided ID : " +id));
    }

    @Override
    public void delete(Integer id) {

        repositories.deleteById(id);
    }

    private String generateRandomIBAN() {

        // generate Iban
        Iban iban = new Iban.Builder()
                .countryCode(CountryCode.DE)
                          .build();

        //check if the iban already existe
        boolean ibanExist = repositories.findByIban(iban).isPresent();
        if (ibanExist) {
            generateRandomIBAN();
        }
        return iban.toString();

    }
}
