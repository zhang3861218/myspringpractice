package com.springframework.beans.factory.config.support;

import com.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zhang3861218
 * @fileName BeanDefinitionRegistry
 * @date 2022/11/23 16:32
 * @description: 定义注册接口
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
