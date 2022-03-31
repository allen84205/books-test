package com.books.test.request;

import java.io.Serializable;
import java.sql.Timestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BooksReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2845649554517816773L;

	@Schema(description = "流水碼")
    private Integer id;

	@Schema(description = "書名")
    private String bookName;

	@Schema(description = "作者")
    private String author;

	@Schema(description = "譯者")
    private String translator;

	@Schema(description = "ISBN")
    private String isbn;

	@Schema(description = "出版商")
    private String publisher;

	@Schema(description = "出版日期", type = "date", pattern = "YYYY-MM-DD")
    private Timestamp publicationDate;

	@Schema(description = "價格")
    private Integer price;
	
	@Schema(description = "查詢出版結束日", type = "date", pattern = "YYYY-MM-DD")
    private Timestamp publicationEDate;
}
