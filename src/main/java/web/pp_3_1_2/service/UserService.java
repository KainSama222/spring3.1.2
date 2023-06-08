package web.pp_3_1_2.service;

import org.springframework.transaction.annotation.Transactional;
import web.pp_3_1_2.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void save(User user);

    void update(User user);

    void deleteUser(Long id);
}
