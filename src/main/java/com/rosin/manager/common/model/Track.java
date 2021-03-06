package com.rosin.manager.common.model;

import java.util.Date;

public class Track {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.track_id
     *
     * @mbg.generated
     */
    private Integer trackId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.task_id
     *
     * @mbg.generated
     */
    private Integer taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.track_type
     *
     * @mbg.generated
     */
    private Integer trackType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.track_start_time
     *
     * @mbg.generated
     */
    private Date trackStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.track_file
     *
     * @mbg.generated
     */
    private String trackFile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.trackCreator_id
     *
     * @mbg.generated
     */
    private Integer trackcreatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column track.track_content
     *
     * @mbg.generated
     */
    private String trackContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table track
     *
     * @mbg.generated
     */
    public Track(Integer trackId, Integer taskId, Integer trackType, Date trackStartTime, String trackFile, Integer trackcreatorId, String trackContent) {
        this.trackId = trackId;
        this.taskId = taskId;
        this.trackType = trackType;
        this.trackStartTime = trackStartTime;
        this.trackFile = trackFile;
        this.trackcreatorId = trackcreatorId;
        this.trackContent = trackContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.track_id
     *
     * @return the value of track.track_id
     *
     * @mbg.generated
     */
    public Integer getTrackId() {
        return trackId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.task_id
     *
     * @return the value of track.task_id
     *
     * @mbg.generated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.track_type
     *
     * @return the value of track.track_type
     *
     * @mbg.generated
     */
    public Integer getTrackType() {
        return trackType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.track_start_time
     *
     * @return the value of track.track_start_time
     *
     * @mbg.generated
     */
    public Date getTrackStartTime() {
        return trackStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.track_file
     *
     * @return the value of track.track_file
     *
     * @mbg.generated
     */
    public String getTrackFile() {
        return trackFile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.trackCreator_id
     *
     * @return the value of track.trackCreator_id
     *
     * @mbg.generated
     */
    public Integer getTrackcreatorId() {
        return trackcreatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column track.track_content
     *
     * @return the value of track.track_content
     *
     * @mbg.generated
     */
    public String getTrackContent() {
        return trackContent;
    }
}