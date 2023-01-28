package github.devokado.ecommerce.stepDefinitions;


import github.devokado.ecommerce.EcommerceApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest(
        classes = {EcommerceApplication.class, TestConfiguration.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {"spring.main.allow-bean-definition-overriding=true"}
)
@ContextConfiguration
@CucumberContextConfiguration
public class CucumberSpringConfig {
}
