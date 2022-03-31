package com.books.test.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.books.test.entity.BooksEntity;
import com.books.test.repository.BooksRepository;
import com.books.test.request.BooksReq;
import com.books.test.service.BooksService;

import lombok.extern.slf4j.Slf4j;

@Service("booksService")
@Slf4j
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksRepository repository;
	
	@Override
	public BooksEntity save(BooksReq request) {

		BooksEntity entity = null;
		if (request != null) {
			if (request.getId() == null) {
				entity = new BooksEntity();
			} else {
				entity = repository.getById(request.getId());
			}
			entity.setBookName(request.getBookName());
			entity.setAuthor(request.getAuthor());
			entity.setTranslator(request.getTranslator());
			entity.setIsbn(request.getIsbn());
			entity.setPublisher(request.getPublisher());
			entity.setPublicationDate(request.getPublicationDate());
			entity.setPrice(request.getPrice());
			entity = repository.save(entity);
			log.info("異動成功");
		}
		
		return entity;
	}

	@Override
	public void delete(Integer id) {
		
		if (id != null) {
			repository.deleteById(id);
		}
	}

	public List<BooksEntity> list(BooksReq request) {
		Specification<BooksEntity> spec = (root, query, builder) -> {
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			if (request.getId() != null) {
				predicates.add(builder.equal(root.get("id").as(Integer.class), request.getId()));
			}
			if (StringUtils.isNotBlank(request.getBookName())) {
				predicates.add(builder.equal(root.get("book_name").as(String.class), request.getBookName()));
			}
			if (StringUtils.isNotBlank(request.getAuthor())) {
				predicates.add(builder.equal(root.get("author").as(String.class), request.getAuthor()));
			}
			if (StringUtils.isNotBlank(request.getTranslator())) {
				predicates.add(builder.equal(root.get("translator").as(String.class), request.getTranslator()));
			}
			if (StringUtils.isNotBlank(request.getIsbn())) {
				predicates.add(builder.equal(root.get("ISBN").as(String.class), request.getIsbn()));
			}
			if (StringUtils.isNotBlank(request.getPublisher())) {
				predicates.add(builder.equal(root.get("publisher").as(String.class), request.getPublisher()));
			}
			if (request.getPublicationDate() != null && request.getPublicationEDate() != null) {
				predicates.add(builder.greaterThanOrEqualTo(root.get("publicationDate").as(Timestamp.class), request.getPublicationDate()));
				predicates.add(builder.lessThanOrEqualTo(root.get("publicationDate").as(Timestamp.class), request.getPublicationEDate()));
			}
			if (request.getPrice() != null) {
				predicates.add(builder.equal(root.get("price").as(Integer.class), request.getPrice()));
			}
			
			query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
			query.orderBy(builder.asc(root.get("id")));
			
			return query.getRestriction();
		};
		
		return repository.findAll(spec);
	}
	
}