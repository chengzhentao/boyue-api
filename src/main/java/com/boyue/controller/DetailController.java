package com.boyue.controller;

import com.boyue.common.Result;
import com.boyue.service.OrderService;
import com.boyue.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/detail")
public class DetailController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    private Result list(@RequestParam(value = "name",required = false) String name,
                        @RequestParam(value = "current",required = false,defaultValue = "1") Integer current,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){


        return Result.ok(orderService.detailList(name,current,pageSize));
    }


    @GetMapping("/getById")
    private Result list(@RequestParam(value = "id",required = false) Long id){


        return Result.ok(orderService.detail(id));
    }

    @PostMapping("/save")
    private Result save(@RequestBody OrderInfoVO orderInfoVO){
        orderService.save(orderInfoVO);
        return Result.ok();
    }


}
