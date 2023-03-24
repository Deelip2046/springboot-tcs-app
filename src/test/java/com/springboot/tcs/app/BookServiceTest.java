package com.springboot.tcs.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class BookServiceTest {
	private BookService bookService= new BookService();

	@Test
	public void addBookTest() {

		Book book = new Book(1L,"Java","Hari");
		Book result = bookService.addBook(book);

		assertEquals("Java", result.getName());
		assertEquals("Hari",result.getAuthor());
		
 }
	@Test
	public void getBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		bookService.addBook(book);
		Book result = bookService.getBook(1L);
		assertEquals("Java", result.getName());
		assertEquals("Hari", result.getAuthor());
		
	}
	@Test
	public void getAllBooksTest() {
		Book book1 = new Book(1L, "Java", "Hari");
		Book book2 = new Book(2L, "Python", "Dr. Dutta");
		bookService.addBook(book1);
		bookService.addBook(book2);
		List<Book> books = bookService.getAllBooks();
		assertEquals(2, books.size());
		
	}
	@Test
	public void deleteBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		bookService.addBook(book);
		Book result = bookService.deleteBook(1L);

		assertEquals("Java", result.getName());
		assertEquals("Hari", result.getAuthor());
	}
	@Test
	public void updateBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		bookService.addBook(book);
		Book updatedBook = new Book(1L, "Python", "Sagar");
		Book result = bookService.updateBook(1L, updatedBook);
		assertEquals("Python", result.getName());
		assertEquals("Sagar", result.getAuthor());
	}
}
