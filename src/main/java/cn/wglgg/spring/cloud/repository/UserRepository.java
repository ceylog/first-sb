package cn.wglgg.spring.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import cn.wglgg.spring.cloud.domain.User;
/**
 * Created by gang on 9/9/16.
 */
public interface UserRepository extends CrudRepository<User,Long>{

    User findById(Long id);
    User findByUserName(String userName);
}
