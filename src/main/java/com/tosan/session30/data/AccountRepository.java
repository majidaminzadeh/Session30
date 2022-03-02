package com.tosan.session30.data;

import com.tosan.session30.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> { // AccountDAO in EJB
}
