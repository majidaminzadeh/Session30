package com.tosan.session30.controller;

import com.tosan.session30.model.Account;
import com.tosan.session30.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/test")
public class RestServiceTest {

    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public List<Account> getAll(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/account")
    public Account getById(@RequestParam(value = "id", required = false) Long id){
        Optional<Account> account = accountService.getAllAccounts().stream().filter(t -> t.getId().equals(id)).findFirst();
        return account.orElse(new Account());
    }

    @GetMapping("/account/{id}")
    public Account getPathById(@PathVariable("id") Long id){
        Optional<Account> account = accountService.getAllAccounts().stream().filter(t -> t.getId().equals(id)).findFirst();
        return account.orElse(new Account());
    }

    @PostMapping("/account")
    public Account getPathById(@RequestBody Account account){
        account.setId(90l);
        return account;
    }

}
