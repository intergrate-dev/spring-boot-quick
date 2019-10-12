package com.example.designmode.strategymode.check;

import com.example.designmode.strategymode.strategy.ParamValidate;

import java.util.regex.Pattern;

/**
 * 判断是否为邮编
 * @author yuan
 * @date 2018年9月17日
 */
public class IsPostCode implements ParamValidate {

	@Override
	public String validate(String param,String validateVal) {
		Pattern pattern = Pattern.compile("[1-9]\\d{5}(?!\\d)");
		java.util.regex.Matcher match = pattern.matcher(param);
		if (match.matches() == false) {
			return "邮编格式不正确";
		} else {
			return null;
		}
	}

}
