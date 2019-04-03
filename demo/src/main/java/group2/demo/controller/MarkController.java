package group2.demo.controller;

import group2.demo.dao.MarkJdbc;
import group2.demo.model.Mark;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkController {

    private final MarkJdbc markJdbc;

    public MarkController(MarkJdbc markJdbc){
        this.markJdbc = markJdbc;
    }

    @GetMapping("/mark/{id}")
    public Mark getMark(@PathVariable int id){
        Mark mark = markJdbc.get(id);
        return mark;
    }
    @GetMapping("/mark/search_by_name/{name}")
    public Mark getMark(@PathVariable String name){
        return markJdbc.search(name);
    }

}
