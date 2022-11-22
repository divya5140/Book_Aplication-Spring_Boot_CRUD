package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	Books findBooksByBookname(String bookname);
	
	List<Books> findBooksByBookidBetween(int start,int end);
	
	List<Books> findBooksByBookidGreaterThan(int id);
	
	
	List<Books> findBooksByBookidLessThan(int id);
	
	
	List<Books> findBooksByAuthorLike(String author);

}