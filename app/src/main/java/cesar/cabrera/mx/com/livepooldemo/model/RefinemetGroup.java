package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;

public class RefinemetGroup implements Serializable {

    private String name;
    private Refinement[] refinement;
    private Boolean multiSelect;
    private String dimensionName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Refinement[] getRefinement() {
        return refinement;
    }

    public void setRefinement(Refinement[] refinement) {
        this.refinement = refinement;
    }

    public Boolean getMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(Boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }
}
