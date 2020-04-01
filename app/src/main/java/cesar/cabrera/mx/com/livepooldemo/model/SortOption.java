package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;

public class SortOption implements Serializable {

    private String sortBy;
    private String label;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
