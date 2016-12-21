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
 * Created by kevin on 16/12/20.
 */

public class BannerBean {

    /**
     * next :
     * this_page_num : 4
     * list : [{"channel_id":"<2>:<12>,<2>:<13>,<2>:<3>","channel_desc":"鎺ㄨ崘","article_id":"26557","content_id":"26557","insert_date":"2016-12-19 11:40:05","publication_date":"2016-12-19 11:35:36","is_direct":"True","is_top":"False","article_url":"http://lolriotmall.qq.com/wireless/zhuanti/2016/wap1219.html?adunionsid=zmlb","title":"鍐伴洩鑺備笓灞為瓌缃楃ぜ鍖�","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/191140058588366_282.jpg","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/191140058588366_480.jpg","image_spec":"1","image_with_btn":"False","score":"3","summary":"榄勭綏濞冨▋浠殑鍐伴洩鑺備箰鍥紝璧跺揩鏉ョ帺鍚э紒","targetid":"1674265979","is_act":"0","is_hot":"0","is_subject":"0","is_report":"True","is_new":"0"},{"channel_id":"<2>:<12>,<2>:<13>,<2>:<23>,<2>:<3>","channel_desc":"鎺ㄨ崘","article_id":"26482","content_id":"26482","insert_date":"2016-12-16 20:08:54","publication_date":"2016-12-16 20:04:30","is_direct":"True","is_top":"False","article_url":"http://lol.qq.com/m/act/a20161209snowfestival/index.htm","title":"澶у啺闆妭 鏀堕泦闆悆棰嗗彇涓板帤濂栧姳","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/162008545314673_282.jpg","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/162008545314673_480.jpg","image_spec":"1","image_with_btn":"False","score":"3","summary":"娲诲姩鏃堕棿锛�2016骞�12鏈�16鏃�18鐐筡u002D2017骞�1鏈�12鏃�23鐐�","targetid":"1671183644","is_act":"0","is_hot":"0","is_subject":"0","is_report":"True","is_new":"0"},{"channel_id":"<2>:<12>,<2>:<13>,<2>:<3>","channel_desc":"鎺ㄨ崘","article_id":"26364","content_id":"26364","insert_date":"2016-12-13 12:27:28","publication_date":"2016-12-13 14:37:40","is_direct":"False","is_top":"False","article_url":"64/article_26364.shtml","title":"鈥滈潚閽㈠奖-鍗¤湝灏斺�濇寮忎笂鏋�","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/131227283426617_282.jpg","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/131227283426617_480.jpg","image_spec":"1","image_with_btn":"False","score":"3","summary":"绮惧噯涓庡惁锛屽氨鏄睜瀹颁笌鎵嬫湳鐨勫尯鍒珇","targetid":"1665317735","video_info":"y0022nhl3ti 361","is_act":"0","is_hot":"0","is_subject":"0","is_report":"True","is_new":"0"},{"channel_id":"<2>:<12>,<2>:<13>,<2>:<3>","channel_desc":"鎺ㄨ崘","article_id":"26337","content_id":"26337","insert_date":"2016-12-12 16:44:14","publication_date":"2016-12-12 16:38:28","is_direct":"False","is_top":"False","article_url":"37/article_26337.shtml","title":"闂嫵澶达細2017璧涘瀛ｅ墠璧涙敼鍔�","image_url_small":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/121644145476930_282.jpg","image_url_big":"http://ossweb-img.qq.com/upload/qqtalk/news/201612/121644145476930_480.jpg","image_spec":"1","image_with_btn":"False","score":"3","summary":"涓婃闂嫵澶寸殑闂璁捐甯堝凡缁忓洖绛旓紝璧跺揩鏉ョ湅鏈夋病鏈変綘鐨勬彁闂惂锛�","targetid":"1663939504","is_act":"0","is_hot":"0","is_subject":"0","is_report":"True","is_new":"0"}]
     */

    private String next;
    private String this_page_num;
    private List<ListBean> list;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getThis_page_num() {
        return this_page_num;
    }

