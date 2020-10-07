package com.example.lab5;

public class News {
    private String title;
    private String link;
    private String image;
    public News() {
    }

    public News(String title, String link, String image) {
        this.title = title;
        this.link = link;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static int get(int position) {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return  title  +
                " \nLink=" + link ;
    }


}