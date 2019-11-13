package io.renren.modules.student.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.student.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author yangaoting
 * @email yan_gt@163.com
 * @date 2019-11-09 20:16:08
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {
	
}
