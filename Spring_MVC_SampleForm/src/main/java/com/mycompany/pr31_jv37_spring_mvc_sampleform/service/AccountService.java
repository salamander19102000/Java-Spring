/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_sampleform.service;

import com.mycompany.pr31_jv37_spring_mvc_sampleform.entity.AccountEntity;
import com.mycompany.pr31_jv37_spring_mvc_sampleform.repository.AccountRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hi_XV
 */
@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;
    
    public List<AccountEntity> getAccounts(){
        return (List<AccountEntity>) accountRepository.findAll();
        
    }
    public void save(AccountEntity account){
        accountRepository.save(account);
    }
    
    public AccountEntity findAccountById(int id){
        Optional< AccountEntity> account= accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();
        }
        else {
            return new AccountEntity();
        }
    }
    
    public boolean delete(int id){
        accountRepository.deleteById(id);
        return accountRepository.existsById(id);
    }
}
