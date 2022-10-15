package top.damoncai.sharding.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.damoncai.sharding.jdbc.entity.Orders;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}

