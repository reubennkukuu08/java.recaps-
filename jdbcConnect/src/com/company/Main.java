package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
try{

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/reubennkukuu08","root","QWER5678");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from student");

        int count = 1;
        while (resultSet.next()){
            String studentData = count +". ";
            for (int i = 1; i<=6; i++){
                studentData += resultSet.getString(i) + "  ";
            }
            System.out.println(studentData);
            count++;
        }
    }catch (Exception e){
    e.printStackTrace();
    }
}
}
