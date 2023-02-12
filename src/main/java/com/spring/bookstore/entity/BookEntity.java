package com.spring.bookstore.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
//    @NotBlank(message = "Please insert name of book")
    @Column(name = "name")
    private String name;

//    @NotBlank(message = "Please insert author of book")
    @Column(name = "author")
    private String author;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private BookDetailEntity bookDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="categoryId")
    private CategoryEntity category;

    public BookEntity() {
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookDetailEntity getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetailEntity bookDetail) {
        this.bookDetail = bookDetail;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
