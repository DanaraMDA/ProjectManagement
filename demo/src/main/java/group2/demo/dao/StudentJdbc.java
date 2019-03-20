package group2.demo.dao;

import group2.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentJdbc {


    private final JdbcTemplate jdbcTemplate;

    public StudentJdbc(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public Student get(int id){
        return jdbcTemplate.queryForObject(sql: "SELECT * FROM student WHERE id = ?", this::mapStudent, id);
    }

    private Student mapStudent(ResultSet rs, int i) throws SQLException{
        Student student= new Student(
                rs.getInt( columnLabel: "id"),
        rs.getString(columnLabel: "surname"),
        rs.getString(columnLabel: "name"),
        rs.getString(columnLabel: "second_name"),
        rs.getInt(columnLabel: "study_group_id")
        );
        return student;
    }

    public Student search_by_group(int study_group_id){
        return jdbcTemplate.queryForObject(sql: "SELECT * FROM student WHERE study_group_id= ?", Student.class, study_group_id);
    }

    public Student show_all(){
        return JdbcTemplate.queryForObject(sql: "SELECT * FROM student");
    }

    public Student create(int id, String surname, String name, String second_name, int study_group_id){
        return JdbcTemplate.queryForObject(sql: "INSERT INTO student VALUES(?,?,?,?,?)", Student.class, id, Student.class, surname, Student.class, name, Student.class, second_name, Student.class, study_group_id);
    }

    public Student delete(int id){
        return jdbcTemplate.queryForObject(sql: "DELETE FROM student WHERE id= ?", Student.class, id);
    }
    public Student modify( String name, int id){
        return jdbcTemplate.queryForObject(sql: "UPDATE student SET name=? WHERE id= ?", Student.class, name, Student.class, id);
    }

}
