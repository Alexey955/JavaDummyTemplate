package hello.classes.utils;

import hello.classes.dtos.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class Utils {

    //Генерация случайного числа в диапазоне
    public static int genIntInRange(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    //    Генерация uuid
    public static String genUUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }

    //Получаем строку с заголовками из HttpServletResponse response
    public static String getHeaders(HttpServletResponse response) {
        StringBuilder headersStr;
        Collection<String> headersCollection = response.getHeaderNames();
        ArrayList<String> headersArray = new ArrayList<>(headersCollection);

        if (headersArray.size() != 0) {
            headersStr = new StringBuilder();

            for (int i = 0; i < headersArray.size(); i++) {
                headersStr.append("{");
                headersStr.append(headersArray.get(i));
                headersStr.append(" = ");
                headersStr.append(response.getHeader(headersArray.get(i)));
                headersStr.append("}");
            }
        } else {
            return null;
        }
        return headersStr.toString();
    }

    //Добавляем параметры в url, если они есть
    private static String addParams(String url, HttpServletRequest request) {
        StringBuilder stringResult = new StringBuilder();
        stringResult.append(url);
        if (request.getParameterMap().keySet().size() != 0) {
            Object[] keys = request.getParameterMap().keySet().toArray();
            stringResult.append("?");
            for (int i = 0; i < request.getParameterMap().keySet().size(); i++) {
                stringResult.append(keys[i]);
                stringResult.append("=");
                stringResult.append(request.getParameter(keys[i].toString()));
                stringResult.append("&");
            }
        }
        return stringResult.toString();
    }

    //Наполнение объекта RequestRestController для запроса
    public static void fillRequestRestController(RequestRestController requestLog, HttpServletRequest request, Map<String, String> headers, String debug_flag, String body) {
        if (body != null) {
            body = body.replaceAll("\n|\r\n", "");
        }

        requestLog.setId(genUUID());
        requestLog.setDateTime(Instant.now());
        requestLog.setMethod(request.getMethod());
        requestLog.setUrl(addParams(request.getRequestURI(), request));
        requestLog.setHeaders(String.valueOf(headers));
        requestLog.setBody(body);
        requestLog.setDebug_flag(debug_flag);
    }

    //Наполнение объекта ResponseRestController для ответа
    public static void fillResponseRestController(ResponseRestController responseLog, RequestRestController requestLog, HttpServletResponse response, String debug_flag, String bodyStr) {
        responseLog.setDebug_flag(debug_flag);
        responseLog.setId(requestLog.getId());
        responseLog.setDateTime(Instant.now());
        responseLog.setUrl(requestLog.getUrl());
        responseLog.setStatus(String.valueOf(response.getStatus()));
        responseLog.setHeaders(getHeaders(response));

        if (bodyStr != null) {
            responseLog.setBody(bodyStr);
        } else {
            responseLog.setBody(null);
        }
    }

    //Запись в файл объекта RequestRestController
    public static RequestRestController printLogsRequestRestController(String file, HttpServletRequest request, Map<String, String> headers, String debug_flag, String body) {
        RequestRestController requestLog = new RequestRestController();

        //наполнение объекта RequestRestController для запроса
        fillRequestRestController(requestLog, request, headers, debug_flag, body);

        String text = requestLog.toString();
        //Форматирование
        if (text != null) {
            text = text.replaceAll("\n|\r\n", "");
        }

        try {
            Files.write(Paths.get(file), (text + "\r\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return requestLog;
    }

    //Запись в файл объекта ResponseRestController
    public static void printLogsResponseRestController(String file, RequestRestController requestLog, HttpServletResponse response, String debug_flag, String bodyStr) {

        ResponseRestController responseLog = new ResponseRestController();

        //наполнение объекта ResponseRestController для ответа
        fillResponseRestController(responseLog, requestLog, response, debug_flag, bodyStr);

        String text = responseLog.toString();
        //Форматирование
        if (text != null) {
            text = text.replaceAll("\n|\r\n", "");
        }

        try {
            Files.write(Paths.get(file), (text + "\r\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Запись в файл объекта RequestHttp
    public static void printLogsRequestHttp(String file, String body, HttpRequestBase httpRequestBase, String uuid) {

        RequestHttp requestLog = new RequestHttp();

        //наполнение объекта RequestAsync для запроса
        fillRequestHttp(requestLog, body, httpRequestBase, uuid);

        String text = requestLog.toString();
        //Форматирование
        if (text != null) {
            text = text.replaceAll("\n|\r\n", "");
        }

        try {
            Files.write(Paths.get(file), (text + "\r\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Запись в файл объекта ResponseHttp
    public static void printLogsResponseHttp(String file, HttpRequestBase httpRequestBase, HttpResponse httpResponse, String uuid) {

        ResponseHttp responseLog = new ResponseHttp();

        //наполнение объекта ResponseHttp для ответа
        fillResponseHttp(responseLog, httpRequestBase, httpResponse, uuid);

        String text = responseLog.toString();
        //Форматирование
        if (text != null) {
            text = text.replaceAll("\n|\r\n", "");
        }

        try {
            Files.write(Paths.get(file), (text + "\r\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Наполнение объекта RequestHttp для запроса
    public static void fillRequestHttp(RequestHttp requestLog, String body, HttpRequestBase httpRequestBase, String uuid) {
        requestLog.setId(uuid);
        requestLog.setDateTime(Instant.now());
        requestLog.setMethod(httpRequestBase.getMethod());
        requestLog.setUrl(String.valueOf(httpRequestBase.getURI()).replace("http:/", "").replace("https:/", ""));

        //Добавление списка заголовков
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < httpRequestBase.getAllHeaders().length; i++) {
            stringBuilder.append(httpRequestBase.getAllHeaders()[i] + "; ");
        }
        requestLog.setHeaders(stringBuilder.toString());
        requestLog.setBody(body);
    }

    //наполнение объекта ResponseHttp для ответа
    public static void fillResponseHttp(ResponseHttp responseLog, HttpRequestBase httpRequestBase, HttpResponse httpResponse, String uuid) {
        responseLog.setId(uuid);
        responseLog.setDateTime(Instant.now());
        responseLog.setDirection("Response");
        responseLog.setMethod("---");
        responseLog.setUrl(String.valueOf(httpRequestBase.getURI()).replace("http:/", "").replace("https:/", ""));

        //Добавление списка заголовков
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < httpResponse.getAllHeaders().length; i++) {
            stringBuilder.append(httpResponse.getAllHeaders()[i] + "; ");
        }
        responseLog.setHeaders(stringBuilder.toString());

        String bodyStr = null;
        try {
            InputStream inputStream = httpResponse.getEntity().getContent();
            for (int i = 0; i < httpResponse.getEntity().getContentLength(); i++) {
                bodyStr += (char) inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bodyStr != null) {
            responseLog.setBody(bodyStr);
        } else {
            responseLog.setBody(null);
        }
    }

    //Задержка
    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Отправка POST запроса
    public static HttpResponse sendPostRequest(HttpPost httpPost, HttpClient httpClient, String body) {
        HttpResponse httpResponse = null;
        try {
            StringEntity stringEntity = new StringEntity(body);
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);

            httpResponse = httpClient.execute(httpPost);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpResponse;
    }

    //Отправка Get запроса
    public static HttpResponse sendGetRequest(HttpGet httpGet, HttpClient httpClient) {
        HttpResponse httpResponse = null;
        try {
            httpGet.getRequestLine();

            httpResponse = httpClient.execute(httpGet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpResponse;
    }

    //Добавляем headers из файла
    public static void setHeaderFromFile(String fileName, HttpServletResponse response) {
        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(fileName));

            String str = buffReader.readLine();
            String[] strSplit;
            if (str != null) {
                while (str != null) {
                    strSplit = str.split("'|'");
                    response.setHeader(strSplit[0], strSplit[2]);
                    str = buffReader.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Добавляем body из файла для запросов в контроллеры
    public static String setBodyFromFile(String fileName, HttpServletResponse response) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(fileName));

            String str = buffReader.readLine();
            if (str != null) {
                while (str != null) {
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

    //Добавляем body из файла для http запросов
    public static String getBodyFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader buffReader = new BufferedReader(new FileReader(fileName));

            String str = buffReader.readLine();
            if (str != null) {
                while (str != null) {
                    stringBuilder.append(str);
                    str = buffReader.readLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    //Добавляем body для ответа
    public static void setBodyFromString(HttpServletResponse response, String responseBody) {
        try {
            response.getWriter().write(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
