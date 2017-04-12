package edu.umd.cs.gpa.service;

import java.util.List;

import edu.umd.cs.gpa.model.Course;

/**
 * Created by howardksw1 on 4/5/17.
 */

public interface CourseService {
    public void addCourseToBacklog(Course course);
    public Course getCourseByIdentifier(String identifier);
    public List<Course> getAllCourses();
}
