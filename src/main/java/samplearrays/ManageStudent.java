package samplearrays;

import java.util.Arrays;
import java.util.Comparator;


public class ManageStudent {


    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        int max_age = 0;
        Student oldest = students[0]; // just initialization;
        for (Student s : students){
            if (s.getAge() > max_age){
                max_age = s.getAge();
                oldest = s;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int counter = 0;
        for (Student s : students){
            if (s.getAge() >= 18){
                counter++;
            }
        }
        return counter;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        int avg = 0;
        for (Student s : students){
            avg += s.getGrade();
        }
        return (double) avg/students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students){
            if (s.getName().equalsIgnoreCase(name)) {return s;};
        }
        // in the case where no student is found i chose to return null
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        // after some research, the custom comparator syntax is as follows:
        //Arrays.sort(students, (a,b) -> Integer.compare(a.getGrade(),b.getGrade()));

        // apparently we need to use the import Comparator:
        Arrays.sort(students,Comparator.comparingInt(Student::getGrade).reversed()); // after some research i landed on this line
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        System.out.println("==== The list of high achievers is : ====");
        for(Student s : students){
            if (s.getGrade() >= 15){
                System.out.println(s.getName());
            }
        }
        System.out.println("====     END     ====");
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students){
            if (s.getId() == id){
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0; i<students.length - 1; i++){
            for (int j = i+1; j<students.length;j++){
                if (students[i].getName().equals(students[j].getName()) ){
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] updatedStudents = new Student[students.length+1];
        for (int i = 0 ; i < students.length ; i++){
            updatedStudents[i] = students[i];
        }
        updatedStudents[students.length] = newStudent;
        return updatedStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        // initializing a Students Array:
        Student[] students = new Student[5];

        Student s1 = new Student(1,"Omar");
        s1.setAge(19);
        s1.setGrade(19);

        Student s2 = new Student(2,"Younes",19);
        s2.setGrade(18);

        Student s3 = new Student(3,"Adam",21,14);

        Student s4 = new Student(4,"mohamed",20,17);

        Student s5 = new Student(5,"Rayane",18,16);

        // adding them to the array:
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        students[3] = s4;
        students[4] = s5;


        // Print all
        System.out.println("== All Students ==");
        for (Student s : students) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("==== The oldest student is : " + findOldest(students) + " ====");

        // 3) Count adults
        System.out.println("==== The count of adults is is : " + countAdults(students) + " ====");

        // 4) Average grade
        System.out.println("==== The average grade is : " + averageGrade(students) + " ====");

        // 5) Find by name
        findStudentByName(students,"Omar"); // true
        findStudentByName(students,"OmAR"); // should return true
        findStudentByName(students,"zayd"); // should return false

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(students);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : students) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(students);

        // 8) Update grade by id
        // function
        System.out.println("\nUpdated id=4? " + updateGrade(students,4,13));
        System.out.println(findStudentByName(students, "Dina"));

        // 9) Duplicate names
        System.out.println("\nHas duplicate names? " + hasDuplicateNames(students));

        // 10) Append new student
        Student s6 = new Student(6,"Leibniz",380,20);
        Student[] newStudents = appendStudent(students,s6);

        // 11) school representation:
        Student[][] school = new Student[2][3];
        school[0][0] = newStudents[0];
        school[0][1] = newStudents[1];
        school[0][2] = newStudents[2];
        school[1][0] = newStudents[3];
        school[1][1] = newStudents[4];
        school[1][2] = newStudents[5];

        // let's display the names of all students in each class:
        for (int i = 0 ; i<school.length; i++){
            System.out.println("==== Students in class " + (i+1) + " ====\n");
            for (int j = 0; j<school[0].length;j++){
                System.out.println(school[i][j] + " | ");
            }
        }

        // let's just sort the classes in order to make it easy for us:
        sortByGradeDesc(school[1]);
        sortByGradeDesc(school[0]);

        System.out.println("The top student in class 1 is : " + school[0][0]);
        System.out.println("The top student in class 2 is : " + school[1][0]);

    }
}