package com.books.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.books.test.entity.BooksEntity;
import com.books.test.request.BooksReq;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringJUnitConfig.class)
class ApiTest {
	
	String URL = "http://localhost:8085/books";
	
	@Test
	void insert() {
		RestTemplate restTemplate = new RestTemplate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp time = null;
		try {
			time = new Timestamp(format.parse("2022-02-01").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BooksReq request = new BooksReq();
		request.setBookName("逆向工程，你我都能變優秀的祕訣");
		request.setAuthor("Ron Friedman");
		request.setTranslator("陳信宏");
		request.setIsbn("9789861756585");
		request.setPublisher("方智");
		request.setPublicationDate(time);
		request.setPrice(410);
		
		ResponseEntity<BooksEntity> response = restTemplate.postForEntity(URL + "/save", request, BooksEntity.class);
		System.out.print(response.getBody());
	}

	@Test
	void update() {
		RestTemplate restTemplate = new RestTemplate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp time = null;
		try {
			time = new Timestamp(format.parse("2022-02-01").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BooksReq request = new BooksReq();
		request.setId(13);
		request.setBookName("逆向工程，你我都能變優秀的祕訣");
		request.setAuthor("Ron Friedman");
		request.setTranslator("陳信宏");
		request.setIsbn("9789861756585");
		request.setPublisher("方智");
		request.setPublicationDate(time);
		request.setPrice(283);
		
		ResponseEntity<BooksEntity> response = restTemplate.postForEntity(URL + "/save", request, BooksEntity.class);
		System.out.print(response.getBody());
	}
	
	@Test
	void list() {
		RestTemplate restTemplate = new RestTemplate();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp stime = null;
		Timestamp etime = null;
		try {
			stime = new Timestamp(format.parse("2022-01-01").getTime());
			etime = new Timestamp(format.parse("2022-03-30").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BooksReq request = new BooksReq();
		request.setPublicationDate(stime);
		request.setPublicationEDate(etime);
		
		System.out.print(restTemplate.postForObject(URL + "/list", request, List.class));
	}
	
	@Test
	void delete() {
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.delete(URL + "/del/14");
	}
}
