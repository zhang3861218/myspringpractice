package com.springframework.beans.factory.config.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.BeanFactory;
import com.springframework.beans.factory.config.BeanDefinition;

/**
 * @author zhang3861218
 * @fileName AbstractBeanFactory
 * @date 2022/11/23 16:36
 * @description: 抽象的Bean工厂基类，定义模板方法
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return null;
    }


    protected <T> T doGetBean(final String name,final Object[] args){
        Object bean=getSingleton(name);
        if(bean!=null){
            return (T) bean;
        }
        BeanDefinition beanDefinition=getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }

    protected  abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) ;

    protected abstract BeanDefinition getBeanDefinition(String beanName) ;
}
