package com.leyou.item.Controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 根据父节点id查询子节点
     * @param pid
     * @return
     */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(@RequestParam(value = "pid",defaultValue = "0") Long pid){
        if (pid==null||pid<0){
            //return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();//400 参数不合法
            return ResponseEntity.badRequest().build();//简洁写法，对上面进行了封装
        }
        List<Category> categories =  this.categoryService.queryCategoriesByPid(pid);
        if (CollectionUtils.isEmpty(categories)){ //判断空
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
        }
        //200 查询成功
        return ResponseEntity.ok(categories);

    }
}
