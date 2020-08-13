package com.zhijie.mapper;

import com.zhijie.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: zhijie
 * @Date: 2020/06/16/15:43
 * @Description:
 */
//这是一个mybatis的类

@Mapper
@Repository
public interface UserMapper {
  List<User>queryUserList();

  User queryUserById(Integer id);

  int addUser(User user);

  int updateUser(User user);

  int deleteUser(Integer id);

  User login(String name,String password);

  User queryUserName(String name);
}
