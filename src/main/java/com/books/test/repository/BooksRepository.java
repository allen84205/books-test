package com.books.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.books.test.entity.BooksEntity;

public interface BooksRepository extends JpaRepository<BooksEntity, Integer>, JpaSpecificationExecutor<BooksEntity> {

}
