package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
//Farkli key-value ikililerin uyusmazligini @JsonIgnoreProperties(ignoreUnknown = true)
//annotation ini pojo classimizin basina yazarak cozebiliriz
public class JsonPlaceHolderPojo {
    /*
    1- Tüm keyler icin private variabler olusturuyoruz
    2- Tüm parametrelerle ve parametresiz Constructor larimizi olusturuyoruz
    3- Geters ve setters larimizi olusturuyoruz
    4- tostring methodumuzu olusturuyoruz
     */
    //1- Tüm keyler icin private variabler olusturuyoruz
    private Integer userId;
    private String title;
    private Boolean completed;

    // 2- Tüm parametrelerle ve parametresiz Constructor larimizi olusturuyoruz


    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }
    //    3- Geters ve setters larimizi olusturuyoruz


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed='" + completed + '\'' +
                '}';
    }

}
