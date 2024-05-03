package com.boyue.service;

import com.boyue.common.PageList;
import com.boyue.entity.Detail;
import com.boyue.entity.Order;
import com.boyue.mapper.DetailMapper;
import com.boyue.mapper.OrderMapper;
import com.boyue.vo.OrderInfoVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private DetailMapper detailMapper;

    public PageList<Order> list(String carNo, String orderNo, String partnerName, String phone, String startDate, String endDate,Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        Example example=new Example(Order.class);//要查询的表对应的实体类
        Example.Criteria criteria=example.createCriteria();//创建查询标准
        if(!StringUtils.isEmpty(carNo)){
            criteria.andEqualTo("carNo",carNo);
        }
        if(!StringUtils.isEmpty(orderNo)){
            criteria.andEqualTo("orderNo",orderNo);
        }
        if(!StringUtils.isEmpty(partnerName)){
            criteria.andLike("partnerName","%" + partnerName + "%");
        }
        if(!StringUtils.isEmpty(phone)){
            criteria.andEqualTo("phone",phone);
        }
        if(!StringUtils.isEmpty(startDate)){
            try {
                LocalDate startDate1 = LocalDate.parse(startDate);
                criteria.andGreaterThan("inTime",startDate1);
            }catch (Exception e){

            }
        }
        if(!StringUtils.isEmpty(endDate)){
            try {
                LocalDate endDate1 = LocalDate.parse(endDate);
                criteria.andLessThan("inTime",endDate1);
            }catch (Exception e){

            }
        }
        example.setOrderByClause("id desc");
        Page page= (Page)orderMapper.selectByExample(example);
        return PageList.ok(page.getResult(),page.getTotal());
    }

    public OrderInfoVO detail(Long id) {
        OrderInfoVO orderInfoVO = new OrderInfoVO();
        Order order =orderMapper.selectByPrimaryKey(id);
        if(order == null){
            return orderInfoVO;
        }
        BeanUtils.copyProperties(order, orderInfoVO);
        Example example=new Example(Detail.class);//要查询的表对应的实体类
        Example.Criteria criteria=example.createCriteria();//创建查询标准
        criteria.andEqualTo("orderNo",order.getOrderNo());
        List<Detail> detailList = detailMapper.selectByExample(example);
        orderInfoVO.setDetails(detailList);
        return orderInfoVO;
    }

    @Transactional(rollbackFor =Exception.class)
    public void save(OrderInfoVO orderInfoVO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderInfoVO, order);
        String orderNo = LocalDateTime.now().toString().replace("-","").replace(":","").replace("T","").replace("Z","").replace("", "").replace(".","");
        order.setOrderNo("BY" + orderNo);
        if(!CollectionUtils.isEmpty(orderInfoVO.getDetails() )){
            for(int i = 0 ; i< orderInfoVO.getDetails().size();i++){
                Detail detail = orderInfoVO.getDetails().get(i);
                detail.setOrderNo(order.getOrderNo());
                detail.setPartnerName(order.getPartnerName());
                detailMapper.insert(detail);
            }
        }
        order.setTotalMoney(orderInfoVO.getDetails().stream().map(Detail::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add));
        orderMapper.insert(order);

    }

    public PageList<Detail> detailList(String name, Integer current, Integer pageSize) {
        PageHelper.startPage(current, pageSize);
        Example example=new Example(Detail.class);//要查询的表对应的实体类
        Example.Criteria criteria=example.createCriteria();//创建查询标准
        if(!StringUtils.isEmpty(name)){
            criteria.andLike("name","%" + name + "%");
        }
        example.setOrderByClause("id desc");
        Page page= (Page)detailMapper.selectByExample(example);
        return PageList.ok(page.getResult(),page.getTotal());
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order == null){
            return;
        }
        Example example=new Example(Detail.class);//要查询的表对应的实体类
        Example.Criteria criteria=example.createCriteria();//创建查询标准
        criteria.andEqualTo("orderNo",order.getOrderNo());
        detailMapper.deleteByExample(example);
        orderMapper.deleteByPrimaryKey(id);
    }
}
