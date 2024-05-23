package com.springboot101.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName activities
 */
@TableName(value ="activities")
@Data
public class Activities implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Integer actState;

    /**
     * 
     */
    private String actStateText;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Object areaId;

    /**
     * 
     */
    private String areaName;

    /**
     * 
     */
    private String coverUrl;

    /**
     * 
     */
    private Integer currentStage;

    /**
     * 
     */
    private Date endTime;

    /**
     * 
     */
    private Integer foyer;

    /**
     * 
     */
    private Date maxApplyEndTime;

    /**
     * 
     */
    private Date minApplyStartTime;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Long stagesId;

    /**
     * 
     */
    private Date startTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        Activities other = (Activities) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActState() == null ? other.getActState() == null : this.getActState().equals(other.getActState()))
            && (this.getActStateText() == null ? other.getActStateText() == null : this.getActStateText().equals(other.getActStateText()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()))
            && (this.getCoverUrl() == null ? other.getCoverUrl() == null : this.getCoverUrl().equals(other.getCoverUrl()))
            && (this.getCurrentStage() == null ? other.getCurrentStage() == null : this.getCurrentStage().equals(other.getCurrentStage()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getFoyer() == null ? other.getFoyer() == null : this.getFoyer().equals(other.getFoyer()))
            && (this.getMaxApplyEndTime() == null ? other.getMaxApplyEndTime() == null : this.getMaxApplyEndTime().equals(other.getMaxApplyEndTime()))
            && (this.getMinApplyStartTime() == null ? other.getMinApplyStartTime() == null : this.getMinApplyStartTime().equals(other.getMinApplyStartTime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStagesId() == null ? other.getStagesId() == null : this.getStagesId().equals(other.getStagesId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActState() == null) ? 0 : getActState().hashCode());
        result = prime * result + ((getActStateText() == null) ? 0 : getActStateText().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        result = prime * result + ((getCoverUrl() == null) ? 0 : getCoverUrl().hashCode());
        result = prime * result + ((getCurrentStage() == null) ? 0 : getCurrentStage().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getFoyer() == null) ? 0 : getFoyer().hashCode());
        result = prime * result + ((getMaxApplyEndTime() == null) ? 0 : getMaxApplyEndTime().hashCode());
        result = prime * result + ((getMinApplyStartTime() == null) ? 0 : getMinApplyStartTime().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStagesId() == null) ? 0 : getStagesId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actState=").append(actState);
        sb.append(", actStateText=").append(actStateText);
        sb.append(", address=").append(address);
        sb.append(", areaId=").append(areaId);
        sb.append(", areaName=").append(areaName);
        sb.append(", coverUrl=").append(coverUrl);
        sb.append(", currentStage=").append(currentStage);
        sb.append(", endTime=").append(endTime);
        sb.append(", foyer=").append(foyer);
        sb.append(", maxApplyEndTime=").append(maxApplyEndTime);
        sb.append(", minApplyStartTime=").append(minApplyStartTime);
        sb.append(", name=").append(name);
        sb.append(", stagesId=").append(stagesId);
        sb.append(", startTime=").append(startTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}