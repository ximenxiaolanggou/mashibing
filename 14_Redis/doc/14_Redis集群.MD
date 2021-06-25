# Redis集群基本介绍(官网)

## 基本介绍

Redis 集群是一个提供在**多个Redis间节点间共享数据**的程序集

Redis集群并不支持处理多个keys的命令,因为这需要在不同的节点间移动数据,从而达不到像Redis那样的性能,在高负载的情况下可能会导致不可预料的错误

Redis 集群通过分区来提供**一定程度的可用性**,在实际环境中当某个节点宕机或者不可达的情况下继续处理命令. Redis 集群的优势:

- 自动分割数据到不同的节点上
- 整个集群的部分节点失败或者不可达的情况下能够继续处理命令

## Redis集群数据分片

Redis 集群没有使用一致性hash, 而是引入了 **哈希槽**的概念

Redis 集群有16384个哈希槽,每个key通过CRC16校验后对16384取模来决定放置哪个槽.集群的每个节点负责一部分hash槽,举个例子,比如当前集群有3个节点,那么:

- 节点 A 包含 0 到 5500号哈希槽.
- 节点 B 包含5501 到 11000 号哈希槽.
- 节点 C 包含11001 到 16384号哈希槽.

这种结构很容易添加或者删除节点. 比如如果我想新添加个节点D, 我需要从节点 A, B, C中得部分槽到D上. 如果我想移除节点A,需要将A中的槽移到B和C节点上,然后将没有任何槽的A节点从集群中移除即可. 由于从一个节点将哈希槽移动到另一个节点并不会停止服务,所以无论添加删除或者改变某个节点的哈希槽的数量都不会造成集群不可用的状态.

## Redis集群的主从复制模型

为了使在部分节点失败或者大部分节点无法通信的情况下集群仍然可用，所以集群使用了主从复制模型,每个节点都会有N-1个复制品.

在我们例子中具有A，B，C三个节点的集群,在没有复制模型的情况下,如果节点B失败了，那么整个集群就会以为缺少5501-11000这个范围的槽而不可用.

然而如果在集群创建的时候（或者过一段时间）我们为每个节点添加一个从节点A1，B1，C1,那么整个集群便有三个master节点和三个slave节点组成，这样在节点B失败后，集群便会选举B1为新的主节点继续服务，整个集群便不会因为槽找不到而不可用了

不过当B和B1 都失败后，集群是不可用的

## Redis 一致性保证

Redis 并不能保证数据的**强一致性**. 这意味这在实际中集群在特定的条件下可能会丢失写操作

第一个原因是因为集群是用了异步复制. 写操作过程:

- 客户端向主节点B写入一条命令.
- 主节点B向客户端回复命令状态.
- 主节点将写操作复制给他得从节点 B1, B2 和 B3

主节点对命令的复制工作发生在返回命令回复之后， 因为如果每次处理命令请求都需要等待复制操作完成的话， 那么主节点处理命令请求的速度将极大地降低 —— 我们必须在性能和一致性之间做出权衡。 注意：Redis 集群可能会在将来提供同步写的方法。 Redis 集群另外一种可能会丢失命令的情况是集群出现了网络分区， 并且一个客户端与至少包括一个主节点在内的少数实例被孤立。

举个例子 假设集群包含 A 、 B 、 C 、 A1 、 B1 、 C1 六个节点， 其中 A 、B 、C 为主节点， A1 、B1 、C1 为A，B，C的从节点， 还有一个客户端 Z1 假设集群中发生网络分区，那么集群可能会分为两方，大部分的一方包含节点 A 、C 、A1 、B1 和 C1 ，小部分的一方则包含节点 B 和客户端 Z1 .

Z1仍然能够向主节点B中写入, 如果网络分区发生时间较短,那么集群将会继续正常运作,如果分区的时间足够让大部分的一方将B1选举为新的master，那么Z1写入B中得数据便丢失了.

注意， 在网络分裂出现期间， 客户端 Z1 可以向主节点 B 发送写命令的最大时间是有限制的， 这一时间限制称为节点超时时间（node timeout）， 是 Redis 集群的一个重要的配置选项

# Redis集群搭建

## 官方单机集群脚本

1. 打开redis压缩包 -> 打开utils文件夹 -> 打开 create-cluster文件夹 

2. 查看`create-cluster`文件

   1. node 代表创建几个redis实例
   2. REPLICAS代表创建接个副本

3. 启动

   ```shell
   ./create-cluster start
   ```

4. 分配槽位

   ```shell
   ./create-cluster create
   ```

5. 会分配6个端口

   ```shell
   30001
   30002
   30003
   30004
   30005
   30006
   ```

6. 连接集群

   ```shell
   redis-cli -c -p 30001
   ```

## 集群搭建

