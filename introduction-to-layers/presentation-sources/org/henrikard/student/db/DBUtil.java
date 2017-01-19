package org.henrikard.student.db;

import java.sql.*;

public class DBUtil{

    private static Connection con;
    private static final String DB_CON_STR = "jdbc:sqlite:org/henrikard/student/resources/students.db";
    static{
        try{
            Class.forName("org.sqlite.JDBC");
            con = getConnection();
        }catch(ClassNotFoundException cnfe){
            System.err.println("Could not load database driver: "  +
                               cnfe.getMessage());
        }
    }

    private static DBUtil instance;
    
    private static Connection getConnection(){
        if(con == null){
            try{
                con = DriverManager.getConnection(DB_CON_STR);
            }catch(SQLException sqle){
                System.err.println("Error creating a connection to the database: " +
                                   sqle.getMessage());
            }
        }
        return con;
    }

    private Statement statement() throws SQLException{
        return con.createStatement();
    }

    private DBUtil(){
    }
    public static DBUtil getInstance(){
        if(instance == null){
            instance = new DBUtil();
        }
        return instance;
    }

    public ResultSet query(String sql) throws SQLException{
        Statement stm = statement();
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }
}
