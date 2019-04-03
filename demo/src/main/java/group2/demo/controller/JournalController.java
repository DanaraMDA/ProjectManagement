package group2.demo.controller;

import group2.demo.dao.JournalJdbc;
import group2.demo.model.Journal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    @GetMapping("/journals")
    public List<Journal> show_all() {
        return journalJdbc.get_all();
    }

    @GetMapping("/journal/get_student/{student_id}")
    public Journal show_student(@PathVariable int student_id) {
        return journalJdbc.search_by_student(student_id);
    }

    @GetMapping("/journal/get_study_plan/{study_plan_id}")
    public List<Journal> show_study_plan(@PathVariable int study_plan_id) {

        return journalJdbc.search_by_group(study_plan_id);
    }

    @GetMapping("/journal/add/{id}&{student_id}&{study_plan_id}&{in_time}&{count}&{mark_id}")
    public int add_journal(@PathVariable int id, @PathVariable int student_id, @PathVariable int study_plan_id, @PathVariable boolean in_time, @PathVariable int count, @PathVariable int mark_id) {
        return journalJdbc.add(id, student_id, study_plan_id, in_time, count, mark_id);
    }

    @GetMapping("journal/delete/{id}")
    public int delete_journal(@PathVariable int id) {
        return journalJdbc.delete(id);
    }

    @GetMapping("journal/set_student_id/{id}&{student_id}")
    public int update_student_id(@PathVariable int id, @PathVariable int student_id) {
        return journalJdbc.modify_by_student_id(id, student_id);
    }

    @GetMapping("journal/set_study_plan_id/{id}&{study_plan_id}")
    public int update_study_slan_id(@PathVariable int id, @PathVariable int study_plan_id) {
        return journalJdbc.modify_by_study_plan_id(id, study_plan_id);
    }

    @GetMapping("journal/set_in_time/{id}&{in_time}")
    public int update_in_time(@PathVariable int id, @PathVariable boolean in_time) {
        return journalJdbc.modify_in_time(id, in_time);
    }

    @GetMapping("journal/set_count/{id}&{count}")
    public int update_count(@PathVariable int id, @PathVariable int count) {
        return journalJdbc.modify_count(id, count);
    }

    @GetMapping("journal/set_mark_id/{id}&{markId}")
    public int update_mark_id(@PathVariable int id, @PathVariable int mark_id) {
        return journalJdbc.modify_mark_id(id, mark_id);
    }
}
