package hello.classes.utils;

import hello.classes.elements.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.*;

import hello.classes.elements.RequestAsync;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class Utils {

    //генерация случайного числа в диапазоне
    public static int genIntInRange(int min, int max){
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    //генерация uuid
    public static String genUUID(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

    //получаем строку с заголовками из HttpServletResponse response
    public static String getHeaders(HttpServletResponse response){
        StringBuilder headersStr;
        Collection<String> headersCollection = response.getHeaderNames();
        ArrayList<String> headersArray = new ArrayList<>(headersCollection);

        if(headersArray.size() != 0){
            headersStr = new StringBuilder();

            for (int i = 0; i < headersArray.size(); i++){
                headersStr.append("{");
                headersStr.append(headersArray.get(i));
                headersStr.append(" = ");
                headersStr.append(response.getHeader(headersArray.get(i)));
                headersStr.append("}");
            }
        }else {
            return null;
        }
        return headersStr.toString();
    }

    //Добавляем параметры в url, если они есть
    private static String addParams(String url, HttpServletRequest request){
        StringBuilder stringResult = new StringBuilder();
        stringResult.append(url);
        if(request.getParameterMap().keySet().size() != 0){
            Object[] keys = request.getParameterMap().keySet().toArray();
            stringResult.append("?");
            for (int i=0; i<request.getParameterMap().keySet().size(); i++){
                stringResult.append(keys[i]);
                stringResult.append("=");
                stringResult.append(request.getParameter(keys[i].toString()));
                stringResult.append("&");
            }
        }
        return stringResult.toString();
    }

    //наполнение объекта Request для запроса
    public static void fillRequest(Request requestLog, HttpServletRequest request, Map<String, String> headers, String debug_flag, String body){
        requestLog.setId(genUUID());
        requestLog.setDateTime(Instant.now());
        requestLog.setDirection("Request");
        requestLog.setMethod(request.getMethod());
        requestLog.setUrl(addParams(request.getRequestURI(), request));
        requestLog.setHeaders(String.valueOf(headers));
        requestLog.setBody(body);
        requestLog.setDebug_flag(debug_flag);
    }

    //наполнение объекта RequestAsync для запроса
    public static void fillRequestAsync(RequestAsync requestAsyncLog, String body, HttpPost httpPost, String uuid){
        requestAsyncLog.setId(uuid);
        requestAsyncLog.setDateTime(Instant.now());
        requestAsyncLog.setDirection("Request");
        requestAsyncLog.setMethod(httpPost.getMethod());
        requestAsyncLog.setUrl(String.valueOf(httpPost.getURI()).replace("http:/", "").replace("https:/", ""));

        //Добавление списка заголовков
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < httpPost.getAllHeaders().length; i++){
            stringBuilder.append(httpPost.getAllHeaders()[i] + "; ");
        }
        requestAsyncLog.setHeaders(stringBuilder.toString());
        requestAsyncLog.setBody(body);
    }

    //запись в файл
    public static void printLogs(String file, String text){
        //Форматирование
        if(text != null){
            text = text.replaceAll("\n|\r\n","");
        }

        try {
            Files.write(Paths.get(file), (text+"\r\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //задержка
    public static void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //наполнение объекта Request для ответа
    public static void fillResponse(Request responseLog, Request requestLog, HttpServletResponse response, String debug_flag, String bodyStr){
        responseLog.setDebug_flag(debug_flag);
        responseLog.setId(requestLog.getId());
        responseLog.setDateTime(Instant.now());
        responseLog.setDirection("Response");
//        responseLog.setMethod(requestLog.getMethod());
        responseLog.setMethod("---");
        responseLog.setUrl(requestLog.getUrl());
        responseLog.setStatus(String.valueOf(response.getStatus()));
        responseLog.setHeaders(getHeaders(response));

        if(bodyStr != null){
            responseLog.setBody(bodyStr);
        }else {
            responseLog.setBody(null);
        }
    }

    //Отправка POST запроса
    public static void sendPostRequest(HttpPost httpPost, HttpClient httpClient, String body) {
        httpPost.setHeader("Content-type", "text/plain");
        try {
            StringEntity stringEntity = new StringEntity(body);
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);

            httpClient.execute(httpPost);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setHeaderFromFile(String fileName, HttpServletResponse response){
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(fileName));

            String str = buffReader.readLine();
            String[] strSplit;
            if(str != null){
                while(str != null){
                    strSplit = str.split("'|'");
                    response.setHeader(strSplit[0], strSplit[2]);
                    str = buffReader.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String setBodyFromFile(String fileName, HttpServletResponse response){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(fileName));

            String str = buffReader.readLine();
            if(str != null){
                while(str != null){
                    stringBuilder.append(str);
                    str = buffReader.readLine();
                }
                response.getWriter().write(stringBuilder.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public static String getBodyFromFile(String fileName){
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(fileName));

            String str = buffReader.readLine();
            if(str != null){
                while(str != null){
                    stringBuilder.append(str);
                    str = buffReader.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
