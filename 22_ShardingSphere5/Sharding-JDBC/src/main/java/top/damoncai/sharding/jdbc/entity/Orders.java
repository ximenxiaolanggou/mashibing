package top.damoncai.sharding.jdbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("orders")
public class Orders {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private Integer orderNo;
    private Integer userId;
    private Double amount;
}
