package org.henrikard.student.main;

import org.henrikard.student.storage.StudentStorageFactory;
import org.henrikard.student.storage.StudentStorage;
import org.henrikard.student.storage.StorageException;
import org.henrikard.student.domain.Student;

import java.util.List;

public class Main{
    public static void main(String[] args){
        try{
            StudentStorage storage = StudentStorageFactory.getStorage();
            List<Student> students = storage.getAllStudents();
            for(Student student : students){
                System.out.println(student);
            }
        }catch(StorageException se){
            System.err.println("Error accessing the storage: " 
                               + se.getMessage());
        }
    }
}
