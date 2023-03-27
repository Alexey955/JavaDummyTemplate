package hello.classes.elements;

import java.time.Instant;

public class RequestAsync {
    private String id = null;
    private Instant dateTime = null;
    private String direction = null;
    private String method = null;
    private String url = null;
    private String headers = null;
    private String body = null;
    private String status = "---";
    private float responseTime = 0;
    private boolean debug_flag = false;

    public boolean isDebug_flag() {
        return debug_flag;
    }

    public void setDebug_flag(boolean debug_flag) {
        this.debug_flag = debug_flag;
    }

    public float getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(float responseTime) {
        this.responseTime = responseTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RequestAsync (){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Debug(" + debug_flag + "); " + "ID(" + id + "); " + "Date(" + dateTime + "); Direction(" + direction + "); Method(" + method + "); Status(\"" + status + "\"); URL(" + url + "); Response_time(\"" + responseTime + "\"); Headers(" + headers + "); Body(" + body + ")";
    }
}
