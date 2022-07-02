package springbootlogger.aspect;


import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLogger {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //设置日志记录的切面

    @Pointcut("execution(* springbootlogger.controller.*.*(..))")
    public void log() {
        /*定义一个切面，此处表示定义了一个名为 log 的切面，并且这个切面会拦截 springbootlogger.controller
           下所有类内的所有方法
         */
    }


    @Before("log()") //表示在切面之前调用 beforeLog() 方法
    public void beforeLog(){
        logger.info("====调用api之前进行日志记录====");
    }

    @After("log()") //表示在切面之后调用 beforeLog() 方法
    public void afterLog(){
        logger.info("====调用api之后进行日志记录====");
    }

    /*
          @AfterReturning 表示在切面拦截的方法完成之后再调用 AfterRuntimeLog 方法
          returning = "result" 表示将切面拦截方法的返回值（即 return 的结果）赋值到 AfterRuntimeLog 的 result 参数
     */
    @AfterReturning(returning = "result",pointcut = "log()")
    public void AfterRuntimeLog(Object result){
        logger.info("Result : {}",result);
    }



}
