package com.leeyom.shardingsphere.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leeyom.shardingsphere.domain.entity.User;
import com.leeyom.shardingsphere.mapper.UserMapper;
import com.leeyom.shardingsphere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * user 仓储层实现类
 *
 * @author leeyom
 */
@Repository(value = "userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> selectAll(Page<User> page, User user) {
        return userMapper.selectPage(page, new QueryWrapper<>(user));
    }
}
