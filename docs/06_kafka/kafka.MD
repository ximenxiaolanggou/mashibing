# 第一章：初识Kafka

### 1.1 Kafka和MQ场景

平台提供消息的订阅与发布功能的消息队列

主要用于系统之间解耦、异步通信和削峰填谷

- 消息队列Message Queue
- Kafka Streaming 流处理

### 1.2 Kafka架构剖析
- 消息队列工作模式
  - 至多消费一次
  - 多次消费

![](D:\西门小狼狗\4.MyGitHub\mashibing\images\1-1.jpg)

- 集群架构

![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-2.jpg)

- 分区和日志

  ![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-3.jpg)

  1. kafka只能保证单个分区顺序
  2. 要想保证数据消费顺序，可以将partition设置为1，但是就实现不了kafka的高吞吐量

- 消费者

  ![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-4.jpg)

  1. 每个消费者自己维护消费指针(偏移量)
  2. partition越多，吞吐量越大

- 顺序写入&MMF

  ![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-5.jpg)

- Zero提高读取时间


# 第二章：安装部署

### 2.1 单机/集群环境搭建

#### 单机

- JDK安装
- zookeeper安装
- kafka配置
  1. broker：每个kfaka的唯一表示
  2. listeners：监听，主机名：端口
  3. log.dir：存储日志
  4. zookeeper.connect：连接参数，主机名：端口
- 基本命令
  1. 启动命令：./bin/kafka-server-start.sh -daemon config/server.properties 
  2. 创建topic：./bin/kafka-topics.sh --bootstrap-server master:9092 --create --topic topic1 --partitions 3 --replication-factor 1
  3. 创建消费者：./bin/kafka-console-consumer.sh --bootstrap-server master:9092 --topic topic1 --group group1
  4. 创建生产者：./bin/kafka-console-producer.sh --broker-list master:9092 --topic topic1

#### 集群

- 安装JDK (RPM举例：rpm -ivh jdk-8u191-linux-x64.rpm )

- 修改配置文件：vim ~/.bashrc 

  ```
  JAVA_HOME=/usr/java/latest
  PATH=$PATH:$JAVA_HOME/bin
  CLASSPATH=.
  export JAVA_HOME
  export PATH
  export CLASSPATH
  ```

- 刷新配置文件：source ~/.bashrc 

- 采用ntp实现时间同步

  1. yum install ntp
  2. ntpdate cn.pool.ntp.org | ntp[1-7].aliyun.com

- 安装zookeeper集群

  1. 修改zoo.cnf文件

     ```
     #1.添加集群配置
     server.1=master:2888:3888
     server.2=node1:2888:3888
     server.3=node2:2888:3888
     ```

    2.修改数据目录

  ```
  dataDir=/home/zkData
  ```

  3. 分发文件

     ```
  scp -r zookeeper-3.4.6/ node1:/home/
  scp -r zookeeper-3.4.6/ node2:/home/
     ```
  4. 创建数目录

    ```
  mkdir /home/zkData
    ```
  5. 在数据目录中创建myid文件，并将服务节点标识写入其中(每台zookeeper都需创建修改)

  ```
  cd /home/zkData
  echo 1 > myid
  ```

- 配置Kafka

  1. broker：每个kfaka的唯一表示
  2. listeners：监听，主机名：端口
  3. zookeeper.connect：连接参数，主机名：端口(改为集群：zookeeper.connect=master:2181,node1:2181,node2:2181)
  
