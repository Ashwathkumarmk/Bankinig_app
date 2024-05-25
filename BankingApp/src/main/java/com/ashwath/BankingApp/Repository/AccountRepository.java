package com.ashwath.BankingApp.Repository;

import com.ashwath.BankingApp.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {


}
