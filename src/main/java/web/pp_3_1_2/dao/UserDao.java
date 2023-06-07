package web.pp_3_1_2.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.pp_3_1_2.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

}