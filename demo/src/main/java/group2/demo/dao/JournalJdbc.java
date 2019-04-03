package group2.demo.dao;


import group2.demo.model.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JournalJdbc {


    private final JdbcTemplate jdbcTemplate;

    public JournalJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Journal get(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM journal WHERE id = ?", this::mapJournal, id);
    }

    private Journal mapJournal(ResultSet rs, int i) throws SQLException {
        Journal journal = new Journal(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getBoolean("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id")
        );
        return journal;
    }


    public List<Journal> get_all() {
        return jdbcTemplate.query("Select * FROM journal", this::mapJournal);
    }

    public List<Journal> search_by_group(int study_plan_id) {
        return (List<Journal>) jdbcTemplate.queryForObject("SELECT * FROM journal WHERE study_plan_id= ?", this::mapJournal, study_plan_id);
    }

    public Journal search_by_student(int student_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM journal WHERE student_id= ?", this::mapJournal, student_id);
    }


    public int add(int id, int student_id, int study_plan_id, boolean in_time, int count, int mark_id) {
        return jdbcTemplate.update("INSERT INTO journal VALUES ( ?, ?, ?, ?, ?, ? )", id, student_id, study_plan_id, in_time, count, mark_id);
    }

    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM journal WHERE id=?", id);
    }


    public int modify_by_student_id(int id, int student_id) {
        return jdbcTemplate.update("UPDATE journal SET student_id=? WHERE id=?", student_id, id);
    }

    public int modify_by_study_plan_id(int id, int study_plan_id) {
        return jdbcTemplate.update("UPDATE journal SET study_plan_id=? WHERE id=?", study_plan_id, id);
    }

    public int modify_in_time(int id, boolean in_time) {
        return jdbcTemplate.update("UPDATE journal SET in_time=? WHERE id=?", in_time, id);
    }

    public int modify_count(int id, int count) {
        return jdbcTemplate.update("UPDATE journal SET count=? WHERE id=?", count, id);
    }

    public int modify_mark_id(int id, int mark_id) {
        return jdbcTemplate.update("UPDATE journal SET mark_id=? WHERE id=?", mark_id, id);
    }
}