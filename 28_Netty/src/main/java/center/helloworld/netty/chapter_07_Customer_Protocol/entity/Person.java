package center.helloworld.netty.chapter_07_Customer_Protocol.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person implements Serializable {

    private String name;

    private Integer age;
}