- 集群操作

  1. 创建

     ```java
     ./bin/kafka-topics.sh 
                         --bootstrap-server CentOSA:9092,CentOSB:9092,CentOSC:9092 
                         --create 
                         --topic topic02 
                         --partitions 3 
                         --replication-factor 3
     ```

    2.查看

  ```java
  ./bin/kafka-topics.sh  --bootstrap-server CentOSA:9092,CentOSB:9092,CentOSC:9092 
  			           --list
  ```

  3. 详情

  ```java
  ./bin/kafka-topics.sh 
                      --bootstrap-server CentOSA:9092,CentOSB:9092,CentOSC:9092 
                      --describe 
                      --topic topic01
  ```

  4.修改

  ```java
   ./bin/kafka-topics.sh 
                      --bootstrap-server CentOSA:9092,CentOSB:9092,CentOSC:9092 
                      --create 
                      --topic topic03 
                      --partitions 1 
                      --replication-factor 1
                          
   ./bin/kafka-topics.sh 
                      --bootstrap-server CentOSA:9092,CentOSB:9092,CentOSC:9092 
                      --alter 
                      --topic topic03 
                      --partitions 2
  ```

  5.删除

  ```java
  ./bin/kafka-topics.sh 
                      --bootstrap-server CentOSA:9092,CentOSB:9092,CentOSC:9092 
                      --delete 
                      --topic topic03
  ```

  6.订阅

  ```java
  ./bin/kafka-console-consumer.sh 
                    --bootstrap-server CentOSA:9092,CentOSB:9092,CentOSC:9092 
                    --topic topic01 
                    --group g1 
                    --property print.key=true 
                    --property print.value=true 
                    --property key.separator=,
  ```

  7.生产

  ```java
  ./bin/kafka-console-producer.sh 
                    --broker-list CentOSA:9092,CentOSB:9092,CentOSC:9092 
                    --topic topic01
  ```

  

### 2.2 常见脚本命令使用

# 第三章：Kafka基础API

### 3.1 topic的基本操作DML管理 

```java
@Slf4j
public class TopicDMLDemo {
    KafkaAdminClient adminClient = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        adminClient = (KafkaAdminClient) KafkaAdminClient.create(props);
    }

    /**
     * 释放资源
     */
    @After
    public void after() {
        if(null != adminClient) adminClient.close();
    }

    /**
     * topic列表
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void topicList() throws ExecutionException, InterruptedException {
        ListTopicsResult topics = adminClient.listTopics();
        KafkaFuture<Set<String>> nameFutures = topics.names();
        for (String name : nameFutures.get()) {
            System.out.println(name);
        }
    }

    /**
     * 创建topic
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void create() throws ExecutionException, InterruptedException {
        List<NewTopic> newTopics = Arrays.asList(new NewTopic("topic04", 2, (short) 3));
        CreateTopicsResult createTopicsResult = adminClient.createTopics(newTopics);
        /**
         * 创建Topic是异步的
         * 添加createTopicsResult.all().get()可以改为同步创建Topic
         */
        createTopicsResult.all().get();
        log.info("创建Topic成功");
    }

    /**
     * 删除topic
     */
    @Test
    public void delete(){
        adminClient.deleteTopics(Arrays.asList("topic03","topic04"));
        log.info("删除Topic成功");
    }

    /**
     * topic详情
     */
    @Test
    public void describeTopics() throws ExecutionException, InterruptedException {
        DescribeTopicsResult describeTopics = adminClient.describeTopics(Arrays.asList("topic03"));
        Map<String, TopicDescription> tdm = describeTopics.all().get();
        for (Map.Entry<String, TopicDescription> entry : tdm.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
```

### 3.2 生产者/消费者代码

#### 生产者

```java
public class Producer {

    KafkaProducer<String, String> producer = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        producer = new KafkaProducer<String, String>(props);
    }

    /**
     * 释放资源
     */
    @After
    public void after() {
        if(null != producer) producer.close();
    }

    @Test
    public void producer() throws InterruptedException {
        for(int i = 0 ; i < 10 ; i++) {
            Thread.sleep(100);
            ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("topic02","key" + i,"value" + i);
            producer.send(producerRecord);
        }
    }
}
```

#### 消费者

```java
public class Consumer {

    KafkaConsumer<String, String> consumer = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        //连接参数
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"group02");

        //创建Topic消费者
        consumer = new KafkaConsumer<String, String>(props);
    }

    /**
     * 释放资源
     */
    @After
    public void after() {
        if(null != consumer) consumer.close();
    }

    @Test
    public void consumer() {
        //订阅Topic开头的消息队列
        consumer.subscribe(Pattern.compile("^topic.*$"));

        while (true) {
            //每隔一秒拉取一次数据
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            Iterator<ConsumerRecord<String, String>> recordIterator = consumerRecords.iterator();
            while (recordIterator.hasNext()) {
                ConsumerRecord<String, String> record = recordIterator.next();
                String key = record.key();
                String value = record.value();
                long offset = record.offset();
                int partition = record.partition();
                System.out.println("key：" + key + ",value：" + value + ",offset：" + offset + ",partition：" + partition);
            }
        }
    }
}
```

### 3.4  消息定义分区策略

##### 实现Partitioner接口重写方法

