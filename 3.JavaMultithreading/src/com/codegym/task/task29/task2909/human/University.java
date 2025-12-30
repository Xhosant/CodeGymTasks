package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public University(String name, int age) {
        students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double average) {
        for (Student s:students
             ) {
            if (Double.compare(s.getAverageGrade(), average)==0) return s;
        }
        return null;
    }

    public Student getStudentWithHighestAverageGrade() {
        double max = 0;
        Student best = null;
        for (Student s:students
        ) {
            double avg = s.getAverageGrade();
            if (avg>max){
                max = avg;
                best = s;
            }
        }
        return best;
    }

    public Student getStudentWithLowestAverageGrade() {
        double min = Double.MAX_VALUE;
        Student worst = null;
        for (Student s:students
        ) {
            double avg = s.getAverageGrade();
            if (avg<min){
                min = avg;
                worst = s;
            }
        }
        return worst;
    }
    public void expel(Student student){
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}