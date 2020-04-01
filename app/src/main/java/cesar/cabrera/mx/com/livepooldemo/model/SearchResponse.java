package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;

public class SearchResponse implements Serializable {

    private Status status;
    private String pageType;
    private PlpResults plpResults;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public PlpResults getPlpResults() {
        return plpResults;
    }

    public void setPlpResults(PlpResults plpResults) {
        this.plpResults = plpResults;
    }
}
