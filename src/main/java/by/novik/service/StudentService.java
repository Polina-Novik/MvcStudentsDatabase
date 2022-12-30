package by.novik.service;

import by.novik.model.User;
import by.novik.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    public List<User> findAll() {
        return repository.findAll();
    }
    public User findById(int id) {
        return repository.findById(id);
    }
    public void save(User user) {
        repository.save(user);
    }
    public void delete(int id) {
        repository.delete(id);
    }
}
