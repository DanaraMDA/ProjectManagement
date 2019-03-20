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
        return jdbcTemplate.queryForObject( "SELECT * FROM student WHERE id = ?", this::mapStudent, id);
    }

    private Student mapStudent(ResultSet rs, int i) throws SQLException{
        Student student= new Student(
        rs.getInt("id"),
        rs.getString( "surname"),
        rs.getString( "name"),
        rs.getString("second_name"),
        rs.getInt("study_group_id")
        );
        return student;
    }

    public Student search_by_group(int study_group_id){
        return jdbcTemplate.queryForObject( "SELECT * FROM student WHERE study_group_id= ?", Student.class, study_group_id);
    }

    public Student show_all(){
        return jdbcTemplate.queryForObject("SELECT * FROM student", Student.class);
    }

    public Student create(int id, String surname, String name, String second_name, int study_group_id){
        return jdbcTemplate.queryForObject("INSERT INTO student VALUES(?,?,?,?,?)", Student.class, id, surname, name, second_name, study_group_id);
    }

    public Student delete(int id){
        return jdbcTemplate.queryForObject( "DELETE FROM student WHERE id= ?", Student.class, id);
    }
    public Student modify( String name, int id){
        return jdbcTemplate.queryForObject( "UPDATE student SET name=? WHERE id= ?", Student.class, name, Student.class, id);
    }

}
