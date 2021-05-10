# 读写分离

### 配置数据库的主从复制

### 配置文件

```properties
# 配置从服务器数据源
spring.shardingsphere.datasource.s0.type=com.alibaba.druid.pool.DruidDataSource 
spring.shardingsphere.datasource.s0.driver-class-name=com.mysql.cj.jdbc.Driver 
spring.shardingsphere.datasource.s0.url=jdbc:mysql://localhost:3307/user_db?serverTimezone=GMT%2B8 
spring.shardingsphere.datasource.s0.username=root
spring.shardingsphere.datasource.s0.password=root

# 主库从库逻辑数据源定义 ds0 为 user_db
spring.shardingsphere.sharding.master-slave-rules.ds0.master-data-source-name=m0 
spring.shardingsphere.sharding.master-slave-rules.ds0.slave-data-source-names=s0

# 配置 user_db 数据库里面 t_user 专库专表
#spring.shardingsphere.sharding.tables.t_user.actual-data-nodes=m$->{0}.t_user
# t_user 分表策略，固定分配至 ds0 的 t_user 真实表
spring.shardingsphere.sharding.tables.t_user.actual-data-nodes=ds0.t_user
```

### 测试

```java
//添加操作
@Test
public void addUserDb() {
 User user = new User();
 user.setUsername("lucymary");
 user.setUstatus("a");
 userMapper.insert(user);
}
//查询操作
@Test
public void findUserDb() {
 QueryWrapper<User> wrapper = new QueryWrapper<>();
 //设置 userid 值
 wrapper.eq("user_id",465508031619137537L);
 User user = userMapper.selectOne(wrapper);
 System.out.println(user);
}
```

