package io.renren.modules.student.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.student.entity.StudentEntity;

import java.util.Map;

/**
 * 
 *
 * @author yangaoting
 * @email yan_gt@163.com
 * @date 2019-11-09 20:16:08
 */
public interface StudentService extends IService<StudentEntity> {

    PageUtils queryPage(Map<String, Object> params);

    boolean isExists(String studentNo);
}

