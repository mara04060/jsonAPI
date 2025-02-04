package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.Config;
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

    static {
        RestAssured.baseURI = Config.BASE_URL;
    }

    @DataProvider(name = "clientData")
    public Object[][] loadTestData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Client> clients = objectMapper.readValue(
                new File("src/test/resources/testData/testCases.json"),
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
        assertEquals(response.jsonPath().getString("name"), client.getName(), "Ім\'я не співпадаз з очікуваним "+client.getName());
        assertEquals(response.jsonPath().getString("email"), client.getEmail(), "Email не співпадаз з очікуваним "+client.getEmail());
        assertEquals(response.jsonPath().getInt("balance"), client.getBalance(), "Баланс не співпадаз з очікуваним "+client.getBalance());
    }
}