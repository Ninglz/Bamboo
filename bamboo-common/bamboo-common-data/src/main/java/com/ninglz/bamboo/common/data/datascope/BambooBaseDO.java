package com.ninglz.bamboo.common.data.datascope;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @description: 领域模型基类
 * @author ninglz
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Data
public class BambooBaseDO<T extends BambooBaseDO<?>> extends Model<T> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private String id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


    /**
     * 删除标记：1:已删除,0:正常
     */
    @TableLogic
    private String active;
}