1. 创建redis-cluster文件夹用于存放集群配置文件

2. 创建 redis-8001.conf redis-8002.conf redis-8003.conf redis-8004.conf redis-8005.conf redis-8006.conf 文件

3. 编辑配置文件

   ```shell
   #绑定IP地址
   bind 192.25.106.216
   #端口
   port 8001
   #pid文件
   pidfile /var/run/redis_8001.pid
   #日志文件地址
   logfile "/usr/local/redis-5.0.8/logs/8001/redis-8001.log"
   #数据文件地址
   dir /usr/local/redis-5.0.8/redis-cluster/8001
   #master连接密码
   masterauth 123456
   
   #客户端在处理任何命令时都要验证身份和密码。
   requirepass 123456
   ######################### APPEND ONLY MODE #########################
    
   # 默认情况下，Redis是异步的把数据导出到磁盘上。这种模式在很多应用里已经足够好，但Redis进程出问题或断电时可能造成一段时间的写操作丢失(这取决于配置的save指令)。
   # AOF是一种提供了更可靠的替代持久化模式，例如使用默认的数据写入文件策略（参见后面的配置）。
   # 在遇到像服务器断电或单写情况下Redis自身进程出问题但操作系统仍正常运行等突发事件时，Redis能只丢失1秒的写操作。
   # AOF和RDB持久化能同时启动并且不会有问题。
   # 如果AOF开启，那么在启动时Redis将加载AOF文件，它更能保证数据的可靠性。
   appendonly yes
   appendfilename "appendonly.aof"
   
   aof-load-truncated yes
   ################################ REDIS CLUSTER  ###############################
   #集群启用
   cluster-enabled yes
   #集群配置文件
   cluster-config-file nodes-8001.conf
   # 集群节点超时毫秒数。超时的节点将被视为不可用状态。
   cluster-node-timeout 15000
   # replicaof    这里需要注释掉
   ```

4. 修改各个redis节点的配置文件信息(.conf redis-8002.conf redis-8003 ...)

5. 启动redis服务

   ```shell
   redis-server ./redis-8001.conf
   redis-server ./redis-8002.conf
   redis-server ./redis-8003.conf
   redis-server ./redis-8004.conf
   redis-server ./redis-8005.conf
   redis-server ./redis-8006.conf
   ```

6. 创建集群，命令中的-cluster-replicas 代表主从节点的比例这里因为是3主3从，所以参数为1

   ```shell
   ./redis-cli --cluster create  -a 123456 --cluster-replicas 1  192.25.106.216:8001 192.25.106.216:8002 192.25.106.216:8003 192.25.106.216:8004 192.25.106.216:8005 192.25.106.216:8006 
   ```

# 集群节点操作

### **集群**

cluster info ：打印集群的信息
cluster nodes ：列出集群当前已知的所有节点（ node），以及这些节点的相关信息。

### **节点**

cluster meet <ip> <port> ：将 ip 和 port 所指定的节点添加到集群当中，让它成为集群的一份子。
cluster forget <node_id> ：从集群中移除 node_id 指定的节点。
cluster replicate <master_node_id> ：将当前从节点设置为 node_id 指定的master节点的slave节点。只能针对slave节点操作。
cluster saveconfig ：将节点的配置文件保存到硬盘里面。

### **槽(slot)**

cluster addslots <slot> [slot ...] ：将一个或多个槽（ slot）指派（ assign）给当前节点。
cluster delslots <slot> [slot ...] ：移除一个或多个槽对当前节点的指派。
cluster flushslots ：移除指派给当前节点的所有槽，让当前节点变成一个没有指派任何槽的节点。
cluster setslot <slot> node <node_id> ：将槽 slot 指派给 node_id 指定的节点，如果槽已经指派给
**另一个节点，那么先让另一个节点删除该槽>，然后再进行指派。**
cluster setslot <slot> migrating <node_id> ：将本节点的槽 slot 迁移到 node_id 指定的节点中。
cluster setslot <slot> importing <node_id> ：从 node_id 指定的节点中导入槽 slot 到本节点。
cluster setslot <slot> stable ：取消对槽 slot 的导入（ import）或者迁移（ migrate）。

### **键**

cluster keyslot <key> ：计算键 key 应该被放置在哪个槽上。
cluster countkeysinslot <slot> ：返回槽 slot 目前包含的键值对数量。
cluster getkeysinslot <slot> <count> ：返回 count 个 slot 槽中的键 。

### 添加节点

