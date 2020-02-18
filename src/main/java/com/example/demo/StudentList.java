package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    List<Student> sList;
    private  static StudentList inst = null;
    private StudentList(){
        sList = new ArrayList();

    }
    public static StudentList getInst(){
        if(inst == null){
            inst = new StudentList();
        }
        return inst;
    }

    public void AddStudent(Student s){
        sList.add(s);

    }
    public Student getStudent(int id){
        if(sList.size()<id||id<0){
            return  null;
        }
        return sList.get(id);
    }
    public Student delStudent(int id){
        if(sList.size()<id||id<0){
            return  null;
        }
        return sList.remove(id);
    }
    public Student updateStudent(Student s, int id){
        if(sList.size()<id||id<0){
            return  null;
        }
        return sList.set(id,s);
    }

    public List<Student> GetStudentList(){
        return sList;
    }
}
