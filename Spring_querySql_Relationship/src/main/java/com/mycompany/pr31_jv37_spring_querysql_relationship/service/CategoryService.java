/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_querysql_relationship.service;

import com.mycompany.pr31_jv37_spring_querysql_relationship.entity.CategoryEntity;
import com.mycompany.pr31_jv37_spring_querysql_relationship.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XV
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public CategoryEntity findById(int id){
        return categoryRepository.findById(id).get();
    }
}
