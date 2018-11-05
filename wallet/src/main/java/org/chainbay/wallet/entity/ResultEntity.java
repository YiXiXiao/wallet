package org.chainbay.wallet.entity;

/**
 * Created by xiaoyixi on 2018/11/5.
 */

public class ResultEntity<T> {
    private String code;
    private String msg;
    private T data;

    public ResultEntity() {
    }

    public ResultEntity(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
