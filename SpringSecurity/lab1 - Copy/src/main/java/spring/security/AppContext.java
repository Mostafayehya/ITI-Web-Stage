package spring.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@ComponentScan("spring.security")
// @ImportResource("classpath:/beans.xml")
@PropertySource("classpath:application.properties")
public class AppContext
//        extends WebMvcConfigurerAdapter
{
//    @Override
//    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//        configurer
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .favorPathExtension(true);
//    }
//
//    /*
//     * Configure ContentNegotiatingViewResolver
//     */
//    @Bean
//    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
//        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
//        resolver.setContentNegotiationManager(manager);
//
//        // Define all possible view resolvers
//        List<ViewResolver> resolvers = new ArrayList<>();
//
//        resolvers.add(pdfViewResolver());
//
//        resolver.setViewResolvers(resolvers);
//        return resolver;
//    }
//
//    /*
//     * Configure View resolver to provide Pdf output using iText library to
//     * generate pdf output for an object content
//     */
//    @Bean
//    public ViewResolver pdfViewResolver() {
//        return new PdfViewResolver();
//    }


}