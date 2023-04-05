package com.springboot.tcs.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
	private BookRepository bookRepository;
	@InjectMocks
	private BookService bookService;

	@Test
	public void addBookTest() {
		Book book = new Book(1L,"Java","Hari");
		when(bookRepository.save(book)).thenReturn(book);
		Book result = bookService.addBook(book);
        assertNotNull(result.getId());
		assertEquals("Java", result.getName());
		assertEquals("Hari",result.getAuthor());
		
 }
	@Test
	public void getBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
		Book result = bookService.getBook(1L);
		assertNotNull(result);
		assertEquals("Java", result.getName());
		assertEquals("Hari", result.getAuthor());
		
	}
	@Test
	public void getAllBooksTest() {
		Book book1 = new Book(1L, "Java", "Hari");
		Book book2 = new Book(2L, "Python", "Dr. Dutta");
		List<Book> bookList = List.of(book1,book2);
		when(bookRepository.findAll()).thenReturn(bookList);
		List<Book> allBooks = bookService.getAllBooks();
		assertNotNull(allBooks);
		assertEquals(2, allBooks.size());
		assertEquals(book1,allBooks.get(0));
		assertEquals(book2,allBooks.get(1));
		
	}
	@Test
	public void deleteBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
		bookService.deleteBook(1L);
		verify(bookRepository,times(1)).deleteById(1L);

	}
	@Test
	public void updateBookTest() {
		Book book = new Book(1L, "Java", "Hari");
		when(bookRepository.existsById(1L)).thenReturn(true);
		when(bookRepository.save(book)).thenReturn(book);
		
		Book result = bookService.updateBook(1L,book);
		assertNotNull(result);
		assertEquals("Java", result.getName());
		assertEquals("Hari", result.getAuthor());
	}
}
