package group2.demo.dao;

import group2.demo.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GroupJdbc {


    private final JdbcTemplate jdbcTemplate;

    public GroupJdbc(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public Group get(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM study_group WHERE id = ?", this::mapStudy_group, id);
    }

    private Group mapStudy_group(ResultSet rs, int i) throws SQLException{
        Group group= new Group(
                rs.getInt(  "id"),
        rs.getString( "name")
        );
        return group;
    }

    public List<Group> show_all(){
        return jdbcTemplate.query( "SELECT * FROM study_group",this::mapStudy_group);
    }

    public int create(int id, String name){
        return jdbcTemplate.update("INSERT INTO study_group VALUES(?,?)", id, name);
    }

    public int delete(int id){

        return jdbcTemplate.update("DELETE FROM study_group WHERE id= ?",  id);
    }
    public int modify(int id, String name ){
        return jdbcTemplate.update("UPDATE study_group SET name=? WHERE id= ?",name,id);
    }

}