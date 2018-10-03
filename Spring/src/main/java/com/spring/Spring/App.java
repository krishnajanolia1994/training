package com.spring.Spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Spring.anno.config.AnnoConfig;
import com.spring.Spring.collection.AddCollection;
import com.spring.Spring.config.JavaConfigDemo;
import com.spring.Spring.config.MyConfiguration;
import com.spring.Spring.di.AutowireDemo;
import com.spring.Spring.di.DependencyInjection;
import com.spring.Spring.lifecycle.LifeCycle;
import com.spring.Spring.sigleton.Singalton;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
    	
    	// method for hello world ///////////
    	Hello hello=(Hello) applicationContext.getBean("hello");
    	hello.hello();
    	
    	///////////// beans show singleton SCOP/////////////
    	Singalton singalton=(Singalton) applicationContext.getBean("sigaleton");
    	Singalton singalton1=(Singalton) applicationContext.getBean("sigaleton");
    	singalton.setX(50);
    	singalton1.setX(100);
    	System.out.println(singalton.getX());
    	
    	/////////////method to show dependency injection//////////////////
    	DependencyInjection dependencyInjection=(DependencyInjection) applicationContext.getBean("dependencyInjection");
    	dependencyInjection.show();
    	
    	////////////// to inject collection //////////////////////////////////
    	AddCollection addCollection=(AddCollection) applicationContext.getBean("collection");
    	List<String> list=addCollection.getList();
    	for(String str : list)
    	{
    		System.out.println(str);
    	}
    	
    	////////////////////////// method to demostrate autowire by name /////////////////////////////////
    	AutowireDemo autowireDemo=(AutowireDemo) applicationContext.getBean("autowireDemo");
    	autowireDemo.show();
    	
    	/////////////// method to show to demostrate lifecycle of bean///////////////////
    	LifeCycle cycle=(LifeCycle) applicationContext.getBean("lifecycle");
    	cycle.show();
    	System.out.println(singalton.getX());
    	try {
        	((AbstractApplicationContext) applicationContext).registerShutdownHook();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
    	
    	///////////////////////////////////////////////////////////////////////////////////
    	///////////////////////////////////////////////////////////////////////////
    	///////////////// annotation based configuration //////////////////////////////
    	ApplicationContext applicationContext2=new ClassPathXmlApplicationContext("springAnno.xml");
    	AnnoConfig annoConfig=(AnnoConfig) applicationContext2.getBean("annoConfig");
    	annoConfig.show();
    	
    	/////////////////////////////////////////////////////////////////////////////////
    	//////////////////////////////////////////////////////////////////////////////
    	///////////////////////////////////////////////////////////////////////////////
    	///////////  java based configuration /////////////////////////////////////////////////
    	ApplicationContext applicationContext3=new AnnotationConfigApplicationContext(MyConfiguration.class);
    	JavaConfigDemo configDemo=(JavaConfigDemo) applicationContext3.getBean("javaConfigDemo");
    	configDemo.show();
	    
	    
	/////////////////////////////////////////////////////////////////////////////////////////////
	    //////////////////////////////////// line of code to demenstrate aspact oriented programmin///////////
	Demo demo=(Demo) applicationContext.getBean("demo");
        demo.show();
    	
    }
}
