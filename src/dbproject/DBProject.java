/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

import com.mysql.jdbc.Driver;
//import java.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOURAV MITRA
 */
public class DBProject {

    Connection con = null;

    public void connect() {
        try {
            //load driver class
            Class.forName("com.mysql.jdbc.Driver");
            //get con
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root12345");
            System.out.println("con " + con);
            System.out.println("Connected");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void add() {
        String s = "insert into student values(11,\"Sonia\",\"Science\");";
        try {
            connect();
            Statement smt = con.createStatement();
            smt.execute(s);
            //commit
            //con.commit();
            close();
            System.out.println("Added");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
 
    public void update() {
        String st = "update student set Stream = \"science\" where Roll = 9";
        String st1 = "update student set Name = \"Laxman\"where Roll = 5";
        try {
            connect();
            Statement smt1 = con.createStatement();
            Statement smt2 = con.createStatement();
            smt1.execute(st);
            smt2.execute(st1);
            System.out.println("Updated");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            close();
        }
    }

    public void createStudent(Student s) {
        int roll = s.getRoll();
        String name = s.getName();
        int age = s.getAge();
        String stream = s.getStream();

        //String sql = "insert into student values(10,\"Pratab\",19,\"Arts\");";
        String sql = "insert into Student values(" + roll + ",\"" + name + "\"," + age + ",\"" + stream + "\");";

        try {
            connect();
            Statement smt = con.createStatement();
            smt.execute(sql);
            //commit
            //con.commit();
            // close();
            System.out.println("Added...");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }

    }
    
    public void getAllStudents1(List l){
        ArrayList list = new ArrayList();
        boolean roll = list.add("roll");
         boolean name = list.add("name");
          boolean age = list.add("age");
           boolean stream = list.add("stream");
         String sql = "insert into student values(" + roll + ",\"" + name + "\"," + age + ",\"" + stream + "\");"; 
    
        try{
         connect();
            Statement smt = con.createStatement();
            smt.execute(sql);
            //commit
            //con.commit();
            // close();
            System.out.println("Added...");
                  Student s1 = new Student();
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }

    }
    
  
    public List getAllStudents() {
        ArrayList list = new ArrayList();
        String sql = "select * from Student";

        try{
        connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            Student std = new Student();
           int r =  rs.getInt("ROLLNO");
            String n =rs.getString("name");
           // int a = rs.getInt("age");
            String str = rs.getString("stream");
            //create a student
            Student s = new Student();
            s.setRoll(r);
            s.setName(n);
           // s.setAge(a);
            s.setStream(str);
          
            //add to the list
            list.add(s);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close();
        }

        return list;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBProject db = new DBProject();

        Student s = new Student();
        s.setName("Ruma");
        s.setAge(19);
        s.setRoll(100);
        s.setStream("Science");
        
          Student s1 = new Student();
        s1.setName("Sourav");
        s1.setRoll(24);
        s1.setAge(20);
        s1.setStream("Science");
        
        Student s2 = new Student();
        s2.setRoll(26);
        s2.setName("Sagnik");
        s2.setAge(19);
        s2.setStream("Commerce");
       
        
        Student s3 = new Student();
        s3.setRoll(72);
        s3.setName("Ishita Mondal");
        s3.setAge(20);
        s3.setStream("Science");
        ArrayList list = new ArrayList();
          list.add(s3);
        
        
    /*   for(int i=0;i<list.size();i++){
         db.getAllStudents1(list);
          
        }*/
      
   //     db.getAllStudents1(list);
       // db.createStudent(s3);
        
        // db.add();
       
      List allStudents = db.getAllStudents();
        
        for(int i=0;i<allStudents.size();i++){
            Student student = (Student) allStudents.get(i);
            
           System.out.println(student.getName() + student.getRoll() + student.getStream());
       }
        // db.update();
     // db.getAllStudents();
    // db.connect();
    }

 
    }
