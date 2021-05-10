package top.damoncai.shardingshpere.entity;

import lombok.Data;

/**
 * @author zhishun.cai
 * @date 2021/4/16 14:28
 */

@Data
public class Course {
    private Long cid;

    private String name;

    private Long userId;
}
