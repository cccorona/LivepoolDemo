package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;
import java.util.ArrayList;

public class PlpResults implements Serializable {

    private Object label;
    private PlpState plpState;
    private SortOption[] sortOptions;
    private RefinemetGroup[] refinementGroups;
    private ArrayList<Product> records;

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public PlpState getPlpState() {
        return plpState;
    }

    public void setPlpState(PlpState plpState) {
        this.plpState = plpState;
    }

    public SortOption[] getSortOptions() {
        return sortOptions;
    }

    public void setSortOptions(SortOption[] sortOptions) {
        this.sortOptions = sortOptions;
    }

    public RefinemetGroup[] getRefinementGroups() {
        return refinementGroups;
    }

    public void setRefinementGroups(RefinemetGroup[] refinementGroups) {
        this.refinementGroups = refinementGroups;
    }

    public ArrayList<Product> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Product> records) {
        this.records = records;
    }
}