```
public class UserDefinedPartitioner implements Partitioner {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    public int partition(String topic, Object o, byte[] keyBytes, Object o1, byte[] bytes1, Cluster cluster) {
        //自定义分区规则
        int numPartitions = cluster.partitionsForTopic(topic).size();
        if(keyBytes==null || keyBytes.length==0){
            return atomicInteger.addAndGet(1) & Integer.MAX_VALUE% numPartitions;
        } else {
            return Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
        }
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("============================== Configure ==============================");
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
        System.out.println("============================== End ==============================");
    }
}
```

##### 生产者设置自定义分区

```java
props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,UserDefinedPartitioner.class.getName());
```

### 3.4 消息序列化

##### 自定义序列化和反序列化

```java
public class ObjectSerializer implements Serializer<Object> {
    @Override
    public void configure(Map<String, ?> map, boolean b) {
        System.out.println("configure");
    }

    @Override
    public byte[] serialize(String topic, Object data) {
        return SerializationUtils.serialize((Serializable) data);
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
```

```java
public class ObjectDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        System.out.println("configure");
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        return SerializationUtils.deserialize(data);
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
```

##### 生产者和消费者设置value序列化规则

```java
props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,ObjectSerializer.class.getName());
```

```java
props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,ObjectDeserializer.class.getName());
```

##### 传输对象实现Serializable接口

```java
public class User implements Serializable {

    private String name;

    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
```

### 3.5 自定义拦截器

##### 自定义生产者拦截器

```java
public class UserDefinedProducerInterceptor implements ProducerInterceptor {
    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        ProducerRecord producerRecord = new ProducerRecord(record.topic(), record.key(), record.value() + "782099197@qq.com");
        return producerRecord;
    }

    /**
     * 无论是正确还是异常都会进入该方法
     * @param recordMetadata
     * @param e
     */
    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        System.out.println("metadata:"+recordMetadata+",exception:"+e);
    }

    @Override
    public void close() {
        System.out.println("close");
    }

    @Override
    public void configure(Map<String, ?> map) {
        System.out.println("configure");
    }
}
```

##### 添加生产者拦截器

```java
props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,UserDefinedProducerInterceptor.class.getName());
```



# 第四章：Kafka API高级特性

### 4.1 偏移量(offset)控制

- 自动提交

不存在偏移量的时候offset配置策略

auto.offset.reset = latest | earliest | none

```java
props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
```

- 自动提交 + 提交时间

```java
props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,10000);
```

- 手动提交

1. 设置为非自动提交

  ```java
//取消自动提交
props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
  ```

2. 手动提交

```java
/**
    * key：TopicPartition topic + 分区
     * value：OffsetAndMetadata offset偏移量信息
*/

 Map<TopicPartition, OffsetAndMetadata> offsets=new HashMap<TopicPartition, OffsetAndMetadata>();
                
    /**
        * 注意：提交的位置为下一个消费的位置
   */
   offsets.put(new TopicPartition(record.topic(),record.partition()),new OffsetAndMetadata(record.offset() + 1));

   consumer.commitAsync(offsets,new OffsetCommitCallback() {
         @Override
        public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
            System.out.println("提交成功！");
       }
});
```

### 4.2 ACK和Retries（存在数据重复问题）

Kafka生产者在发送完一个的消息之后，要求Broker在规定的额时间Ack应答答，如果没有在规定时间内应答，Kafka生产者会尝试n次重新发送消息。

**acks=1 默认**

1. acks=1 - Leader会将Record写到其本地日志中，但会在不等待所有Follower的完全确认的情况下做出响应。在这种情况下，如果Leader在确认记录后立即失败，但在Follower复制记录之前失败，则记录将丢失。
2. acks=0 - 生产者根本不会等待服务器的任何确认。该记录将立即添加到套接字缓冲区中并视为已发送。在这种情况下，不能保证服务器已收到记录。
3. acks=all - 这意味着Leader将等待全套同步副本确认记录。这保证了只要至少一个同步副本仍处于活动状态，记录就不会丢失。这是最有力的保证。这等效于acks = -1设置。
4. request.timeout.ms = 30000  默认
   retries = 2147483647 默认
5. 存在数据重复问题

![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-6.jpg)

### 4.3 幂等性

Kafka在0.11.0.0版本支持增加了对幂等的支持。幂等是针对生产者角度的特性。幂等可以保证上生产者发送的消息，不会丢失，而且不会重复。实现幂等的关键点就是服务端可以区分请求是否重复，过滤掉重复的请求。要区分请求是否重复的有两点：

