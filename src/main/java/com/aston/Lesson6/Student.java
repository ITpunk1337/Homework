package com.aston.Lesson6;

import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private int course;
    private double[] grades; // Оценки по предметам

    public Student(String name, String group, int course, double[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public double getAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public void promote() {
        this.course++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return course == student.course && name.equals(student.name) && group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }
}