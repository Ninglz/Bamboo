package com.ninglz.bamboo.common.core.util;

import cn.hutool.extra.cglib.CglibUtil;

/**
 * @program: bamboo
 * @description: 对象拷贝
 * @author: ninglz
 * @created: 2021/08/31 11:49
 */
public class CopyUtiil {

    public static void copy(Object source, Object target,boolean isReferenceCopy){
        if(isReferenceCopy){
            DozerUtil.copy(source,target);
        }
        else{
            CglibUtil.copy(source,target);
        }
    }

    public static void copy(Object source, Object target) {
        copy(source,target,false);
    }
}

