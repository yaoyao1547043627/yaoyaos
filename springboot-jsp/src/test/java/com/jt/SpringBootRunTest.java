package com.jt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
/**
 * @RunWith表示测试类对象的方法由谁去调用并测试
 * @author Administrator
 *@SpringBootTest注解描述的类交给spring容器管理
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {
	@Autowired
      UserMapper userMapper;
	
	@Test
	public void test() {
		System.out.println("userMapper:"+userMapper);
//		List<User>list = userMapper.findAll();
//		for(User user:list) {
//			System.out.println("user:"+user);
//		}
		//表示查询的全部数据库记录
		List<User>list = userMapper.selectList(null);
		for(User user:list) {
			System.out.println("user:"+user);
      }
	}
	
	@Test
	public void testInsert() {
		User user =new User();
		user.setName("yaoyao");
		user.setAge(20);
		user.setSex("男");
		userMapper.insert(user);
		System.out.println("插入成功");
	}
	
	@Test
	public void deleteTest() {
		//userMapper.deleteById(54);
		List<Integer>idList = new ArrayList<>();
		idList.add(55);
		idList.add(56);
		userMapper.deleteBatchIds(idList);
		System.out.println("删除成功");
	}
	
	@Test
	public void updateTest() {
		User user = new User();
		user.setId(53);
		user.setName("yangyang");
		userMapper.updateById(user);
		System.out.println("修改成功");
	}
	@Test
	public void testSelectOne() {
		//User user= userMapper.selectById(50);
		/*
		 * queryWrapper条件构造器 
		 * 动态生成where条件之后的sql
		 */
		User user = new User();
		user.setName("yangyang");
		System.out.println("user:"+user);
		QueryWrapper<User> quer =new QueryWrapper<>(user);
		System.out.println("quer:"+quer);
		//根据其中不为null的属性 当做where条件
		 user = userMapper.selectOne(quer);
		System.out.println("user:"+user);
		//System.out.println("查询成功");
	}
	@Test
	public void testSelectOne1() {
		
		QueryWrapper<User> quer =new QueryWrapper<>();
//	   quer.eq("name", "yangyang")
//	        .eq("age",20);
		//age大于100的
		  quer.gt("age", 100);
		List<User> users = userMapper.selectList(quer);
		for(User user:users) {
			System.out.println("user:"+user);
      }
	//	System.out.println("user:"+user);
		//System.out.println("查询成功");
	}
	@Test
	public void testSeslectList() {
		QueryWrapper<User>quer = new QueryWrapper<>();
		//age 在1到180之间
		quer.between("age", 1, 180);
		List<User> users = userMapper.selectList(quer);
		for(User user:users) {
			System.out.println("user:"+user);
      }
	}
	@Test
	public void testSelectList2() {
		QueryWrapper<User>quer = new QueryWrapper<>();
		quer.isNull("name");
		List<User> users = userMapper.selectList(quer);
		for(User user:users) {
			System.out.println("user:"+user);
      }
	}
	
	/**
	 * 要求将name为null的信息 name设置为苏乞儿
	 * entity:要修改后的数据信息
	 * updateWrapper:更新的条件构造器
	 */
	@Test
	public void updateTest1() {
		User user = new User();
		user.setName("苏乞儿");
		UpdateWrapper<User>update = new UpdateWrapper<>();
		update.isNotNull("name");
		int users =userMapper.update(user, update);
		System.out.println("users:"+users);
		System.out.println("恭喜你学会了Mybatisplus");
	}
}
