package center.helloworld.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhishun.cai
 * @create 2023/8/28
 * @note 解析JWT
 */
public class Demo_02_ParseJWT {
    private static final String key = "!@#qwe$*&";

    private static final String token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTMxODk2MTgsImFnZSI6MTIsImp0aSI6IjEyMyIsInVzZXJuYW1lIjoiemhhbmdzYW4ifQ.mQ8_dvSa6HTVhzJgUWJL4TfW8Yx9m-6kwOxa5rcKmcQ";

    public static void main(String[] args) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
        DecodedJWT decodedJWT = null;

        try {
            decodedJWT = verifier.verify(token);
        } catch (SignatureVerificationException e) { // 签名算法异常
            e.printStackTrace();
        } catch (TokenExpiredException e) { // 令牌过期
            e.printStackTrace();
        } catch (AlgorithmMismatchException e) {// 算法不匹配
            e.printStackTrace();
        } catch (InvalidClaimException e) { // 失效的payload
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String username = decodedJWT.getClaim("username").asString();
        Integer age = decodedJWT.getClaim("age").asInt();
        String id = decodedJWT.getId();
        System.out.println("id: " + id);
        System.out.println("username: " + username);
        System.out.println("age: " + age);
    }
}
