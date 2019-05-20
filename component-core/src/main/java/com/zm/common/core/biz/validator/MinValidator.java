package com.zm.common.core.biz.validator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;

/**
 * 最小值验证实现
 * 
 */
public class MinValidator implements Validator<Min> {

	@Override
	public String validate(Min annotation, Object value) throws RuntimeException {
		if (value == null || annotation == null)
			return null;

		BigDecimal dv = toBigDecimal(value);
		if (dv == null)
			return null;

		int result = dv.compareTo(BigDecimal.valueOf(annotation.value()));
		if (annotation.allowEqual()) {
			if (result < 0)
				return MessageFormat.format(R.R.validatorMinEqual(), annotation.value());
		} else {
			if (result <= 0)
				return MessageFormat.format(R.R.validatorMin(), annotation.value());
		}

		return null;
	}

	private BigDecimal toBigDecimal(Object value) {
		if (value instanceof Double || value instanceof Float) {
			return BigDecimal.valueOf(((Number) value).doubleValue());
		} else if (value instanceof BigInteger) {
			return BigDecimal.valueOf(((BigInteger) value).doubleValue());
		} else if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		} else if (value instanceof Number) {
			return BigDecimal.valueOf(((Number) value).longValue());
		} else
			return null;
	}

}