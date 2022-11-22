package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Books;
import com.example.demo.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	BooksRepository booksRepository;
	
	public Books update(Books books,int bookid)
	{
		Books b1=booksRepository.findById(bookid).get();
		b1.setAuthor(books.getAuthor());
		b1.setBookname(books.getBookname());
		b1.setPrice(books.getPrice());
		return booksRepository.save(b1);
	}
	public String saveorUpdate(Books books)
	{
			booksRepository.save(books);
			return "Book saved";
	}
	public void delete(int id)
	{
		booksRepository.deleteById(id);
	}
	public  List<Books> getAllBooks()
	{
		List<Books> books=booksRepository.findAll();
		return books;
	}
	public Books getBooksById(int id)
	{
		return booksRepository.findById(id).get();
	}
	public Books getBooksByName(String bookname)
	{
		Books books = booksRepository.findBooksByBookname(bookname);
		
		return books;
	}
	public List<Books> getBooksByBookid(int start,int end)
	{
		List<Books> books=booksRepository.findBooksByBookidBetween(start, end);
		return books;
	}
	
	
	public List<Books> getBooksByBookauthor(String author)
	{
		List<Books> books=booksRepository.findBooksByAuthorLike(author);
		return books;
	}
	
	public List<Books> getBooksByBookidgt(int id)
	{
		List<Books> books=booksRepository.findBooksByBookidGreaterThan(id);
		return books;
	}
	
	public List<Books> getBooksByBookidlt(int id)
	{
		List<Books> books=booksRepository.findBooksByBookidLessThan(id);
		return books;
	}
	
	
	public String deleteByname(String bookname) {
		// TODO Auto-generated method stub
		Books books=booksRepository.findBooksByBookname(bookname);
		if(books != null)
		{
			booksRepository.delete(books);		
		}
		return bookname;
	}
	
}
