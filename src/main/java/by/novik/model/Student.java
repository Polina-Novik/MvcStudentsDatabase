package by.novik.model;

import jakarta.validation.constraints.Min;

import jakarta.validation.constraints.Size;

public class Student {

    @Min(value = 1,message = "id can't be less than 1")
    private int id;
    @Size(min=2, max=10,message = "name should be more than {min} and less than {max}")
    private String description;
    @Min(value = 1,message = "course id can't be less than 1")
    private int courseId;



    public Student(int id, String description, int courseId) {
        this.id = id;
        this.description = description;
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }


    @Override
    public int hashCode() {
        return id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
