package top.damoncai.sharding.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.damoncai.sharding.jdbc.entity.Mold;
import top.damoncai.sharding.jdbc.entity.Sensor;

import java.util.List;
import java.util.Map;

@Mapper
public interface SensorMapper extends BaseMapper<Sensor> {
    @Select({"SELECT * FROM molds mold LEFT JOIN products product ON mold.id = product.id LEFT JOIN cycles cycle ON cycle.pro_id = product.id left join sensors on sensors.cycle_id = cycle.id where mold.id = 1"})
    //@Select({"SELECT *  FROM products product LEFT JOIN cycles ON cycles.pro_id = product.id LEFT JOIN sensors ON sensors.cycle_id = cycles.id "})
    List<Map> getList();

    //@Select({"SELECT *  FROM mold LEFT JOIN product ON mold.id = product.id LEFT JOIN cycles ON cycles.pro_id = product.id LEFT JOIN sensors ON sensors.cycle_id = cycles.id"})
   // List<Map> getOrderByUser(Long id);


    @Select({"SELECT mold.des,count(cycle.id) FROM mold LEFT JOIN product ON mold.id = product.id LEFT JOIN cycles cycle ON cycle.pro_id = product.id left join sensors on sensors.cycle_id = cycle.id"})
        //@Select({"SELECT *  FROM products product LEFT JOIN cycles ON cycles.pro_id = product.id LEFT JOIN sensors ON sensors.cycle_id = cycles.id "})
    List<Map> getList2();


    @Select({"SELECT * FROM mold LEFT JOIN product ON mold.id = product.id LEFT JOIN cycles cycle ON cycle.pro_id = product.id left join sensors on sensors.cycle_id = cycle.id"})
        //@Select({"SELECT *  FROM products product LEFT JOIN cycles ON cycles.pro_id = product.id LEFT JOIN sensors ON sensors.cycle_id = cycles.id "})
    List<Map> getList3();

}

