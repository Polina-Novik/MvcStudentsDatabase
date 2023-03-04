package by.novik.controller;


import by.novik.model.Student;

import by.novik.service.StudentService;
import by.novik.util.DataBaseConnection;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("student")
@Slf4j
public class StudentController {
private  final StudentService service;
    /**
     * a
     */


    private int count = 0;

    @GetMapping("list")
    public String getStudents(HttpSession session, Model model) {

        Statement statement = DataBaseConnection.getStatement();
        ResultSet resultSet = null;

            try {
                List<Student> students = new ArrayList<>();
                resultSet = statement.executeQuery("select * from students");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String description = resultSet.getString("description");
                    int courseId = resultSet.getInt("course_id");

                    Student student = new Student(id, description, courseId);
                    students.add(student);
                }
                model.addAttribute("students",students);
                model.addAttribute("size",students.size());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        try {

            statement.execute("update counter set count=count+1 where id=1");
            resultSet = statement.executeQuery("select * from counter");
            while (resultSet.next()) {
                count = resultSet.getInt("count");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        session.setAttribute("count", count);
        return "students.jsp";
    }
    @GetMapping("new")

    public String createUser(@Valid Student student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            log.info("Errors: {}", bindingResult.getAllErrors());
            return "errors.jsp";
        }
else{
        log.info("student received: {}", student);
        service.save(student);
        return "index.jsp";
}
//http://localhost:8080/student/new?id=4&description=Maxim&courseId=4

    }

    @GetMapping("{id}")
    public String getById(@PathVariable("id") int id, Model model) throws SQLException {
        Student student=service.findById(id);

            model.addAttribute("student", student);
            return "your_student.jsp";

    }
//http://localhost:8080/student/4
}
