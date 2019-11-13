package io.renren.modules.trainingproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author yangaoting
 * @email yan_gt@163.com
 * @date 2019-11-10 00:00:16
 */
@Data
@TableName("tb_training_project")
public class TrainingProjectEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 序号
	 */
	@TableId(type = IdType.AUTO)
	private Integer uuid;
	/**
	 * 项目编号
	 */
	private String projectCode;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 所属分组
	 */
	private String projectLevel;
	/**
	 * 逻辑删除字段
	 */
	@TableLogic
	private Integer status;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private String createUser;
	/**
	 * 
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private String updateUser;

}
