package com.tosan.session30.controller;

import com.tosan.session30.model.Account;
import com.tosan.session30.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/test")
public class RestServiceTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestServiceTest.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/all")
    public List<Account> getAll(){
        LOGGER.error("ERROR");
        LOGGER.warn("WARN");
        LOGGER.info("INFO");
        LOGGER.debug("DEBUG");
        LOGGER.trace("TRACE");
        return accountService.getAllAccounts();
    }

    @GetMapping("/account")
    public Account getByCode(@RequestParam(value = "code", required = false) String code){
//        Optional<Account> account = accountService.getAllAccounts().stream().filter(t -> t.getCode() != null && t.getCode().equals(code)).findFirst();
//        return account.orElse(new Account());
        return accountService.getAccountByCode(code);
    }

    @GetMapping("/account/{id}")
    public Account getPathById(@PathVariable("id") Long id){
//        Optional<Account> account = accountService.getAllAccounts().stream().filter(t -> t.getId().equals(id)).findFirst();
        Account account = accountService.getAccountById(id);
        return account;
    }

    @PostMapping("/account")
    public Account getPathById(@RequestBody Account account){
        account.setId(90l);
        return account;
    }

    @GetMapping("/account/title/{title}")
    public List<Account> getByTitle(@PathVariable("title") String title){
//        account.setId(90l);
//        return account;
        return accountService.getAccountByTitle(title);
    }

    @GetMapping("/account/code/{code}/title/{title}")
    public List<Account> getByTitle(@PathVariable("code") String code, @PathVariable("title") String title){
//        account.setId(90l);
//        return account;
        return accountService.getAccountByCodeAndTitle(code, title);
    }

    @PostMapping("/account/create")
    public Account create(@RequestBody Account account){
        try {
            account = accountService.save(account);
        } catch (RuntimeException ex) {
            LOGGER.error("Exception occured: {}", ex);
//            throw ex;
        }
        return account;
    }
}
