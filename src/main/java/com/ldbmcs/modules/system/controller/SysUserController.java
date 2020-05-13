package com.ldbmcs.modules.system.controller;

import com.ldbmcs.common.base.ApiResult;
import com.ldbmcs.common.base.BaseController;
import com.ldbmcs.modules.system.service.ISysUserService;
import com.ldbmcs.modules.system.entity.SysUser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author ldbmcs
 * @since 2020-05-13
 */
@RestController
@RequestMapping("/system/sys-user")
public class SysUserController extends BaseController {

    @Resource
    public ISysUserService sysUserService;

    @GetMapping("/list")
    public ApiResult list() {
        List<SysUser> list = sysUserService.list();
        return success(list);
    }

    @PutMapping("/add")
    public ApiResult add(SysUser sysUser) {
        sysUserService.save(sysUser);
        return success();
    }

    @DeleteMapping("/delete")
    public ApiResult delete(Integer id) {
        sysUserService.removeById(id);
        return success();
    }

    @PostMapping("/update")
    public ApiResult update(SysUser sysUser) {
        sysUserService.updateById(sysUser);
        return success();
    }

    @GetMapping("/detail")
    public ApiResult detail(Integer id) {
        SysUser sysUser = sysUserService.getById(id);
        return success(sysUser);
    }
}