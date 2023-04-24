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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PiRule {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 标识
     */
    private String code;

    /**
     * 索引位置用于排序
     */
    private Integer zindex;

    /**
     * 1 数据节点 0 非数据节点
     */
    private Integer dataNode;

    /**
     * 工艺识别配置ID
     */
    private Long piConfigId;

    /**
     * 父级ID 默认是0
     */
    private Long pid = 0L;

    /**
     * 子节点
     */
    public List<PiRule> children;

    /**
     * 节点数据VO对象集合
     */
    private List<PiRuleNodeData> piRuleNodeDatas;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 修改时间
     */
    private LocalDateTime updatetime;



}