```shell
1）新配置二个测试节点
# cd /etc/redis 
 
//新增配置 
# cp redis-6379.conf redis-6378.conf && sed -i "s/6379/6378/g" redis-6378.conf 
# cp redis-6382.conf redis-6385.conf && sed -i "s/6382/6385/g" redis-6385.conf 
   
//启动 
# redis-server /etc/redis/redis-6385.conf > /var/log/redis/redis-6385.log 2>&1 & 
# redis-server /etc/redis/redis-6378.conf > /var/log/redis/redis-6378.log 2>&1 & 
 
2）添加主节点
# redis-trib.rb add-node 192.168.10.219:6378 192.168.10.219:6379 
注释：
192.168.10.219:6378是新增的节点
192.168.10.219:6379集群任一个旧节点
 
3）添加从节点
# redis-trib.rb add-node --slave --master-id 03ccad2ba5dd1e062464bc7590400441fafb63f2 192.168.10.220:6385 192.168.10.219:6379 
注释：
--slave，表示添加的是从节点
--master-id 03ccad2ba5dd1e062464bc7590400441fafb63f2,主节点的node id，在这里是前面新添加的6378的node id
192.168.10.220:6385,新节点
192.168.10.219:6379集群任一个旧节点
 
4）重新分配slot
# redis-trib.rb reshard 192.168.10.219:6378               //下面是主要过程 
How many slots do you want to move (from 1 to 16384)? 1000 //设置slot数1000 
What is the receiving node ID? 03ccad2ba5dd1e062464bc7590400441fafb63f2 //新节点node id 
Please enter all the source node IDs. 
 Type 'all' to use all the nodes as source nodes for the hash slots. 
 Type 'done' once you entered all the source nodes IDs. 
Source node #1:all                                      //表示全部节点重新洗牌 
Do you want to proceed with the proposed reshard plan (yes/no)? yes //确认重新分 
 
新增加的主节点，是没有slots的，
M: 03ccad2ba5dd1e062464bc7590400441fafb63f2 192.168.10.219:6378
slots:0-332,5461-5794,10923-11255 (0 slots) master
主节点如果没有slots的话，存取数据就都不会被选中。
可以把分配的过程理解成打扑克牌，all表示大家重新洗牌；输入某个主节点的node id，然后在输入done的话，就好比从某个节点，抽牌。
 
5）查看一下，集群情况
[root@slave2 redis]# redis-trib.rb check 192.168.10.219:6379 
Connecting to node 192.168.10.219:6379: OK 
Connecting to node 192.168.10.220:6385: OK 
Connecting to node 192.168.10.219:6378: OK 
Connecting to node 192.168.10.220:6382: OK 
Connecting to node 192.168.10.220:6383: OK 
Connecting to node 192.168.10.219:6380: OK 
Connecting to node 192.168.10.219:6381: OK 
Connecting to node 192.168.10.220:6384: OK 
>>> Performing Cluster Check (using node 192.168.10.219:6379) 
M: 5d8ef5a7fbd72ac586bef04fa6de8a88c0671052 192.168.10.219:6379 
 slots:5795-10922 (5128 slots) master 
 1 additional replica(s) 
S: 9c240333476469e8e2c8e80b089c48f389827265 192.168.10.220:6385 
 slots: (0 slots) slave 
 replicates 03ccad2ba5dd1e062464bc7590400441fafb63f2 
M: 03ccad2ba5dd1e062464bc7590400441fafb63f2 192.168.10.219:6378 
 slots:0-332,5461-5794,10923-11255 (1000 slots) master 
 1 additional replica(s) 
M: 19b042c17d2918fade18a4ad2efc75aa81fd2422 192.168.10.220:6382 
 slots:333-5460 (5128 slots) master 
 1 additional replica(s) 
M: b2c50113db7bd685e316a16b423c9b8abc3ba0b7 192.168.10.220:6383 
 slots:11256-16383 (5128 slots) master 
 1 additional replica(s) 
S: 6475e4c8b5e0c0ea27547ff7695d05e9af0c5ccb 192.168.10.219:6380 
 slots: (0 slots) slave 
 replicates 19b042c17d2918fade18a4ad2efc75aa81fd2422 
S: 1ee01fe95bcfb688a50825d54248eea1e6133cdc 192.168.10.219:6381 
 slots: (0 slots) slave 
 replicates b2c50113db7bd685e316a16b423c9b8abc3ba0b7 
S: 9a2a1d75b8eb47e05eee1198f81a9edd88db5aa1 192.168.10.220:6384 
 slots: (0 slots) slave 
 replicates 5d8ef5a7fbd72ac586bef04fa6de8a88c0671052 
[OK] All nodes agree about slots configuration. 
>>> Check for open slots... 
>>> Check slots coverage... 
[OK] All 16384 slots covered.
```

### **手动改变slave从节点所属的master主节点（一个slave只能属于一个master，而一个master可以有多个slave）**

