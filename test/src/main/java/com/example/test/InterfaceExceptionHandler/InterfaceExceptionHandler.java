package com.example.test.InterfaceExceptionHandler;
 
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
/**
 * 自定义异常处理器
 *
 * @author ieflex
 */
@RestControllerAdvice
@Slf4j
public class InterfaceExceptionHandler {
 
//	/**
//	 * 接口 业务异常
//	 */
//	@ResponseBody
//	@ExceptionHandler(BusinessInterfaceException.class)
//	public String businessInterfaceException(BusinessInterfaceException e) {
//		log.error(e.getMessage(), e);
//		ErrorBean error = e.getError();
//		ResultBean resultBean = new ResultBean(error.hashCode(), error.getErrorMsg());
//		return resultBean.toString();
//	}
//
//	/**
//	 * 拦截所有运行时的全局异常   
//	 */
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseBody
//	public String runtimeException(RuntimeException e) {
//		log.error(e.getMessage(), e);
//		// 返回 JOSN
//		ResultBean resultBean = new ResultBean(Constants.INTERFACE_MSG_301, Constants.INTERFACE_MSG_301_TEXT);
//		return resultBean.toString();
//	}
//
//	/**
//	 * 系统异常捕获处理
//	 */
//	@ExceptionHandler(Exception.class)
//	@ResponseBody
//	public String exception(Exception e) {
//		log.error(e.getMessage(), e);
//		ResultBean resultBean = new ResultBean(Constants.INTERFACE_MSG_301, Constants.INTERFACE_MSG_301_TEXT);
//		// 返回 JOSN
//		return resultBean.toString();
//	}
}