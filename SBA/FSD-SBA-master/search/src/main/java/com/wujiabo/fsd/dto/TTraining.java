package com.lipengwei.fsd.dto;

import java.util.Date;

public class TTraining {
    private String id;

    private String skillId;

    private String skillName;

    private String mentorId;

    private String mentorName;

    private Long fees;

    private Date startDate;

    private Date endDate;

    private String status;

    private Integer progress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
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

    public Long getFees() {
        return fees;
    }

    public void setFees(Long fees) {
        this.fees = fees;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
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
        TTraining other = (TTraining) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSkillId() == null ? other.getSkillId() == null : this.getSkillId().equals(other.getSkillId()))
            && (this.getSkillName() == null ? other.getSkillName() == null : this.getSkillName().equals(other.getSkillName()))
            && (this.getMentorId() == null ? other.getMentorId() == null : this.getMentorId().equals(other.getMentorId()))
            && (this.getMentorName() == null ? other.getMentorName() == null : this.getMentorName().equals(other.getMentorName()))
            && (this.getFees() == null ? other.getFees() == null : this.getFees().equals(other.getFees()))
            && (this.getStartDate() == null ? other.getStartDate() == null : this.getStartDate().equals(other.getStartDate()))
            && (this.getEndDate() == null ? other.getEndDate() == null : this.getEndDate().equals(other.getEndDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getProgress() == null ? other.getProgress() == null : this.getProgress().equals(other.getProgress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSkillId() == null) ? 0 : getSkillId().hashCode());
        result = prime * result + ((getSkillName() == null) ? 0 : getSkillName().hashCode());
        result = prime * result + ((getMentorId() == null) ? 0 : getMentorId().hashCode());
        result = prime * result + ((getMentorName() == null) ? 0 : getMentorName().hashCode());
        result = prime * result + ((getFees() == null) ? 0 : getFees().hashCode());
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());
        result = prime * result + ((getEndDate() == null) ? 0 : getEndDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getProgress() == null) ? 0 : getProgress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", skillId=").append(skillId);
        sb.append(", skillName=").append(skillName);
        sb.append(", mentorId=").append(mentorId);
        sb.append(", mentorName=").append(mentorName);
        sb.append(", fees=").append(fees);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", status=").append(status);
        sb.append(", progress=").append(progress);
        sb.append("]");
        return sb.toString();
    }
}