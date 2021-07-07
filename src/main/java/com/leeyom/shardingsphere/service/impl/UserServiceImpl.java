package com.leeyom.shardingsphere.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leeyom.shardingsphere.common.dto.ApiResponse;
import com.leeyom.shardingsphere.common.enums.UserResponseStatus;
import com.leeyom.shardingsphere.common.exception.BizException;
import com.leeyom.shardingsphere.domain.entity.User;
import com.leeyom.shardingsphere.mapper.UserMapper;
import com.leeyom.shardingsphere.repository.UserRepository;
import com.leeyom.shardingsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author Leeyom Wang
 * @since 2020-05-30 16:17:36
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ApiResponse<IPage<User>> selectAll(Page<User> page, User user) {
        return ApiResponse.ofSuccess(userRepository.selectAll(page, user));
    }

    @Override
    public User getUserInfo(Integer userId) {
        User user = getById(userId);
        if (ObjectUtil.isNull(user)) {
            throw new BizException(UserResponseStatus.USER_NOT_EXIT);
        }
        return user;
    }

    @Override
    public User getByEmail(String email) {
        User param = new User();
        param.setEmail(email);
        return getOne(new QueryWrapper<>(param));
    }
}