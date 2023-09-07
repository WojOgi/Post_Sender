package org.example;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] housesData = {
                "{\n" +
                        "  \"houseNumber\": \"G-1009\",\n" +
                        "  \"maxCapacity\": \"2\"\n" +
                        "}",

                "{\n" +
                        "  \"houseNumber\": \"G-1229\",\n" +
                        "  \"maxCapacity\": \"3\"\n" +
                        "}",

                "{\n" +
                        "  \"houseNumber\": \"G-1779\",\n" +
                        "  \"maxCapacity\": \"1\"\n" +
                        "}",

                "{\n" +
                        "  \"houseNumber\": \"G-1119\",\n" +
                        "  \"maxCapacity\": \"4\"\n" +
                        "}",
                "{\n" +
                        "  \"houseNumber\": \"G-1239\",\n" +
                        "  \"maxCapacity\": \"3\"\n" +
                        "}"
        };
        String[] occupantsData = {
                "{\n" +
                        "  \"firstName\": \"Jan\",\n" +
                        "  \"lastName\": \"Kowalski\",\n" +
                        "  \"gender\": \"M\"\n" +
                        "}",
                "{\n" +
                        "  \"firstName\": \"Joanna\",\n" +
                        "  \"lastName\": \"Kowalski\",\n" +
                        "  \"gender\": \"F\"\n" +
                        "}",
                "{\n" +
                        "  \"firstName\": \"Joanna\",\n" +
                        "  \"lastName\": \"Ogieglo\",\n" +
                        "  \"gender\": \"F\"\n" +
                        "}",
                "{\n" +
                        "  \"firstName\": \"Wojciech\",\n" +
                        "  \"lastName\": \"Ogieglo\",\n" +
                        "  \"gender\": \"M\"\n" +
                        "}",
                "{\n" +
                        "  \"firstName\": \"Weronika\",\n" +
                        "  \"lastName\": \"Ogieglo\",\n" +
                        "  \"gender\": \"F\"\n" +
                        "}",
                "{\n" +
                        "  \"firstName\": \"Oliwia\",\n" +
                        "  \"lastName\": \"Ogieglo\",\n" +
                        "  \"gender\": \"F\"\n" +
                        "}",
                "{\n" +
                        "  \"firstName\": \"Mike\",\n" +
                        "  \"lastName\": \"Saylor\",\n" +
                        "  \"gender\": \"M\"\n" +
                        "}"

        };
        for (String data : housesData) {
            sendHousesPostRequest(data);
        }
        for (String data1 : occupantsData) {
            sendOccupantsPostRequest(data1);
        }
    }


    private static void sendHousesPostRequest(String data) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://localhost:8080/housing";

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpPost.setEntity(new StringEntity(data));
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String responseContent = EntityUtils.toString(entity);
            System.out.println("Response: " + responseContent);
        }
        httpClient.close();
    }

    private static void sendOccupantsPostRequest(String data1) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://localhost:8080/occupants/add_occupant_without_house";

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpPost.setEntity(new StringEntity(data1));
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String responseContent = EntityUtils.toString(entity);
            System.out.println("Response: " + responseContent);
        }
        httpClient.close();
    }
}
