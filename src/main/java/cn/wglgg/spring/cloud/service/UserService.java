package cn.wglgg.spring.cloud.service;

import cn.wglgg.spring.cloud.domain.User;
import cn.wglgg.spring.cloud.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


/**
 * Created by gang on 9/9/16.
 */
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final static Logger logger = Logger.getLogger(UserService.class);

    public void saveUser(User user){
        User save = userRepository.save(user);
        logger.info("user saved");
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.delete(id);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    @Cacheable(value = "userNameCache",keyGenerator = "wiselyKeyGenerator")
    public User findByUserName(String userName){
        logger.info("无缓存调用数据库查询");
        return userRepository.findByUserName(userName);
    }
}
