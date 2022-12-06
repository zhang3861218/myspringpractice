package com.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhang3861218
 * @fileName PropertyValues
 * @date 2022/11/30 17:47
 * @description: 属性值集合
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList=new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : this.propertyValueList){
            if (pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }
}
