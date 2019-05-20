package com.zm.common.core.biz.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记属性满足最小值条件。
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorClass(MinValidator.class)
@Documented
public @interface Min {

	/**
	 * 最小值
	 * 
	 * @return 最小值。
	 */
	double value();

	/**
	 * 是否允许等于最小值
	 * 
	 * @return 允许等于返回true，否则返回false。
	 */
	boolean allowEqual() default true;

}
