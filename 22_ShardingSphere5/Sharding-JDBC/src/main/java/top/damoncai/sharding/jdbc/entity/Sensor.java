package top.damoncai.sharding.jdbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("sensors")
public class Sensor {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String des;
    private Long cycleId;
    private Long proId;
    private Long moldId;
}
