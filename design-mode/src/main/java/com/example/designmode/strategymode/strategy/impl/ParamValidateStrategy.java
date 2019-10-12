package com.example.designmode.strategymode.strategy.impl;

import com.example.designmode.strategymode.strategy.ParamValidate;

/**
 * 参数校验策略类
 * @author yuan
 * @date 2018-9-17
 *
 */
public class ParamValidateStrategy {
	//持有的具体策略的对象
	private ParamValidate paramValidate;
	/**
     * 构造函数，传入一个具体策略对象
     * @param paramValidate    具体策略对象
     */
	public ParamValidateStrategy(ParamValidate paramValidate) {
		super();
		this.paramValidate = paramValidate;
	}
	 /**
     * 策略方法
     */
	public String validate(String param,String validateVal){
		return paramValidate.validate(param,validateVal);
	}

}
