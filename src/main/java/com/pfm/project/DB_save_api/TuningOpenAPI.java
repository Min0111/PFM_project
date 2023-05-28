package com.pfm.project.DB_save_api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfm.project.domain.store.Store;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Component
public class TuningOpenAPI {
    public JSONArray getJsonObjectFromOpenAPI(URL url) throws IOException, ParseException {
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type","application/json");

        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));

        String storeResult = bf.readLine();

        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(storeResult);

        JSONObject out1 = (JSONObject) object.get("ListPriceModelStoreService");

        JSONArray array = (JSONArray) out1.get("row");

        return array;
    }
    public StorePlaceMapper tuningOpenAPIStoreData(JSONObject jsonObject) {
        Long id = Long.parseLong((String) jsonObject.get("SH_ID"));
        String store_name = (String)jsonObject.get("SH_NAME");
        int store_code = Integer.parseInt((String) jsonObject.get("INDUTY_CODE_SE"));
        String address = (String)jsonObject.get("SH_ADDR");
        String photo = (String)jsonObject.get("SH_PHOTO");


        // number = "" or number = "-" or number == 없음
        // 아마 완벽?
        String number = (String)jsonObject.get("SH_PHONE");
        if (number == "" || number.length() == 1 || number.contains("없음")) {
            number = null;
        }



        // storewaytocome = "" or storewaytocome = " " storewaytocome == null
        String come = (String)jsonObject.get("SH_WAY");
        come = come.replaceAll("\n", " ");
        if (come == "" || come == " " || come.contains("null")) {
            come = null;
        }

        // store_info = "" info == "null"
        String info = (String)jsonObject.get("SH_INFO");

//        String infoWithNoSpace = info.replaceAll(" ", "");
//
//        if (infoWithNoSpace.length() == 0) {
//            System.out.println("zz");
//        }

        info = info.replaceAll("\n", " ");
        if (info == "" || info.contains("null")) {
            info = null;
        }

        // pride = "" or pride = " " or pride == "null"
        String pride = (String)jsonObject.get("SH_PRIDE");
        if (pride == "" || pride == " " || pride.contains("null")) {
            pride = null;
        }


        NaverPlace naverPlace = naverTuning(address);

        if (naverPlace == null) {
            return null;


        } else {
            Store store =  Store.builder()
                    .storeId(id)
                    .storeName(store_name)
                    .storeType(store_code)
                    .storeAddress(naverPlace.getAddress())
                    .storeNumber(number)
                    .storeWayToCome(come)
                    .storeInfo(info)
                    .storePride(pride)
                    .storeUrl(photo).build();

            PlaceApiDTO place = PlaceApiDTO.builder().id(id).latitude(naverPlace.getLatitude()).longitude(naverPlace.getLongitude()).build();



            return StorePlaceMapper.builder().store(store).place(place).build();
        }

    }
    private NaverPlace naverTuning(String address) {

        try {
//            String newAddress = "서울특별시 서울 중랑구 용마산로129길 61-4";
            String newAddress = address.replace("서울 ", "");

            String enc = URLEncoder.encode(newAddress, "UTF-8");
            String url = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+ enc;



            HttpClient httpclient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(url);
            getRequest.setHeader("X-NCP-APIGW-API-KEY-ID", "y56xusy96s");
            getRequest.setHeader("X-NCP-APIGW-API-KEY", "c4jNxgZSUm4Q2npsEEK4iXMx1NgF7G6qrTKQ82Wo");
            getRequest.setHeader("Accept", "application/json");

            HttpResponse response = httpclient.execute(getRequest);


            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                String body = handler.handleResponse(response);

                ObjectMapper mapper = new ObjectMapper();
                JsonNode bodyJson = mapper.readTree(body);

                if (bodyJson.get("meta").get("totalCount").asInt() != 0) {
                    NaverPlace naverPlace = NaverPlace
                            .builder()
                            .address(bodyJson.get("addresses").get(0).get("jibunAddress").asText())
                            .latitude(bodyJson.get("addresses").get(0).get("x").asDouble())
                            .longitude(bodyJson.get("addresses").get(0).get("y").asDouble())
                            .build();

                    return naverPlace;
                }

                return null;

            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
