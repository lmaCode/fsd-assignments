package com.lipengwei.fsd.entity;

public class TPayment {
    private String id;

    private String trainingId;

    private String skillId;

    private String skillName;

    private String mentorId;

    private String mentorName;

    private Long amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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
        TPayment other = (TPayment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTrainingId() == null ? other.getTrainingId() == null : this.getTrainingId().equals(other.getTrainingId()))
            && (this.getSkillId() == null ? other.getSkillId() == null : this.getSkillId().equals(other.getSkillId()))
            && (this.getSkillName() == null ? other.getSkillName() == null : this.getSkillName().equals(other.getSkillName()))
            && (this.getMentorId() == null ? other.getMentorId() == null : this.getMentorId().equals(other.getMentorId()))
            && (this.getMentorName() == null ? other.getMentorName() == null : this.getMentorName().equals(other.getMentorName()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTrainingId() == null) ? 0 : getTrainingId().hashCode());
        result = prime * result + ((getSkillId() == null) ? 0 : getSkillId().hashCode());
        result = prime * result + ((getSkillName() == null) ? 0 : getSkillName().hashCode());
        result = prime * result + ((getMentorId() == null) ? 0 : getMentorId().hashCode());
        result = prime * result + ((getMentorName() == null) ? 0 : getMentorName().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", trainingId=").append(trainingId);
        sb.append(", skillId=").append(skillId);
        sb.append(", skillName=").append(skillName);
        sb.append(", mentorId=").append(mentorId);
        sb.append(", mentorName=").append(mentorName);
        sb.append(", amount=").append(amount);
        sb.append("]");
        return sb.toString();
    }
}