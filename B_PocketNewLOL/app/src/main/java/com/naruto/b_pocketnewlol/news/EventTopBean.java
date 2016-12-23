package com.naruto.b_pocketnewlol.news;

import java.util.List;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 * <p>
 * Created by kevin on 16/12/23.
 */

public class EventTopBean {

    /**
     * normal_features : [{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/gc_252025079662119.png","intent":"qtpage://match_subscribelist?bGameId=&sGameId=","name":"赛程订阅"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/gc_25202443743317.png","intent":"qtpage://match_common_list?type=1","name":"赛事视频"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/gc_252026030729110.png","intent":"qtpage://club_square","name":"俱乐部"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/gc_252026316585880.png","intent":"qtpage://match_common_list?type=2","name":"赛况数据"}]
     * gallery_features : [{"intent":"qtpage://news_detail?url=http%3A%2F%2Fqt.qq.com%2Fstatic%2Fpages%2Fnews%2Fphone%2F27%2Farticle_26127.shtml","title":"2016全明星赛赛事预告及回顾","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/110528237226775_480.jpg"}]
     * result : 0
     */

    private int result;
    private List<NormalFeaturesBean> normal_features;
    private List<GalleryFeaturesBean> gallery_features;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<NormalFeaturesBean> getNormal_features() {
        return normal_features;
    }

    public void setNormal_features(List<NormalFeaturesBean> normal_features) {
        this.normal_features = normal_features;
    }

    public List<GalleryFeaturesBean> getGallery_features() {
        return gallery_features;
    }

    public void setGallery_features(List<GalleryFeaturesBean> gallery_features) {
        this.gallery_features = gallery_features;
    }

    public static class NormalFeaturesBean {
        /**
         * iconUrl : http://ossweb-img.qq.com/upload/qqtalk/lol_hero/gc_252025079662119.png
         * intent : qtpage://match_subscribelist?bGameId=&sGameId=
         * name : 赛程订阅
         */

        private String iconUrl;
        private String intent;
        private String name;

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class GalleryFeaturesBean {
        /**
         * intent : qtpage://news_detail?url=http%3A%2F%2Fqt.qq.com%2Fstatic%2Fpages%2Fnews%2Fphone%2F27%2Farticle_26127.shtml
         * title : 2016全明星赛赛事预告及回顾
         * iconUrl : http://ossweb-img.qq.com/upload/qqtalk/news/201612/110528237226775_480.jpg
         */

        private String intent;
        private String title;
        private String iconUrl;

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }
    }
}
