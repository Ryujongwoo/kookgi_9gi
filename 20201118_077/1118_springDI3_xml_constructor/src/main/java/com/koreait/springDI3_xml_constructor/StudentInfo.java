package com.koreait.springDI3_xml_constructor;

public class StudentInfo {

	private Student student;
	
	public StudentInfo() {
		System.out.println("StudentInfo 클래스의 기본 생성자 실행");
	}
	public StudentInfo(Student student) {
		super();
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "StudentInfo [student=" + student + "]";
	}
	
	public void getStudentInfo() {
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		System.out.println("학년 : " + student.getGradeNum());
		System.out.println("반 : " + student.getClassNum());
	}
	
}






