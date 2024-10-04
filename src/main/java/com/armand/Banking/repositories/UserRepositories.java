package com.armand.Banking.repositories;

import com.armand.Banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepositories extends JpaRepository<User, Integer> {

    //select * from User where firstname = 'ali'
    List<User> findAllByFirstName(String firstName);

    //select * from User where firstname like 'ali'
    List<User> findAllByFirstNameContaining(String firstName);

    //select * from User where firstname ilike 'ali'
    List<User> findAllByFirstNameContainingIgnoreCase(String firstName);


    //select * from User u inner join account a an u.id = a.id_user and a.iban = 'DE12345678'
    List<User> findAllByAccount_Iban(String iban);

    //select * from User where firstname = '%ali' and email = 'bouali.pro@gmail.com'
    User findByFirstNameContainingIgnoreCaseAndEmail(String firstName, String email);

    @Query("from User where firstName = :fn")
    List<User>SearchByFirstName(@Param("fn") String firstName);

    @Query("from User where firstName = '%:firstname'")
    List<User> searchByFirstNameContaining(String firstname);

    @Query("from User u inner join Account a on u.userId = a.user.userId where a.iban = :iban")
    List<User>SearchByIban(String iban);

    @Query(value = "select * from users u inner join account a on u.user_id = a.id and a.iban = :iban", nativeQuery = true)
    List<User>SearchByIbanNative(String iban);



}
