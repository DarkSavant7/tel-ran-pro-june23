package de.telran.market.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
/**
 * https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/aop.html
 */
public class LoggerAspect {
    // определяем срез по всем методам бинов из пакета com.example.aop.service
//    @Pointcut("execution(private de.telran.market.dto.ProductDto de.telran.market.service..*.*(..))")
    @Pointcut("execution(* de.telran.market.service..*.*(..))")
    private void getName() {
    } // определяем совет (Advice) "ПЕРЕД" выполнением кода бина (класса)

//    @Pointcut("execution(* de.telran.market.service.MainProductService.deleteById(..))")
//    @Pointcut("execution(* de.telran.market.service.MainProductService.deleteById(Long))")
//    @Pointcut("execution(* de.telran.market.service.*.*(Long, de.telran.market.dto.ProductDto))")
    @Pointcut("execution(* de.telran.market.service.MainProductService.*(..))")
    private void findAllFromProductService(){}

    @Before("findAllFromProductService()")
    public void logProductsBefore(JoinPoint joinPoint) {
        log.info("[AOP]: Product service method called signature: {}", joinPoint.getSignature());
        log.info("[AOP]: Product service method called target: {}", joinPoint.getTarget());
        log.info("[AOP]: Product service method called source location: {}", joinPoint.getSourceLocation());
        log.info("[AOP]: Product service method called source this: {}", joinPoint.getThis());
        log.info("[AOP]: Product service method called source args: {}", joinPoint.getArgs());
        log.info("[AOP]: Product service method called source kind: {}", joinPoint.getKind());
    }

    @After("findAllFromProductService()")
    public void logProductsAfter(JoinPoint joinPoint) {
        log.info("[AOP] AFTER: Product service method called signature: {}", joinPoint.getSignature());
    }

//        @Around("execution(public de.telran.market.dto.ProductDto de.telran.market.service.MainProductService.findById(Long))")
//        public Object beforeUserEditProduct(ProceedingJoinPoint joinPoint) throws Throwable {
//            log.info("Aspect fake method called: {}", joinPoint.getSignature());
//            var args = joinPoint.getArgs();
//            var currentId = (Long) args[0];
////            var result = (ProductDto) joinPoint.proceed();
////            var result = (ProductDto) joinPoint.proceed();
//            var result = (ProductDto) joinPoint.proceed(new Object[]{currentId + 1});
//            log.info("Result was {}", result);
////            return ProductDto.builder().title("Hello from aspect").build();
//        return result;
//        }

//    @Before("getName()")
////    @After("getName()")
//    public void logBefore(JoinPoint joinPoint) {
//// выводим в консоль информацию о текущей точке соединения
//        log.info("Service method called: {}", joinPoint.getSignature());
//    }
//
//    @Before("execution(public * de.telran.marketapp.web.AuthController.*(..))")
//    public void beforeUserEditProduct(JoinPoint joinPoint) {
//        log.info("Auth controller called: {}", joinPoint.getSignature());
//    }
//
//    @Around("execution(public * de.telran.marketapp.services.ProductService.methodForAspect(String))")
//    public Object beforeUserEditProduct(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("Aspect fake method called: {}", joinPoint.getSignature());
//        var result = (String) joinPoint.proceed();
//        log.info("Result was {}", result);
//        return "Hello from aspect";
////        return result;
//    }
}
