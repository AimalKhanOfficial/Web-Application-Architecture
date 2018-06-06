package formatter.config;

import formatter.actualformatters.AddressFormater;
import formatter.actualformatters.CustomerConverter;
import formatter.dao.CustomerDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
public class ConfigFile extends WebMvcConfigurerAdapter {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        AddressFormater addressFormater = new AddressFormater();
        registry.addFormatter(addressFormater);

        CustomerConverter customerConverter = new CustomerConverter(tradeService());
        registry.addConverter(customerConverter);
    }

    @Bean
    public CustomerDataService tradeService(){
        return new CustomerDataService();
    }

    @Bean
    public ViewResolver viewResolver () {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
