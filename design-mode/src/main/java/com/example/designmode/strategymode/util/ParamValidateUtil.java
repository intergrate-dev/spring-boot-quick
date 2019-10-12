package com.example.designmode.strategymode.util;

import com.alibaba.fastjson.JSONObject;
import com.example.designmode.strategymode.model.SqlParam;
import com.example.designmode.strategymode.strategy.ParamValidate;
import com.example.designmode.strategymode.strategy.impl.ParamValidateStrategy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 校验类
 *
 * @author yuan
 * @date 2018年9月17日
 */
public class ParamValidateUtil {
    /**
     * @param @param  TAiSqlParamList
     * @param @param  keyParameter
     * @param @return
     * @param @throws ClassNotFoundException
     * @param @throws InstantiationException
     * @param @throws IllegalAccessException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @author yuan
     * @date 2018年9月17日
     */
    public static List<String> ValidateAllFields(List<SqlParam> sqlParamList, String keyParameter) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        JSONObject json = JSONObject.parseObject(keyParameter);
        //获得json数组的所有key
        /*Iterator keys = json.keys();
        List<String> keylist = IteratorUtils.toList(keys);*/
        //错误信息的list
        List<String> errorMsgList = new ArrayList<>();
        for (SqlParam sqlParam : sqlParamList) {
            if (json.containsKey(sqlParam.getKey())) {
                String paramValue = json.getString(sqlParam.getKey());
                //TODO: 此处待完善
                //反射获取枚举类
                Class<Enum> clazz = (Class<Enum>) Class.forName("com.example.designmode.strategymode.model.Constant$ParamValidate");
                //获取所有枚举实例
                Enum[] enumConstants = clazz.getEnumConstants();
                //根据方法名获取方法
                //根据方法名获取方法
                Method getDesc = clazz.getMethod("getDesc");
                Method getIndex = clazz.getMethod("getIndex");
                String validateType = null;
                for (Enum enum1 : enumConstants) {
                    //判断枚举值与数据库中存的检查类型是否一致，一致就校验，不一直跳过
                    if (((Integer) getIndex.invoke(enum1)) ==
                            Integer.parseInt(sqlParam.getValidateType())) {
                        //执行枚举方法获得枚举实例对应的值
                        validateType = (String) getDesc.invoke(enum1);
                        break;
                    } else {
                        continue;
                    }
                }
                if (validateType == null) {
                    errorMsgList.add("校验类型不存在！");
                    return errorMsgList;
                }

                //根据数据库中储存的枚举类型，根据枚举值获取对应的枚举描述，从而反射生成校验类（校验类的类名与枚举描述必须一致）
                Class<?> forName = Class.forName("com.example.designmode.strategymode.check." + validateType);
                Object obj = forName.newInstance();
                ParamValidateStrategy paramValidateStrategy = new ParamValidateStrategy((ParamValidate) obj);
                String message = paramValidateStrategy.validate(paramValue, sqlParam.getValidateVal());
                if (message != null) {
                    errorMsgList.add(message);
                }

            }
        }
        return errorMsgList;
    }
}
