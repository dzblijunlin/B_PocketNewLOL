package com.naruto.b_pocketnewlol.discovery.bean;

import java.util.List;

/**
 * Created by 大嘴宝 on 16/12/24.
 */

public class TeamNumPhotoBean {

    /**
     * iconUrl : http://ossweb-img.qq.com/upload/qqtalk/lol_live/team_club_13.png?9154
     * name : EDG
     * trendTopicId : 261
     * fansTopicId : 13
     * adminUin : 2127559367
     * adminUuid : 11819949-064a-48c4-9f62-4056c1511b8a
     * allowurl : 0
     * tab : Post
     * fansCount : 5815804
     * clubvote : 765082
     * sh_id : 1
     * members : [{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/mb_club_61.jpg?3280"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/mb_club_62.jpg?3341"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/mb_club_371.jpg?3391"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/mb_club_650.jpg?3403"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/mb_club_1241.jpg?1102"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/mb_club_1490.jpg?6381"},{"iconUrl":"http://ossweb-img.qq.com/upload/qqtalk/lol_live/mb_club_1491.jpg?2048"}]
     */

    private String iconUrl;
    private String name;
    private String trendTopicId;
    private String fansTopicId;
    private String adminUin;
    private String adminUuid;
    private int allowurl;
    private String tab;
    private int fansCount;
    private int clubvote;
    private String sh_id;
    private List<MembersBean> members;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAdminUuid() {
        return adminUuid;
    }

    public void setAdminUuid(String adminUuid) {
        this.adminUuid = adminUuid;
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

    public String getSh_id() {
        return sh_id;
    }

    public void setSh_id(String sh_id) {
        this.sh_id = sh_id;
    }

    public List<MembersBean> getMembers() {
        return members;
    }

    public void setMembers(List<MembersBean> members) {
        this.members = members;
    }

    public static class MembersBean {
        /**
         * iconUrl : http://ossweb-img.qq.com/upload/qqtalk/lol_live/mb_club_61.jpg?3280
         */

        private String iconUrl;

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }
    }
}
