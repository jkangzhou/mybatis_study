package cn.zhou.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (PlayRecord)实体类
 *
 * @author makejava
 * @since 2023-04-19 13:49:46
 */
public class PlayRecord implements Serializable {
    private static final long serialVersionUID = 338664580130571246L;

    private Integer id;

    private Integer userId;

    private Integer videoId;
    /**
     * 当前播放第几集
     */
    private Integer currentNum;
    /**
     * 当前播放第几集视频id
     */
    private Integer episodeId;

    private Date createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

