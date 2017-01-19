package org.henrikard.student.storage;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.henrikard.student.domain.Student;
import org.henrikard.student.db.DBUtil;

public class StudentStorageDB implements StudentStorage{
    private DBUtil db;
    private static final String SELECT_STUDENT = 
        "SELECT id, name FROM students WHERE id=";

    private static final String SELECT_ALL_STUDENTS =
        "SELECT id, name FROM students";

    public StudentStorageDB(){
        db = DBUtil.getInstance();
    }
    public Student getStudentById(int id) throws StorageException{
        try{
            String query = SELECT_STUDENT + id;
            ResultSet rs = db.query(query);
            if(rs.next() ){
                return new Student(rs.getInt("id"), rs.getString("name"));
            }else{
                throw new StorageException("Could not find student with id " + 
                                           id);
            }
        }catch(SQLException sqle){
            throw new StorageException(sqle.getMessage());
        }
    }

    public List<Student> getAllStudents() throws StorageException{
        try{
            List<Student> students = new ArrayList<Student>();
            ResultSet rs = db.query(SELECT_ALL_STUDENTS);
            while(rs.next()){
                students.add(new Student(rs.getInt("id"), rs.getString("name")));
            }
            if(students.size() != 0){
                return students;
            }else{
                throw new StorageException("No students could be fetched");
            }
        }catch(SQLException sqle){
            throw new StorageException(sqle.getMessage());
        }
    }
}
