package com.springboot.tcs.app;

import java.util.List;

import org.springframework.stereotype.Repository;
public interface BookRepository extends JpaRepository <Book, Long>{

	Book save(Book book);

	Book findById(Long id);

	List<Book> findAll();

	void deleteById(Long id);

	boolean existsById(Long id);
	

}

