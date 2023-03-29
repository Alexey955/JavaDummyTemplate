package hello.templates.classes.controllers;

import hello.classes.dtos.RequestRestController;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;

import static hello.classes.utils.Utils.*;

//@RestController
public class AsyncPostRequest_T {

//    Экземпляр класса с body
//    private System_num_bodies_T_Json bodies = new System_num_bodies_T_Json();

    @GetMapping("/http-request/post")
    public void sendAsyncPostRequest(HttpServletRequest request, HttpServletResponse response,
                                     @RequestHeader Map<String, String> headers, @RequestBody(required = false) String body){

//        Debug; наполнение объекта RequestRestController и запись в файл
        String logsPath = "./logs/logs.txt";
        RequestRestController requestRestController = printLogsRequestRestController(logsPath, request, headers, "false", body);

//        Задержка для /http-request/post
//        pause(30); //Из логов

        //Отправляем асинхронный запрос
        new Thread() {
            @Override
            public void run() {

//                Получаем body для запроса
//                String requestBody = bodies.getBodyMethod();

//                Debug; Добавляем body для ответа
                String requestBody = getBodyFromFile("./templates/Bodies/Body_sendAsyncPostRequest_debug.txt");

//                Указываем URL для запроса
                HttpClient httpClient = new DefaultHttpClient();
//                HttpPost httpPost = new HttpPost("http://localhost:8080/session/123/123");

//                Debug; указываем URL для запроса
                HttpPost httpPost = new HttpPost("http://localhost:8080/session/123/123");

//                Добавляем headers для запроса
                httpPost.setHeader("Content-type", "text/plain");
//                httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
//                httpPost.setHeader("Content-Type", "text/xml;charset=utf-8");

//                Задержка для http://localhost:8080/session/123/123
//                pause(30); //Из логов

//                Debug; наполнение объекта RequestAsync и запись в файл
                printLogsRequestHttp(logsPath, requestBody, httpPost, requestRestController.getId());

//                Отправляем запрос
                HttpResponse httpResponse = sendPostRequest(httpPost, httpClient, requestBody);

//                Debug; наполнение объекта ResponseHttp и запись в файл
                printLogsResponseHttp(logsPath, httpPost, httpResponse, requestRestController.getId());

                stop();
            }
        }.start();

//        Debug; наполнение объекта ResponseRestController и запись в файл
        printLogsResponseRestController(logsPath, requestRestController, response, "false", null);
    }
}