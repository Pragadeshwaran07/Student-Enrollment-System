package com.jap.oops;

public abstract class Course {

	private int courseId;
	private String courseName;
	private Student[] enrolledStudents;
	private int enrolledStudentsCount;

	public Course(int courseId, String courseName)
	{
		this.courseId = courseId;
		this.courseName = courseName;
		this.enrolledStudents = new Student[10];
		this.enrolledStudentsCount = 0;
	}
	public int getCourseId()
	{
		return courseId;
	}

	public String getCourseName()
	{
		return courseName;
	}

	// Method to add a student to the course
	public String addStudent(Student student)
	{
		if (this.enrolledStudentsCount >= 10)
		{
			return "Maximum students enrolled. Cannot add more students.";
		}
		else if (isEnrolled(student))
		{
			return student.getStudentName() + " has already been added to the course: " + this.courseName;
		}
		this.enrolledStudents[this.enrolledStudentsCount++] = student;
		return student.getStudentName() + " has been added to the course: " + this.courseName;
	}

	public boolean isEnrolled(Student student)
	{
		for (Student enrolledStudent : this.enrolledStudents)
		{
			if (enrolledStudent != null && enrolledStudent.getStudentId() == student.getStudentId()) {
				return true;
			}
		}
		return false;
	}

	// Method to view enrolled students in the course
	public String viewEnrolledStudents()
	{
		StringBuilder result = new StringBuilder("Students Enrolled in the course " + this.courseName + ":\n");
		for (int i=0;i < enrolledStudents.length;i++)
		{
			if (enrolledStudents[i] != null)
			{
				result.append(i+1).append(".").append(enrolledStudents[i].getStudentName()).append('\n');
			}
		}
		return result.toString();
	}

	// Abstract method to get specific course details (to be implemented by derived classes)
	public abstract String getCourseDetails();
}
