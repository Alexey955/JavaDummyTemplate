package hello.templates.classes.controllers;

import hello.classes.bodies.Session_data_1408_bodies;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.Map;

import static hello.classes.utils.Utils.pause;

//@RestController
public class GetMapping_T {

//    Экземпляр класса с body
//    private Session_data_1408_bodies session_data_1408_bodies = new Session_data_1408_bodies();

    @GetMapping("/session/{sessionId}/SMBIB/default")
    public String getSession(HttpServletRequest request, HttpServletResponse response,
                             @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body,
                             @PathVariable String sessionId){

//        Debug логирование; наполнение объекта Request для запроса и записываем в файл
//        Request requestLog = new Request();
//        fillRequest(requestLog, request, headers, "false", body);
//        printLogs("./logs/logs.txt", requestLog.toString());

//        Добавляем headers для ответа
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.setHeader("Content-Type", "text/xml;charset=utf-8");

//        Debug; Добавляем headers для ответа
//        setHeaderFromFile("./Templates/Headers/Header_getSession_debug.txt", response);

//        Добавляем body для ответа
//        String responseBody = session_data_1408_bodies.getBodyGetSession();
//        try {
//            response.getWriter().write(responseBody);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Debug; Добавляем body для ответа
//        String bodyStr = setBodyFromFile("./Templates/Bodies/Body_getSession_debug.txt", response);

//        Задержка для /session/{sessionId}/SMBIB/default
//        pause(30); //Из логов

//        Debug логирование; наполнение объекта Request для ответа и записываем в файл
//        Request responseLog = new Request();
//        fillResponse(responseLog, requestLog, response, "false", responseBody);
//        responseLog.setBody(responseBody);
//        printLogs("./logs/logs.txt", responseLog.toString());

//        Debug логирование; записываем в файл для дальнейшей отправки в InfluxDB
//        StringToInfluxDB stringToInfluxDB = new StringToInfluxDB();
//        stringToInfluxDB.setMethod("GET_/session/{sessionId}/SMBIB/default");
//        stringToInfluxDB.setTimestamp(String.valueOf(System.currentTimeMillis()));
//        printLogs("./logs/InfluxDB_logs.txt", stringToInfluxDB.toString());

        return null;
    }
}
