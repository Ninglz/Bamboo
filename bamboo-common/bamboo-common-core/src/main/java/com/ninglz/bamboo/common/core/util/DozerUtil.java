package com.ninglz.bamboo.common.core.util;

/**
 * @program: bamboo
 * @description: dozer 深拷贝
 * @author: ninglz
 * @created: 2021/08/31 11:05
 */
import org.dozer.DozerBeanMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public final class DozerUtil {
    private static final Set<String> IGNORE_FILEDS = new HashSet<>(1);

    static {
        IGNORE_FILEDS.add("serialVersionUID");
    }

    private DozerUtil() {}

    private static DozerBeanMapper dozer = new DozerBeanMapper();

    public static <T> T map(Object source, Class<T> destinationClass) {
        if (source == null) {
            return null;
        }
        return dozer.map(source, destinationClass);
    }

    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        if (sourceList == null) {
            return Collections.emptyList();
        }
        List<T> destinationList = new ArrayList<>();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    public static void copy(Object source, Object destinationObject) {
        if (source == null || destinationObject == null) {
            return;
        }
        dozer.map(source, destinationObject);
    }

    public static Map<String, Object> bean2Map(Object source) {
        Map<String, Object> result = new HashMap<>();
        try {
            Class<?> sourceClass = source.getClass();
            Field[] sourceFiled = sourceClass.getDeclaredFields();
            for (Field field : sourceFiled) {
                field.setAccessible(true);
                result.put(field.getName(), field.get(source));
//                FieldName fieldName = field.getAnnotation(FieldName.class);
//                if (fieldName == null) {
//                    result.put(field.getName(), field.get(source));
//                } else {
//                    if (fieldName.Ignore()) continue;
//                    result.put(fieldName.value(), field.get(source));
//                }
            }
            return result;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T map2Bean(Map<String, Object> source, Class<T> instance) {
        try {
            T object = instance.newInstance();
            Field[] fields = object.getClass().getDeclaredFields();
            Method[] methods = object.getClass().getMethods();
            for (Field field : fields) {
                Method method = getSetMethodName(field, methods);
                if(null == method) {
                    throw new RuntimeException("Filed:" + field.getName() + " no set method");
                }
                method.invoke(object, source.get(field.getName()));
            }
            return object;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * get field set method
     * @param field
     * @param methods
     * @return
     */
    private static Method getSetMethodName(Field field, Method[] methods) {
        String fieldName = field.getName();
        String methodName = "set".concat(fieldName.substring(0, 1).toUpperCase()).concat(fieldName.substring(1));
        Method method = filterMethod(methods, methodName);
        return method;
    }

    /**
     * @param methods
     * @param methodName
     * @return
     */
    private static Method filterMethod(Method[] methods, String methodName) {
        if(methods!=null && methods.length>0) {
            for(Method method : methods) {
                if(method.getName().equals(methodName)) {
                    return method;
                }
            }
        }
        return null;
    }
}

