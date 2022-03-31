package com.books.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.books.test.entity.BooksEntity;
import com.books.test.request.BooksReq;
import com.books.test.service.BooksService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * BooksController
 *
 * @author Allen
 */
@Tag(name = "書籍管理")
@RestController
@RequestMapping(path = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BooksController {

    @Autowired
    private BooksService service;

    @ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "新增/修改", description = "書本新增/修改")
    @RequestMapping(value = "/save", method = { RequestMethod.POST })
    public Object save(@RequestBody BooksReq request) {
        return service.save(request);
    }

    @ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "刪除", description = "書本刪除")
    @RequestMapping(value = "/del/{id}", method = { RequestMethod.DELETE })
    public void delById(@PathVariable Integer id) {
        service.delete(id);
    }

    @ResponseStatus(value = HttpStatus.OK)
	@Operation(summary = "查詢", description = "書本條件查詢")
    @RequestMapping(value = "/list", method = { RequestMethod.POST })
    public List<BooksEntity> getByIds(@RequestBody BooksReq request) {
        return service.list(request);
    }

}