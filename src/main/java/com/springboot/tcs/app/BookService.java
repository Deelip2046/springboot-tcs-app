package com.springboot.tcs.app;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);	
	}
	public Book getBook(Long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	public Book deleteBook(Long id) {
		bookRepository.deleteById(id);
		return deleteBook(null);
	}
	public Book updateBook(Long id, Book book) {
		if(bookRepository.existsById(id)) {
			book.setId(id);
			return bookRepository.save(book);
		
		}
		return null;
	}
	
}
	





