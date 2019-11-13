package io.renren.modules.student.service.impl;

import io.renren.modules.student.dao.StudentDao;
import io.renren.modules.student.entity.StudentEntity;
import io.renren.modules.student.service.StudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;



@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public boolean isExists(String studentNo) {
        return this.count(new QueryWrapper<StudentEntity>().eq("student_no",studentNo))  != 0;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StudentEntity> page = this.page(
                new Query<StudentEntity>().getPage(params),
                new QueryWrapper<StudentEntity>().like(params.containsKey("studentName"),"student_name",params.get("studentName"))
        );

        return new PageUtils(page);
    }

}