package com.lw.dcsjob.common.core.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lw
 * @create 2024-09-24-21:37
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class DcsJobSpringContext implements BeanFactoryPostProcessor, ApplicationContextAware {

    private static ConfigurableListableBeanFactory FACTORY;

    private static ApplicationContext CONTEXT;


    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DcsJobSpringContext.FACTORY = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DcsJobSpringContext.CONTEXT = applicationContext;
    }

    public static ListableBeanFactory getBeanFactory() {
        final ListableBeanFactory factory = null == FACTORY ? CONTEXT : FACTORY;
        if (null == factory) {
            throw new RuntimeException("No ConfigurableListableBeanFactory or ApplicationContext injected, maybe not in the Spring enviroment?");
        }
        return factory;
    }

    public static ApplicationContext getContext() {
        return CONTEXT;
    }

    public static <T> T getBeanByType(Class<T> clazz) {
        return getBeanFactory().getBean(clazz);
    }

    public static synchronized <T> T getBean(String name) {
        try {
            return (T) getBeanFactory().getBean(name);
        } catch (BeansException | NullPointerException e) {
            log.error("BeanName:{} not exists, Exception => {}", name, e.getMessage());
            return null;
        }
    }

    public static synchronized <T> T getBean(Class<T> requiredType) {
        try {
            return getBeanFactory().getBean(requiredType);
        } catch (BeansException | NullPointerException e) {
            log.error("BeanName:{} not exists, Exception => {}", requiredType.getName(), e.getMessage());
            return null;
        }
    }

    public static synchronized <T> T getBean(String name, Class<T> requiredType) {
        try {
            return getBeanFactory().getBean(name, requiredType);
        } catch (BeansException | NullPointerException e) {
            log.error("BeanName:{} not exists, Exception => {}", name, e.getMessage());
            return null;
        }
    }
}
