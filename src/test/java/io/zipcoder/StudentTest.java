package io.zipcoder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentTest {
    @Test
    public void studentConstructorTest() {
        //Given
        String expectedFirst = "testFirstName";
        String expectedLast = "testLastName";
        Double[] expectedScores = new Double[]{1.2, 2.3};
        List<Double> expectedExamScores = new ArrayList<>(Arrays.asList(expectedScores));

        //When
        Student testStudent = new Student(expectedFirst, expectedLast, expectedScores);

        //Then
        String actualFirst = testStudent.getFirstName();
        String actualLast = testStudent.getLastName();
        List<Double> actualExamScores = testStudent.getScores();

        Assert.assertEquals(expectedFirst, actualFirst);
        Assert.assertEquals(expectedLast, actualLast);
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void studentConstructorTest2() {
        //Given
        String expectedFirst = "otherName";
        String expectedLast = "SomeName";
        Double[] expectedScores = new Double[]{1.2, 2.3, 3.3, 4.1, 5.0};
        List<Double> expectedExamScores = new ArrayList<>(Arrays.asList(expectedScores));

        //When
        Student testStudent = new Student(expectedFirst, expectedLast, expectedScores);

        //Then
        String actualFirst = testStudent.getFirstName();
        String actualLast = testStudent.getLastName();
        List<Double> actualExamScores = testStudent.getScores();

        Assert.assertEquals(expectedFirst, actualFirst);
        Assert.assertEquals(expectedLast, actualLast);
        Assert.assertEquals(expectedExamScores, actualExamScores);
    }

    @Test
    public void setFirstNameTest() {
        //Given
        Student testStudent = new Student(null, null, null);
        String expectedFirst = "differentName";
        //When
        testStudent.setFirstName(expectedFirst);
        //Then
        String actualFirst = testStudent.getFirstName();
        Assert.assertEquals(expectedFirst, actualFirst);

    }

    @Test
    public void setLastNameTest() {
        //Given
        Student testStudent = new Student(null, null, null);
        String expectedLast = "differentName";
        //When
        testStudent.setLastName(expectedLast);
        //Then
        String actualLast = testStudent.getLastName();
        Assert.assertEquals(expectedLast, actualLast);

    }

    @Test
    public void getNumberOfExamsTakenTest() {
        //Given
        Student testStudent = new Student(null, null, new Double[]{1.2, 3.4, 5.6});
        Integer expectedNumberOfExams = 3;
        //When
        Integer actualNumberOfExams = testStudent.getNumberOfExamsTaken();
        //Then
        Assert.assertEquals(expectedNumberOfExams, actualNumberOfExams);
    }

    @Test
    public void getNumberOfExamsTakenTest2() {
        //Given
        Student testStudent = new Student(null, null, new Double[]{1.2});
        Integer expectedNumberOfExams = 1;
        //When
        Integer actualNumberOfExams = testStudent.getNumberOfExamsTaken();
        //Then
        Assert.assertEquals(expectedNumberOfExams, actualNumberOfExams);
    }

    @Test
    public void getExamScoresTest() {
        //Given
        Student testStudent = new Student(null, null, new Double[]{ 100.0, 95.0, 123.0, 96.0 });
        String expectedExamPrint = "Exam Scores :\n \tExam 1 -> 100.0\n" +
                " \tExam 2 -> 95.0\n" +
                " \tExam 3 -> 123.0\n" +
                " \tExam 4 -> 96.0\n";
        //When
        String actualExamPrint = testStudent.getExamScores();
        //Then
        Assert.assertEquals(expectedExamPrint, actualExamPrint);

    }

    @Test
    public void getExamScoresTest2() {
        //Given
        Student testStudent = new Student(null, null, new Double[]{ 10.0, 5.6, 3.2, 51.0 });
        String expectedExamPrint = "Exam Scores :\n \tExam 1 -> 10.0\n \tExam 2 -> 5.6\n \tExam 3 -> 3.2\n \tExam 4 -> 51.0\n";
        //When
        String actualExamPrint = testStudent.getExamScores();
        //Then
        Assert.assertEquals(expectedExamPrint, actualExamPrint);

    }

    @Test
    public void addExamScoreTest() {
        //Given
        Student testStudent = new Student(null, null, null);
        String expectedExamPrint = "Exam Scores :\n \tExam 1 -> 10.0\n";

        //When
        testStudent.addExamScore(10.0);

        //Then
        String actualExamPrint = testStudent.getExamScores();
        Assert.assertEquals(expectedExamPrint, actualExamPrint);

    }

    @Test
    public void addExamScoreTest2() {
        //Given
        Student testStudent = new Student(null, null, null);
        String expectedExamPrint = "Exam Scores :\n \tExam 1 -> 160.3\n";

        //When
        testStudent.addExamScore(160.3);

        //Then
        String actualExamPrint = testStudent.getExamScores();
        Assert.assertEquals(expectedExamPrint, actualExamPrint);
    }

    @Test
    public void setExamScoreTest() {
        //Given
        Student testStudent = new Student(null, null, new Double[]{10.3});
        String expectedExamPrint = "Exam Scores :\n \tExam 1 -> 160.3\n";

        //When
        testStudent.setExamScore(1, 160.3);

        //Then
        String actualExamPrint = testStudent.getExamScores();
        Assert.assertEquals(expectedExamPrint, actualExamPrint);
    }

    @Test
    public void setExamScoreTest2() {
        //Given
        Student testStudent = new Student(null, null, new Double[]{10.3, 10.2, 3.4});
        String expectedExamPrint = "Exam Scores :\n \tExam 1 -> 10.3\n \tExam 2 -> 160.3\n \tExam 3 -> 3.4\n";

        //When
        testStudent.setExamScore(2, 160.3);

        //Then
        String actualExamPrint = testStudent.getExamScores();
        Assert.assertEquals(expectedExamPrint, actualExamPrint);
    }

    @Test
    public void getAverageExamScoreTest() {
        //Given
        Student testStudent = new Student(null, null, new Double[]{5.0, 10.0, 15.0});
        Integer expectedAverage = (int) (5.0 + 10.0 + 15.0)/3;

        //When
        Integer actualAverage = testStudent.getAerageExamScore();

        //Then
        Assert.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void getAverageExamScoreTest2() {
        //Given
        Student testStudent = new Student(null, null, new Double[]{7.2, 10.5, 115.0});
        Integer expectedAverage = (int) (7.2 + 10.5 + 115.0)/3;

        //When
        Integer actualAverage = testStudent.getAerageExamScore();

        //Then
        Assert.assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void toStringTest() {
        //Given
        Student testStudent = new Student("First", "Name", new Double[]{90.0, 50.0, 10.0});
        String expectedString = "Student Name : First Name\n> Average Score : 50\n> Exam Scores :\n \tExam 1 -> 90.0\n \tExam 2 -> 50.0\n \tExam 3 -> 10.0\n";
        //When
        String actualString = testStudent.toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void toStringTest2() {
        //Given
        Student testStudent = new Student("Eragon", "Saphira", new Double[]{70.0, 62.3, 81.9});
        String expectedString = "Student Name : Eragon Saphira\n> Average Score : 71\n> Exam Scores :\n \tExam 1 -> 70.0\n \tExam 2 -> 62.3\n \tExam 3 -> 81.9\n";
        //When
        String actualString = testStudent.toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }
}