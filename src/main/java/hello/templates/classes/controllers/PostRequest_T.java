package hello.templates.classes.controllers;

import hello.classes.elements.Request;
import hello.classes.elements.RequestAsync;
import hello.classes.utils.Utils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static hello.classes.utils.Utils.*;

//@RestController
public class PostRequest_T {
    //    Экземпляр класса с body
//    private Session_data_1408_bodies session_data_1408_bodies = new Session_data_1408_bodies();

    @GetMapping("/http-request/post")
    public void sendPostRequest(HttpServletRequest request, HttpServletResponse response,
                                @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body){

//        Debug; наполнение объекта Request для запроса и записываем в файл
//        Request requestLog = new Request();
//        fillRequest(requestLog, request, headers, "false", body);
//        printLogs("./logs/logs.txt", requestLog.toString());

//        Получаем body для запроса
//        String bodyStr = session_data_1408_bodies.getBodyGetSession();

//        Debug; Добавляем body для ответа
//        String bodyStr = getBodyFromFile("./Templates/Bodies/Body_sendPostRequest_debug.txt");

//        Указываем URL для запроса
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost("http://localhost:8080/session/123/123");

//        Debug; указываем URL для запроса
//        HttpPost httpPost = new HttpPost("http://localhost:8080/session/123/123");

//        Добавляем headers для запроса
//        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");

//        Задержка для http://localhost:8080/session/123/123
//        pause(30); //Из логов

//        Отправляем запрос
//        Utils.sendPostRequest(httpPost, httpClient, bodyStr);

//        Debug; наполнение объекта RequestAsync для ответа и записываем в файл
//        RequestAsync requestAsyncLog = new RequestAsync();
//        fillRequestAsync(requestAsyncLog, bodyStr, httpPost, requestLog.getId());
//        printLogs("./logs/logs.txt", requestAsyncLog.toString());

//        Debug; наполнение объекта Request для ответа и записываем в файл
//        Request responseLog = new Request();
//        fillResponse(responseLog, requestLog, response, "false", null);
//        printLogs("./logs/logs.txt", responseLog.toString());
    }
}