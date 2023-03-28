package hello.classes.controllers;

import hello.classes.elements.Request;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static hello.classes.utils.Utils.*;

@RestController
public class DebugController {

//    Перехватывает все запросы, для которых нет контроллеров
    @RequestMapping("/**")
    public String allRequests(HttpServletRequest request, HttpServletResponse response,
                              @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body) {

//        Debug; наполнение объекта Request для запроса и записываем в файл
        Request requestLog = new Request();
        fillRequest(requestLog, request, headers, "true", body);
        printLogs("./logs/logs.txt", requestLog.toString());

//        Пауза
//        pause(5000);

//        Debug; Добавляем заголовки для ответа
        setHeaderFromFile("./Templates/Headers/Header_debug.txt", response);

//        Debug; Добавляем тело для ответа
        String bodyStr = setBodyFromFile("./Templates/Bodies/Body_debug.txt", response);

//        Debug; наполнение объекта Request для ответа и записываем в файл
        Request responseLog = new Request();
        fillResponse(responseLog, requestLog, response, "true", bodyStr);
        printLogs("./logs/logs.txt", responseLog.toString());

        return null;
    }
}