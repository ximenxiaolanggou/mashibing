package top.damoncai.sharding.jdbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("cycles")
public class Cycle {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private Long proId;
    private Long moldId;
}
