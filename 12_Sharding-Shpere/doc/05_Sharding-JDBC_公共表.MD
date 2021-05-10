# 公共表

1. 存储固定数据的表，表数据很少发生变化，查询时候经常进行关联
2. 在每个数据库中创建出相同结构公共表

### 步骤

1. 在所有库中创建相同的数据表结构

2. 添加配置文件

   ```properties
   spring.shardingsphere.sharding.broadcast-tables=t_udict 
   spring.shardingsphere.sharding.tables.t_udict.key-generator.column=dictid 
   spring.shardingsphere.sharding.tables.t_udict.key-generator.type=SNOWFLAKE
   ```

3. 测试

   ```java
   @Test
   public void addDict() {
       Dict dict = new Dict();
       dict.setValue("damoncai");
       dictMapper.insert(dict);
   }
   ```

   



