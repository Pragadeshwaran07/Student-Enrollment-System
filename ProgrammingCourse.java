package com.jap.oops;

public class ProgrammingCourse extends Course {

	private String programmingLanguage;

	public ProgrammingCourse(int courseId, String courseName, String programmingLanguage) {
		super(courseId, courseName);
		this.programmingLanguage = programmingLanguage;
	}

	public String getCourseDetails() {
		return "Programming Course Details:\n" +
				"Course ID: " + getCourseId() + "\n" +
				"Course Name: " + getCourseName() + "\n" +
				"Programming Language: " + this.programmingLanguage;
	}
}
