package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.demo.MyServiceBean;
import ru.gb.hw.HomeTest;

@SpringBootApplication
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAopDemoApplication {

	// OOP (Object oriented programing)
	// AOP (Aspect oriented programming)

	// CGLib extends MyServiceBean
	// DynamicProxy implements ...

	// @Transactional

	public static void main(String[] args) {
//		System.out.println(RuntimeException.class.isAssignableFrom(IllegalArgumentException.class));
//		System.out.println(IllegalArgumentException.class.isAssignableFrom(RuntimeException.class));


		ConfigurableApplicationContext context = SpringApplication.run(SpringAopDemoApplication.class, args);
//		MyServiceBean myServiceBean = context.getBean(MyServiceBean.class);
//
//		myServiceBean.method1("argument");

		// object = myServiceBean
		// proxy[object]

		// method1 -> proxy[object -> method2]


		// object = Bean MyServiceBean
		// Proxy[object = MyServiceBean] != MyServiceBean == MyServiceInterface


		HomeTest homeTest = context.getBean(HomeTest.class);
		System.out.println("HomeTest method1: " + homeTest.method1("1",2));
		System.out.println("HomeTest method2: " + homeTest.method2());
		System.out.println("HomeTest method3: " + homeTest.method3());

	}

}
