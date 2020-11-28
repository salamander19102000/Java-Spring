/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_querysql_relationship.main;

import com.mycompany.pr31_jv37_spring_querysql_relationship.configuration.SpringConfig;
import com.mycompany.pr31_jv37_spring_querysql_relationship.entity.BookDetailEntity;
import com.mycompany.pr31_jv37_spring_querysql_relationship.entity.BookEntity;
import com.mycompany.pr31_jv37_spring_querysql_relationship.entity.CategoryEntity;
import com.mycompany.pr31_jv37_spring_querysql_relationship.service.BookService;
import com.mycompany.pr31_jv37_spring_querysql_relationship.service.CategoryService;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author XV
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = (BookService) context.getBean("bookService");
        CategoryService categoryService = (CategoryService) context.getBean("categoryService");
        save(bookService, categoryService);
//        displayBook(bookService);
//        delete(bookService);
//        searchByAuthor(bookService);
//        searchCategoryNameAndPricce(bookService);
//        searchCategoryNameAndPricceNativeQuery(bookService);
    }

    public static void delete(BookService bookService) {
        bookService.delete(1);
    }

    public static void searchCategoryNameAndPricceNativeQuery(BookService bookService) {
        List<BookEntity> books = bookService.findBookByCategoryNameAndPrice("ngu van", 10);
        if (!CollectionUtils.isEmpty(books)) {
            for (BookEntity book : books) {
                System.out.println(book.toString());
            }
        } else {
            System.out.println("Not Found!!");
        }
    }

    public static void searchCategoryNameAndPricce(BookService bookService) {
        List<BookEntity> books = bookService.findBookByCategoryNameAndPrice("ngu van", 10);
        if (!CollectionUtils.isEmpty(books)) {
            for (BookEntity book : books) {
                System.out.println(book.toString());
            }
        } else {
            System.out.println("Not Found!!");
        }
    }

    public static void searchByAuthor(BookService bookService) {
        List<BookEntity> books = bookService.findBookByAuthor("k");
        if (!CollectionUtils.isEmpty(books)) {
            for (BookEntity book : books) {
                System.out.println(book.toString());
            }
        } else {
            System.out.println("Not Found!!");
        }
    }

    public static void displayBook(BookService bookService) {
        List<BookEntity> books = bookService.getbook();
        if (!CollectionUtils.isEmpty(books)) {
            for (BookEntity book : books) {
//                System.out.println("=== static display book is==="+ book.get(id));
                System.out.println(book.toString());
            }
        } else {
            System.out.println("Not Found!!");
        }
    }

    public static void save(BookService bookService, CategoryService categoryService) {
        BookEntity book = new BookEntity();
        book.setAuthor("Stephen King");
        book.setName("It");

        BookDetailEntity bookDetail = new BookDetailEntity();
        bookDetail.setIsbn("12h136");
        bookDetail.setNumberOfPages(627);
        bookDetail.setPrice(15.4);
        bookDetail.setPublishDate(new Date());
        bookDetail.setBookEntity(book);

        book.setBookDetail(bookDetail);
        CategoryEntity category = categoryService.findById(201);
        book.setCategory(category);

        bookService.save(book);
    }
}
