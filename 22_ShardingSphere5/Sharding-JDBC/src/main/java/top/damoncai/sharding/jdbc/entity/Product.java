package top.damoncai.sharding.jdbc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("products")
public class Product {
    private Long id;
    private String str;
    private Long moldId;
}
