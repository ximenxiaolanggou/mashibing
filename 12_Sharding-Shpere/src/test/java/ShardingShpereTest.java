import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.damoncai.shardingshpere.App;
import top.damoncai.shardingshpere.entity.Course;
import top.damoncai.shardingshpere.entity.Dict;
import top.damoncai.shardingshpere.entity.User;
import top.damoncai.shardingshpere.mapper.CourseMapper;
import top.damoncai.shardingshpere.mapper.DictMapper;
import top.damoncai.shardingshpere.mapper.UserMapper;

/**
 * @author zhishun.cai
 * @date 2021/4/16 15:52
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ShardingShpereTest {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DictMapper dictMapper;

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setName("数学" + i);
            courseMapper.insert(course);
        }
    }

    @Test
    public void insert2() {

        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setName("数学" + i);
            course.setUserId(Long.valueOf(i));
            courseMapper.insert(course);
        }
    }


    @Test
    public void insertUser() {

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("数学" + i);
            user.setAge(i);
            userMapper.insert(user);
        }
    }

    @Test
    public void addDict() {
        Dict dict = new Dict();
        dict.setValue("damoncai");
        dictMapper.insert(dict);
    }

    @Test
    public void selectDict() {
        dictMapper.selectById(1384106507213279234L);
    }

    @Test
    public void deleteDict() {
        dictMapper.deleteById(1384106507213279234L);
    }
}
