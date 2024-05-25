package com.ashwath.BankingApp.ServiceImpl;

import com.ashwath.BankingApp.Dto.AccountDto;
import com.ashwath.BankingApp.Entity.Account;
import com.ashwath.BankingApp.ExceptionHandling.UserNotFoundException;
import com.ashwath.BankingApp.Mapper.AccountMapper;
import com.ashwath.BankingApp.Repository.AccountRepository;
import com.ashwath.BankingApp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
      //  Account account=new Account();
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);


        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() ->  new UserNotFoundException("account does not exist with given id:"+ id));


        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("account does not exist with given id:" + id));
        double balance = account.getBalance();
        double updatedBal=balance+amount;
        account.setBalance(updatedBal);
        Account savedAcc = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAcc);

    }

    @Override
    public AccountDto withDraw(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("account does not exist with given id:" + id));
        double balance = account.getBalance();
        if(balance<amount){
            throw  new RuntimeException("Insufficient fund");
        }
        double updatedBal=balance-amount;
        account.setBalance(updatedBal);
        Account savedAcc = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAcc);

    }

    @Override
    public void deleteAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("account does not exist with given id:" + id));
         accountRepository.deleteById(id);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
      return  accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
               .collect(Collectors.toList());
    }
}
