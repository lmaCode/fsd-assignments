package com.lipengwei.fsd.dto;

import java.util.Date;

public class TMentorCalendar {
    private String id;

    private String mentorId;

    private String mentorName;

    private Date trainingDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
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
        TMentorCalendar other = (TMentorCalendar) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMentorId() == null ? other.getMentorId() == null : this.getMentorId().equals(other.getMentorId()))
            && (this.getMentorName() == null ? other.getMentorName() == null : this.getMentorName().equals(other.getMentorName()))
            && (this.getTrainingDate() == null ? other.getTrainingDate() == null : this.getTrainingDate().equals(other.getTrainingDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMentorId() == null) ? 0 : getMentorId().hashCode());
        result = prime * result + ((getMentorName() == null) ? 0 : getMentorName().hashCode());
        result = prime * result + ((getTrainingDate() == null) ? 0 : getTrainingDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mentorId=").append(mentorId);
        sb.append(", mentorName=").append(mentorName);
        sb.append(", trainingDate=").append(trainingDate);
        sb.append("]");
        return sb.toString();
    }
}