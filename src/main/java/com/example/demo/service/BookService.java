package com.example.demo.service;

import com.example.demo.exception.InsufficientAmountException;

public interface BookService {
	// 1. 查詢書本價格：回傳 Integer → 有結果需要回傳
	Integer getBookPrice(Integer bookId);

	// 2. 查詢庫存：回傳 Integer → 呼叫者需要知道剩下幾本
	Integer getBookAmount(Integer bookId);

	// 3. 查詢帳戶餘額：回傳 Integer → 需要告訴使用者目前餘額
	Integer getWalletBalance(String username);

	// 4. 減少庫存：不回傳 → 更新資料庫即可，不需回傳值
	void reduceBookAmount(Integer bookId, Integer amountToReduce) throws InsufficientAmountException;

	// 5. 扣帳戶餘額：不回傳 → 只是執行操作
	void reduceWalletBalance(String username, Integer bookPrice) throws InsufficientAmountException;
}
