package by.novik.repository;

import by.novik.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class UserRepository {
    private final List<User> users=new ArrayList<>();
    public List<User> findAll() {
        return users;
    }
    public void save(User user) {
        users.add(user);
    }
    public User findById(int id) {
        return users.stream()
                .filter(user -> user.getId()==id)
                .findAny().orElseThrow(() -> new NoSuchElementException("User is not found"));
    }
    public void delete(int id) {
        users.remove(findById(id));
    }
}
