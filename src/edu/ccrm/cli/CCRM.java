package edu.ccrm.cli;

import edu.ccrm.domain.*;
import edu.ccrm.service.*;
import edu.ccrm.io.*;
import edu.ccrm.util.AppConfig;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CCRM {
    private static AppConfig config = AppConfig.getInstance();
    private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService = new StudentServiceImpl();
    private static CourseService courseService = new CourseServiceImpl();
    private static EnrollmentService enrollmentService = new EnrollmentServiceImpl();
    private static ImportExportService ioService = new ImportExportService();

    public static void main(String[] args) {
        System.out.println("Campus Course & Records Manager (CCRM) - Starting at " + LocalDateTime.now());
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageStudents();
                    break;
                case 2:
                    manageCourses();
                    break;
                case 3:
                    manageEnrollment();
                    break;
                case 4:
                    importExportData();
                    break;
                case 5:
                    backupData();
                    break;
                case 6:
                    showReports();
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting CCRM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== CCRM Menu ===");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Manage Enrollment/Grades");
        System.out.println("4. Import/Export Data");
        System.out.println("5. Backup & Show Backup Size");
        System.out.println("6. Reports");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void manageStudents() {
        System.out.println("1. Add Student\n2. Update Student\n3. Deactivate Student\n4. Print Profile");
        int subChoice = scanner.nextInt();
        scanner.nextLine();
        if (subChoice == 1) {
            Student student = new Student("S001", "2023001", "John Doe", "john@example.com", Status.ACTIVE, LocalDateTime.now());
            studentService.addStudent(student);
            System.out.println("Student added: " + student);
        }
    }

    private static void manageCourses() {
        System.out.println("1. Add Course\n2. Update Course");
        int subChoice = scanner.nextInt();
        scanner.nextLine();
        if (subChoice == 1) {
            Course course = new Course("CS101", "Intro to CS", 3, "Dr. Smith", Semester.FALL, "Computer Science");
            courseService.addCourse(course);
            System.out.println("Course added: " + course);
        }
    }

    private static void manageEnrollment() {
        System.out.println("Enrolling Student S001 in CS101");
        try {
            enrollmentService.enrollStudent("S001", "CS101");
            System.out.println("Enrolled successfully.");
        } catch (MaxCreditLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void importExportData() {
        ioService.importFromCSV(config.getDataFolder() + "/students.csv");
        ioService.exportToCSV(config.getDataFolder() + "/exported_data.csv");
        System.out.println("Data imported and exported.");
    }

    private static void backupData() {
        ioService.backupData();
        long size = ioService.getBackupSizeRecursively(config.getBackupFolder());
        System.out.println("Backup completed. Total size: " + size + " bytes");
    }

    private static void showReports() {
        System.out.println("Generating GPA report...");
        // Simplified Stream pipeline
        studentService.getAllStudents().stream()
                .map(Student::getGPA)
                .forEach(gpa -> System.out.println("GPA: " + gpa));
    }
}