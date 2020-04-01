package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;

public class PlpState implements Serializable {

    private Object categoryId;
    private Object currentSortOption;
    private Object currentFilters;
    private Integer firstRecNum;
    private Integer lastRecNum;
    private Integer recsPerPage;
    private Integer totalNumRecs;
    private String originalSearchTerm;


    public Object getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Object categoryId) {
        this.categoryId = categoryId;
    }

    public Object getCurrentSortOption() {
        return currentSortOption;
    }

    public void setCurrentSortOption(Object currentSortOption) {
        this.currentSortOption = currentSortOption;
    }

    public Object getCurrentFilters() {
        return currentFilters;
    }

    public void setCurrentFilters(Object currentFilters) {
        this.currentFilters = currentFilters;
    }

    public Integer getFirstRecNum() {
        return firstRecNum;
    }

    public void setFirstRecNum(Integer firstRecNum) {
        this.firstRecNum = firstRecNum;
    }

    public Integer getLastRecNum() {
        return lastRecNum;
    }

    public void setLastRecNum(Integer lastRecNum) {
        this.lastRecNum = lastRecNum;
    }

    public Integer getRecsPerPage() {
        return recsPerPage;
    }

    public void setRecsPerPage(Integer recsPerPage) {
        this.recsPerPage = recsPerPage;
    }

    public Integer getTotalNumRecs() {
        return totalNumRecs;
    }

    public void setTotalNumRecs(Integer totalNumRecs) {
        this.totalNumRecs = totalNumRecs;
    }

    public String getOriginalSearchTerm() {
        return originalSearchTerm;
    }

    public void setOriginalSearchTerm(String originalSearchTerm) {
        this.originalSearchTerm = originalSearchTerm;
    }
}
