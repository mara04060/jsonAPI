package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.Config;
import enums.Descriptions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Client;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ClientApiTest {
    private final String JSON_PATCH ="src/test/resources/testData/testCases.json";
    static {
        RestAssured.baseURI = Config.BASE_URL;
    }

    @DataProvider(name = "clientData")
    public Object[][] loadTestData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Client> clients = objectMapper.readValue(
                new File(JSON_PATCH),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Client.class)
        );

        Object[][] data = new Object[clients.size()][1];
        for (int i = 0; i < clients.size(); i++) {
            data[i][0] = clients.get(i);
        }
        return data;
    }

    @Test(dataProvider = "clientData")
    public void testCreateClient(Client client) {

        Response response = given()
                .contentType(Config.MIME_CODE)
                .body(client)
                .when()
                .post(Config.CLIENT_ENDPOINT);

        // Assert status code
        assertEquals(response.getStatusCode(), 200);

        // Assert response body
        assertEquals(response.jsonPath().getString("name"), client.getName(), Descriptions.ERROR_NAME.getTestDescription() +client.getName());
        assertEquals(response.jsonPath().getString("email"), client.getEmail(), Descriptions.ERROR_EMAIL.getTestDescription()+client.getEmail());
        assertEquals(response.jsonPath().getInt("balance"), client.getBalance(), Descriptions.ERROR_BALANCE.getTestDescription() +client.getBalance());
    }
}