package com.pfm.project.server_db;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component // 추가
@EnableAsync
public class Server_BackUP {


    @Scheduled(cron = "0 15 10 15 * ?") // 초,분,시,일,월
    public void DB_BakUP(){

    }



}
