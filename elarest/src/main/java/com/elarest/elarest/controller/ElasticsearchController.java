package com.elarest.elarest.controller;

import com.elarest.elarest.dao.BookDao;
import com.elarest.elarest.entity.Book;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class ElasticsearchController {

    @Autowired
    private BookDao bookDao;

    @GetMapping(path = "/restclient/book/{id}")
    public @ResponseBody String getLogById(@PathVariable String id) throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        Map<String,Object> paras = new HashMap<>();

        paras.put("id",id);

        String str = restTemplate.getForObject("http://localhost:9200/product/book/{id}",
                String.class,
                paras);

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(str);
        JsonNode root = mapper.readTree(parser);
        JsonNode sourceNode = root.get("_source");

        Book book = mapper.convertValue(sourceNode,Book.class);

        return book.getMessage();
    }

    @GetMapping(path = "/springdata/book/{id}")
    public @ResponseBody String getBookById(@PathVariable String id){

        Optional<Book> opt = bookDao.findById(id);
        Book book = opt.get();

        return book.getMessage();
    }

    @GetMapping(path = "/springdata/search/{key}")
    public @ResponseBody List<Book> search(@PathVariable String key){

        List<Book> list = bookDao.getByMessage(key);

        return list;
    }
}
