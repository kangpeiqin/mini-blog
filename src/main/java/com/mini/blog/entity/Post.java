package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;


/**
 * <p>
 * 文章发布表
 * </p>
 *
 * @author generator
 * @since 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_post")
@ApiModel(value = "Post对象", description = "文章发布表 ")
public class Post extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题")
    @NotBlank(message = "title should not be empty")
    @Size(max = 100, message = "文章标题的字符长度不能超过 {max}")
    private String title;

    @ApiModelProperty(value = "文章简介")
    @NotBlank(message = "description should not be empty")
    private String description;

    @ApiModelProperty(value = "原始内容")
    @NotBlank(message = "content should not be empty")
    private String originalContent;

    @ApiModelProperty(value = "格式化内容")
    private String formatContent;

    @ApiModelProperty(value = "发布状态")
    @NotNull(message = "postStatus should not be empty")
    private Boolean postStatus;

    @ApiModelProperty(value = "封面图片")
    @NotBlank(message = "coverImage should not be empty")
    private String coverImage;

    @ApiModelProperty(value = "浏览次数")
    private Long browseTimes;

    @ApiModelProperty(value = "文章的所属的分类")
    @NotBlank(message = "分类id不能为空")
    private String categoryId;

    @ApiModelProperty(value = "是否允许被评论")
    @NotNull(message = "allowComment should not be empty")
    private Boolean allowComment;

    @ApiModelProperty(value = "文章是否被推荐")
    @NotNull(message = "recommend should not be empty")
    private Boolean recommend;

    @ApiModelProperty("文章标签")
    @TableField(exist = false)
    String tags;

    @ApiModelProperty("所属分类名称")
    @TableField(exist = false)
    String categoryName;

    public Integer getPostYear(LocalDate createTime) {
        return createTime.getYear();
    }

}
