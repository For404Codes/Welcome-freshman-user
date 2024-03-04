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
@TableName("user_attributes")
public class UserAttributesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性表ID
	 */
	@TableId
	private Integer attributeId;
	/**
	 * 力量属性
	 */
	private Integer strength;
	/**
	 * 敏捷属性
	 */
	private Integer agility;
	/**
	 * 智力属性
	 */
	private Integer intelligence;
	/**
	 * 经验值
	 */
	private Integer emp;
	/**
	 * 等级
	 */
	private Integer grade;
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
