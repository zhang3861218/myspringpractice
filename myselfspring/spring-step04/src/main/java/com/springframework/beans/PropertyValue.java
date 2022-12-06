package com.springframework.beans;

/**
 * @author zhang3861218
 * @fileName PropertyValue
 * @date 2022/11/30 17:43
 * @description: bean属性信息
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name,String value) {
        this.name=name;
        this.value =value;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
