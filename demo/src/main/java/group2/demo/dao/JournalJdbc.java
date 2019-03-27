package group2.demo.dao;


import group2.demo.model.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JournalJdbc {


    private final JdbcTemplate jdbcTemplate;

    public JournalJdbc(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public Journal get(int id){
        return jdbcTemplate.queryForObject( "SELECT * FROM journal WHERE id = ?", this::mapJournal, id);
    }

    private Journal mapJournal(ResultSet rs, int i) throws SQLException{
        Journal journal= new Journal(
                rs.getInt(  "id"),
        rs.getInt("student_id"),
        rs.getInt("study_plan_id"),
        rs.getBoolean( "in_time" ),
        rs.getInt("count"),
        rs.getInt("mark_id")
        );
        return journal;
    }

    public Journal search_by_group(int study_plan_id){
        return jdbcTemplate.queryForObject( "SELECT * FROM journal WHERE study_plan_id= ?", Journal.class, study_plan_id);
    }

    public Journal search_by_student(int student_id){
        return jdbcTemplate.queryForObject( "SELECT * FROM journal WHERE student_id= ?", Journal.class, student_id);
    }
    public Journal modify( int mark_id, int id){
        return jdbcTemplate.queryForObject("UPDATE journal SET mark=? WHERE id= ?", Journal.class, mark_id,  id);
    }
}
