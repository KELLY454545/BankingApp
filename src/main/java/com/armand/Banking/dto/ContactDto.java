package com.armand.Banking.dto;


import com.armand.Banking.models.Contact;
import com.armand.Banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ContactDto {

    private int contactId;
    private String firstName;
    private String lastName;
    private String email;
    private String iban;

    private int userId;

    public static ContactDto formEntity(Contact contact) {
        return ContactDto.builder()
                .contactId(contact.getContactId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .userId(contact.getUser().getUserId())

                .build();
    }

    public static Contact toEntity(ContactDto contact) {
        return Contact.builder()
                .contactId(contact.getContactId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .user(
                        User.builder()
                                .userId(contact.getUserId())
                                .build())

                .build();
    }
}
