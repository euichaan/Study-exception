package com.aiforpet.core.controller;

import com.aiforpet.core.AccountService;
import com.aiforpet.core.controller.dto.MyAccountReq;
import com.aiforpet.core.controller.dto.Response;
import com.aiforpet.core.controller.dto.SignUpReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Response signUp(@RequestBody @Valid final SignUpReq request) { // 유효성 검사를 실패하면 MethodArgumentNotValidException
        return new Response(accountService.create(request));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response getAccount(@PathVariable final long id) {
        return new Response(accountService.findById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response updateMyAccount(@PathVariable final long id, @RequestBody final MyAccountReq request) {
        return new Response(accountService.updateMyAccount(id, request));
    }
}
