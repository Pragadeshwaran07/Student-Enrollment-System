package com.jap.oops;

public class MathCourse extends Course {

	private boolean calculusRequired;

	public MathCourse(int courseId, String courseName, boolean calculusRequired) {
		super(courseId, courseName);
		this.calculusRequired = calculusRequired;
	}

	public String getCourseDetails() {
		return "Math Course Details:\n" +
				"Course ID: " + getCourseId() + "\n" +
				"Course Name: " + getCourseName() + "\n" +
				"Calculus Required: " + this.calculusRequired;
	}
}
