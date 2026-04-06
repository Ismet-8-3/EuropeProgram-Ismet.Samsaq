package databasetestautomation;

/**
 * @author : ismetsasaq
 * @created : 06/04/2026,12:19
 * @Email : noah.yisimaiti@Gmail.com
 **/
public class Products {
    //status,quantity,price,name,stock_level,tax_type, " +
    //                "seo_meta_title,seo_meta_Description,seo_meta_keywords
    private int status;
    private int quantity;
    private double price;
    private String name;
    private int stock_level;
    private int taxType;
    private String seoMetaTitle;
    private String seoMetaDescription;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock_level() {
        return stock_level;
    }

    public void setStock_level(int stock_level) {
        this.stock_level = stock_level;
    }

    public Products(int status, int quantity, double price, String name, int stock_level, int taxType,
                    String seoMetaTitle, String seoMetaDescription, String seoMetaKeyWords) {
        this.status = status;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.stock_level = stock_level;
        this.taxType = taxType;
        this.seoMetaTitle = seoMetaTitle;
        this.seoMetaDescription = seoMetaDescription;
        this.seoMetaKeyWords = seoMetaKeyWords;
    }

    public int getTaxType() {
        return taxType;
    }

    public void setTaxType(int taxType) {
        this.taxType = taxType;
    }

    public String getSeoMetaTitle() {
        return seoMetaTitle;
    }

    public void setSeoMetaTitle(String seoMetaTitle) {
        this.seoMetaTitle = seoMetaTitle;
    }

    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    public void setSeoMetaDescription(String seoMetaDescription) {
        this.seoMetaDescription = seoMetaDescription;
    }

    public String getSeoMetaKeyWords() {
        return seoMetaKeyWords;
    }

    public void setSeoMetaKeyWords(String seoMetaKeyWords) {
        this.seoMetaKeyWords = seoMetaKeyWords;
    }

    private String seoMetaKeyWords;
}
