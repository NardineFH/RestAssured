package ApiPages;

import io.restassured.response.Response;

public class GetRequest extends  APIRequest{
    public GetRequest(String uri, String endpoint ) {
        super( uri,  endpoint);
    }

    @Override
 public Response send()
 {
     return requestSpecification.get(endpoint);
 }

}
