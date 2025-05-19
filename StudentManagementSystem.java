package com.jap.oops;

import java.util.Scanner;

public class StudentManagementSystem
{
	static void displayMenu(Scanner scanner, Student[] students, Course[] courses) {
		int userChoice;

		do {
			System.out.println("\nStudent Management System Menu:");
			System.out.println("1. Enroll Students for the Course");
			System.out.println("2. View enrollment details");
			System.out.println("3. Explore course details");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			userChoice = scanner.nextInt();
			switch (userChoice) {
				case 1:
					System.out.println("\nEnroll in a course: ");
					enrollStudentInCourse(getStudent(scanner,students), getCourse(scanner,courses));
					break;
				case 2:
					System.out.println(viewStudentEnrollmentDetails(getStudent(scanner, students), students));
					break;
				case 3:
					System.out.println("Select a course to view enrolled students:");
					System.out.println(viewEnrolledStudentsInCourse(getCourse(scanner,courses), courses));
					break;
				case 4:
					System.out.println("Existing the Student Management System...");
					break;
				default:
					System.out.println("Please enter the available choices from the menu.");
			}
		} while (userChoice != 4);
	}


	private static Student getStudent(Scanner scanner, Student[] students) {
		System.out.println("Available Students:");
		for (int i = 0; i < students.length; i++)
		{
			System.out.println(i + 1 + ". " + students[i].getStudentName() + " " + students[i].getStudentId());
		}
		System.out.print("Enter student number: ");
		int selectedStudent = scanner.nextInt();
		boolean isRightStudent = true;
		while (isRightStudent) {
			if (selectedStudent > students.length) {
				System.out.println("Please select students available on the student list");
				System.out.print("Enter student number: ");
				selectedStudent = scanner.nextInt();
			}
			if (selectedStudent > 0 && selectedStudent <= students.length) {
				isRightStudent = false;
			} else {
				System.out.println("Please enter only positive numbers.");
				System.out.print("Enter student number: ");
				selectedStudent = scanner.nextInt();
			}
		}
		return students[selectedStudent - 1];
	}

	private static Course getCourse(Scanner scanner, Course[] courses)
	{
		System.out.println("\nAvailable Courses:");
		for (int i = 0; i < courses.length; i++) {
			System.out.println(i + 1 + ". " + courses[i].getCourseName());
		}
		System.out.print("Enter course number: ");
		int selectedCourse = scanner.nextInt();
		boolean isRightCourse = true;
		while (isRightCourse) {
			if (selectedCourse > courses.length) {
				System.out.println("Please select course available on the courses list");
				System.out.print("Enter course number: ");
				selectedCourse = scanner.nextInt();
			}
			if (selectedCourse > 0 && selectedCourse <= courses.length) {
				isRightCourse = false;
			} else {
				System.out.println("Please enter only positive numbers.");
				System.out.print("Enter course number:");
				selectedCourse = scanner.nextInt();
			}
		}
		return courses[selectedCourse - 1];
	}

	public static boolean enrollStudentInCourse(Student selectedStudent, Course selectedCourse) {
		System.out.println(selectedStudent.enrollInCourse(selectedCourse));
		return true;
	}

	public static String viewStudentEnrollmentDetails(Student selectedStudent, Student[] students)
	{
		StringBuilder result = new StringBuilder("\nView Enrollment Details:\n");
		result.append("Enrollment Details for ").append(selectedStudent.getStudentName()).append(":\n");
		for (Course enrolledCourse : selectedStudent.getEnrolledCourses())
		{
			if (enrolledCourse != null)
				result.append(enrolledCourse.getCourseDetails()).append("\n-----------------------\n");
		}
		return result.toString();
	}

	public static String viewEnrolledStudentsInCourse(Course selectedCourse, Course[] courses)
	{
		return selectedCourse.viewEnrolledStudents();
	}
}