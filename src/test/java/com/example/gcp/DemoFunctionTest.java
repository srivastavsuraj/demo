package com.example.gcp;
import io.micronaut.http.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import io.micronaut.gcp.function.http.*;

public class DemoFunctionTest {

    @Test
    public void testGet() throws Exception {
        try (HttpFunction function = new HttpFunction()) {
            GoogleHttpResponse response = function.invoke(HttpMethod.GET, "/demo");
            assertEquals(HttpStatus.OK, response.getStatus());
        }
    }

    @Test
    public void testPost()throws  Exception{
        try (HttpFunction function = new HttpFunction()) {
            SampleInputMessage sampleInputMessage = new SampleInputMessage();
            sampleInputMessage.setName("Test Name");
            HttpRequest request = HttpRequest.POST("/demo", sampleInputMessage).contentType(MediaType.APPLICATION_JSON_TYPE);
            GoogleHttpResponse response = function.invoke(request);
            assertEquals(HttpStatus.OK, response.getStatus());
        }
    }
}
