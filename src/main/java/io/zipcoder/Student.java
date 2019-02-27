package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(testScores != null) {this.examScores.addAll(Arrays.asList(testScores));}
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Double> getScores() {
        return examScores;
    }

    public int getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores() {
        StringBuilder exams = new StringBuilder("Exam Scores :\n");
        for (int i = 0; i < examScores.size(); i++) {
            exams.append(String.format(" \tExam %d -> %.1f%n", i+1, examScores.get(i)));
        }
        return exams.toString();
    }

    public void addExamScore(double newScore) {
        examScores.add(newScore);
    }

    public void setExamScore(int i, double newScore) {
        examScores.set(i-1, newScore);
    }

    public Integer getAerageExamScore() {
        int sum = 0;
        for (Double score : examScores) {
            sum += score;
        }
        return sum/examScores.size();
    }

    @Override
    public String toString() {
        StringBuilder stringStudent = new StringBuilder(
                String.format("Student Name : %s %s%n> Average Score : %d%n> %s",
                                firstName, lastName, getAerageExamScore(), getExamScores()));
        return stringStudent.toString();
    }

    public int compareTo(Student student) {
        int averageScoresCompare = student.getAerageExamScore().compareTo(getAerageExamScore()) * 1000;
        int lastNameCompare = student.getLastName().compareTo(lastName) * 10;
        int firstNameCompare = student.getFirstName().compareTo(firstName);
        return averageScoresCompare + lastNameCompare + firstNameCompare;
    }
}
