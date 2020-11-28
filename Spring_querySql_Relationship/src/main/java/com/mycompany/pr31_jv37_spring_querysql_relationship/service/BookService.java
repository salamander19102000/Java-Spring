/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_querysql_relationship.service;

import com.mycompany.pr31_jv37_spring_querysql_relationship.entity.BookEntity;
import com.mycompany.pr31_jv37_spring_querysql_relationship.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XV
 */
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    
    public void save(BookEntity book){
        bookRepository.save(book);
    }
    
    public List<BookEntity>getbook(){
        return (List<BookEntity>)bookRepository.findAll();
    }
    
    public void delete(int id) {
        bookRepository.deleteById(id);
    }
    public List<BookEntity> findBookByAuthor(String author){
        return bookRepository.findByAuthorContaining(author);
    }
    
    public List<BookEntity> findBookByCategoryNameAndPrice(String CategoryName, double price){
        return bookRepository.findBookByCategoryNameAndPrice(CategoryName, price);
    }
    
    public List<BookEntity> findBookByCategoryNameAndPriceNativeQuery(String CategoryName, double price){
        return bookRepository.findBookNativeQuery(CategoryName, price);
    }
    
}
