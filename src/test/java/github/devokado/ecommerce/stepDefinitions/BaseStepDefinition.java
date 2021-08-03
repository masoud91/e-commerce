package github.devokado.ecommerce.stepDefinitions;


import com.fasterxml.jackson.databind.ObjectMapper;
import github.devokado.ecommerce.EcommerceApplication;
import github.devokado.ecommerce.stepDefinitions.catalog.ProductStepDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.spring.CucumberContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CucumberContextConfiguration
@SpringBootTest(
        classes = {EcommerceApplication.class, TestConfiguration.class},
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = {"spring.main.allow-bean-definition-overriding=true"}
)
@ContextConfiguration
@DirtiesContext()
public class BaseStepDefinition {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    Environment environment;

    protected ObjectMapper mapper = new ObjectMapper();
    protected static final String HOST = "localhost";
    protected static final String PORT = "8080";

    protected static final Logger logger = LoggerFactory.getLogger(ProductStepDefinition.class);
    protected ResponseEntity<String> response;
    protected List<Map<String, String>> requestBody;

    public TestRestTemplate getRestTemplate() {
        return restTemplate != null ? restTemplate : new TestRestTemplate();
    }

    public void setRestTemplate(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> invokeRESTCall(String url, HttpMethod method, HttpEntity<?> requestEntity) {
        return getRestTemplate().exchange(url, method, requestEntity, String.class);
    }

    public HttpHeaders getDefaultHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public String buildUrl(String host, String port, String path, Map<String, Object> uriVariables,
                           MultiValueMap<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path).host(host).port(port).scheme("http");
        if (queryParams != null && !queryParams.isEmpty())
            builder.queryParams(queryParams);
        UriComponents uriComponent = uriVariables != null && !uriVariables.isEmpty()
                ? builder.buildAndExpand(uriVariables)
                : builder.build();

        return uriComponent.toUri().toString();

    }

    public String buildUrl(String host, String port, String path) {

        return buildUrl(host, port, path, null, null);
    }

    public String buildUrl(String host, String port, String path, Map<String, Object> uriVariables) {

        return buildUrl(host, port, path, uriVariables, null);
    }

    protected void sendRequest(HttpMethod method, String uri, DataTable body) {
        requestBody = body.asMaps();
        Map<String, Object> requestMap = new HashMap<>();
        requestBody.forEach(x -> requestMap.put(x.get("attribute"), x.get("value")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
        logger.warn(String.valueOf(requestEntity));
        response = invokeRESTCall(uri, method, requestEntity);
    }

}
