package com.sandbox.internals.bean_definitions;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanDefinitionPlayground {

    public static void main(String[] args) {

        DefaultListableBeanFactory factory =
                new DefaultListableBeanFactory();

        // Create a BeanDefinition
        BeanDefinition definition = BeanDefinitionBuilder
                .genericBeanDefinition(MyService.class)
                .setScope(BeanDefinition.SCOPE_SINGLETON)
                .setLazyInit(false)
                .getBeanDefinition();

        // Register it manually
        factory.registerBeanDefinition("myService", definition);

        // Ask Spring for the bean
        MyService service = factory.getBean(MyService.class);

        service.hello();

        // Inspect the BeanDefinition
        BeanDefinition bd = factory.getBeanDefinition("myService");

        System.out.println("Bean name: myService");
        System.out.println("Bean class: " + bd.getBeanClassName());
        System.out.println("Scope: " + bd.getScope());
        System.out.println("Lazy: " + bd.isLazyInit());
        System.out.println("Singleton: " + bd.isSingleton());
        System.out.println("Primary: " + bd.isPrimary());
    }

    static class MyService {

        public void hello() {
            System.out.println("Hello from MyService!");
        }
    }
}
