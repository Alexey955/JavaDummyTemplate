package hello.classes.dtos;

public class StringToInfluxDB {
    private String method = null;
    private String timestamp = null;

    public StringToInfluxDB() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return method + "\'|\'" + timestamp;
    }
}
