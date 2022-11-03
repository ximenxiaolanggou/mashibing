package top.damoncai.sharding.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.damoncai.sharding.jdbc.entity.Cycle;
import top.damoncai.sharding.jdbc.entity.Sensor;

import java.util.List;
import java.util.Map;

@Mapper
public interface CycleMapper extends BaseMapper<Cycle> {

}

