package org.rdlinux.ezmybatis.core.interceptor.executor;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Invocation;
import org.rdlinux.ezmybatis.core.constant.EzMybatisConstant;
import org.rdlinux.ezmybatis.core.interceptor.InterceptorLogic;
import org.rdlinux.ezmybatis.core.interceptor.InterceptorLogicResult;
import org.rdlinux.ezmybatis.core.mapper.EzBaseMapper;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapperParamInitLogic implements InterceptorLogic {
    private static Set<String> methodNames;

    static {
        Method[] declaredMethods = EzBaseMapper.class.getDeclaredMethods();
        methodNames = Arrays.stream(declaredMethods).map(Method::getName).collect(Collectors.toSet());
    }

    @Override
    @SuppressWarnings(value = {"rawtype", "unchecked"})
    public InterceptorLogicResult invokeBefore(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String methodId = mappedStatement.getId();
        int index = methodId.lastIndexOf(".");
        String methodName = methodId.substring(index + 1);
        String className = methodId.substring(0, index);
        Class<?> mapperClass = Class.forName(className);
        //添加参数
        if (EzBaseMapper.class.isAssignableFrom(mapperClass) && methodNames.contains(methodName)) {
            Type[] genericInterfaces = mapperClass.getGenericInterfaces();
            Type[] actualTypeArguments = ((ParameterizedTypeImpl) genericInterfaces[0]).getActualTypeArguments();
            Class<?> etClass = (Class<?>) actualTypeArguments[0];
            Map<String, Object> param = (Map<String, Object>) invocation.getArgs()[1];
            param.put(EzMybatisConstant.MAPPER_PARAM_MAPPER_CLASS, mapperClass);
            param.put(EzMybatisConstant.MAPPER_PARAM_ENTITY_CLASS, etClass);
            param.put(EzMybatisConstant.MAPPER_PARAM_CONFIGURATION, mappedStatement.getConfiguration());
        }
        return new InterceptorLogicResult(true, false);
    }
}
