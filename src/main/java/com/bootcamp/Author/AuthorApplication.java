package com.bootcamp.Author;

import com.bootcamp.Author.entities.Address;
import com.bootcamp.Author.entities.Author;
import com.bootcamp.Author.entities.Book;
import com.bootcamp.Author.entities.Subject;
import com.bootcamp.Author.repos.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AuthorApplication {

	@Autowired
	public static AuthorRepository repository;

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AuthorApplication.class, args);
		repository = applicationContext.getBean(AuthorRepository.class);
		createAuthor();
	}

	public static void createAuthor(){
		Author author = new Author();
		author.setName("Ruskin Bond");
		Address address = new Address();
		address.setStreetNumber("72");
		address.setLocation("Mt. Top Hill");
		address.setState("Himachal Pradesh");
		author.setAddress(address);

		Subject subject = new Subject();
		subject.setName("English");
		Subject subject1 = new Subject();
		subject1.setName("Physics");
		Subject subject2 = new Subject();
		subject2.setName("Computer Science");

		author.addSubject(subject);
		author.addSubject(subject1);
		author.addSubject(subject2);

		Book book = new Book();
		book.setName("Ek tha Rusty");
		author.setBook(book);

		repository.save(author);
	}

}
