/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_mvc_sampleform.repository;

import com.mycompany.pr31_jv37_spring_mvc_sampleform.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hi_XV
 */
@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    
}
