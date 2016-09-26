package cn.wglgg.spring.cloud.repository;

import cn.wglgg.spring.cloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by gang on 9/9/16.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findById(Long id);
    User findByUserName(String userName);
}
