package io.renren.modules.student.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import io.renren.common.exception.RRException;
import io.renren.common.utils.*;
import io.renren.modules.student.entity.StudentEntity;
import io.renren.modules.student.service.StudentService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 *
 * @author yangaoting
 * @email yan_gt@163.com
 * @date 2019-11-09 20:16:08
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("student:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uuid}")
    @RequiresPermissions("student:info")
    public R info(@PathVariable("uuid") Long uuid){
		StudentEntity student = studentService.getById(uuid);

        return R.ok().put("student", student);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("student:save")
    public R save(@RequestBody StudentEntity student){
        //数据校验
        verifyForm(student);

        //初始化数据
        student.setUuid(UUIDUtils.uuid());
        student.setStatus(0);
        student.setCreateTime(new Date());
        student.setCreateUser(ShiroUtils.getUserId().toString());
        student.setUpdateTime(new Date());
        student.setUpdateUser(ShiroUtils.getUserId().toString());

        //保存
        studentService.save(student);

        return R.ok();
    }

    private void verifyForm(StudentEntity student) {
        if(StringUtils.isBlank(student.getStudentNo())){
            throw new RRException("学号不能为空");
        }

        if(studentService.isExists(student.getStudentNo())){
            throw new RRException("该学号已占用");
        }

        if(StringUtils.isBlank(student.getStudentName())){
            throw new RRException("姓名不能为空");
        }

        if(student.getGender() == null || (student.getGender() != 0 && student.getGender() != 1)){
            throw new RRException("未确认学生性别");
        }

        if(StringUtils.isBlank(student.getGrade())){
            throw new RRException("年级不能为空");
        }

        if(student.getBirthday() == null){
            throw new RRException("出生日期不能为空");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("student:update")
    public R update(@RequestBody StudentEntity student){
		studentService.updateById(student);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("student:delete")
    public R delete(@RequestBody Long[] uuids){
		studentService.removeByIds(Arrays.asList(uuids));

        return R.ok();
    }

}
