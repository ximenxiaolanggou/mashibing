package center.helloworld.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhishun.cai
 * @create 2023/8/28
 * @note 创建JWT
 */
public class Demo_01_CreateJWT {
    private static final String key = "!@#qwe$*&";

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 60);

        /**
         * header可以不写有默认值
         * payload 通常⽤来存放⽤⼾信息
         * signature 是前两个合起来的签名值
         */
        JWTCreator.Builder jwtBuilder = JWT.create();
        jwtBuilder.withHeader(map);
        jwtBuilder.withClaim("username", "zhangsan");
        jwtBuilder.withClaim("age", 12);
        jwtBuilder.withJWTId("123");
        // 设置过期时间
        jwtBuilder.withExpiresAt(instance.getTime());

        // 设置签名
        String sign = jwtBuilder.sign(Algorithm.HMAC256(key));
        System.out.println(sign);
    }
}
