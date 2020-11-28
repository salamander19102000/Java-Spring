/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr31_jv37_spring_querysql_relationship.repository;

import com.mycompany.pr31_jv37_spring_querysql_relationship.entity.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author XV
 */
@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {

    List<BookEntity> findByAuthorContaining(String author);

    @Query("Select b From BookEntity b Where b.category.name Like %?1% And b.bookDetail.price>= ?2")
    List<BookEntity> findBookByCategoryNameAndPrice(String categoryName, double price);

    @Query(value = " SELECT * FROM book b "
            + " INNER JOIN category c ON b.category_id=c.id "
            + " INNER JOIN book_detail bd ON bd.id=b.id\n "
            + " WHERE c.name Like %?1%"
            + " AND bd.price>= ?2 " , nativeQuery = true)
    List<BookEntity> findBookNativeQuery(String categoryName, double price);
}
