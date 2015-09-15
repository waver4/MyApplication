package com.waver.myapplication;


public class CardNews {

    private String news_title;
    private int news_icon;

    public CardNews(String title, int img) {
        this.news_title = title;
        this.news_icon = img;
    }

    public void setNews_icon(int news_icon) {
        this.news_icon = news_icon;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public int getNews_icon() {
        return news_icon;
    }

    public String getNews_title() {
        return news_title;
    }
}
