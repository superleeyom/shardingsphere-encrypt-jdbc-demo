package com.leeyom.scaffold;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.json.JSONUtil;
import com.leeyom.shardingsphere.ShardingSphereEncryptJdbcDemoApplication;
import com.leeyom.shardingsphere.domain.entity.User;
import com.leeyom.shardingsphere.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ShardingSphereEncryptJdbcDemoApplication.class)
class ShardingSphereEncryptJdbcDemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void cipherTest() {
        // 验证数据加密，新增
        // userService.save(new User("韩武江", 28, "hanwujiang@163.com"));

        // 编辑
        // User updateUser = new User();
        // updateUser.setId(12L);
        // updateUser.setEmail("jianglanhe@gmail.com");
        // userService.updateById(updateUser);

        // 验证开启密文列查询
        // User user = userService.getByEmail("hanwujiang@163.com");

        // 删除明文列，用主键id去查询，看是否能正常查询
        User user = userService.getById(13);
        System.out.println(JSONUtil.toJsonStr(user));
    }

    @Test
    void testHuoolEncrypt() {
        // hutool数据脱敏
        String phone = "13488883888";
        String encryptPhone = DesensitizedUtil.mobilePhone(phone);
        System.out.println(encryptPhone);
    }
}
