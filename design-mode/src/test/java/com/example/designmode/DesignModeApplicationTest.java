package com.example.designmode;

import com.example.designmode.strategymode.model.DemoPojo;
import com.example.designmode.strategymode.model.SqlParam;
import com.example.designmode.strategymode.service.StrategyService;
import com.example.designmode.strategymode.util.ParamValidateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignModeApplicationTest {


    @Test
    public void contextLoads() {

    }


    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        //testStrategyMode();
    }

    /**
     * test samples of strategy mode
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws SecurityException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    private void testStrategyMode() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        strategyModeSampleOne();
    }

    private void strategyModeSampleOne() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取参数key的字符串值,需要转换成json对象（需要替换sql中的数据）
        //String keyParameter = "{\"name\": \"张三\", \"age\": \"23\", \"phone\": \"17688889999\", \"email\": \"1525@qq.com\"}";
        String keyParameter = "{\"name\": \"wewe\", \"accid\": \"acc0023\", \"age\": \"23\", \"phone\": \"17688889999\", \"email\": \"1525@qq.com\"}";
        //根据sql id得到参数验证list
        List<SqlParam> sqlParamList = getSqlParamList();        //校验参数
        List<String> messageList = ParamValidateUtil.ValidateAllFields(sqlParamList, keyParameter);
        messageList.forEach(a -> {
            System.out.println(a);
        });
    }

    private List<SqlParam> getSqlParamList() {
        SqlParam sqlParam1 = new SqlParam("1", "name", "0", "10", "");
        SqlParam sqlParam2 = new SqlParam("2", "age", "1", "", "");
        SqlParam sqlParam3 = new SqlParam("3", "phone", "5", "", "");
        SqlParam sqlParam4 = new SqlParam("4", "email", "3", "", "");
        List<SqlParam> sqlParamList = new ArrayList<>();
        sqlParamList.add(sqlParam1);
        sqlParamList.add(sqlParam2);
        sqlParamList.add(sqlParam3);
        sqlParamList.add(sqlParam4);
        return sqlParamList;
    }

}
