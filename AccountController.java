package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/accounts")
    public List<Account> getAccounts()
    {
        List<Account> accounts = new ArrayList<>();
        for(Account a:accountRepository.findAll())
            accounts.add(a);
        return accounts;
    }

    @RequestMapping("/accounts/{account}")
    public Account getAccount(@PathVariable String account)
    {
        return accountRepository.findById(account).orElse(null);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/accounts")
    public void postAccount(@RequestBody Account account)
    {
        accountRepository.save(account);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/accounts/{account1}")
    public void updateAccount(@RequestBody Account account, @PathVariable String account1)
    {
        accountRepository.save(account);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{account}")
    public void deleteAccount(@PathVariable String account)
    {
        accountRepository.deleteById(account);
    }

    @RequestMapping("/accounts/type/{types}")
    public List<Account> getType(@PathVariable List<String> types)
    {
       List<Account> accounts = new ArrayList<>();
       for(String type:types)
       for(Account a:accountRepository.findBytype(type))
           accounts.add(a);
       return accounts;
    }

}
