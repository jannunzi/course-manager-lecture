package com.jga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jga.models.Course;
import com.jga.models.Faculty;
import com.jga.repositories.CourseRepository;
import com.jga.repositories.FacultyRepository;

@RestController
public class FacultyService {
	@Autowired
	FacultyRepository facultyRepository;

	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/api/course/{courseId}/author")
	public Faculty findAuthorForCourse(
			@PathVariable("courseId") int fId) {
		Course course = courseRepository.findOne(fId);
		return course.getAuthor();
	}
	
	@GetMapping("/api/faculty/{facultyId}/authored")
	public List<Course> findAuthoredCourses(
			@PathVariable("facultyId") int fId) {
		Faculty faculty = facultyRepository.findOne(fId);
		return faculty.getAuthored();
	}
	
	@PutMapping("/api/faculty/{fId}/authored/{cId}")
	public void authoredCourse(
			@PathVariable("fId") int fId,
			@PathVariable("cId") int cId) {
		Faculty faculty = facultyRepository.findOne(fId);
		Course course   = courseRepository.findOne(cId);
		course.setAuthor(faculty);
		courseRepository.save(course);
//		faculty.authoredCourse(course);
//		facultyRepository.save(faculty);
	}


	@GetMapping("/api/faculty")
	public List<Faculty> 	findAllFaculty() {
		return (List<Faculty>) facultyRepository.findAll();
	}
	
	@PostMapping("/api/faculty")
	public Faculty createFaculty(
			@RequestBody Faculty faculty) {
		return facultyRepository.save(faculty);
	}
}
