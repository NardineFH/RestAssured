package ApiPages;

import io.restassured.response.Response;

public class DeleteRequest extends APIRequest{
    public DeleteRequest(String uri, String endpoint) {
        super(uri, endpoint);
       }

    public Response send()
    {
        return requestSpecification.delete(endpoint);
    }
}
