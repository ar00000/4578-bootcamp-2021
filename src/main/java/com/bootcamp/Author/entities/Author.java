package com.bootcamp.Author.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        if(book!=null){
            if(books==null){
                books = new HashSet<>();
            }
            book.setAuthor(this);
            books.add(book);
        }
    }

    public void addSubject(Subject subject){
        if(subject!=null){
            if(subjects==null){
                subjects = new HashSet<>();
            }
            subject.setAuthor(this);
            subjects.add(subject);
        }
    }
}
