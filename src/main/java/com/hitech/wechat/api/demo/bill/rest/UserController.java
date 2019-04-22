package com.hitech.wechat.api.demo.bill.rest;

import com.hitech.wechat.api.demo.bill.domain.User;
import com.hitech.wechat.api.demo.bill.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/list")
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

}
