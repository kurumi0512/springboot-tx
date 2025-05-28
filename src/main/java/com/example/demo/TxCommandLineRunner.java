package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.exception.InsufficientAmountException;
import com.example.demo.service.BuyService;

@Component // 元件
//CommandLineRunner：這個介面讓此類別在 應用啟動完成後自動執行 run() 方法，常用來執行初始化邏輯或測試程式碼。
public class TxCommandLineRunner implements CommandLineRunner {

	@Autowired
	private BuyService buyService;

	// 模擬一筆購書行為（指定使用者與書籍 ID）。
	// 若資金不足，會拋出 InsufficientAmountException，並印出錯誤訊息。
	private void buyBook(String username, Integer bookId) {
		try {
			buyService.buyOneBook(username, bookId);
		} catch (InsufficientAmountException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override // 執行 buyBook("john", 1)，模擬使用者 john 購買書籍 ID 為 1 的書。
	public void run(String... args) throws Exception {
		try {
			buyBook("john", 1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
