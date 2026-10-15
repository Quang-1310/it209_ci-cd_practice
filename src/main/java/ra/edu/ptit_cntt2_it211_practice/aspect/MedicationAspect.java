package ra.edu.ptit_cntt2_it211_practice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MedicationAspect {
    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* ra.edu.ptit_cntt2_it211_practice.service.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info("Hàm sắp được gọi {}", methodName);
    }
}
