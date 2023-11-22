package com.aiforpet.core.controller.dto;

import com.aiforpet.core.domain.Account;

public record Response(

        String email,
        String firstName,
        String lastName,
        String password,
        String address1,
        String address2,
        String zip
) {

    public Response(Account account) {
        this(account.getEmail(), account.getFirstName(), account.getLastName(),
                account.getPassword(), account.getAddress1(), account.getAddress2(), account.getZip());
    }
}
