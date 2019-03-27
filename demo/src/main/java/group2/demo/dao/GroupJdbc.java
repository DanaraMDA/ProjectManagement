package group2.demo.dao;

import group2.demo.model.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public Group show_all(){
        return jdbcTemplate.queryForObject( "SELECT * FROM study_group",Group.class);
    }

    public Group create(int id, String name){
        return jdbcTemplate.queryForObject("INSERT INTO study_group VALUES(?,?)", Group.class, id, name);
    }

    public Group delete(int id){
        return jdbcTemplate.queryForObject( "DELETE FROM study_group WHERE id= ?", Group.class, id);
    }
    public Group modify( String name, int id){
        return jdbcTemplate.queryForObject("UPDATE study_group SET name=? WHERE id= ?", Group.class, name,id);
    }

}