1. 唯一标识：要想区分请求是否重复，请求中就得有唯一标识。例如支付请求中，订单号就是唯一标识
2. 记录下已处理过的请求标识：光有唯一标识还不够，还需要记录下那些请求是已经处理过的，这样当收到新的请求时，用新请求中的标识和处理记录进行比较，如果处理记录中有相同的标识，说明是重复记录，拒绝掉。

幂等又称为exactly once。要停止多次处理消息，必须仅将其持久化到Kafka Topic中仅仅一次。在初始化期间，kafka会给生产者生成一个唯一的ID称为Producer ID或PID。

PID和序列号与消息捆绑在一起，然后发送给Broker。由于序列号从零开始并且单调递增，因此，仅当消息的序列号比该PID / TopicPartition对中最后提交的消息正好大1时，Broker才会接受该消息。如果不是这种情况，则Broker认定是生产者重新发送该消息。

**注意**

enable.idempotence= false 默认 需要置为true

在使用幂等性的时候，要求必须开启retries=true和acks=all

**生产者幂等性配置**

```java
// ACKS 设置为all
props.put(ProducerConfig.ACKS_CONFIG,"all");
//尝试次数设置3 一共四次
props.put(ProducerConfig.RETRIES_CONFIG,3);
//问答时间设置为1ms(测试)
props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,1);

//开启kafka幂等性
props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
//设置阻塞等待数量 设置为 1 确保顺序
props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,1);
```

![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-7.jpg)

### 4.4事务控制

Kafka的幂等性，只能保证一条记录的在分区发送的原子性，但是如果要保证多条记录（多分区）之间的完整性，这个时候就需要开启kafk的事务操作。

在Kafka0.11.0.0除了引入的幂等性的概念，同时也引入了事务的概念。通常Kafka的事务分为 生产者事务Only、消费者&生产者事务。一般来说默认消费者消费的消息的级别是read_uncommited数据，这有可能读取到事务失败的数据，所有在开启生产者事务之后，需要用户设置消费者的事务隔离级别。

isolation.level	=  read_uncommitted 默认

该选项有两个值read_committed|read_uncommitted，如果开始事务控制，消费端必须将事务的隔离级别设置为read_committed

开启的生产者事务的时候，只需要指定transactional.id属性即可，一旦开启了事务，默认生产者就已经开启了幂等性。但是要求"transactional.id"的取值必须是唯一的，同一时刻只能有一个"transactional.id"存储在，其他的将会被关闭。

##### 生产者事务

**描述**

![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-8.jpg)

1. 生产者设置

```JAVA
public class Producer {

    KafkaProducer<String, String> producer = null;

    /**
     * 创建kafka客户端
     */
    @Before
    public void before() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"master:9092,node1:9092,node2:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        // ACKS 设置为all
        props.put(ProducerConfig.ACKS_CONFIG,"all");
        //尝试次数设置3 一共四次（可以去掉使用默认）
        props.put(ProducerConfig.RETRIES_CONFIG,3);
        //问答时间设置为1ms(测试)
        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,20000);

        //开启kafka幂等性
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG,true);
        //设置阻塞等待数量 设置为 1 确保顺序
        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION,1);

        //配置kafka批处理大小
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,1024);
        //等待5ms如果batch中的数据不足1024大小
        props.put(ProducerConfig.LINGER_MS_CONFIG,5);

        //必须配置事务ID，必须是唯一的
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"transaction-id " + UUID.randomUUID().toString());

        producer = new KafkaProducer<String, String>(props);
    }

    /**
     * 释放资源
     */
    @After
    public void after() {
        if(null != producer) producer.close();
    }

    @Test
    public void producer() throws InterruptedException {
        producer.initTransactions();
        try {
            producer.beginTransaction();
            for(int i = 0 ; i < 5 ; i++) {
                if(i == 3) throw new RuntimeException("出错啦~~");
                ProducerRecord<String,String> producerRecord = new ProducerRecord<String,String>("topic02","acks" + 1,"test acks");
                producer.send(producerRecord);
                producer.flush();
            }
        producer.commitTransaction();
        }catch (Exception e) {
            System.err.println("出现错误");
            producer.abortTransaction();
        }
    }
}
```

2. 消费者设置(设置读已提交配置)

```java
props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG,"read_committed");
```

