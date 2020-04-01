package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;

public class Refinement implements Serializable {

    private Integer count;
    private String label;
    private String refinementId;
    private Boolean selected;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getRefinementId() {
        return refinementId;
    }

    public void setRefinementId(String refinementId) {
        this.refinementId = refinementId;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
