package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class StudentController {
    StudentList students = StudentList.getInst();

    public StudentController(){
        students = StudentList.getInst();
    }

    @RequestMapping("/student")
    public Student student(@RequestParam(value = "id",defaultValue = "-1") int id){
        return students.getStudent(id);
    }

    @PostMapping("/student")
    public Student newStudent(@RequestBody Student s){
        students.AddStudent(s);
        return s;
    }
    @GetMapping ("/students")

    public List<Student> allStudent(){
        return  students.GetStudentList();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delStudent(@PathVariable int id){
        try{
            students.delStudent(id);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @PutMapping("/update/{id}")
    public boolean update(@RequestBody Student s,@PathVariable int id){
        try{
            students.updateStudent(s,id);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("/studentlist")
    public List<Student> getfromDB(){
        String sql = "Select * from student";
        List<Student> studentList = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student student = new Student();
                student.setName(rs.getString("name"));
                student.setAddress(rs.getString("address"));
                student.setDob(rs.getString("dob"));
                student.setCourse(rs.getString("course"));
                return student;
            }
        });

        return studentList;
    }

}