##### 生产者和消费者事务

![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-9.jpg)



# 第五章：Kafka架构进阶

### 5.1 Kafka数据同步机制

### 5.2 Kafka eagle监控

- 解压文件

- 配置环境变量

  ```shell
  vim ~/.bashrc
  # 添加
  KE_HOME=/home/kafka-eagle
  # 刷新配置文件
  source ~/.bashrc
  ```

- 修改配置文件 conf/system-config.properties

  ```java
  kafka.eagle.zk.cluster.alias=cluster1
  cluster1.zk.list=master:2181,node1:2181,node2:2181
  #cluster2.zk.list=xdn10:2181,xdn11:2181,xdn12:2181
      
  kafka.eagle.metrics.charts=true
      
  cluster1.kafka.eagle.sasl.enable=false
  cluster1.kafka.eagle.sasl.protocol=SASL_PLAINTEXT
  cluster1.kafka.eagle.sasl.mechanism=SCRAM-SHA-256
  cluster1.kafka.eagle.sasl.jaas.config=org.apache.kafka.common.security.scram.ScramLoginModule required username="kafka" password="kafka-eagle";
  cluster1.kafka.eagle.sasl.client.id=
  
  #cluster2.kafka.eagle.sasl.enable=false
  #cluster2.kafka.eagle.sasl.protocol=SASL_PLAINTEXT
  #cluster2.kafka.eagle.sasl.mechanism=PLAIN
  #cluster2.kafka.eagle.sasl.jaas.config=org.apache.kafka.common.security.plain.PlainLoginModule required username="kafka" password="kafka-eagle";
  #cluster2.kafka.eagle.sasl.client.id=
  
  ```

- 修改每台kafka启动文件 kafka-server-start.sh

```shell
vi kafka-server-start.sh
...
if [ "x$KAFKA_HEAP_OPTS" = "x" ]; then
    export KAFKA_HEAP_OPTS="-server -Xms2G -Xmx2G -XX:PermSize=128m -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:ParallelGCThreads=8 -XX:ConcGCThreads=5 -XX:InitiatingHeapOccupancyPercent=70"
    export JMX_PORT="9999"
    #export KAFKA_HEAP_OPTS="-Xmx1G -Xms1G"
fi
```

- 修改数据库连接信息

### 5.3 Flume eagle 监控

### 5.4 Spring Boot集成Kafka

##### 配置文件

```yml
spring:
  kafka:
    bootstrap-servers: master:9092,node1:9092,node2:9092
    producer:
      acks: all
      retries: 5
      batch-size: 16384
      buffer-memory: 33554432
      transaction-id-prefix: transaction-id-
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
      properties:
        enable:
          idempotence: true
    consumer:
      group-id: default-group
      auto-offset-reset: earliest # 1. topic03中存在两条数据 2. 第一次被某个消费者组订阅会重头消费
      enable-auto-commit: false  # 取消自动提交
#      auto-commit-interval: 100 
      properties:
        isolation.level:
          read_committed
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
    listener:
      ack-mode: manual # 改为手动确认
```

##### 测试类

```java
@RestController
@RequestMapping("/consumer")
public class Consumer {

    @Autowired
    private KafkaTemplate<String,String> template;

    @KafkaListeners(value = {@KafkaListener(topics = {"topic01"})})
    @SendTo(value = {"topic02"})
    public String listenner(ConsumerRecord<?, ?> record) {
        return record.value()+" mashibing edu";
    }

    @KafkaListeners(value = {@KafkaListener(topics = {"topic02"})})
    public void listenner2(ConsumerRecord<?, ?> record) {
        System.err.println("msg: " + record.value());
    }

    @KafkaListeners(value = {@KafkaListener(topics = {"topic03"})})
    public void listenner3(ConsumerRecord<?, ?> record, Acknowledgment acknowledgment) {
        try {
            int i = 1/0;
            System.err.println("msg: " + record.value());
        }catch (Exception e) {
            System.err.println("消费 Error");
        }finally {

        }
//        acknowledgment.acknowledge();
    }
}
```

##### 手动提交配置

1. 配置文件

```yaml
# 取消自动提交
spring.kafka.consumer.enable-auto-commit=false

#监听消费模式 手动确认
spring.kafka.listener.ack-mode=manual
```

![](D:\西门小狼狗\4.MyGitHub\mashibing\images\kafka-10.jpg)

