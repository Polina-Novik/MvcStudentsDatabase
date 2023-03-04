package by.novik.service;

import by.novik.model.Student;

import by.novik.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Student findById(int number) throws SQLException {
        return repository.findById(number);
    }
    public void save(Student student) throws SQLException {
        repository.save(student);
    }

}
