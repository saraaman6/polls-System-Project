package com.example.project.repository;

import com.example.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@Repository
 public class UserRepositoryImpl implements UserRepository{
    private static final String USER_TABLE = "users";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public User createUser(User user) {
        String sql = "INSERT INTO " + USER_TABLE + "(first_name, last_name, email, age, address, joining_date) " +

                " VALUES (? ,?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getJoining_date()
        );
        return null;
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM " + USER_TABLE +
                " WHERE user_id = ?";
        try {
        return jdbcTemplate.queryForObject(sql,new UserMapper(),id);
        } catch (Exception e) {
            System.out.println("user is not exist");
        }
        return null;
    }

    @Override
    public List<User>  getUsersInfo() {
        String sql = "SELECT * FROM " + USER_TABLE;
        return jdbcTemplate.query(sql, new UserMapper());
    }




    @Override
    public User updateUser(User user) {
        String sql = "UPDATE " + USER_TABLE + " SET first_name = ?,last_name = ? ,email = ?,age = ?, address = ?, joining_date = ?" +
                " WHERE user_id = ?";

        jdbcTemplate.update(
                sql,
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail(),
                user.getAge(),
                user.getAddress(),
                user.getJoining_date(),
                user.getUserId()

        );
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        String sql = "DELETE FROM " + USER_TABLE + " WHERE user_id = ?";
        jdbcTemplate.update(
                sql,
                id
        );
    }

}
