package com.springframework.beans.factory.support;

import com.springframework.beans.BeansException;
import com.springframework.beans.factory.config.BeanDefinition;

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
