package com.example.project.repository;
import com.example.project.model.User;
import java.util.List;

public interface UserRepository {
User createUser(User user);
User getUserById(Long id);
List<User>getUsersInfo();
User updateUser(User user);
void deleteUser(Long id);



}
