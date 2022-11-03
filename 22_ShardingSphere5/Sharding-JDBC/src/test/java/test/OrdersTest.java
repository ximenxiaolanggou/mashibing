package test;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import top.damoncai.sharding.jdbc.App;
import top.damoncai.sharding.jdbc.entity.Cycle;
import top.damoncai.sharding.jdbc.entity.Mold;
import top.damoncai.sharding.jdbc.entity.Product;
import top.damoncai.sharding.jdbc.entity.Sensor;
import top.damoncai.sharding.jdbc.mapper.CycleMapper;
import top.damoncai.sharding.jdbc.mapper.MoldMapper;
import top.damoncai.sharding.jdbc.mapper.ProductMapper;
import top.damoncai.sharding.jdbc.mapper.SensorMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class OrdersTest {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CycleMapper cycleMapper;

    @Autowired
    private SensorMapper sensorMapper;

    @Autowired
    private MoldMapper moldMapper;


    @Test
    public void add() {

        List<Long> moldIds = Arrays.asList(1L, 2L);
        for (Long moldId : moldIds) {
            Mold mold = new Mold();
            mold.setDes("mold" + moldId);
            mold.setId(moldId);
            moldMapper.insert(mold);


            Product product = new Product();
            product.setId(moldId);
            product.setMoldId(moldId);
            product.setStr("产品" + moldId);
            productMapper.insert(product);
            // 周期
            for (int i = 0; i < 2; i++) {
                Cycle cycle = new Cycle();
                cycle.setName("周期" + i);
                cycle.setProId(moldId);
                cycle.setMoldId(moldId);
                cycleMapper.insert(cycle);

                // 传感器
                for (int j = 0; j < 2; j++) {
                    Sensor sensor = new Sensor();
                    sensor.setDes(j == 0 ? "温度" : "压力");
                    sensor.setProId(moldId);
                    sensor.setCycleId(cycle.getId());
                    sensor.setMoldId(moldId);
                    sensorMapper.insert(sensor);
                }
            }
        }
    }

    @Test
    public void list() {
        List<Map> maps = sensorMapper.getList();
        for (Map map : maps) {
            System.out.println(map);
        }
    }

    @Test
    public void add2() {

        List<Long> proIds = Arrays.asList(1L, 2L);
        // 周期

        for (Long proId : proIds) {
            Cycle cycle = new Cycle();
            cycle.setName("周期" + proId);
            cycle.setProId(proId);
            cycleMapper.insert(cycle);

            // 传感器
            for (int j = 0; j < 2; j++) {
                Sensor sensor = new Sensor();
                sensor.setDes(j == 0 ? "温度" : "压力");
                sensor.setProId(proId);
                sensor.setCycleId(cycle.getId());
                sensorMapper.insert(sensor);
            }
        }
    }

    @Test
    public void list2() {
//        List<Map> maps = sensorMapper.getList2();
//        for (Map map : maps) {
//            System.out.println(map);
//        }

        List<Map> maps2 = sensorMapper.getList3();
        for (Map map : maps2) {
            System.out.println(map);
        }

    }
}
