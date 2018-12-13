package service;

import entity.Book;
import entity.Category;

import java.util.List;

public interface BookService {

    public List<Category> getAllCategories();

    public Category getCategory(int id);

    public List<Book> getAllBooks();

    public Book save(Book book);

    public Book update(Book book);

    public Book get(long id);

    public long getNextId();
}
