package com.aiforpet.core.controller.dto;

import com.aiforpet.core.domain.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record SignUpReq(

        @Email
        String email,
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotEmpty
        String password,
        @NotEmpty
        String address1,
        @NotEmpty
        String address2,
        @NotEmpty
        String zip
) {

        public Account toEntity() {
            return Account.builder()
                    .email(this.email)
                    .firstName(this.firstName)
                    .lastName(this.lastName)
                    .password(this.password)
                    .address1(this.address1)
                    .address2(this.address2)
                    .zip(this.zip)
                    .build();
        }
}
