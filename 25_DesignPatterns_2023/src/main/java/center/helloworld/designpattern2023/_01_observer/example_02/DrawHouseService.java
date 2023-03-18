package center.helloworld.designpattern2023._01_observer.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note 摇号服务
 */
public class DrawHouseService {

    //摇号抽签
    public String lots(Long uId){
        if(uId.hashCode() % 2 == 0){
            return "中签";
        }else{
            return "未中签";
        }
    }
}
