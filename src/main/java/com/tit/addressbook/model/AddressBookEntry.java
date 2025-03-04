package com.tit.addressbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookEntry {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
}