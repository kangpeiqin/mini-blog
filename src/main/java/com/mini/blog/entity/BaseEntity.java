package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@ApiModel(value = "实体类公共字段", description = "实体类公共字段")
public class BaseEntity implements Serializable {

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "create_time", fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTime;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateTime;
}
