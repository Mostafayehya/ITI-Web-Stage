package spring.security.mappers;

import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

public class MyHandlerMapping extends AbstractDetectingUrlHandlerMapping {

    @Override
    protected String[] determineUrlsForHandler(String beanName) {
        switch (beanName.toLowerCase()) {
        case "hellocontroller":
            return new String[] { "/app/welcome" };
        default:
            return null;
        }
    }

}