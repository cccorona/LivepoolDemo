package cesar.cabrera.mx.com.livepooldemo.model;

import java.io.Serializable;

public class Product implements Serializable {

    private Long productId;
    private Long skuRepositoryId;
    private String productDisplayName;
    private String productType;
    private Integer productRatingCount;
    private Double productAvgRating;
    private Double listPrice;
    private Double minimumListPrice;
    private Double maximumListPrice;
    private Double promoPrice;
    private Double minimumPromoPrice;
    private Double maximumPromoPrice;
    private Boolean isHybrid;
    private Boolean isMarketPlace;
    private String smImage;
    private String lgImage;
    private String xlImage;
    private String groupType;
    private Object plpFlags;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSkuRepositoryId() {
        return skuRepositoryId;
    }

    public void setSkuRepositoryId(Long skuRepositoryId) {
        this.skuRepositoryId = skuRepositoryId;
    }

    public String getProductDisplayName() {
        return productDisplayName;
    }

    public void setProductDisplayName(String productDisplayName) {
        this.productDisplayName = productDisplayName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getProductRatingCount() {
        return productRatingCount;
    }

    public void setProductRatingCount(Integer productRatingCount) {
        this.productRatingCount = productRatingCount;
    }

    public Double getProductAvgRating() {
        return productAvgRating;
    }

    public void setProductAvgRating(Double productAvgRating) {
        this.productAvgRating = productAvgRating;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getMinimumListPrice() {
        return minimumListPrice;
    }

    public void setMinimumListPrice(Double minimumListPrice) {
        this.minimumListPrice = minimumListPrice;
    }

    public Double getMaximumListPrice() {
        return maximumListPrice;
    }

    public void setMaximumListPrice(Double maximumListPrice) {
        this.maximumListPrice = maximumListPrice;
    }

    public Double getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }

    public Double getMinimumPromoPrice() {
        return minimumPromoPrice;
    }

    public void setMinimumPromoPrice(Double minimumPromoPrice) {
        this.minimumPromoPrice = minimumPromoPrice;
    }

    public Double getMaximumPromoPrice() {
        return maximumPromoPrice;
    }

    public void setMaximumPromoPrice(Double maximumPromoPrice) {
        this.maximumPromoPrice = maximumPromoPrice;
    }

    public Boolean getHybrid() {
        return isHybrid;
    }

    public void setHybrid(Boolean hybrid) {
        isHybrid = hybrid;
    }

    public Boolean getMarketPlace() {
        return isMarketPlace;
    }

    public void setMarketPlace(Boolean marketPlace) {
        isMarketPlace = marketPlace;
    }

    public String getSmImage() {
        return smImage;
    }

    public void setSmImage(String smImage) {
        this.smImage = smImage;
    }

    public String getLgImage() {
        return lgImage;
    }

    public void setLgImage(String lgImage) {
        this.lgImage = lgImage;
    }

    public String getXlImage() {
        return xlImage;
    }

    public void setXlImage(String xlImage) {
        this.xlImage = xlImage;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public Object getPlpFlags() {
        return plpFlags;
    }

    public void setPlpFlags(Object plpFlags) {
        this.plpFlags = plpFlags;
    }
}
