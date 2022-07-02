package springbootexception.exceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)  //根据业务，完成异常处理的需求
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e){

        //在处理异常之前将请求路径、异常信息记录到日志内
        logger.error("Request URL : {},Exception : {}",request.getRequestURI(),e);

        /*

        根据业务要求来完成处理异常的业务


         */

        return null;
    }
}
