package org.henrikard.student.domain;

public class Student{
    private String name;
    private int id;
    public Student(int id, String name){
        this.name = name;
        this.id   = id;
    }
    
    public String name(){
        return this.name;
    }

    public int id(){
        return id;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(name)
            .append(" (")
            .append(id)
            .append(")")
            .toString();
    }
}
