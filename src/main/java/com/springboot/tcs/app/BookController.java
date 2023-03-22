package com.springboot.tcs.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addbook")
	public Book createBook(@RequestBody Book book){
		return bookService.addBook(book);
	}
	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id) {
		return bookService.getBook(id);
	}
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id, @RequestBody Book book){
		return bookService.updateBook(id, book);
	}
	@DeleteMapping("/{id}")
	public Book deleteBook(@PathVariable Long id) {
		return bookService.deleteBook(id);
	}
	
	

}
