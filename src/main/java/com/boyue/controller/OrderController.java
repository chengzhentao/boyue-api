package com.boyue.controller;

import com.boyue.common.Result;
import com.boyue.service.OrderService;
import com.boyue.vo.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    private Result list(@RequestParam(value = "carNo",required = false) String carNo,
                        @RequestParam(value = "orderNo",required = false) String orderNo,
                        @RequestParam(value = "partnerName",required = false) String partnerName,
                        @RequestParam(value = "phone",required = false) String phone,
                        @RequestParam(value = "startDate",required = false) String startDate,
                        @RequestParam(value = "endDate",required = false) String endDate,
                        @RequestParam(value = "current",required = false,defaultValue = "1") Integer current,
                        @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize){


        return Result.ok(orderService.list(carNo,orderNo,partnerName,phone,startDate,endDate,current,pageSize));
    }


    @GetMapping("/detail")
    private Result list(@RequestParam(value = "id",required = false) Long id){


        return Result.ok(orderService.detail(id));
    }

    @PostMapping("/save")
    private Result list(@RequestBody OrderInfoVO orderInfoVO){
        orderService.save(orderInfoVO);
        return Result.ok();
    }

    @PostMapping("/delete")
    private Result delete(@RequestBody OrderInfoVO orderInfoVO){
        orderService.delete(orderInfoVO.getId());
        return Result.ok();
    }
}
