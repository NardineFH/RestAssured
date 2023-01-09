package ApiPages;

import io.restassured.response.Response;

public class PatchRequest extends APIRequest{
    public PatchRequest(String uri, String endpoint) {
        super(uri, endpoint);
    }

    @Override
    public Response send() {
        return requestSpecification.patch(endpoint);
    }


}
