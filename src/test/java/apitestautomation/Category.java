package apitestautomation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author : ismetsasaq
 * @created : 18/04/2026,14:29
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class Category {
    @JsonProperty("catDescription")
    private String catDescription;

    @JsonProperty("catImage")
    private int catImage;
    @JsonProperty("catName")
    private String catName;
    @JsonProperty("catParentId")
    private int catParentId;
    @JsonProperty("hide")
    private int hide;
    @JsonProperty("id")
    private int id;
    @JsonProperty("itemIntShip")
    private int itemIntShip;
    @JsonProperty("itemShip")
    private int itemShip;
    @JsonProperty("priority")
    private int priority;
    @JsonProperty("seoMetaDescription")
    private String seoMetaDescription;
    @JsonProperty("seoMetaKeywords")
    private String seoMetaKeywords;

    public Category(String catDescription, int catImage, String catName, int catParentId, int hide, int id,
                    int itemIntShip, int itemShip, int priority, String seoMetaDescription,
                    String seoMetaKeywords, String seoMetaTitle, int status) {
        this.catDescription = catDescription;
        this.catImage = catImage;
        this.catName = catName;
        this.catParentId = catParentId;
        this.hide = hide;
        this.id = id;
        this.itemIntShip = itemIntShip;
        this.itemShip = itemShip;
        this.priority = priority;
        this.seoMetaDescription = seoMetaDescription;
        this.seoMetaKeywords = seoMetaKeywords;
        this.seoMetaTitle = seoMetaTitle;
        this.status = status;
    }

    @JsonProperty("seoMetaTitle")
    private String seoMetaTitle;
    @JsonProperty("status")
    private int status;
}
