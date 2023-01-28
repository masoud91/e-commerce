package github.devokado.ecommerce.stepDefinitions;


import io.cucumber.datatable.DataTable;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class BaseStepDefinition {

    private final TestRestTemplate restTemplate;

    protected static final String HOST = "localhost";
    protected static final String PORT = "8080";

    protected ResponseEntity<String> response;
    protected List<Map<String, String>> requestBody;

    public BaseStepDefinition() {
        this.restTemplate = new TestRestTemplate();
    }

    protected ResponseEntity<String> invokeRESTCall(String url, HttpMethod method, HttpEntity<?> requestEntity) {
        return restTemplate.exchange(url, method, requestEntity, String.class);
    }

    public HttpHeaders getDefaultHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    protected String buildUrl(String path, Map<String, Object> uriVariables,
                              MultiValueMap<String, String> queryParams) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromPath(path).host(BaseStepDefinition.HOST).port(BaseStepDefinition.PORT).scheme("http");

        if (queryParams != null && !queryParams.isEmpty()) {
            builder.queryParams(queryParams);
        }

        UriComponents uriComponent = uriVariables != null && !uriVariables.isEmpty()
                ? builder.buildAndExpand(uriVariables)
                : builder.build();

        return uriComponent.toString();
    }

    protected void sendRequest(
            HttpMethod method,
            String path,
            Map<String, Object> uriVariables,
            MultiValueMap<String, String> queryParams,
            DataTable body) {

        requestBody = body.asMaps();
        Map<String, Object> requestMap = new HashMap<>();
        requestBody.forEach(x -> requestMap.put(x.get("attribute"), x.get("value")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestMap, getDefaultHttpHeaders());
        String uri = buildUrl(path, uriVariables, queryParams);
        response = invokeRESTCall(uri, method, requestEntity);
    }

}
