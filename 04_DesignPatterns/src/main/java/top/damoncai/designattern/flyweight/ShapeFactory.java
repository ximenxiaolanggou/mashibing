package top.damoncai.designattern.flyweight;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhishun.cai
 * @date 2021/1/25 13:57
 */

public class ShapeFactory {

    private static Map<String,Shape> shapeMap = new HashMap();

    public static Shape getShape(String color) {
        if(StringUtils.isBlank(color)) throw new RuntimeException("请传递颜色");
        for (String key : shapeMap.keySet()) {
            if (color.equals(key)) return shapeMap.get(key);
        }
        Shape shape = new Rectangle(color,10,10);
        System.out.println(color + " ==> 创建完成");
        shapeMap.put(color,shape);
        return shape;
    }
}
