package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Books;
import com.example.demo.service.BooksService;

@RestController
public class BooksController {
	
@Autowired
	BooksService booksservice;
	
  @PostMapping("/books")
	private int saveBook(@RequestBody Books books)
	{
		booksservice.saveorUpdate(books);
		return books.getBookid();
	}
  
  
  @PutMapping("/books")
	private Books update(@RequestBody Books books)
	{
		booksservice.saveorUpdate(books);
		return books;
	}
  @PutMapping("/books/{bookid}")
 	private String updateById(@RequestBody Books books,@PathVariable("bookid") int bookid)
 	{
 		booksservice.update(books,bookid);
 		return "updated";
 		
 	}
  @DeleteMapping("/book/{bookid}")
	private String deleteBook(@PathVariable("bookid") int bookid)
	{
		booksservice.delete(bookid);
		return "deleted";
		
	}
  
  
  
  
  @DeleteMapping("/deletebook/{bookname}")
 	private String deleteBooks(@PathVariable("bookname") String bookname)
 	{
 		booksservice.deleteByname(bookname);
 		return "Deleted";
 		
 		
 	}
  @GetMapping("/book")
  private List<Books> getAllBooks()
  {
	  return booksservice.getAllBooks();
  }
  @GetMapping("/betweenbook/{start}/{end}")
  private List<Books> getAllBooks(@PathVariable("start")int start,@PathVariable("end")int end)
  {
	  return booksservice.getBooksByBookid(start,end);
  }
  
  
  @GetMapping("/gtbook/{id}")
  private List<Books> getAllBooks(@PathVariable("id")int id)
  {
	  return booksservice.getBooksByBookidgt(id);
  }
  
  
  
  
  
  @GetMapping("/ltbook/{id}")
  private List<Books> getAllBookslt(@PathVariable("id")int id)
  {
	  return booksservice.getBooksByBookidlt(id);
  }
  
  
  @GetMapping("/authorbook/{author}")
  private List<Books> getBooksauthor(@PathVariable("author")String author)
  {
	  return booksservice.getBooksByBookauthor(author);
  }
  
  
  
  @GetMapping("/book/{bookid}")
  private Books getBooks(@PathVariable("bookid") int bookid)
  {
	  return booksservice.getBooksById(bookid);
  }
  
  
  
  
  
  
  
  
  @GetMapping("/findbook/{bookname}")
  private Books getBooks(@PathVariable("bookname") String bookname)
  {
	  return booksservice.getBooksByName(bookname); 
	}
}
