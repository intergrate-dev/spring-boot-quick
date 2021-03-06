package com.example.designmode.strategymode.check;

import com.example.designmode.strategymode.strategy.ParamValidate;

import java.util.regex.Pattern;

/**
 * 判断是否是年龄 1-999数字
 * @author yuan
 * @date 2018年9月17日
 */
public class IsAge implements ParamValidate {
	/**
	 * 判断是否是年龄 1-999数字
	 * 
	 * @return
	 */
	@Override
	public String validate(String param,String validateVal) {
		Pattern pattern = Pattern.compile("^(?!0)\\d{1,3}$");
		java.util.regex.Matcher match = pattern.matcher(param);
		if (match.matches() == false) {
			return "年龄格式不正确";
		} else {
			return null;
		}
	}

}
