package group2.demo.controller;

import group2.demo.dao.StudentJdbc;
import group2.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin("3000")
public class StudentController {

    private final StudentJdbc studentJdbc;

    public StudentController(StudentJdbc studentJdbc){
        this.studentJdbc = studentJdbc;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = studentJdbc.get(id);
        return student;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
      //  Student student=studentJdbc.show_all();
        return ResponseEntity.ok().body(studentJdbc.show_all());
    }
    @GetMapping("/student/group/{group_id}")
    public List<Student> search_by_group(@PathVariable int group_id) {
        //  Student student=studentJdbc.show_all();
        return studentJdbc.search_by_group(group_id);
    }



    @GetMapping("/students/group={group}")
    public List<Student> getStudentsByGroup(@PathVariable int group) {
        return studentJdbc.search_by_group(group);
    }

    @GetMapping("/student/add/{id}&{surname}&{name}&{second_name}&{study_group}")
    public int addStudent(@PathVariable int id, @PathVariable String surname, @PathVariable String name,
                              @PathVariable String second_name, @PathVariable int study_group_id) {
        return studentJdbc.create(id, surname, name, second_name, study_group_id);
    }

    @GetMapping("/student/delete/{id}")
    public int deleteStudent(@PathVariable int id) {
        return studentJdbc.delete(id);
    }

    @GetMapping("/student/set_surname/{id}&{surname}")
    public int updateSurname(@PathVariable int id, @PathVariable String surname) {
        return studentJdbc.modify_surname(surname,id);
    }

    @GetMapping("/student/set_name/{id}&{name}")
    public int updateName(@PathVariable int id, @PathVariable String name) {
        return studentJdbc.modify_name(name,id);
    }

    @GetMapping("/student/set_secondname/{id}&{secondName}")
    public int updateSecondName(@PathVariable int id, @PathVariable String secondName) {
        return studentJdbc.modify_secondname( secondName,id);
    }

    @GetMapping("/student/set_studygroup/{id}&{studyGroupId}")
    public int updateStudyGroupId(@PathVariable int id, @PathVariable int studyGroupId) {
        return studentJdbc.modify_group( studyGroupId,id);
    }
}
