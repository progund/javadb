package org.henrikard.student.storage;

public class StudentStorageFactory{
    public static StudentStorage getStorage(){
        // We only have one type of storage just now...
        return new StudentStorageDB();
    }
}
