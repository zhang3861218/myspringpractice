package com.springframework.beans.factory.config.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.PropertyValue;
import com.springframework.beans.PropertyValues;
import com.springframework.beans.factory.config.BeanDefinition;
import com.springframework.beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;

import java.lang.reflect.Constructor;

/**
 * @author zhang3861218
 * @fileName AbstractAutowireCapableBeanfactory
 * @date 2022/11/29 16:25
 * @description: 实现默认bean创建的抽象bean工厂超类
 */
public abstract class AbstractAutowireCapableBeanfactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy=new CglibSubclassingInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean=null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        }catch(Exception e){
            throw new BeansException("",e);
        }
        registerSingleton(beanName,bean);
        return bean;
    }



    private void applyPropertyValues(String beanName,Object bean,BeanDefinition beanDefinition){
        try{
            PropertyValues propertyValues=beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue:propertyValues.getPropertyValues()){
                String name=propertyValue.getName();
                Object value=propertyValue.getValue();


                if (value instanceof BeanReference){
                    BeanReference beanReference= (BeanReference) value;
                    value=getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean,name,value);
            }
        }catch(Exception e){
            throw new BeansException("");
        }

    }



    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse=null;
        Class<?> beanClass=beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors=beanClass.getDeclaredConstructors();
        for (Constructor ctor:declaredConstructors){
            if (null!=args&&ctor.getParameterTypes().length==args.length){
                constructorToUse=ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy){
        this.instantiationStrategy=instantiationStrategy;
    }

}
