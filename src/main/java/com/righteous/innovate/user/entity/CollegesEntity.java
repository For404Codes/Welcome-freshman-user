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
@TableName("colleges")
public class CollegesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学院ID
	 */
	@TableId
	private Integer collegeId;
	/**
	 * 学院名
	 */
	private String name;
	/**
	 * 学院简介
	 */
	private String introduction;
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
