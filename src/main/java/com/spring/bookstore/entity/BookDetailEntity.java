package com.spring.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookdetail")
public class BookDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
//    @NotBlank(message = "Please insert price")
    @Column(name="price")
    private double price;

//    @NotBlank(message = "Please insert number of page")
    @Column(name = "numberOfPage")
    private int numberOfPage;

    @OneToOne(mappedBy = "bookDetail")
    private BookEntity book;

    public BookDetailEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
