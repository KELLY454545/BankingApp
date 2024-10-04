package com.armand.Banking.dto;


import com.armand.Banking.models.Addressv1;
import com.armand.Banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@Builder
public class AdressDto {

    private long Id;
    private String Street;
    private int houseNumber;
    private String ZIPCode;
    private String City;
    private String country;
    private int userId;

    public static AdressDto fromEntity(Addressv1 addressv1) {
        return AdressDto.builder()
                .Id(addressv1.getId())
                .Street(addressv1.getStreet())
                .houseNumber(addressv1.getHouseNumber())
                .ZIPCode(addressv1.getZIPCode())
                .City(addressv1.getCity())
                .country(addressv1.getCountry())
                .userId(addressv1.getUser().getUserId())
                .build();
    }
    public static Addressv1 toEntity(AdressDto addressv1) {
        return Addressv1.builder()
                .Id(addressv1.getId())
                .Street(addressv1.getStreet())
                .houseNumber(addressv1.getHouseNumber())
                .ZIPCode(addressv1.getZIPCode())
                .City(addressv1.getCity())
                .country(addressv1.getCountry())
                .user(User.builder()
                        .userId((int)addressv1.getId())
                        .build()
                )
                .build();
    }
}

