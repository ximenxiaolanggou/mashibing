package center.hellowrold.jvm.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class PiRuleNodeData {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 距离父节点顶端像素点
     */
    private Integer top;

    /**
     * 距离父节点左边像素点
     */
    private Integer left;

    /**
     * 识别文字的宽度
     */
    private Integer width;

    /**
     * 识别文字的高度
     */
    private Integer height;

    /**
     * 工艺识别规则ID
     */
    private Long piRuleId;

    /**
     * 值
     */
    private String val;



}
