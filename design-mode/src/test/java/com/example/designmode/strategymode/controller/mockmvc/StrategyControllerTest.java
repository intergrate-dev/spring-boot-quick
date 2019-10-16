package com.example.designmode.strategymode.controller.mockmvc;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.designmode.strategymode.model.DemoPojo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testChoose() throws Exception {
        DemoPojo dp = new DemoPojo();
        dp.setName("A");
        dp.setOrderId("O_001");
        dp.setPoolId("axxStrategy");
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/choose")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
//                .andDo(MockMvcResultHandlers.print())
                .content(JSONObject.toJSONString(dp)))
                .andReturn();
        //Assert.assertEquals(200, mvcResult.getResponse().getStatus());
        //Assert.assertEquals(dp.getName(), mvcResult.getResponse().getContentAsString());

        System.out.println("=========== testChoose: " + mvcResult.getResponse().getContentAsString());

    }
}