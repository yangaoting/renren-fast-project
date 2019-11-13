package io.renren.modules.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 
 * 
 * @author yangaoting
 * @email yan_gt@163.com
 * @date 2019-11-09 20:16:08
 */
@Data
@TableName("tb_student")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.UUID)
	@JsonSerialize(using = ToStringSerializer.class)
	private Long uuid;
	/**
	 * 
	 */
	private String studentNo;
	/**
	 * 
	 */
	private String studentName;
	/**
	 * 
	 */
	private Integer gender;
	/**
	 * 
	 */
	private String grade;
	/**
	 * 
	 */
	private Date birthday;
	/**
	 * 
	 */
	@TableLogic
	private Integer status;
	/**
	 * 
	 */
	private String createUser;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String updateUser;
	/**
	 * 
	 */
	private Date updateTime;

}
