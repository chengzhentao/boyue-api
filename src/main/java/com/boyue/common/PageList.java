package com.boyue.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageList<T> implements Serializable {

    private long total;

    private List<T> records;

    public static<T> PageList<T> ok(List<T> records,Long total) {

        PageList pageList = new PageList<>();
        pageList.setRecords(records);
        pageList.setTotal(total);
        return pageList;
    }
}
