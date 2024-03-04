package com.righteous.innovate.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author gxj
 * @email 
 * @date 2024-03-04 16:24:02
 */
@Data
@TableName("users")
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID号
	 */
	@TableId
	private Integer userId;
	/**
	 * 用户名
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 对应属性表ID
	 */
	private Integer attributeId;
	/**
	 * 学号
	 */
	private String studentNumber;
	/**
	 * 生源地
	 */
	private String source;
	/**
	 * 身份证号
	 */
	private String idNumber;
	/**
	 * 学院ID
	 */
	private Integer collegeId;
	/**
	 * 关键字设置
	 */
	private String preferences;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建者用户ID
	 */
	private Integer createdUser;
	/**
	 * 更新时间
	 */
	private Date updateTime;
	/**
	 * 更新者用户ID
	 */
	private Integer updatedUser;
	/**
	 * 是否删除（1是，0否）
	 */
	private Integer isDelete;

}
