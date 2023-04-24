package center.hellowrold.jvm.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class PiImg  {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 原始文件名称
     */
    private String orgName;

    /**
     * 现在文件名
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;


}
