package edu.umd.cs.gpa.model;

import java.util.ArrayList;

/**
 * Created by howardksw1 on 4/5/17.
 */

public class Course {
    private String title;
    private String identifier;
    private ArrayList<Work> exams;
    private ArrayList<Work> quizzes;
    private ArrayList<Work> projects;
    private ArrayList<Work> assignments;
    private ArrayList<Work> extra;
    private double current_grade;
    private double desire_grade;

    public Course(String title, String identifier, double desire_grade) {
        this.title = title;
        this.identifier = identifier;
        this.desire_grade = desire_grade;
    }

    public void setTitle(String title) { this.title = title; }

    public String getTitle() { return title; }

    public void setIdentifier(String identifier) { this.identifier = identifier; }

    public String getIdentifier() { return identifier; }

    public void setDesire_grade(double grade) { this.desire_grade = grade; }

    public double getDesire_grade() { return desire_grade; }

    public void setCurrent_grade(double grade) { this.current_grade = grade; }

    public double getCurrent_grade() { return current_grade; }

    // check if the work element exists in the works data structure
    private Work containsWork(ArrayList<Work> works, String title) {
        for(Work w:works) {
            if(w.getTitle().equals(title)) {
                return w;
            }
        }
        return null;
    }

    // add a work into the data structure depending on the categories
    public boolean add(Work work) {
        switch (work.getCategory()) {
            case EXAM:
                if(containsWork(exams,work.getTitle()) == null) {
                    exams.add(work);
                    return true;
                }
                break;
            case ASSIGNMENT:
                if(containsWork(assignments,work.getTitle()) == null) {
                    assignments.add(work);
                    return true;
                }
                break;
            case QUIZ:
                if(containsWork(quizzes,work.getTitle()) == null) {
                    quizzes.add(work);
                    return true;
                }
                break;
            case PROJECT:
                if(containsWork(projects,work.getTitle()) == null) {
                    projects.add(work);
                    return true;
                }
                break;
            case EXTRA:
                if(containsWork(extra,work.getTitle()) == null) {
                    extra.add(work);
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    // remove helper function to iterate through the data structure and locate the position
    private ArrayList<Work> removeWork(ArrayList<Work> works, String title) {
        for(Work work: works){
            if (work.getTitle().equals(title)){
                works.remove(work);
            }
        }
        return works;
    }

    // remove the item by the type of categories
    public void remove(Work.Category work, String target){
        switch (work){
            case EXAM:
                exams = removeWork(exams,target);
                break;
            case ASSIGNMENT:
                assignments = removeWork(assignments,target);
                break;
            case QUIZ:
                quizzes = removeWork(quizzes,target);
                break;
            case PROJECT:
                projects = removeWork(projects,target);
                break;
            case EXTRA:
                extra = removeWork(extra,target);
                break;
            default:
                break;
        }
    }
}
