package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	// 取得書本價格
	// 自訂 SQL 查詢語法
	// 這是一段原生 SQL 查詢：從 book 資料表中，依據 book_id 查出 book_price。其中 :bookId 是命名參數。:要黏在一起
	// nativeQuery = true 表示這是一段「原生 SQL」，而不是 JPQL（JPA 的查詢語言）。
	@Query(value = "select book_price from book where book_id = :bookId", nativeQuery = true)
	Integer getBookPrice(Integer bookId);
}
