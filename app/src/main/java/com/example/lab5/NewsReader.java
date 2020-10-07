package com.example.lab5;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



public class NewsReader {
    public static List<News> listNews(InputStream inputStream){
        try {
            List<News> newses = new ArrayList<>();
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(inputStream, null);

            News news = null;
            int eventType = xmlPullParser.getEventType();
            String tagName = "";
            String content = "";
            String img = "";
            while(eventType != XmlPullParser.END_DOCUMENT){
                //1
                tagName = xmlPullParser.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if(tagName.equalsIgnoreCase("item"))
                            news = new News();
                        break;
                    case XmlPullParser.TEXT:
                        content = xmlPullParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(news != null) {
                            if (tagName.equalsIgnoreCase("title"))
                                news.setTitle(content);
                            else if (tagName.equalsIgnoreCase("link"))
                                news.setLink(content);

                            else if (tagName.equalsIgnoreCase("item"))
                                newses.add(news);
                        }
                        break;
                }
                eventType = xmlPullParser.next();
            }
            return newses;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
