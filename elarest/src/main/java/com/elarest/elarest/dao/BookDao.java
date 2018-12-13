package com.elarest.elarest.dao;

import com.elarest.elarest.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends CrudRepository<Book,String> {

    public List<Book> getByMessage(String key);
}
