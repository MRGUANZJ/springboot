package com.zhijie.service;

import com.zhijie.mapper.UserMapper;
import com.zhijie.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zhijie
 * @Date: 2020/06/16/16:16
 * @Description:
 */
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper mapper;
    @Override
    public List<User> queryUserList() {
        return mapper.queryUserList();
    }

    @Override
    public User queryUserById(Integer id) {
        return mapper.queryUserById(id);
    }

    @Override
    public int addUser(User user) {
        return mapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return mapper.updateUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return mapper.deleteUser(id);
    }

    @Override
    public User login(String name, String password) {
        return mapper.login(name,password);
    }

    @Override
    public User queryUserName(String name) {
        return mapper.queryUserName(name);
    }

}
