package jyh.test.android.ex_0611_openapi;

public class BookModel {
    //vo : value object
    //서버를 통해 얻어올 정보들을 묶어서 한번에 관리하는 클래스
    //제목, 저자, 가격, 이미지
    private String b_title, b_author, b_price, b_img;

    public String getB_title() {
        return b_title;
    }

    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    public String getB_author() {
        return b_author;
    }

    public void setB_author(String b_author) {
        this.b_author = b_author;
    }

    public String getB_price() {
        return b_price;
    }

    public void setB_price(String b_price) {
        this.b_price = b_price;
    }

    public String getB_img() {
        return b_img;
    }

    public void setB_img(String b_img) {
        this.b_img = b_img;
    }
}
