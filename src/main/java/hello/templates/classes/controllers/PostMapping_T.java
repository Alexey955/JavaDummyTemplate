package hello.templates.classes.controllers;

import static hello.classes.utils.Utils.*;
import hello.classes.elements.StringToInfluxDB;
import hello.classes.elements.Request;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.Map;

//@RestController
public class PostMapping_T {

//    Экземпляр класса с body
//    private Session_data_1408_bodies session_data_1408_bodies = new Session_data_1408_bodies();

//    @PostMapping("/session/{sessionId}/{serviceId}")
    public String getSessionService(HttpServletRequest request, HttpServletResponse response,
                                    @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body,
                                    @PathVariable String serviceId){

//        Debug; наполнение объекта Request для запроса и записываем в файл
//        Request requestLog = new Request();
//        if(body != null){
//            body = body.replaceAll("\n|\r\n","");
//        }
//        fillRequest(requestLog, request, headers, "false", body);
//        printLogs("./logs/logs.txt", requestLog.toString());

//        Добавляем headers для ответа
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.setHeader("Content-Type", "text/xml;charset=utf-8");

//        Debug; Добавляем headers для ответа
//        setHeaderFromFile("./Templates/Headers/Header_getSessionService_debug.txt", response);

//        Добавляем body для ответа
//        String responseBody = session_data_1408_bodies.getBodyGetSession(mdmOsnClient,mdmOsn);
//        try {
//            response.getWriter().write(responseBody);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Debug; Добавляем body для ответа
//        String bodyStr = setBodyFromFile("./Templates/Bodies/Body_getSession_debug.txt", response);

//        Задержка для /session/{sessionId}/{serviceId}
//        pause(30); //Из логов

//        Debug; наполнение объекта Request для ответа и записываем в файл
//        Request responseLog = new Request();
//        fillResponse(responseLog, requestLog, response, "false", responseBody);
//        responseLog.setBody(responseBody);
//        printLogs("./logs/logs.txt", responseLog.toString());

//        Записываем в файл для дальнейшей отправки в InfluxDB
//        StringToInfluxDB stringToInfluxDB = new StringToInfluxDB();
//        stringToInfluxDB.setMethod("POST_/session/{sessionId}/{serviceId}");
//        stringToInfluxDB.setTimestamp(String.valueOf(System.currentTimeMillis()));
//        printLogs("./logs/InfluxDB_logs.txt", stringToInfluxDB.toString());

        return null;
    }
}
