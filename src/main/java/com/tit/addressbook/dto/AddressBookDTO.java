
package com.tit.addressbook.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    @NotBlank(message = "Name is required and cannot be empty")
    @Pattern(regexp = "^[A-Za-z][a-zA-Z ]{2,}$", message = "Name must start with a letter and be at least 3 characters long")
    private String name;
    private String address;
    private String phone;
    private String email;
}
