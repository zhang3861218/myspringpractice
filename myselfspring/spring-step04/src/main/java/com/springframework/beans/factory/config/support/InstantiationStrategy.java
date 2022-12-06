package com.springframework.beans.factory.config.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * Bean实例化策略接口
 * @author zhang3861218
 * @fileName InstantiationStrategy
 * @date 2022/11/23 15:27
 * @description:
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] args) throws BeansException;

}
