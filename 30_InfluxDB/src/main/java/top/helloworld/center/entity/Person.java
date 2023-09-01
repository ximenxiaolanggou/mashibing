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
@Measurement(name = "person")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    /**
     * 性别
     */
    @Column(tag = true)
    private String gender;

    /**
     * 用户名
     */
    @Column
    private String name;

    /**
     * 年龄
     */
    @Column
    private Integer age;

    /**
     * 时间戳
     */
    @Column(timestamp = true)
    private Instant timestamp;
}
