package io.renren.modules.trainingproject.service.impl;

import io.renren.modules.trainingproject.dao.TrainingProjectDao;
import io.renren.modules.trainingproject.entity.TrainingProjectEntity;
import io.renren.modules.trainingproject.service.TrainingProjectService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;



@Service("trainingProjectService")
public class TrainingProjectServiceImpl extends ServiceImpl<TrainingProjectDao, TrainingProjectEntity> implements TrainingProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TrainingProjectEntity> page = this.page(
                new Query<TrainingProjectEntity>().getPage(params),
                new QueryWrapper<TrainingProjectEntity>()
        );

        return new PageUtils(page);
    }

}