package com.cg.client;

import java.util.List;
import java.util.Scanner;

import com.cg.bean.CourseMaster;
import com.cg.dao.AdminDao;
import com.cg.dao.AdminDaoImpl;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.InvalidCourseException;
import com.cg.service.AdminService;
import com.cg.service.AdminServiceImpl;

public class FmsCli {
	private static Scanner console;
	static {
		console = new Scanner(System.in);
	}

	public static void main(String[] args) {
		int option = 0;
		
		while(true) {
			System.out.println("1-Add Course details.");
			System.out.println("2-Fetch Course details by course id.");
			System.out.println("3-Fetch All Course details.");
			System.out.println("4-Remove Course by course id.");
			System.out.println("5-Update Course by course id.");
			System.out.println("6-System Exit.");
			option = console.nextInt();
			
			switch(option) {
			case 1: addCourseDetails(); break;
			case 2: fetchCourseDetails(); break;
			case 3: fetchAllCourseDetails(); break;
			case 4: removeCourseByCourseId(); break;
			case 5: updateCoureByCourseId(); break;
			case 6: System.exit(0);
			default: System.out.println("Please add valid information..");
			}
		}
	}

	private static void updateCoureByCourseId() {
		AdminService service = new AdminServiceImpl();
		String courseid, coursename, coursedays;
		
		do {
			System.out.println("Enter course Id: ");
			courseid = console.next();
		} while(!service.validateId(courseid));
		
		do {
			System.out.println("Enter Course Name: ");
			coursename = console.next();
		} while(!service.validateName(coursename));
			
		do {
			System.out.println("Enter Course Days: ");
			coursedays = console.next();
		} while(!service.validateDays(coursedays));
		
		CourseMaster course = new CourseMaster();
		course.setCourseId(Integer.parseInt(courseid));
		course.setCourseName(coursename);
		course.setDays(Integer.parseInt(coursedays));
		
		try {
			CourseMaster c = service.updateCourse(course);
			System.out.println("Course details are updated with course id: " + courseid);
		} catch (InvalidCourseException e) {
			System.out.println("Course details not updated..");
		}
		
	}

	private static void removeCourseByCourseId() {
		AdminService service = new AdminServiceImpl();
		String courseid;
		
		do {
		System.out.println("Enter course id: ");
		courseid = console.next();
		} while(!service.validateId(courseid));
		
		try {
			service.removeCourse(Integer.parseInt(courseid));
			System.out.println("Course removed with id: " + courseid);
		} catch (InvalidCourseException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void fetchAllCourseDetails() {
		AdminService service = new AdminServiceImpl();
		
		try {
			List<CourseMaster> courses = service.getAllCourses();
			for(CourseMaster course : courses) {
				System.out.println(course.toString());
			}
		} catch (CourseNotFoundException e) {
			System.out.println("Course details not found..");
		}
		
	}

	private static void fetchCourseDetails() {
		AdminService service = new AdminServiceImpl();
		String courseid;
		
		do {
		System.out.println("Enter course id: ");
		courseid = console.next();
		} while(!service.validateId(courseid));
		
		try {
			CourseMaster course = service.getCourseByCourseId(Integer.parseInt(courseid));
			System.out.println("Course Id: " + course.getCourseId());
			System.out.println("Course Name: " + course.getCourseName());
			System.out.println("Course Days: " + course.getDays());
		} catch (InvalidCourseException e) {
			e.printStackTrace();
		}
		
	}

	private static void addCourseDetails() {
		AdminService service = new AdminServiceImpl();
		String courseid, coursename, coursedays;
		
//		do {
//		System.out.println("Enter Course ID: ");
//		courseid = console.next();
//		} while(!service.validateId(courseid));
		
		do {
		System.out.println("Enter Course Name: ");
		coursename = console.next();
		} while(!service.validateName(coursename));
		
		do {
		System.out.println("Enter Course Days: ");
		coursedays = console.next();
		} while(!service.validateDays(coursedays));
		
		CourseMaster course = new CourseMaster();
		//course.setCourseId(Integer.parseInt(courseid));
		course.setCourseName(coursename);
		course.setDays(Integer.parseInt(coursedays));
		
		try {
			int id = service.saveCourse(course);
			System.out.println("Course details are saved with course id: " + id);
		} catch (InvalidCourseException e) {
			System.out.println("Course details not saved..");
		}
		
	}
}
