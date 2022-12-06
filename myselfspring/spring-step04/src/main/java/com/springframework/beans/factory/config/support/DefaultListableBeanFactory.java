package com.springframework.beans.factory.config.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhang3861218
 * @fileName DefaultListableBeanFactory
 * @date 2022/11/30 16:27
 * @description: 默认的bean工厂实现类
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanfactory implements BeanDefinitionRegistry{

    private Map<String,BeanDefinition> beanDefinitionMap=new HashMap<>();


    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition=beanDefinitionMap.get(beanName);
        if (beanDefinition==null){
            throw new BeansException("");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
