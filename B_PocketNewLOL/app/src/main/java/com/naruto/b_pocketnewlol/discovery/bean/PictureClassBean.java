package com.naruto.b_pocketnewlol.discovery.bean;

import java.util.List;

/**
 * Created by 大嘴宝 on 17/1/4.
 */

public class PictureClassBean {

    /**
     * result : 0
     * categories : [{"id":"22","name":"掌盟闪屏","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_091134421561837.png?1799"},{"id":"25","name":"玩家投稿","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_071839270167203.jpg?5967"},{"id":"21","name":"英雄原画","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_042047013008506.jpg?3347"},{"id":"8","name":"皮肤原画","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_042113342422665.jpg?2081"},{"id":"36","name":"VG","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041730196686966.jpg?3757"},{"id":"35","name":"SNAKE","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041730278537946.jpg?3757"},{"id":"34","name":"SAT","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041730357803334.jpg?3757"},{"id":"33","name":"RNG","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041730444964883.jpg?3757"},{"id":"32","name":"OMG","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041730534066935.jpg?3757"},{"id":"31","name":"NEWBEE","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041731039072098.jpg?3757"},{"id":"30","name":"LGD","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041731117077280.jpg?3757"},{"id":"29","name":"IM","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041731203941863.jpg?3757"},{"id":"28","name":"IG","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041731283573430.jpg?3757"},{"id":"27","name":"GT","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041731397455048.jpg?3757"},{"id":"26","name":"EDG","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041731462491268.jpg?3757"},{"id":"37","name":"WE","kind_type":"1","thumbUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_041730096733457.jpg?3757"}]
     * hasnext : 0
     */

    private int result;
    private int hasnext;
    private List<CategoriesBean> categories;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getHasnext() {
        return hasnext;
    }

    public void setHasnext(int hasnext) {
        this.hasnext = hasnext;
    }

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class CategoriesBean {
        /**
         * id : 22
         * name : 掌盟闪屏
         * kind_type : 1
         * thumbUrl : http://ossweb-img.qq.com/upload/qqtalk/lol_hero/wpk_091134421561837.png?1799
         */

        private String id;
        private String name;
        private String kind_type;
        private String thumbUrl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKind_type() {
            return kind_type;
        }

        public void setKind_type(String kind_type) {
            this.kind_type = kind_type;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }
    }
}
