package web.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        hiddenFilter(servletContext);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { HiberConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    private void hiddenFilter(ServletContext context) {
        context.addFilter("hiddenFilter", new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null, true, "/*");;
    }
}
