package group2.demo.controller;

import group2.demo.dao.JournalJdbc;
import group2.demo.model.Journal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

public class JournalController {

    private final  JournalJdbc journalJdbc;

    public JournalController(JournalJdbc journalJdbc){
        this.journalJdbc = journalJdbc;
    }

    @GetMapping("/journal/{id}")
    public Journal getJournal(@PathVariable int id){
        Journal journal = journalJdbc.get(id);
        return journal;
    }

}
