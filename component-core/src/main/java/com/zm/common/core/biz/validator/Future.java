package com.zm.common.core.biz.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记日期是未来的日期。
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ValidatorClass(FutureValidator.class)
@Documented
public @interface Future {

	/**
	 * 是否允许等于今天。
	 * 
	 * @return 允许返回true，否则返回false。
	 */
	boolean includeToday() default false;

}