```shell
//查看一下6378的从节点 
# redis-cli -p 6378 cluster nodes | grep slave | grep 03ccad2ba5dd1e062464bc7590400441fafb63f2 
   
//将6385加入到新的master 
# redis-cli -c -p 6385 -h 192.168.10.220 
192.168.10.220:6385> cluster replicate 5d8ef5a7fbd72ac586bef04fa6de8a88c0671052  //新master的node id 
OK 
192.168.10.220:6385> quit 
   
//查看新master的slave 
# redis-cli -p 6379 cluster nodes | grep slave | grep 5d8ef5a7fbd72ac586bef04fa6de8a88c0671052
```

### 删除节点

```shell
1）删除从节点
# redis-trib.rb del-node 192.168.10.220:6385 '9c240333476469e8e2c8e80b089c48f389827265' 
 
2）删除主节点
如果主节点有从节点，将从节点转移到其他主节点
如果主节点有slot，去掉分配的slot，然后在删除主节点
# redis-trib.rb reshard 192.168.10.219:6378                             //取消分配的slot,下面是主要过程 
How many slots do you want to move (from 1 to 16384)? 1000              //被删除master的所有slot数量 
What is the receiving node ID? 5d8ef5a7fbd72ac586bef04fa6de8a88c0671052 //接收6378节点slot的master 
Please enter all the source node IDs. 
 Type 'all' to use all the nodes as source nodes for the hash slots. 
 Type 'done' once you entered all the source nodes IDs. 
Source node #1:03ccad2ba5dd1e062464bc7590400441fafb63f2                //被删除master的node-id 
Source node #2:done  
   
Do you want to proceed with the proposed reshard plan (yes/no)? yes    //取消slot后，reshard 
 
 
新增master节点后，也进行了这一步操作，当时是分配，现在去掉。反着的。
# redis-trib.rb del-node 192.168.10.219:6378 '03ccad2ba5dd1e062464bc7590400441fafb63f2' 
 
新的master节点被删除了，这样就回到了，就是这篇文章开头，还没有添加节点的状态
```

### **复制迁移**

```shell
在redis集群中通过"cluster replicate <master_node_id> "命令可以将一个slave节点重新配置为另外一个master的slave。
注意：这个只是针对slave节点，即登录到slave节点的reids中，执行这个命令。
 
比如172.16.60.204:7003是172.16.60.202:7000主节点的slave节点，也可以把他设置成172.16.60.205:7004主节点的slave节点。
172.16.60.205:7004主节点的ID是48cbab906141dd26241ccdbc38bee406586a8d03
 
则操作为
[root@redis-new01 ~]# /data/redis-4.0.6/src/redis-cli -h 172.16.60.204 -c -p 7003
172.16.60.204:7003> cluster replicate 48cbab906141dd26241ccdbc38bee406586a8d03
OK
172.16.60.204:7003>
 
这样172.16.60.204:7003节点就变成了172.16.60.205:7004主节点的slave节点，而不再是172.16.60.202:7000主节点的slave节点！
 
这样可以自动的将一个复制节点从一个master下移动到另外一个master下。 这种情况下的复制节点的自动重配置被称为复制迁移。
复制迁移可以提升系统的可靠性和抗灾性。
 
在某种情况下，你想让集群的复制节点从一个master迁移到另一个master的原因可能是：
集群的抗崩溃能力总是跟集群中master 拥有的平均slave数量成正比。
比如，如果一个集群中每个master只有一个slave，当master和slave都挂掉的时候这个集群就崩溃了。因为此时有一些哈希槽无法找到了。
虽然网络分裂会把一堆节点从集群中孤立出来（这样你一下就会知道集群出问题了），但是其他的更常见的硬件或者软件的问题并不会在多台机器上同时发生，
所以很 可能在你的这个集群（平均每个master只有一个slave）有一个slave在早上4点挂掉，然后他的master在随后的早上6点挂掉。这样依然会 导致集群崩溃。
 
可以通过给每个master都再多加一个slave节点来改进系统的可靠性，但是这样很昂贵。复制迁移允许只给某些master增加slave。比方说你的集群有20个节点，
10个master，每个master都有1个slave。然后你增加3个 slave到集群中并把他们分配给某几个master节点，这样某些master就会拥有多于1个slave。
 
当某个 master失去了slave的时候，复制迁移可以将slave节点从拥有富余slave的master旗下迁移给没有slave的master。所以当 你的slave在早上4点挂掉的时候，
另一个slave会被迁移过来取代它的位置，这样当master节点在早上5点挂掉的时候，依然有一个slave可 以被选举为master，集群依然可以正常运行。
 
所以简而言之，关于复制迁移应该注意下面几个方面：
-  集群在迁移的时候会尝试去迁移拥有最多slave数量的master旗下的slave。
-  想利用复制迁移特性来增加系统的可用性，你只需要增加一些slave节点给单个master（哪个master节点并不重要）。
-  复制迁移是由配置项cluster-migration-barrier控制的
```





