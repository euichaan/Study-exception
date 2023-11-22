package com.aiforpet.core;

import com.aiforpet.core.controller.dto.MyAccountReq;
import com.aiforpet.core.controller.dto.SignUpReq;
import com.aiforpet.core.domain.Account;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public Account create(SignUpReq request) {
        return accountRepository.save(request.toEntity());
    }

    @Transactional(readOnly = true)
    public Account findById(long id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Account updateMyAccount(long id, MyAccountReq request) {
        final Account account = accountRepository.findById(id).orElseThrow();
        account.updateMyAccount(request);
        return account;
    }
}
