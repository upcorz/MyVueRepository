package com.kai.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kai.entity.Piechart;
import com.kai.service.PiechartService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Piechart)表控制层
 *
 * @author kai
 * @since 2020-12-23 18:25:25
 */
@RestController
@RequestMapping("piechart")
@CrossOrigin // 解决跨域问题
public class PiechartController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PiechartService piechartService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param piechart 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R<?> selectAll(Page<Piechart> page, Piechart piechart) {
        return success(this.piechartService.page(page, new QueryWrapper<>(piechart)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R<?> selectOne(@PathVariable Serializable id) {
        return success(this.piechartService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param piechart 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R<?> insert(@RequestBody Piechart piechart) {
        return success(this.piechartService.save(piechart));
    }

    /**
     * 修改数据
     *
     * @param piechart 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R<?> update(@RequestBody Piechart piechart) {
        return success(this.piechartService.updateById(piechart));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R<?> delete(@RequestParam("idList") List<Long> idList) {
        return success(this.piechartService.removeByIds(idList));
    }
}
