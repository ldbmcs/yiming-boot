package ${package.Controller};

import com.ldbmcs.common.base.ApiResult;
import com.ldbmcs.common.base.BaseController;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} extends ${superControllerClass} {

    @Resource
    public ${table.serviceName} ${entity?uncap_first}Service;

    @GetMapping("/list")
    public ApiResult list() {
        List<${entity}> list = ${entity?uncap_first}Service.list();
        return success(list);
    }

    @PutMapping("/add")
    public ApiResult add(${entity} ${entity?uncap_first}) {
        ${entity?uncap_first}Service.save(${entity?uncap_first});
        return success();
    }

    @DeleteMapping("/delete")
    public ApiResult delete(Integer id) {
        ${entity?uncap_first}Service.removeById(id);
        return success();
    }

    @PostMapping("/update")
    public ApiResult update(${entity} ${entity?uncap_first}) {
        ${entity?uncap_first}Service.updateById(${entity?uncap_first});
        return success();
    }

    @GetMapping("/detail")
    public ApiResult detail(Integer id) {
        ${entity} ${entity?uncap_first} = ${entity?uncap_first}Service.getById(id);
        return success(${entity?uncap_first});
    }
}