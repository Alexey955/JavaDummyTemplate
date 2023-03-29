package hello.templates.classes.controllers;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static hello.classes.utils.Utils.*;

//@RestController
public class PostMapping_T {

//    Экземпляр класса с body
//    private System_num_bodies_T_Json bodies = new System_num_bodies_T_Json();

    @PostMapping("/session/{sessionId}/{serviceId}")
    public String getSessionService(HttpServletRequest request, HttpServletResponse response,
                                    @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body,
                                    @PathVariable String serviceId) {

//        Debug; наполнение объекта RequestRestController и запись в файл
//        String logsPath = "./logs/logs.txt";
//        RequestRestController requestRestController = printLogsRequestRestController(logsPath, request, headers, "false", body);

//        Добавляем headers для ответа
//        response.setHeader("Content-Type", "application/json;charset=utf-8");
//        response.setHeader("Content-Type", "text/xml;charset=utf-8");

//        Debug; Добавляем headers для ответа
//        setHeaderFromFile("./templates/Headers/Header_getSessionService_debug.txt", response);

//        Добавляем body для ответа
//        String responseBody = bodies.getBodyMethod();
//        setBodyFromString(response, responseBody);

//        Debug; Добавляем body для ответа
//        String responseBody = setBodyFromFile("./templates/Bodies/Body_getSession_debug.txt", response);

//        Задержка для /session/{sessionId}/{serviceId}
//        pause(30); //Из логов

//        Debug; наполнение объекта ResponseRestController и запись в файл
//        printLogsResponseRestController(logsPath, requestRestController, response, "false", responseBody);

//        Записываем в файл для дальнейшей отправки в InfluxDB
//        StringToInfluxDB stringToInfluxDB = new StringToInfluxDB();
//        stringToInfluxDB.setMethod("POST_/session/{sessionId}/{serviceId}");
//        stringToInfluxDB.setTimestamp(String.valueOf(System.currentTimeMillis()));
//        printLogs("./logs/InfluxDB_logs.txt", stringToInfluxDB.toString());

        return null;
    }
}