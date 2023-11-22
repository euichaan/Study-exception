package com.aiforpet.core.controller;

import com.aiforpet.core.AccountService;
import com.aiforpet.core.controller.dto.Response;
import com.aiforpet.core.controller.dto.SignUpReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Response signUp(@RequestBody @Valid final SignUpReq request) { // 유효성 검사를 실패하면 MethodArgumentNotValidException
        return new Response(accountService.create(request));
    }
}
