package com.boyue.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Detail implements Serializable {

    @Id
    private Long id;
    private String orderNo;
    private String partnerName;
    private String name ;
    private BigDecimal number;
    private String unit ;
    private BigDecimal price;
    private BigDecimal total;
    private String remark;


}
