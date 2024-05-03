package com.boyue.vo;

import com.boyue.entity.Detail;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class OrderInfoVO implements Serializable {

    private Long id;
    private String orderNo;
    private String partnerName;
    private String phone;
    private Integer length;
    private String carNo;
    private String carType;
    private String maintainType;
    private String receiveUser;
    private String maintainUser;
    private String operatorUser;
    private LocalDate inTime;
    private LocalDate outTime;
    private BigDecimal totalMoney;
    private List<Detail> details;
}
