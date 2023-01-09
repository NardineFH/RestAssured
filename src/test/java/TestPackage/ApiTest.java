package TestPackage;

import ApiPages.DeleteRequest;
import ApiPages.GetRequest;
import ApiPages.PostRequest;
import ApiPages.PutRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {


    String baseURL = "https://reqres.in/";
    @Test
    public void getTest (){

        GetRequest getRequest = new GetRequest(baseURL , "api/users/2");
        Response response = getRequest.send();
        Assert.assertEquals(200 , response.getStatusCode());
        Assert.assertEquals("2",response.jsonPath().getString("data.id"));
        Assert.assertEquals("janet.weaver@reqres.in",response.jsonPath().getString("data.email"));
        Assert.assertEquals("Janet",response.jsonPath().getString("data.first_name"));
        Assert.assertEquals("Weaver",response.jsonPath().getString("data.last_name"));
        Assert.assertEquals("https://reqres.in/img/faces/2-image.jpg",response.jsonPath().getString("data.avatar"));
        Assert.assertEquals("https://reqres.in/#support-heading",response.jsonPath().getString("support.url"));
        Assert.assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",response.jsonPath().getString("support.text"));


    }

    @Test
    public void postTest(){
        String body = """
                {
                  "name": "nardine",
                    "job": "leader" }""" ;

        PostRequest postRequest = new PostRequest(baseURL, "api/users");
        postRequest.addBody(body);
        Response response = postRequest.send();
        Assert.assertEquals(201 , response.getStatusCode());
        Assert.assertEquals("nardine" , response.jsonPath().getString("name"));
        Assert.assertEquals("leader" , response.jsonPath().getString("job"));


    }

    @Test
    public void putTest(){
        String body = """
                {
                    "name": "nardine",
                    "job": "tester"
                }""";
        PutRequest putRequest = new PutRequest(baseURL, "api/users/2");
        putRequest.addBody(body);
        Response response = putRequest.send();
        Assert.assertEquals(200 , response.getStatusCode());
        Assert.assertEquals("nardine",response.jsonPath().getString("name"));
        Assert.assertEquals("tester",response.jsonPath().getString("job"));
    }
    @Test
    public void deleteTest(){
        DeleteRequest deleteRequest = new DeleteRequest(baseURL, "api/users/2");
        Response response = deleteRequest.send();
        Assert.assertEquals(204 , response.getStatusCode());

    }
    @Test
    public void getuserlistTest(){

        GetRequest getRequest = new GetRequest(baseURL , "api/users?page=2");
        Response response = getRequest.send();
        Assert.assertEquals(200 , response.getStatusCode());
        Assert.assertEquals("2",response.jsonPath().getString("page"));
        Assert.assertEquals("7",response.jsonPath().getString("data[0].id"));
        Assert.assertEquals("8",response.jsonPath().getString("data[1].id"));
        Assert.assertEquals("9",response.jsonPath().getString("data[2].id"));
        Assert.assertEquals("10",response.jsonPath().getString("data[3].id"));
        Assert.assertEquals("11",response.jsonPath().getString("data[4].id"));
        Assert.assertEquals("12",response.jsonPath().getString("data[5].id"));


    }
}
