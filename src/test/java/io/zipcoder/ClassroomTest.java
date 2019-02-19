package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ClassroomTest {
    @Test
    public void studentConstructorTestInt() {
        //Given
        int expectedMaxStudents = 4;

        //When
        Classroom classroom = new Classroom(expectedMaxStudents);

        //Then
        int actualMaxStudents = classroom.getStudents().length;
        Assert.assertEquals(expectedMaxStudents, actualMaxStudents);
    }

    @Test
    public void studentConstructorTestInt2() {
        //Given
        int expectedMaxStudents = 300;

        //When
        Classroom classroom = new Classroom(expectedMaxStudents);

        //Then
        int actualMaxStudents = classroom.getStudents().length;
        Assert.assertEquals(expectedMaxStudents, actualMaxStudents);
    }

    @Test
    public void studentConstructorTest() {
        //Given
        int expectedMaxStudents = 30;

        //When
        Classroom classroom = new Classroom();

        //Then
        int actualMaxStudents = classroom.getStudents().length;
        Assert.assertEquals(expectedMaxStudents, actualMaxStudents);
    }

    @Test
    public void studentConstructorTestStudents() {
        //Given
        Student[] expectedStudents = new Student[]{new Student(null, null, null), new Student("Zac", "merkl", new Double[]{30.2, 34.5})};

        //When
        Classroom classroom = new Classroom(expectedStudents);

        //Then
        Student[] actualStudents = classroom.getStudents();
        Assert.assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void getAverageExamScoreTest() {
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        double expectedAverage = 125.0;

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double actualAverage = classroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAverage, actualAverage, 0.1);
    }

    @Test
    public void getAverageExamScoreTest2() {
        //Given
        Double[] s1Scores = { 50.0, 70.0 , 90.0};
        Double[] s2Scores = { 10.2, 3.4, 11.0 };
        double expectedAverage = 39.0;

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = new Student[]{s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double actualAverage = classroom.getAverageExamScore();

        //Then
        Assert.assertEquals(expectedAverage, actualAverage, 0.1);
    }

    @Test
    public void addStudentTest() {
        //Given
        Classroom classroom = new Classroom();
        Student addedStudent = new Student("Charles", "Babitch", null);

        // When
        classroom.addStudent(addedStudent);

        //Then
        Assert.assertTrue(classroom.containsStudent(addedStudent));
    }

    @Test
    public void addStudentTest2() {
        //Given
        Classroom classroom = new Classroom();
        Student addedStudent = new Student("Charles", "Babitch", null);
        Student addedStudent2 = new Student("Ada", "Lovelace", new Double[]{1000.0});

        // When
        classroom.addStudent(addedStudent);
        classroom.addStudent(addedStudent2);

        //Then
        Assert.assertTrue(classroom.containsStudent(addedStudent));
        Assert.assertTrue(classroom.containsStudent(addedStudent2));

    }

    @Test
    public void addStudentTest3() {
        //Given
        Classroom classroom = new Classroom();
        Student addedStudent = new Student("Charles", "Babitch", null);
        Student addedStudent2 = new Student("Ada", "Lovelace", new Double[]{1000.0});

        // When
        classroom.addStudent(addedStudent2);

        //Then
        Assert.assertFalse(classroom.containsStudent(addedStudent));
        Assert.assertTrue(classroom.containsStudent(addedStudent2));

    }

    @Test
    public void removeStudentTest() {
        //Given
        Classroom classroom = new Classroom();
        Student addedStudent = new Student("Charles", "Babitch", null);
        Student addedStudent2 = new Student("Ada", "Lovelace", new Double[]{1000.0});
        classroom.addStudent(addedStudent);
        classroom.addStudent(addedStudent2);

        // When
        classroom.removeStudent("Charles", "Babitch");

        //Then
        Assert.assertFalse(classroom.containsStudent(addedStudent));
        Assert.assertTrue(classroom.containsStudent(addedStudent2));

    }

    @Test
    public void removeStudentTest2() {
        //Given
        Classroom classroom = new Classroom();
        Student addedStudent = new Student("Charles", "Babitch", null);
        Student addedStudent2 = new Student("Ada", "Lovelace", new Double[]{1000.0});
        classroom.addStudent(addedStudent);
        classroom.addStudent(addedStudent2);

        // When
        classroom.removeStudent("Charles", "Babitch");
        classroom.removeStudent("Ada", "Lovelace");

        //Then
        Assert.assertFalse(classroom.containsStudent(addedStudent));
        Assert.assertFalse(classroom.containsStudent(addedStudent2));

    }

    @Test
    public void getStudentsByScoreTest() {
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 25.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        List<Student> expectedStudents = new ArrayList<Student>(Arrays.asList(s1, s2));

        Student[] students = new Student[]{s2, s1};
        Classroom classroom = new Classroom(students);

        List<Student> sortedStudents = new ArrayList<>(Arrays.asList(students));
        Collections.sort(sortedStudents);

         //When
        List<Student> actualStudents = classroom.getStudentsByScore();
        //Then
        Assert.assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void getStudentsByScoreTestf2() {
        //Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 25.0, 25.0 };
        Double[] s3Scores = { 75.0, 340.2 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);

        List<Student> expectedStudents = new ArrayList<>(Arrays.asList(s3, s1, s2));

        Student[] students = new Student[]{s2, s1, s3};
        Classroom classroom = new Classroom(students);

        List<Student> sortedStudents = new ArrayList<>(Arrays.asList(students));
        Collections.sort(sortedStudents);

        //When
        List<Student> actualStudents = classroom.getStudentsByScore();
        //Then
        Assert.assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void getGradeBook() {
        //Given
        Student s1 = new Student("student", "one", new Double[]{10.2});
        Student s2 = new Student("student", "two", new Double[]{20.2});
        Student s3 = new Student("student", "two", new Double[]{30.2});
        Student s4 = new Student("student", "two", new Double[]{40.2});
        Student s5 = new Student("student", "two", new Double[]{50.2});

        HashMap<Student, Character> expectedGradeBook = new HashMap<>();
        expectedGradeBook.put(s1, 'D');
        expectedGradeBook.put(s2, 'D');
        expectedGradeBook.put(s3, 'C');
        expectedGradeBook.put(s4, 'B');
        expectedGradeBook.put(s5, 'A');

        Student[] students = new Student[]{s2, s1, s3, s5, s4};
        Classroom classroom = new Classroom(students);

        //When
        HashMap<Student, Character> actualGradeBook = classroom.getGradeBook();
        //Then
        Assert.assertEquals(expectedGradeBook, actualGradeBook);
    }

    @Test
    public void getGradeBook2() {
        //Given
        Student s1 = new Student("student", "one", new Double[]{10.2});
        Student s2 = new Student("student", "two", new Double[]{20.2});
        Student s3 = new Student("student", "two", new Double[]{30.2});
        Student s4 = new Student("student", "two", new Double[]{40.2});
        Student s5 = new Student("student", "two", new Double[]{50.2});
        Student s6 = new Student("student", "one", new Double[]{60.2});
        Student s7 = new Student("student", "two", new Double[]{70.2});
        Student s8 = new Student("student", "two", new Double[]{80.2});
        Student s9 = new Student("student", "two", new Double[]{90.2});
        Student s0 = new Student("student", "two", new Double[]{110.2});

        HashMap<Student, Character> expectedGradeBook = new HashMap<>();
        expectedGradeBook.put(s1, 'F');
        expectedGradeBook.put(s2, 'D');
        expectedGradeBook.put(s3, 'D');
        expectedGradeBook.put(s4, 'D');
        expectedGradeBook.put(s5, 'D');
        expectedGradeBook.put(s6, 'C');
        expectedGradeBook.put(s7, 'C');
        expectedGradeBook.put(s8, 'B');
        expectedGradeBook.put(s9, 'B');
        expectedGradeBook.put(s0, 'A');

        Student[] students = new Student[]{s2, s1, s3, s5, s4, s0, s6, s8, s7, s9};
        Classroom classroom = new Classroom(students);

        //When
        HashMap<Student, Character> actualGradeBook = classroom.getGradeBook();
        //Then
        Assert.assertEquals(expectedGradeBook, actualGradeBook);
    }
}
