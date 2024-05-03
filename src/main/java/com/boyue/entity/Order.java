package com.boyue.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Table(name = "`order`")
public class Order implements Serializable {

    @Id
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

}
