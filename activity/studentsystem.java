package activity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class studentsystem {
    private Scanner sc = new Scanner(System.in);
    public ArrayList<Student> Students;

    public studentsystem() {
        this.Students = new ArrayList<>();
    }

    public void addStudent() {
        int studentId;
        String studentFirstName;
        String studentLastName;
        int studentGradeLevel;
        float studentGPA;

        System.out.println();

        while (true) {
            while (true) {
                try {
                    System.out.print("Enter Student ID: ");
                    studentId = sc.nextInt();
                    if (studentId <= 0) {
                        throw new IllegalArgumentException("Student ID must be a positive integer.");
                    }
                    if (isStudentIdExists(studentId)) {
                        throw new IllegalArgumentException("Student ID already exists. Please enter a unique Student ID.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a positive integer for Student ID.");
                    sc.nextLine(); 
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            sc.nextLine(); 

            while (true) {
                System.out.print("Enter Student First Name: ");
                studentFirstName = sc.nextLine();
                if (!studentFirstName.trim().isEmpty() && studentFirstName.matches("[a-zA-Z]+")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid first name containing only letters.");
                }
            }

            while (true) {
                System.out.print("Enter Student Last Name: ");
                studentLastName = sc.nextLine();
                if (!studentLastName.trim().isEmpty() && studentLastName.matches("[a-zA-Z]+")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid last name containing only letters.");
                }
            }

            while (true) {
                try {
                    System.out.print("Enter Student Grade Level: ");
                    studentGradeLevel = sc.nextInt();
                    if (studentGradeLevel <= 0 || studentGradeLevel > 12) {
                        throw new IllegalArgumentException("Grade level must be between 1 and 12.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer for Grade Level.");
                    sc.nextLine(); 
                }
            }

            while (true) {
                try {
                    System.out.print("Enter Student GPA: ");
                    studentGPA = sc.nextFloat();
                    if (studentGPA < 0.0 || studentGPA > 4.0) {
                        throw new IllegalArgumentException("GPA must be between 0.0 and 4.0.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid decimal number for GPA.");
                    sc.nextLine(); 
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            Students.add(new Student(studentId, studentFirstName, studentLastName, studentGradeLevel, studentGPA));
            System.out.println("STUDENT SUCCESSFULLY ADDED");
            System.out.println();

            System.out.print("Do you want to add another student? (yes/no): ");
            if (!sc.next().equalsIgnoreCase("yes" )) {
                break;
            }
            sc.nextLine(); 
        }
    }

    private boolean isStudentIdExists(int studentId) {
        for (Student student : Students) {
            if (student.getStudentId() == studentId) {
                return true;
            }
        }
        return false;
    }

    public void displayAllStudent() {
        System.out.println("******************************************");
        System.out.println("\t" + "LIST OF STUDENTS");
        for (Student student : this.Students) {
            System.out.println(student);
        }
    }

    public void sort_students_by_name() {
        Students.sort(Comparator.comparing(Student::getFirstName));
        System.out.println("SORTED LIST BY FIRSTNAME");
    }

    public void sort_studentsbygpa() {
        Students.sort(Comparator.comparing(Student::getGpa));
        System.out.println("SORTED LIST BY GPA");
    }

    public void find_students_by_id(int id) {
       
        Students.sort(Comparator.comparingInt(Student::getStudentId));

        int start = 0;
        int end = Students.size() - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            int midId = Students.get(mid).getStudentId();

            if (midId == id) {
                System.out.println("\nStudent Found: \n" + Students.get(mid));
                return;
            } else if (midId < id) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println("\nStudent ID not found");
    }

    public void remove_student() {
      //wala pa nahuman
    }
}
