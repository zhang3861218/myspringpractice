package com.springframework.beans.factory.config;

import com.springframework.beans.PropertyValues;

/**
 * @author 小傅哥，微信：fustack
 * @description 定义 Bean 实例信息
 * @date 2022/03/07
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class BeanDefinition {

    private Class beanClass;



    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass,PropertyValues propertyValues) {

        this.beanClass = beanClass;
        this.propertyValues=propertyValues !=null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }






}
