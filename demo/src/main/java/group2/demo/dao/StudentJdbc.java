package group2.demo.dao;

import group2.demo.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public List<Student> search_by_group(int study_group_id){
        return jdbcTemplate.query( "SELECT * FROM student WHERE study_group_id= ?", this::mapStudent, study_group_id);
    }

    public List<Student> show_all(){
        return jdbcTemplate.query("SELECT * FROM student",this::mapStudent);// Student.class);
    }

    public int create(int id, String surname, String name, String second_name, int study_group_id){
        return jdbcTemplate.update("INSERT INTO student VALUES(?,?,?,?,?)", id, surname, name, second_name, study_group_id);
    }

    public int delete(int id){
        return jdbcTemplate.update( "DELETE FROM student WHERE ID= ?",  id);
    }
    public int modify_name( String name, int id){
        return jdbcTemplate.update( "UPDATE student SET NAME=? WHERE id= ?", name, id);
    }
    public int modify_surname( String surname, int id){
        return jdbcTemplate.update( "UPDATE student SET SURNAME=? WHERE id= ?",  surname,  id);
    }

    public int modify_secondname( String second_name, int id){
        return jdbcTemplate.update( "UPDATE student SET SECOND_NAME =? WHERE id= ?",  second_name,id);
    }
    public int modify_group(int id, int studyGroupId) {
        return jdbcTemplate.update("UPDATE STUDENT SET STUDY_GROUP_ID=? WHERE ID=?", studyGroupId, id);
    }
}