    public void setThis_page_num(String this_page_num) {
        this.this_page_num = this_page_num;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * channel_id : <2>:<12>,<2>:<13>,<2>:<3>
         * channel_desc : 鎺ㄨ崘
         * article_id : 26557
         * content_id : 26557
         * insert_date : 2016-12-19 11:40:05
         * publication_date : 2016-12-19 11:35:36
         * is_direct : True
         * is_top : False
         * article_url : http://lolriotmall.qq.com/wireless/zhuanti/2016/wap1219.html?adunionsid=zmlb
         * title : 鍐伴洩鑺備笓灞為瓌缃楃ぜ鍖�
         * image_url_small : http://ossweb-img.qq.com/upload/qqtalk/news/201612/191140058588366_282.jpg
         * image_url_big : http://ossweb-img.qq.com/upload/qqtalk/news/201612/191140058588366_480.jpg
         * image_spec : 1
         * image_with_btn : False
         * score : 3
         * summary : 榄勭綏濞冨▋浠殑鍐伴洩鑺備箰鍥紝璧跺揩鏉ョ帺鍚э紒
         * targetid : 1674265979
         * is_act : 0
         * is_hot : 0
         * is_subject : 0
         * is_report : True
         * is_new : 0
         * video_info : y0022nhl3ti 361
         */

        private String channel_id;
        private String channel_desc;
        private String article_id;
        private String content_id;
        private String insert_date;
        private String publication_date;
        private String is_direct;
        private String is_top;
        private String article_url;
        private String title;
        private String image_url_small;
        private String image_url_big;
        private String image_spec;
        private String image_with_btn;
        private String score;
        private String summary;
        private String targetid;
        private String is_act;
        private String is_hot;
        private String is_subject;
        private String is_report;
        private String is_new;
        private String video_info;

        public String getChannel_id() {
            return channel_id;
        }

        public void setChannel_id(String channel_id) {
            this.channel_id = channel_id;
        }

        public String getChannel_desc() {
            return channel_desc;
        }

        public void setChannel_desc(String channel_desc) {
            this.channel_desc = channel_desc;
        }

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getInsert_date() {
            return insert_date;
        }

        public void setInsert_date(String insert_date) {
            this.insert_date = insert_date;
        }

        public String getPublication_date() {
            return publication_date;
        }

        public void setPublication_date(String publication_date) {
            this.publication_date = publication_date;
        }

        public String getIs_direct() {
            return is_direct;
        }

        public void setIs_direct(String is_direct) {
            this.is_direct = is_direct;
        }

        public String getIs_top() {
            return is_top;
        }

        public void setIs_top(String is_top) {
            this.is_top = is_top;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage_url_small() {
            return image_url_small;
        }

        public void setImage_url_small(String image_url_small) {
            this.image_url_small = image_url_small;
        }

        public String getImage_url_big() {
            return image_url_big;
        }

        public void setImage_url_big(String image_url_big) {
            this.image_url_big = image_url_big;
        }

        public String getImage_spec() {
            return image_spec;
        }

        public void setImage_spec(String image_spec) {
            this.image_spec = image_spec;
        }

        public String getImage_with_btn() {
            return image_with_btn;
        }

        public void setImage_with_btn(String image_with_btn) {
            this.image_with_btn = image_with_btn;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTargetid() {
            return targetid;
        }

        public void setTargetid(String targetid) {
            this.targetid = targetid;
        }

        public String getIs_act() {
            return is_act;
        }

        public void setIs_act(String is_act) {
            this.is_act = is_act;
        }

        public String getIs_hot() {
            return is_hot;
        }

        public void setIs_hot(String is_hot) {
            this.is_hot = is_hot;
        }

        public String getIs_subject() {
            return is_subject;
        }

        public void setIs_subject(String is_subject) {
            this.is_subject = is_subject;
        }

        public String getIs_report() {
            return is_report;
        }

        public void setIs_report(String is_report) {
            this.is_report = is_report;
        }

        public String getIs_new() {
            return is_new;
        }

        public void setIs_new(String is_new) {
            this.is_new = is_new;
        }

        public String getVideo_info() {
            return video_info;
        }

        public void setVideo_info(String video_info) {
            this.video_info = video_info;
        }
    }
}
