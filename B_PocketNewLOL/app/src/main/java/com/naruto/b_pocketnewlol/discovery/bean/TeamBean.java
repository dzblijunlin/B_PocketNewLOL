package com.naruto.b_pocketnewlol.discovery.bean;

import java.util.List;

/**
 * Created by 大嘴宝 on 16/12/20.
 */

public class TeamBean {

    /**
     * result : 0
     * clubs : [{"id":"13","name":"EDG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_13.png?9154","fansCount":5816849,"clubvote":764611,"trendTopicId":"261","fansTopicId":"13","adminUin":"","allowurl":0,"tab":"Post","sh_id":"1","adminUuid":"11819949-064a-48c4-9f62-4056c1511b8a"},{"id":"7","name":"OMG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_7.png?5948","fansCount":3096820,"clubvote":108869,"trendTopicId":"262","fansTopicId":"7","adminUin":"","allowurl":0,"tab":"Post","sh_id":"6","adminUuid":"97abd23b-efd2-4922-8055-bea5bbc1bedd"},{"id":"43","name":"Snake","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_43.png?0871","fansCount":2085129,"clubvote":67724,"trendTopicId":"268","fansTopicId":"43","adminUin":"","allowurl":0,"tab":"Post","sh_id":"9","adminUuid":"c7adb2cb-d7ba-437a-a8c1-f7995c855222"},{"id":"44","name":"VG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_44.png?0889","fansCount":1822530,"clubvote":12773,"trendTopicId":"263","fansTopicId":"44","adminUin":"","allowurl":0,"tab":"Post","sh_id":"11","adminUuid":"6ae65dfc-f9a3-4ad8-be96-f5be325749e3"},{"id":"103","name":"RNG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_103.png?2023","fansCount":3090030,"clubvote":38412,"trendTopicId":"266","fansTopicId":"103","adminUin":"","allowurl":0,"tab":"Post","sh_id":"8","adminUuid":"f472f933-28e3-4eae-b691-310927d8d1ad"},{"id":"10","name":"LGD","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_10.png?4180","fansCount":2511730,"clubvote":73125,"trendTopicId":"259","fansTopicId":"10","adminUin":"","allowurl":0,"tab":"Post","sh_id":"4","adminUuid":"78b50568-2aac-4320-bb7d-5b5f52368645"},{"id":"41","name":"Newbee","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_41.png?1097","fansCount":2176102,"clubvote":50894,"trendTopicId":"264","fansTopicId":"41","adminUin":"","allowurl":0,"tab":"Post","sh_id":"7","adminUuid":"d6ac9638-7ea3-4f80-a4b4-6405e99bd3b1"},{"id":"6","name":"IG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_6.png?1152","fansCount":2050587,"clubvote":30908,"trendTopicId":"260","fansTopicId":"6","adminUin":"","allowurl":0,"tab":"Post","sh_id":"2","adminUuid":"4d591293-e616-4073-a5d8-5e03105ea9dd"},{"id":"9","name":"WE","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_9.png?1171","fansCount":2146499,"clubvote":70311,"trendTopicId":"267","fansTopicId":"9","adminUin":"","allowurl":0,"tab":"Post","sh_id":"12","adminUuid":"03894e5c-4f4c-4dc4-bf80-2d3c689a7e9b"},{"id":"202","name":"IM","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_202.png?1999","fansCount":192083,"clubvote":330,"trendTopicId":"275","fansTopicId":"202","adminUin":"","allowurl":0,"tab":"Post","sh_id":"57","adminUuid":"e5b59056-41dc-4abc-9cc9-d3f138119bb9"},{"id":"230","name":"QG","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_230.png?0188","fansCount":11680,"clubvote":4,"trendTopicId":"276","fansTopicId":"230","adminUin":"","allowurl":0,"tab":"Post","sh_id":"-1","adminUuid":"b8696c86-97e9-431e-bc04-e37753df052d"},{"id":"104","name":"UP","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_104.png?1234","fansCount":1607163,"clubvote":2236,"trendTopicId":"270","fansTopicId":"104","adminUin":"","allowurl":0,"tab":"Post","sh_id":"-1","adminUuid":"8e0e8df4-018a-4f35-a52a-854185af86a6"},{"id":"70","name":"M3","iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_70.png?1248","fansCount":1539357,"clubvote":7656,"trendTopicId":"265","fansTopicId":"70","adminUin":"","allowurl":0,"tab":"Post","sh_id":"5","adminUuid":"194c8d7e-abbc-4473-866d-6276281e327e"}]
     * topics : []
     */

    private int result;
    private List<ClubsBean> clubs;
    private List<?> topics;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<ClubsBean> getClubs() {
        return clubs;
    }

    public void setClubs(List<ClubsBean> clubs) {
        this.clubs = clubs;
    }

    public List<?> getTopics() {
        return topics;
    }

    public void setTopics(List<?> topics) {
        this.topics = topics;
    }

    public static class ClubsBean {
        /**
         * id : 13
         * name : EDG
         * iconUrl : http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_13.png?9154
         * fansCount : 5816849
         * clubvote : 764611
         * trendTopicId : 261
         * fansTopicId : 13
         * adminUin :
         * allowurl : 0
         * tab : Post
         * sh_id : 1
         * adminUuid : 11819949-064a-48c4-9f62-4056c1511b8a
         */

        private String id;
        private String name;
        private String iconUrl;
        private int fansCount;
        private int clubvote;
        private String trendTopicId;
        private String fansTopicId;
        private String adminUin;
        private int allowurl;
        private String tab;
        private String sh_id;
        private String adminUuid;

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

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public int getClubvote() {
            return clubvote;
        }

        public void setClubvote(int clubvote) {
            this.clubvote = clubvote;
        }

        public String getTrendTopicId() {
            return trendTopicId;
        }

        public void setTrendTopicId(String trendTopicId) {
            this.trendTopicId = trendTopicId;
        }

        public String getFansTopicId() {
            return fansTopicId;
        }

        public void setFansTopicId(String fansTopicId) {
            this.fansTopicId = fansTopicId;
        }

        public String getAdminUin() {
            return adminUin;
        }

        public void setAdminUin(String adminUin) {
            this.adminUin = adminUin;
        }

        public int getAllowurl() {
            return allowurl;
        }

        public void setAllowurl(int allowurl) {
            this.allowurl = allowurl;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }

        public String getSh_id() {
            return sh_id;
        }

        public void setSh_id(String sh_id) {
            this.sh_id = sh_id;
        }

        public String getAdminUuid() {
            return adminUuid;
        }

        public void setAdminUuid(String adminUuid) {
            this.adminUuid = adminUuid;
        }
    }
}
