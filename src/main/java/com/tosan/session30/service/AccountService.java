package com.tosan.session30.service;

import com.tosan.session30.data.AccountRepository;
import com.tosan.session30.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAllAccounts(){
        List<Account> accounts = repository.findAll();
        return accounts;
    }

}
