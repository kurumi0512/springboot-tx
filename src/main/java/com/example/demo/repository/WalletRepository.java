package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Wallet;

import jakarta.transaction.Transactional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {

	// 取得客戶餘額
	@Query(value = "select balance from wallet where username = :username", nativeQuery = true)
	Integer getWalletBalance(String username);

	// 更新餘額
	// set 是 SQL 中 UPDATE 語句的一部分，意思是「設定某個欄位的新值」
	// 錢包餘額 = 原本餘額 - 書本價格
	@Modifying
	@Transactional
	@Query(value = "update wallet set balance = balance - :bookPrice where username = :username", nativeQuery = true)
	void updateWalletBalance(Integer bookPrice, String username);
}