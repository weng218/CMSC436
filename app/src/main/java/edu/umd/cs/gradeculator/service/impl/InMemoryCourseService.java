package edu.umd.cs.gpa.service.impl;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.umd.cs.gpa.model.Course;
import edu.umd.cs.gpa.service.CourseService;

/**
 * Created by howardksw1 on 4/5/17.
 */

public class InMemoryCourseService implements CourseService {
    private Context context;
    private List<Course> courses;

    public InMemoryCourseService(Context context) {
        this.context = context;
        this.courses = new ArrayList<Course>();
    }

    @Override
    public void addCourseToBacklog(Course course) {
        Course currCourse = getCourseByIdentifier(course.getTitle());
        if (currCourse == null) {
            courses.add(course);
        } else {
            currCourse.setTitle(course.getTitle());
            currCourse.setIdentifier(course.getIdentifier());
            currCourse.setDesire_grade(course.getDesire_grade());
            currCourse.setCurrent_grade(course.getCurrent_grade());
        }
    }

    @Override
    public Course getCourseByIdentifier(String identifier) {
        for(Course course: courses) {
            if(course.getIdentifier().equals(identifier)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> prioritizedStories = new ArrayList<Course>(courses);

        Collections.sort(prioritizedStories, new Comparator<Course>() {
            @Override
            public int compare(Course course1, Course course2) {
                return course1.getIdentifier().compareTo(course2.getIdentifier());
            }
        });

        return prioritizedStories;
    }
}
