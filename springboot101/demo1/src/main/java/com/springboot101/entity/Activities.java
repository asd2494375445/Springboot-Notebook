package com.springboot101.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @TableName activities
 */
@TableName(value ="activities")
@Data
@Builder
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
    private Integer areaId;

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


}