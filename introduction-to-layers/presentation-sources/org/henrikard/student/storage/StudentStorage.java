package org.henrikard.student.storage;

import java.util.List;

import org.henrikard.student.domain.Student;

public interface StudentStorage {
  
  public List<Student> getAllStudents() throws StorageException;

  public Student getStudentById(int id) throws StorageException;

}
