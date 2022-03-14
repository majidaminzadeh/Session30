package com.tosan.session30.service;

import com.tosan.session30.data.AccountRepository;
import com.tosan.session30.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private AccountService accountService;

    public List<Account> getAllAccounts(){
        List<Account> accounts = repository.findAll();
        return accounts;
    }

    public Account getAccountById(Long id){
        if(id == null){
            return null;
        }
        Optional<Account> account = repository.findById(id);
        return account.orElse(null);
    }

    public Account getAccountByCode(String code){
        if(code == null){
            return null;
        }
//        Account account = repository.findAccountByCode(code);
        Account account = repository.customFindByCode(code);
        return account;
    }

    public List<Account> getAccountByTitle(String title){
        if(title == null){
            return null;
        }
        List<Account> account = repository.findAccountByTitleIsContaining(title);
        return account;
    }
    public List<Account> getAccountByCodeAndTitle(String code, String title){
//        if(title == null){
//            return null;
//        }
        List<Account> account = repository.findAccountByCodeIsContainingOrTitleIsContaining(code, title);
        return account;
    }

    @Transactional
    public Account save(Account account) {
        //...
        Account account1 = repository.save(account);
        //..
        ex();
        return account1;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void ex() {
        throw new RuntimeException("exception mockup");
    }
}
