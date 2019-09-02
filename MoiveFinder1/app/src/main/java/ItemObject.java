public class ItemObject {
    private String title;
    private String img_url;
    private String detail_link;
    private String reserve;
    private String age;

    public ItemObject(String title, String url, String link, String reserve, String age){
        this.title = title;
        this.img_url = url;
        this.detail_link = link;
        this.reserve = reserve;
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getDetail_link() {
        return detail_link;
    }

    public String getReserve() {
        return reserve;
    }

    public String getAge() {
        return age;
    }
}


