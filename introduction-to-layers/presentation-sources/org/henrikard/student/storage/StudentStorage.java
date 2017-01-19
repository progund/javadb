package org.henrikard.student.storage;

import org.henrikard.student.domain.Student;
import java.util.List;

public interface StudentStorage{
    public List<Student> getAllStudents() throws StorageException;
    public Student getStudentById(int id) throws StorageException;
}
