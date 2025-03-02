package top.sob.auth.spring.dao.jdbc;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import top.sob.auth.spring.bean.User;

import java.util.List;

public interface UserDao {

    @Select("SELECT * FROM `auth_db`.`users` WHERE `id` = #{id}")
    User getById(long id);

    @Select("SELECT * FROM `auth_db`.`users` WHERE `username` = #{name}")
    User getByName(String name);

    @Select("SELECT * FROM `auth_db`.`users` WHERE `username` LIKE CONCAT('%', #{name}, '%')")
    List<User> searchByName(String name);

    @Insert("INSERT INTO `auth_db`.`users` (`id`, `username`, `password`) VALUES (#{id}, #{username}, #{password})")
    void put(User user);

    @Select("SELECT EXISTS(SELECT * FROM `auth_db`.`users` WHERE `username` = #{name} AND `password` = #{password})")
    boolean login(String name, String password);

    @Select("SELECT EXISTS(SELECT * FROM `auth_db`.`users` WHERE `username` = #{name})")
    boolean exists(String name);

    @Select("SELECT COUNT(*) FROM `auth_db`.`users`")
    int size();
}
