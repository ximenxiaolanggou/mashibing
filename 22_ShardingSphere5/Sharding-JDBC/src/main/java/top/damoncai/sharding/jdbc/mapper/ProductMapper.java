package top.damoncai.sharding.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.damoncai.sharding.jdbc.entity.Cycle;
import top.damoncai.sharding.jdbc.entity.Product;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}

