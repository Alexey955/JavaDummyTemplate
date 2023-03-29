package hello.templates.classes.controllers;

import hello.classes.dtos.RequestRestController;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static hello.classes.utils.Utils.*;

//@RestController
public class DebugController_T {

//    Перехватывает все запросы, для которых нет контроллеров
    @RequestMapping("/**")
    public String allRequests(HttpServletRequest request, HttpServletResponse response,
                              @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body){

//        Debug; наполнение объекта RequestRestController и запись в файл
        String logsPath = "./logs/logs.txt";
        RequestRestController requestRestController = printLogsRequestRestController(logsPath, request, headers, "true", body);

//        pause(5000); //Пауза

//        Debug; Добавляем headers для ответа
        setHeaderFromFile("./templates/Headers/Header_debug.txt", response);

//        Debug; Добавляем body для ответа
        String bodyStr = setBodyFromFile("./templates/Bodies/Body_debug.txt", response);

//        Debug; наполнение объекта ResponseRestController и запись в файл
        printLogsResponseRestController(logsPath, requestRestController, response, "true", bodyStr);

        return null;
    }
}