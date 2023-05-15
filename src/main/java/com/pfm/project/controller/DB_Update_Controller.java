package com.pfm.project.controller;

import com.pfm.project.domain.db_update.DB_Update;
import com.pfm.project.service.DB_Update_Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class DB_Update_Controller {

    private final DB_Update_Service dbservice;

    public DB_Update_Controller(DB_Update_Service dbservice) {
        this.dbservice = dbservice;
    }

    @GetMapping("/api")
    public void savedb(){

        String result = "";
        String result2 = "";

        List<DB_Update> req = new ArrayList<>();
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
            URL url = new URL("http://openapi.seoul.go.kr:8088/7a584c4877627261393579564c574a/json/ListPriceModelStoreService/1/10");

            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type","application/json");

            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));

            result = bf.readLine();

            JSONParser parser = new JSONParser();

            JSONObject object = (JSONObject) parser.parse(result);
            JSONObject out1 = (JSONObject) object.get("ListPriceModelStoreService");

            // 공공데이터 api 총 개수
            String total_count = out1.get("list_total_count").toString();


            JSONArray array = (JSONArray) out1.get("row");


            URL url1 = new URL("http://openapi.seoul.go.kr:8088/7a584c4877627261393579564c574a/json/ListPriceModelStoreService/1001/"+total_count);
            HttpURLConnection connection1 = (HttpURLConnection)url1.openConnection();
            connection1.setRequestMethod("GET");
            connection1.setRequestProperty("Content-type","application/json");
            BufferedReader bf2 = new BufferedReader(new InputStreamReader(url1.openStream(),"UTF-8"));
            result2 = bf2.readLine();
            JSONObject object2 = (JSONObject) parser.parse(result2);
            JSONObject out2 = (JSONObject) object2.get("ListPriceModelStoreService");
            JSONArray array2 = (JSONArray) out2.get("row");


            // api 1~1000개 불러오기
            for (int i =0; i<array.size(); i++){
                JSONObject arr = (JSONObject) array.get(i);
                Long id = Long.parseLong(arr.get("SH_ID").toString().trim());
                String store_name = arr.get("SH_NAME").toString().trim();
                int store_code = Integer.parseInt(arr.get("INDUTY_CODE_SE").toString().trim());
                String store_code_name = arr.get("INDUTY_CODE_SE_NAME").toString().trim();
                String address = arr.get("SH_ADDR").toString().trim();
                String number = arr.get("SH_PHONE").toString().trim();
                String come = arr.get("SH_WAY").toString().trim();
                String info = arr.get("SH_INFO").toString().trim();
                String pride = arr.get("SH_PRIDE").toString().trim();
                String photo = arr.get("SH_PHOTO").toString().trim();
                DB_Update api_request = new DB_Update(id,store_name,store_code,store_code_name,address,number,come,pride,photo,info);
                req.add(api_request);

            }


            // api 1001~total_count개 불러오기
        /*    for (int i =0; i<array2.size(); i++){
                JSONObject arr = (JSONObject) array2.get(i);
                Long id = Long.parseLong((String) arr.get("SH_ID"));
                String store_name = (String)arr.get("SH_NAME");
                int store_code = Integer.parseInt((String) arr.get("INDUTY_CODE_SE"));
                String store_code_name = (String)arr.get("INDUTY_CODE_SE_NAME");
                String address = (String)arr.get("SH_ADDR");
                String number = (String)arr.get("SH_PHONE");
                String come = (String)arr.get("SH_WAY");
                String info = (String)arr.get("SH_INFO");
                String pride = (String)arr.get("SH_PRIDE");
                String photo = (String)arr.get("SH_PHOTO");

                Kind_Store api_request = new Kind_Store(id,store_name,store_code,store_code_name,address,number,come,pride,photo,info);
                req.add(api_request);

            }
            */
            dbservice.saveDB(req);



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
