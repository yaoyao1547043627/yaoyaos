package com.jt.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;

//@Mapper //将接口交给spring管理 管理的是UserMapper代理对象
public interface UserMapper extends BaseMapper<User>{
    // List<User>findAll();
}
