/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbproject;

/**
 *
 * @author SOURAV MITRA
 */
public class Student {
    
    private String name;
    private int rollno ;
    public int age;
    public String stream;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the roll
     */
    public int getRoll() {
        return rollno;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(int roll) {
        this.rollno = roll;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the stream
     */
    public String getStream() {
        return stream;
    }

    /**
     * @param stream the stream to set
     */
    public void setStream(String stream) {
        this.stream = stream;
    }
    
    
    
}
