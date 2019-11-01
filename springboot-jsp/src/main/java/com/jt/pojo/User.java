package com.jt.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)//使用chain属性 setter方法返回当前对象   public User setId(Integer id)
//如果表名和类名一致可以省略
@TableName(value="user")
public class User implements Serializable{
	private static final long serialVersionUID = 3065787541532924197L;
	@TableId(type=IdType.AUTO)//代表主键 并且主键自增
	private Integer id;
	//如果字段属性名称一致 可以省略配置
	//@TableField(value="name") 如果表字段和属性名不一致 则可以用此注解进行标识
	private String name;
	private Integer age;
	private String sex;
}
