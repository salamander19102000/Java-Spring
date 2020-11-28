/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_querysql_relationship.repository;

import com.mycompany.pr31_jv37_spring_querysql_relationship.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author XV
 */
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer>{
    
}
