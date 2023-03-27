package hello.templates.classes.controllers;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

//@RestController
public class AsyncPostRequest_T {

//    Экземпляр класса с body
//    private Session_data_1408_bodies session_data_1408_bodies = new Session_data_1408_bodies();

    @GetMapping("/http-request/post")
    public void sendAsyncPostRequest(HttpServletRequest request, HttpServletResponse response,
                                @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body){

//        Debug; наполнение объекта Request для запроса и записываем в файл
//        Request requestLog = new Request();
//        fillRequest(requestLog, request, headers, "false", body);
//        printLogs("./logs/logs.txt", requestLog.toString());

//        Задержка для /http-request/post
//        pause(30); //Из логов

        //Отправляем асинхронный ответ
//        new Thread() {
//            @Override
//            public void run() {

//                Получаем body для запроса
//                String bodyStr = session_data_1408_bodies.getBodyGetSession();

//                Debug; Добавляем body для ответа
//                String bodyStr = getBodyFromFile("./Templates/Bodies/Body_sendAsyncPostRequest_debug.txt");

//                Указываем URL для запроса
//                HttpClient httpClient = new DefaultHttpClient();
//                HttpPost httpPost = new HttpPost("http://localhost:8080/session/123/123");

//                Debug; указываем URL для запроса
//                HttpPost httpPost = new HttpPost("http://localhost:8080/session/123/123");

//                Добавляем headers для запроса
//                httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
//                httpPost.setHeader("Content-Type", "text/xml;charset=utf-8");

//                Задержка для http://localhost:8080/session/123/123
//                pause(30); //Из логов

//                Отправляем запрос
//                Utils.sendPostRequest(httpPost, httpClient, bodyStr);

//                Debug; наполнение объекта RequestAsync для ответа и записываем в файл
//                RequestAsync requestAsyncLog = new RequestAsync();
//                fillRequestAsync(requestAsyncLog, bodyStr, httpPost, requestLog.getId());
//                printLogs("./logs/logs.txt", requestAsyncLog.toString());

//                stop();
//            }
//        }.start();

//        Debug; наполнение объекта Request для ответа и записываем в файл
//        Request responseLog = new Request();
//        fillResponse(responseLog, requestLog, response, "false", null);
//        printLogs("./logs/logs.txt", responseLog.toString());
    }
}