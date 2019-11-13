package io.renren.modules.trainingproject.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.trainingproject.entity.TrainingProjectEntity;;

import java.util.Map;

/**
 * 
 *
 * @author yangaoting
 * @email yan_gt@163.com
 * @date 2019-11-10 00:00:16
 */
public interface TrainingProjectService extends IService<TrainingProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

