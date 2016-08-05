package com.example.mypc.esports2.config;

/**
 * Created by MyPC on 2016/8/2.
 */
public class UrlConfig {
    public static class Path {
        public static final String BASE_URL = "http://139.196.106.200/";
    }
    public static class ThumbnailPath{
        public static final String GAMES="match";
        public static final String INFO="info";

    }
    public static class KEY {
        public static final String GAME_ID = "game_id";
        public static final String PAGE = "p";
        public static final String MATCH_ID = "match_id";
        public static final String ROW = "row";
        public static final String ORDERTYPE = "ordertype";
        public static final String ISHOT = "ishot";

    }
    public static class MiddlePath{
        public static final String MIDDLE="Circle/lists";
    }
    public static class PostPath{
        public static final String POST="Circle/postlists";
    }
}
