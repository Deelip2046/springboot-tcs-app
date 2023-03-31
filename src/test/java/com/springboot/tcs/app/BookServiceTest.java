package com.springboot.tcs.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class BookServiceTest {
	@Mock
	private BookService bookRepository;
	@InjectMocks
	private BookService bookService;

	@Test
	public void addBookTest() {

		Book book = new Book(1L,"Java","Hari");
//		when(bookRepository.save(book)).thenReturn(new Book(1L, "Java","Hari"));
		Book result = bookService.addBook(book);
        assertNotNull(result.getId());
		assertEquals("Java", result.getName());
		assertEquals("Hari",result.getAuthor());
		
 }
	@Test
	public void getBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		bookService.addBook(book);
		Book result = bookService.getBook(1L);
		assertNotNull(result);
		assertEquals("Java", result.getName());
		assertEquals("Hari", result.getAuthor());
		
	}
	@Test
	public void getAllBooksTest() {
		Book book1 = new Book(1L, "Java", "Hari");
		Book book2 = new Book(2L, "Python", "Dr. Dutta");
		bookService.addBook(book1);
		bookService.addBook(book2);
		List<Book> allBooks = bookService.getAllBooks();
		assertNotNull(allBooks);
		assertEquals(2, allBooks.size());
		assertEquals(book1,allBooks.get(0));
		assertEquals(book2,allBooks.get(1));
		
	}
	@Test
	public  void deleteBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		bookService.addBook(book);
//		when(bookRepository).findById(1L).thenReturn(Optional.of(book));
		Book deletedBook = bookService.deleteBook(1L);
        assertNotNull(deletedBook);
		assertEquals("Java", deletedBook.getName());
		assertEquals("Hari", deletedBook.getAuthor());
		assertNull(bookService.getBook(1L));
	}
	@Test
	public void updateBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		bookService.addBook(book);
		Book updatedBook = new Book(1L, "Python", "Sagar");
		Book result = bookService.updateBook(1L, updatedBook);
		assertNotNull(result);
		assertEquals("Python", result.getName());
		assertEquals("Sagar", result.getAuthor());
	}
}
