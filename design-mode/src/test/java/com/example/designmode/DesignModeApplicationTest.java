package com.example.designmode;

import com.example.designmode.factorymode.abstractfactory.factory.IDBFactory;
import com.example.designmode.factorymode.abstractfactory.factory.MysqlFactory;
import com.example.designmode.factorymode.abstractfactory.factory.OricleFactory;
import com.example.designmode.factorymode.abstractfactory.service.DepartmentService;
import com.example.designmode.factorymode.abstractfactory.service.UserService;
import com.example.designmode.factorymode.factorymethod.Handler.DBHandler;
import com.example.designmode.factorymode.factorymethod.Handler.IOHandler;
import com.example.designmode.factorymode.factorymethod.factory.IOFactory;
import com.example.designmode.factorymode.factorymethod.factory.XmlFactory;
import com.example.designmode.factorymode.factorymethod.other.IOSimpleFactory;
import com.example.designmode.factorymode.simplefactory.factory.HandlerFactory;
import com.example.designmode.strategymode.model.SqlParam;
import com.example.designmode.strategymode.util.ParamValidateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignModeApplicationTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HandlerFactory handlerFactory;

    //@Autowired
    private UserService userService;

    //@Autowired
    private DepartmentService departmentService;

    @Test
    public void contextLoads() {

    }


    @Test
    public void test() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        //testStrategyMode();
        //testSimpleFactory();
        //testFactoryMethod();
        testAbstractFactory();
    }

    private void testAbstractFactory() {
        IDBFactory factory1 = new MysqlFactory();

        userService = factory1.createUser();
        userService.setUser(1,"晓明");
        userService.getUserName(1);

        IDBFactory factory2 = new OricleFactory();
        departmentService = factory2.createDepartment();
        departmentService.setDepartment(1,"技术部");
        departmentService.getDepartmentName(1);

    }
    private void testFactoryMethod(){
        /*IOFactory factory = new XmlFactory();
        IOHandler handler = factory.getHandler();*/
        // 用简单工厂实现的测试
        IOHandler handler = IOSimpleFactory.getHandler(DBHandler.class);

        handler.add("name","小明");
        handler.update("name","小红");
        handler.query("name");
        handler.remove("name");
    }
    private void testSimpleFactory() {
        handlerFactory.getHandlerByName("axxHandler").print();
        handlerFactory.getHandlerByName("bxxHandler").print();
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
