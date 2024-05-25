package com.ashwath.BankingApp.Service;

import com.ashwath.BankingApp.Dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    public AccountDto createAccount(AccountDto accountDto);

    public  AccountDto getAccountById(Long id);

    public AccountDto deposit(Long id,double amount);

    public  AccountDto withDraw(Long id,double amount);

    public void deleteAccountById(Long id);

    public List<AccountDto> getAllAccounts();
}
