package com.xtpeach.tiny.id.base.entity;

/**
 * @author xtpeach
 */
public class  ResultCode {

    /**
     * 正常可用
     */
    public static final int NORMAL = 1;
    /**
     * 需要去加载nextId
     */
    public static final int LOADING = 2;
    /**
     * 超过maxId 不可用
     */
    public static final int OVER = 3;

    private ResultCode(){

    }
}
