package ApiPages;

import io.restassured.response.Response;

public class PostRequest extends APIRequest {
    public PostRequest(String uri, String endpoint) {
        super(uri,endpoint);
           }
    public void addBody(String body)
    {
        requestSpecification.body(body);
    }
    public Response send()
    {
        return requestSpecification.post(endpoint);
    }
}
