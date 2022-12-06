package com.springframework.beans.factory.config;

/**
 * @author zhang3861218
 * @fileName BeanReference
 * @date 2022/11/30 18:17
 * @description: BEAN引用
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
