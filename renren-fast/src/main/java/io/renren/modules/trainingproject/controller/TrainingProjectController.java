package io.renren.modules.trainingproject.controller;

import java.util.Arrays;
import java.util.Map;

import io.renren.modules.trainingproject.entity.TrainingProjectEntity;
import io.renren.modules.trainingproject.service.TrainingProjectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author yangaoting
 * @email yan_gt@163.com
 * @date 2019-11-10 00:00:16
 */
@RestController
@RequestMapping("/trainingproject")
public class TrainingProjectController {
    @Autowired
    private TrainingProjectService trainingProjectService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("trainingproject:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = trainingProjectService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uuid}")
    @RequiresPermissions("trainingproject:info")
    public R info(@PathVariable("uuid") Integer uuid){
		TrainingProjectEntity trainingProject = trainingProjectService.getById(uuid);

        return R.ok().put("trainingProject", trainingProject);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("trainingproject:save")
    public R save(@RequestBody TrainingProjectEntity trainingProject){
		trainingProjectService.save(trainingProject);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("trainingproject:update")
    public R update(@RequestBody TrainingProjectEntity trainingProject){
		trainingProjectService.updateById(trainingProject);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("trainingproject:delete")
    public R delete(@RequestBody Integer[] uuids){
		trainingProjectService.removeByIds(Arrays.asList(uuids));

        return R.ok();
    }

}
