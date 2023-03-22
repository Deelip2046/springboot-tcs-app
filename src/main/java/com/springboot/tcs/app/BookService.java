package com.springboot.tcs.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	private Map<Long, Book> books = new HashMap<>();
	private Long nextId = 1L;
	
	public Book addBook(Book book) {
		book.setId(nextId++);
		books.put(book.getId(), book);

		return book;
	}
	public Book getBook(Long id) {
		return books.get(id);
	}
	public List<Book> getAllBooks(){
		return new ArrayList<>(books.values());
	}
	public Book deleteBook(Long id) {
		return books.remove(id);
	}

	public Book updateBook(Long id,Book book) {
		book.setId(id);
		books.put(id, book);
		return book;
	}
}
	





