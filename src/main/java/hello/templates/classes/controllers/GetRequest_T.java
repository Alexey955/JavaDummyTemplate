package hello.templates.classes.controllers;

import hello.classes.elements.Request;
import hello.classes.elements.RequestAsync;
import hello.classes.utils.Utils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static hello.classes.utils.Utils.*;

//@RestController
public class GetRequest_T {

    @GetMapping("/http-request/get")
    public void sendAsyncGetRequest(HttpServletRequest request, HttpServletResponse response,
                                    @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body){

//        Debug; наполнение объекта Request для запроса и записываем в файл
//        Request requestLog = new Request();
//        fillRequest(requestLog, request, headers, "false", body);
//        printLogs("./logs/logs.txt", requestLog.toString());

//        Указываем URL для запроса
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet("http://localhost:8080/session/123/123");

//        Debug; указываем URL для запроса
//        HttpGet httpGet = new HttpGet("http://localhost:8080/session/123/123");

//        Добавляем headers для запроса
//        httpGet.setHeader("Content-type", "text/plain");
//        httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
//        httpGet.setHeader("Content-Type", "text/xml;charset=utf-8");

//        Задержка для http://localhost:8080/session/123/123
//        pause(30); //Из логов

//        Debug; наполнение объекта RequestAsync для запроса и записываем в файл
//        RequestAsync requestAsyncLog = new RequestAsync();
//        fillRequestAsync(requestAsyncLog, null, httpGet, requestLog.getId());
//        printLogs("./logs/logs.txt", requestAsyncLog.toString());

//        Отправляем запрос
//        HttpResponse httpResponse = sendGetRequest(httpGet, httpClient);

//        Debug; наполнение объекта RequestAsync для ответа и записываем в файл
//        RequestAsync responseAsyncLog = new RequestAsync();
//        fillResponseAsync(requestAsyncLog, httpGet, httpResponse, requestLog.getId());
//        printLogs("./logs/logs.txt", requestAsyncLog.toString());

//        Debug; наполнение объекта Request для ответа и записываем в файл
//        Request responseLog = new Request();
//        fillResponse(responseLog, requestLog, response, "false", null);
//        printLogs("./logs/logs.txt", responseLog.toString());
    }
}