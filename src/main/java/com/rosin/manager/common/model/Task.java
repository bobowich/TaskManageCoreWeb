package com.rosin.manager.common.model;

import java.util.Date;

public class Task {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_id
     *
     * @mbg.generated
     */
    private Integer taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.subTask_num
     *
     * @mbg.generated
     */
    private Integer subtaskNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.taskCreator_id
     *
     * @mbg.generated
     */
    private Integer taskcreatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_start_time
     *
     * @mbg.generated
     */
    private Date taskStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_end_time
     *
     * @mbg.generated
     */
    private Date taskEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_progress
     *
     * @mbg.generated
     */
    private Integer taskProgress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.fatherTask_id
     *
     * @mbg.generated
     */
    private Integer fathertaskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_create_time
     *
     * @mbg.generated
     */
    private Date taskCreateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_state
     *
     * @mbg.generated
     */
    private Integer taskState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_finish_time
     *
     * @mbg.generated
     */
    private Date taskFinishTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_remark
     *
     * @mbg.generated
     */
    private Integer taskRemark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_archive
     *
     * @mbg.generated
     */
    private Integer taskArchive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_content
     *
     * @mbg.generated
     */
    private String taskContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbg.generated
     */
    public Task(Integer taskId, Integer subtaskNum, Integer taskcreatorId, Date taskStartTime, Date taskEndTime, Integer taskProgress, Integer fathertaskId, Date taskCreateTime, Integer taskState, Date taskFinishTime, Integer taskRemark, Integer taskArchive, String taskContent) {
        this.taskId = taskId;
        this.subtaskNum = subtaskNum;
        this.taskcreatorId = taskcreatorId;
        this.taskStartTime = taskStartTime;
        this.taskEndTime = taskEndTime;
        this.taskProgress = taskProgress;
        this.fathertaskId = fathertaskId;
        this.taskCreateTime = taskCreateTime;
        this.taskState = taskState;
        this.taskFinishTime = taskFinishTime;
        this.taskRemark = taskRemark;
        this.taskArchive = taskArchive;
        this.taskContent = taskContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_id
     *
     * @return the value of task.task_id
     *
     * @mbg.generated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.subTask_num
     *
     * @return the value of task.subTask_num
     *
     * @mbg.generated
     */
    public Integer getSubtaskNum() {
        return subtaskNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.taskCreator_id
     *
     * @return the value of task.taskCreator_id
     *
     * @mbg.generated
     */
    public Integer getTaskcreatorId() {
        return taskcreatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_start_time
     *
     * @return the value of task.task_start_time
     *
     * @mbg.generated
     */
    public Date getTaskStartTime() {
        return taskStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_end_time
     *
     * @return the value of task.task_end_time
     *
     * @mbg.generated
     */
    public Date getTaskEndTime() {
        return taskEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_progress
     *
     * @return the value of task.task_progress
     *
     * @mbg.generated
     */
    public Integer getTaskProgress() {
        return taskProgress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.fatherTask_id
     *
     * @return the value of task.fatherTask_id
     *
     * @mbg.generated
     */
    public Integer getFathertaskId() {
        return fathertaskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_create_time
     *
     * @return the value of task.task_create_time
     *
     * @mbg.generated
     */
    public Date getTaskCreateTime() {
        return taskCreateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_state
     *
     * @return the value of task.task_state
     *
     * @mbg.generated
     */
    public Integer getTaskState() {
        return taskState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_finish_time
     *
     * @return the value of task.task_finish_time
     *
     * @mbg.generated
     */
    public Date getTaskFinishTime() {
        return taskFinishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_remark
     *
     * @return the value of task.task_remark
     *
     * @mbg.generated
     */
    public Integer getTaskRemark() {
        return taskRemark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_archive
     *
     * @return the value of task.task_archive
     *
     * @mbg.generated
     */
    public Integer getTaskArchive() {
        return taskArchive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_content
     *
     * @return the value of task.task_content
     *
     * @mbg.generated
     */
    public String getTaskContent() {
        return taskContent;
    }
}