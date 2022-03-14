package com.tosan.session30.data;

import com.tosan.session30.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> { // AccountDAO in EJB
    Account findAccountByCode(String code);
    List<Account> findAccountByTitleIsContaining(String title);
    List<Account> findAccountByCodeIsContainingOrTitleIsContaining(String code, String title);

    @Query("SELECT acc FROM Account acc where acc.code=?1")
    Account customFindByCode(String code);
}
