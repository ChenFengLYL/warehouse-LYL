package com.ylu.warehouse.sys.common;

/**
 * json数据实体
 */
public class DateGridView {

    private Integer code = 0;
    private String msg="";
    private Long count = 0L;
    private Object data;

    public DateGridView() {
    }

    public DateGridView(Object data) {
        this.data = data;
    }

    public DateGridView(Long count, Object data) {
        this.count = count;
        this.data = data;
    }

    public DateGridView(Integer code, String msg, Long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
