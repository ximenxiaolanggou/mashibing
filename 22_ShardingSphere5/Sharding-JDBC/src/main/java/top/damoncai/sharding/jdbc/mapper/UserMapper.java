package top.damoncai.sharding.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.damoncai.sharding.jdbc.entity.Orders;
import top.damoncai.sharding.jdbc.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}

