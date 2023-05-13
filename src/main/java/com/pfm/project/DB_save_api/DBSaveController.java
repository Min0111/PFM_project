package com.pfm.project.DB_save_api;

import com.pfm.project.domain.product.Product;
import com.pfm.project.domain.store.Store;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DBSaveController {

    private final DBSaveService dbSaveService;

    @Autowired
    public DBSaveController(DBSaveService dbSaveService) {
        this.dbSaveService = dbSaveService;
    }


    @GetMapping("/api")
    public String index(){
        return "../resources/templates/index";
    }

    @PostMapping("/api/store")
    public void saveStoreDb(){

        String result = "";
        String result2 = "";

        List<Store> req = new ArrayList<>();
        Long SH_ID;	 //업소아이디
        String SH_NAME;	 //업소명
        int INDUTY_CODE_SE;	 //분류코드
        String INDUTY_CODE_SE_NAME;	 //분류코드명
        String SH_ADDR;	 //업소 주소
        String SH_PHONE;	 //업소 전화번호
        String SH_WAY;	 //찾아오시는 길
        String SH_INFO;	 //업소정보
        String SH_PRIDE;	 //자랑거리
        String SH_PHOTO; 	//업소 사진

        try {
            URL url = new URL("http://openapi.seoul.go.kr:8088/55574947656272613834534d504674/json/ListPriceModelStoreService/1/1000");
            URL url1 = new URL("http://openapi.seoul.go.kr:8088/55574947656272613834534d504674/json/ListPriceModelStoreService/1001/1210");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type","application/json");

            HttpURLConnection connection1 = (HttpURLConnection)url1.openConnection();
            connection1.setRequestMethod("GET");
            connection1.setRequestProperty("Content-type","application/json");

            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(url1.openStream(),"UTF-8"));

            result = bf.readLine();
            result2 = bf2.readLine();

            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(result);
            JSONObject object2 = (JSONObject) parser.parse(result2);

            JSONObject out1 = (JSONObject) object.get("ListPriceModelStoreService");

            JSONObject out2 = (JSONObject) object2.get("ListPriceModelStoreService");

            JSONArray array = (JSONArray) out1.get("row");
            JSONArray array2 = (JSONArray) out2.get("row");




            for (int i =0; i<array.size(); i++){
                JSONObject arr = (JSONObject) array.get(i);
                Long id = Long.parseLong((String) arr.get("SH_ID"));
                String store_name = (String)arr.get("SH_NAME");
                int store_code = Integer.parseInt((String) arr.get("INDUTY_CODE_SE"));
                String store_code_name = (String)arr.get("INDUTY_CODE_SE_NAME");
                String address = (String)arr.get("SH_ADDR");
                String number = (String)arr.get("SH_PHONE");
                String come = (String)arr.get("SH_WAY");
                come = come.replaceAll("\n", " ");
                String info = (String)arr.get("SH_INFO");
                info = info.replaceAll("\n", " ");

                String pride = (String)arr.get("SH_PRIDE");
                String photo = (String)arr.get("SH_PHOTO");


                Store api_request = Store.builder()
                        .storeId(id)
                        .storeName(store_name)
                        .storeType(store_code)
                        .storeAddress(address)
                        .storeNumber(number)
                        .storeWayToCome(come)
                        .storeInfo(info)
                        .storePride(pride)
                        .storeUrl(photo).build();

                System.out.println("hizz");
                System.out.println(api_request);

                req.add(api_request);

            }

            for (int i =0; i<array2.size(); i++){
                JSONObject arr = (JSONObject) array2.get(i);
                Long id = Long.parseLong((String) arr.get("SH_ID"));
                String store_name = (String)arr.get("SH_NAME");
                int store_code = Integer.parseInt((String) arr.get("INDUTY_CODE_SE"));
                String address = (String)arr.get("SH_ADDR");
                String number = (String)arr.get("SH_PHONE");
                String come = (String)arr.get("SH_WAY");
                String info = (String)arr.get("SH_INFO");
                String pride = (String)arr.get("SH_PRIDE");
                String photo = (String)arr.get("SH_PHOTO");

                Store api_request = Store.builder()
                        .storeId(id)
                        .storeName(store_name)
                        .storeType(store_code)
                        .storeAddress(address)
                        .storeNumber(number)
                        .storeWayToCome(come)
                        .storeInfo(info)
                        .storePride(pride)
                        .storeUrl(photo).build();
                req.add(api_request);

            }

//            dbSaveService.saveStoreDB(req);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @PostMapping("/api/product")
    public void saveProductDb(){

        String result = "";
        String result2 = "";

        List<ProductApiDTO> req = new ArrayList<>();

        try {
            URL url = new URL("http://openAPI.seoul.go.kr:8088/7a584c4877627261393579564c574a/json/ListPriceModelStoreProductService/1/1000");
            URL url1 = new URL("http://openAPI.seoul.go.kr:8088/7a584c4877627261393579564c574a/json/ListPriceModelStoreProductService/1001/1210");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type","application/json");

            HttpURLConnection connection1 = (HttpURLConnection)url1.openConnection();
            connection1.setRequestMethod("GET");
            connection1.setRequestProperty("Content-type","application/json");

            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(url1.openStream(),"UTF-8"));

            result = bf.readLine();
            result2 = bf2.readLine();

            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(result);
            JSONObject object2 = (JSONObject) parser.parse(result2);

            JSONObject out1 = (JSONObject) object.get("ListPriceModelStoreProductService");

            JSONObject out2 = (JSONObject) object2.get("ListPriceModelStoreProductService");

            JSONArray array = (JSONArray) out1.get("row");
            JSONArray array2 = (JSONArray) out2.get("row");




            for (int i =0; i<array.size(); i++){
                JSONObject arr = (JSONObject) array.get(i);
                Long id = Long.parseLong((String) arr.get("SH_ID"));
                double price = (double)arr.get("IM_PRICE");
                int resultPrice = Integer.parseInt(String.valueOf(Math.round(price)));
                String productName = (String)arr.get("IM_NAME");


                ProductApiDTO api_request = ProductApiDTO.builder().productPrice(resultPrice).productName(productName).id(id).build();

                req.add(api_request);

            }

            for (int i =0; i<array2.size(); i++){
                JSONObject arr = (JSONObject) array.get(i);
                Long id = Long.parseLong((String) arr.get("SH_ID"));
                double price = (double)arr.get("IM_PRICE");
                int resultPrice = Integer.parseInt(String.valueOf(Math.round(price)));
                String productName = (String)arr.get("IM_NAME");


                ProductApiDTO api_request = ProductApiDTO.builder().productPrice(resultPrice).productName(productName).id(id).build();

                req.add(api_request);

            }

            dbSaveService.saveProductDB(req);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}