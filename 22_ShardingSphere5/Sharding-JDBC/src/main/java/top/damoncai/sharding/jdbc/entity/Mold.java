package top.damoncai.sharding.jdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("molds")
public class Mold {
    private Long id;
    private String des;
}
