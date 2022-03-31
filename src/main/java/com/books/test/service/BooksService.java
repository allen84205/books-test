package com.books.test.service;

import java.util.List;

import com.books.test.entity.BooksEntity;
import com.books.test.request.BooksReq;

public interface BooksService {
	
	abstract BooksEntity save(BooksReq books);
	
	abstract void delete(Integer id);
	
	abstract List<BooksEntity> list(BooksReq books);
}