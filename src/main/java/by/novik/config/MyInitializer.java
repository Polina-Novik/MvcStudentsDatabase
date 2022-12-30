package by.novik.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return null; //у нас нет рут конфигс - поэтому исправили на 0
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class}; //связываем конфиг диспетчер с классом конфигурации
    }

    protected String[] getServletMappings() {
        return new String[]{"/"}; //массив и тут и там одим значением по сути заполнили
    }
}
