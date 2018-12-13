package com.mongodb.controller;

import com.mongodb.bulk.UpdateRequest;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.entity.Baike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Controller
public class OperateMongodbController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping(path = "/add-baike")
    public @ResponseBody Baike addBaike(Baike baike){

        baike.setCreateDate(new Date());
        mongoTemplate.insert(baike);

        return baike;
    }

    @GetMapping(path = "/find/{id}")
    public @ResponseBody Baike findBaike(@PathVariable String id){

        return mongoTemplate.findById(id,Baike.class);
    }

    @GetMapping(path = "/query/{bad}")
    public @ResponseBody List<Baike> queryBaike(@PathVariable long bad){

        Criteria criteria = where("comment.bad").gt(bad);

        List<Baike> baikes = mongoTemplate.find(Query.query(criteria),Baike.class);

        return baikes;
    }

    @GetMapping(path = "/update/{tag}")
    public @ResponseBody String updateMulti(@PathVariable String tag){

        Criteria criteria = where("tag").in(tag);

        Update update = new Update();
        update.inc("comment.bad",1);
        UpdateResult result = mongoTemplate.
                updateMulti(Query.query(criteria),update,Baike.class);

        return "成功修改" + result.getModifiedCount();
    }
}
