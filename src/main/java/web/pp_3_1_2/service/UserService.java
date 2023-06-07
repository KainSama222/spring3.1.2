package web.pp_3_1_2.service;

import web.pp_3_1_2.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void save(User user);

    void deleteUser(Long id);
}
