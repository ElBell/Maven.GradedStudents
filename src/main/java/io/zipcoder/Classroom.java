package io.zipcoder;


import org.junit.Test;

import java.util.*;

public class Classroom {
    private List<Student> students = new ArrayList<>();
    private int maxStudents = 0;
    public Classroom(int maxNumberStudents) {
        maxStudents = maxNumberStudents;
    }

    public Classroom(Student[] newStudents) {
        students.addAll(Arrays.asList(newStudents));
        maxStudents = newStudents.length;
    }

    public Classroom() {
        maxStudents = 30;
    }

    public Student[] getStudents() {
        Student[] arrayStudents = (students.toArray(new Student[maxStudents]));
        return arrayStudents;
    }

    public Double getAverageExamScore() {
        int sum = 0;
        for (Student student: students) {
            sum += student.getAerageExamScore();
        }
        return (double) sum/students.size();
    }

    public boolean containsStudent(Student student) {
        return students.contains(student);
    }

    public void addStudent(Student addedStudent) {
        students.add(addedStudent);
    }

    public void removeStudent(String first, String last) {
        for (Student student: students) {
            if(student.getFirstName().equals(first) && student.getLastName().equals(last)) {
                students.remove(student);
                break;
            }
        }
    }

    public List<Student> getStudentsByScore() {
        Collections.sort(students);
        return students;
    }

    public HashMap<Student, Character> getGradeBook(){
        HashMap<Student, Character> studentGrades = new HashMap<>();
        Collections.sort(students);
        for (int i = 0; i < students.size(); i++) {
            if (i < getNumAs()) {
                studentGrades.put(students.get(i), 'A');
            } else if (i < getNumBs()) {
                studentGrades.put(students.get(i), 'B');
            } else if (i < getNumCs()) {
                studentGrades.put(students.get(i), 'C');
            } else if (i < getNumDs()) {
                studentGrades.put(students.get(i), 'D');
            } else {
                studentGrades.put(students.get(i), 'F');
            }
        }
        return studentGrades;
    }

    public int getNumAs() {
        return (int)Math.ceil(students.size() * .1);
    }
    public int getNumBs() {
        return (int)Math.ceil(students.size() * .19) + getNumAs();
    }
    public int getNumCs() {
        return (int)Math.floor(students.size() * .21) + getNumBs();
    }
    public int getNumDs() {
        return (int)Math.ceil(students.size() * .39) + getNumCs();
    }

}
