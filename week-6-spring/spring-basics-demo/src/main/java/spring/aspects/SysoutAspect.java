package spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SysoutAspect {
	@Before(value = "execution(* spring.beans.*.*())")
	public void log() {
		System.out.println("I'm logging!");
	}

	@After(value = "execution(* spring.beans.Controller.*())")
	public void goodbye() {
		System.out.println("Bye!");
	}
	
	@Around(value = "execution(* spring.beans.Controller.*())")
	public void around(ProceedingJoinPoint pjp) {
		System.out.println("Around 1");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Around 2");
	}
	
	@AfterThrowing(value = "execution(* spring.beans.Controller.error())")
	public void handle(JoinPoint jp) {
		System.out.println("oops");
	}
}
