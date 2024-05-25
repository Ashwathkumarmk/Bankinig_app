package com.ashwath.BankingApp.Controller;

import com.ashwath.BankingApp.Dto.AccountDto;
import com.ashwath.BankingApp.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping()
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto){
        AccountDto account = accountService.createAccount(accountDto);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

   @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable  Long id){
       AccountDto accountById = accountService.getAccountById(id);
       return new ResponseEntity<>(accountById,HttpStatus.OK);
   }
@PutMapping("/{id}/deposit")
   public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){
    Double amount = request.get("amount");
    System.out.println("amount::"+amount);
    AccountDto accountDto = accountService.deposit(id, amount);
    return ResponseEntity.ok(accountDto);
}
@PutMapping("/{id}/withdraw")
public ResponseEntity<AccountDto> withDraw(@PathVariable Long id,@RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=accountService.withDraw(id,amount);
        return ResponseEntity.ok(accountDto);
}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteAccById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return new ResponseEntity<>("account deleted successfully!!",HttpStatus.OK);
}
@GetMapping("/accounts")
public ResponseEntity<List<AccountDto>> getAccounts(){
    List<AccountDto> allAccounts = accountService.getAllAccounts();
    return ResponseEntity.ok(allAccounts);
}

}
