package center.hellowrold.jvm.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhishun.cai
 * @since 2023-02-27
 */
@Data
public class PiConfig {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 注塑机品牌
     */
    private Long immBrandId;

    /**
     * 注塑机型号
     */
    private String immModel;

    /**
     * 注塑机吨位
     */
    private Integer immTonnage;

    /**
     * 添加的用户ID
     */
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 注塑机品牌名称
     */
    private String immBrandName;

    /**
     * 工艺识别规则对象集合
     */
    private List<PiRule> piRules;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;



}
