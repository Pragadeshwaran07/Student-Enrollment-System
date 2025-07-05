package com.jap.oops;

public class Student {
	//declare the attributes enrolledCoursesCount,studentID,studentName,enrolledCourses
	private int studentId;
	private String studentName;
	private Course[] enrolledCourses;
	private int enrolledCoursesCount;

	// generate the Constructor with studentId and studentName
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.enrolledCourses = new Course[5];
		this.enrolledCoursesCount = 0;
	}

	//generate the getter and setter
	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}


	public Course[] getEnrolledCourses() {
		return enrolledCourses;
	}



	public String enrollInCourse(Course course) {

		if (this.enrolledCoursesCount >= 5)
		{
			return this.studentName + " has enrolled for maximum courses";
		}
		else if (isEnrolled(course))
		{
			return this.studentName + " is already enrolled in " + course.getCourseName();
		}
		this.enrolledCourses[this.enrolledCoursesCount++] = course;
		course.addStudent(this);
		return this.studentName + " has been enrolled in " + course.getCourseName();
	}

	// Check if already enrolled in a course
	public boolean isEnrolled(Course course)
	{
		for (Course enrolledCourse : this.enrolledCourses) {
			if (enrolledCourse != null && enrolledCourse.getCourseId() == course.getCourseId()) {
				return true;
			}
		}
		return false;
	}
}
