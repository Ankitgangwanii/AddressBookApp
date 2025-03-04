package com.tit.addressbook.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private String name;
    private String address;
    private String phone;
    private String email;
}