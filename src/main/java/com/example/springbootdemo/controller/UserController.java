package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息管 理
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/user/*")
public class UserController {
    /**
     *
     */
    private final static List<User> userList = new ArrayList<>();

    {
        userList.add(new User("1", "admin", "123456"));
        userList.add(new User("2", "jet", "123456"));
    }

    /**
     * @return List
     */
    @ApiOperation("获取列表")
    @GetMapping("list")
    public List userList() {
        return userList;
    }

    /**
     * @param user
     * @return user
     */
    @ApiOperation("新增用户")
    @PostMapping("save")
    public boolean save(User user) {
        return userList.add(user);
    }

    /**
     * @param user
     * @return user
     */
    @ApiOperation("跟新用户")
    @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "User")
    @PutMapping("update")
    public boolean update(User user) {
        return userList.remove(user) && userList.add(user);
    }

    /**
     * @param user
     * @return users
     */
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "users", value = "N个用户信息", dataType = "List<User>")
    @DeleteMapping("delete")
    public boolean delete(@RequestBody List<User> users) {
        return userList.removeAll(users);
    }
}
