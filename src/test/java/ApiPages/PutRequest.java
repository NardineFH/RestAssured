package ApiPages;

import io.restassured.response.Response;

public class PutRequest extends APIRequest{

    public PutRequest(String uri, String endpoint) {
        super(uri, endpoint);
           }
    public void addBody(String body)
    {
        requestSpecification.body(body);
    }


    public Response send()
    {
        return requestSpecification.put(endpoint);
    }
}
