package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;

public class Status implements Serializable {

    private String status;
    private Integer statusCode;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
