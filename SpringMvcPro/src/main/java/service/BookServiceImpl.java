package service;

import entity.Book;
import entity.Category;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private List<Category> categories;

    private List<Book> books;

    public BookServiceImpl(){

        categories = new ArrayList<Category>();

        Category category1 = new Category(1,"Computer");

        Category category2 = new Category(2,"Traveller");

        Category category3 = new Category(3,"Health");

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        books = new ArrayList<Book>();

        books.add(new Book(1L,"9876365271","klajklgarjkl",
                category1,"Budi",new BigDecimal(54.99)));

        books.add(new Book(2L,"9876365271","进口国拉进来",
                category1,"Budi",new BigDecimal(64.99)));
    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category getCategory(int id) {

        for(Category category : categories){

            if(id == category.getId()){

                return category;
            }
        }

        return null;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book save(Book book) {

        book.setId(this.getNextId());
        books.add(book);

        return book;
    }

    public Book update(Book book) {

        int bookCount = books.size();

        for(int i=0;i<bookCount;i++){

            Book saveBook = books.get(i);

            if(saveBook.getId() == book.getId()){

                books.set(i,book);
                return book;
            }
        }
        return book;
    }

    public Book get(long id) {

        for(Book book : books){

            if(id == book.getId()){

                return book;
            }
        }
        return null;
    }

    public long getNextId() {

        long id = 0L;
        for(Book book : books){

            long bookId = book.getId();

            if(bookId > id){

                id = bookId;
            }
        }
        return id + 1;
    }
}
