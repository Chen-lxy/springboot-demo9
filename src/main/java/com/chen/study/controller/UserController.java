package com.chen.study.controller;

import com.chen.study.entity.User;
import com.chen.study.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/queryById")
    public User queryById(int id){
        return userMapper.queryById(id);
    }

    @RequestMapping("/")
    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    @RequestMapping("/add")
    public String addUser(User user){
        return userMapper.addUser(user) == 1?"success":"failed";
    }

    @RequestMapping("/updateById")
    public String updateUser(User user){
        return userMapper.updateUser(user) == 1? "success":"failed";
    }

    /**
     * 分页查询
     * @param model
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/listall")
    public String listCategorey(Model model,
                                @RequestParam(value = "start",defaultValue = "0") int start,
                                @RequestParam(value = "size",defaultValue = "2") int size) throws Exception{
        PageHelper.startPage(start,size,"id desc");
        List<User> users = userMapper.queryAll();
        PageInfo<User> page = new PageInfo<>(users);
        model.addAttribute("page",page);
        return "list";

    }
}
