package group2.demo.controller;

import group2.demo.dao.GroupJdbc;
import group2.demo.model.Group;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

public class GroupController {

    private final GroupJdbc groupJdbc;

    public GroupController(GroupJdbc groupJdbc){
        this.groupJdbc= groupJdbc;
    }

    @GetMapping("/group/{id}")
    public Group getGroup(@PathVariable int id){
       Group group = groupJdbc.get(id);
        return group;
    }

    @GetMapping("/groups")
    public List<Group> get_all(){
        return groupJdbc.show_all();
    }


    @GetMapping("/group/add/{id}&{name}")
    public Group add_group(@PathVariable int id, @PathVariable String name){
        return groupJdbc.create(id,name);
    }
    @GetMapping("/group/delete/{id}")
    public Group delete_group(@PathVariable int id){
        return groupJdbc.delete(id);
    }
}

