package com.example.service;

import com.example.dao.UserMapper;
import com.example.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by hadoop on 16-12-21.
 * UserService 实现 UserDetailsService 接口
 */
@Service
public class UserService implements UserDetailsService {
    private Logger logger = Logger.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("loadUserByUserName");
        User user = userMapper.selectByUsername(username);
        if (user == null ) {
            logger.error("user is null");
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }

        logger.info(user.getUsername() + "---->" + user.getPassword());

        return user;
    }
}
