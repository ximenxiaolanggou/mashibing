package top.helloworld.center.entity;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author zhishun.cai
 * @create 2023/8/7
 * @note
 */

@Data
@Measurement(name = "cycle")
@AllArgsConstructor
@NoArgsConstructor
public class Cycle {

    @Column(tag = true)
    private String mold_id;

    @Column(tag = true)
    private String pro_id;

    @Column
    private int id;

    @Column
    private int cycle_num;

    @Column
    private int sensor_number;

    @Column
    private Long cycleTimestamp;

    /**
     * 时间戳
     */
    @Column(timestamp = true)
    private Instant timestamp;
}
