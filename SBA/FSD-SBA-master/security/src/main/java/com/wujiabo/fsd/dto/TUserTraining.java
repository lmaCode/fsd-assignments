package com.lipengwei.fsd.dto;

public class TUserTraining {
    private String id;

    private String userId;

    private String userName;

    private String mentorId;

    private String mentorName;

    private String trainingId;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TUserTraining other = (TUserTraining) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getMentorId() == null ? other.getMentorId() == null : this.getMentorId().equals(other.getMentorId()))
            && (this.getMentorName() == null ? other.getMentorName() == null : this.getMentorName().equals(other.getMentorName()))
            && (this.getTrainingId() == null ? other.getTrainingId() == null : this.getTrainingId().equals(other.getTrainingId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getMentorId() == null) ? 0 : getMentorId().hashCode());
        result = prime * result + ((getMentorName() == null) ? 0 : getMentorName().hashCode());
        result = prime * result + ((getTrainingId() == null) ? 0 : getTrainingId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", mentorId=").append(mentorId);
        sb.append(", mentorName=").append(mentorName);
        sb.append(", trainingId=").append(trainingId);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}