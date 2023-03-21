package by.novik.repository;

import by.novik.util.DataBaseConnection;
import by.novik.model.Student;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class StudentRepository {

    Statement statement = DataBaseConnection.getStatement();
    ResultSet resultSet = null;

    public void save(Student student) throws SQLException {

        int courseId = student.getCourseId();
        String description = student.getDescription();
        statement.execute("insert into students (description,course_id) values ('" + description + "'," + courseId + ")");
    }

    public Student findById(int number) throws SQLException {
        List<Student> students = new ArrayList<>();
        resultSet = statement.executeQuery("select * from students");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String description = resultSet.getString("description");
            int courseId = resultSet.getInt("course_id");

            Student student = new Student(id, description, courseId);
            students.add(student);
        }
        return students.stream()
                .filter(student -> student.getId() == number)
                .findAny().orElseThrow(() -> new NoSuchElementException("Student is not found"));

    }

}
