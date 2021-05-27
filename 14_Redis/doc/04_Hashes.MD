# Hashes

### HSET key field value

#### 描述

设置 key 指定的哈希集中指定字段的值。

如果 key 指定的哈希集不存在，会创建一个新的哈希集并与 key 关联。

如果字段在哈希集中存在，它将被重写。

#### 返回值

- 1如果field是一个新的字段
- 0如果field原来在map里面已经存在

#### 例子

```shell
redis> HSET myhash field1 "Hello"
(integer) 1
redis> HGET myhash field1
"Hello"
redis> 
```

### HMSET key field value [field value ...]

#### 描述

设置 `key` 指定的哈希集中指定字段的值。该命令将重写所有在哈希集中存在的字段。如果 `key` 指定的哈希集不存在，会创建一个新的哈希集并与 `key` 关联

#### 返回值

#### 例子

```shell
redis> HMSET myhash field1 "Hello" field2 "World"
OK
redis> HGET myhash field1
"Hello"
redis> HGET myhash field2
"World"
redis> 
```

### HSETNX key field value

#### 描述

只在 `key` 指定的哈希集中不存在指定的字段时，设置字段的值。如果 `key` 指定的哈希集不存在，会创建一个新的哈希集并与 `key` 关联。如果字段已存在，该操作无效果

#### 返回值

- 1：如果字段是个新的字段，并成功赋值
- 0：如果哈希集中已存在该字段，没有操作被执行

#### 例子

```shell
redis> HSETNX myhash field "Hello"
(integer) 1
redis> HSETNX myhash field "World"
(integer) 0
redis> HGET myhash field
"Hello"
redis> 
```

### HGET key field

#### 描述

返回 key 指定的哈希集中该字段所关联的值

#### 返回值

该字段所关联的值。当字段不存在或者 key 不存在时返回nil。

#### 例子

```shell
redis> HSET myhash field1 "foo"
(integer) 1
redis> HGET myhash field1
"foo"
redis> HGET myhash field2
(nil)
redis> 
```

### HMGET key field [field ...]

#### 描述

返回 key 指定的哈希集中该字段所关联的值

对于哈希集中不存在的每个字段，返回 `nil` 值。因为不存在的keys被认为是一个空的哈希集，对一个不存在的 `key` 执行 [HMGET](http://redis.cn/commands/hmget.html) 将返回一个只含有 `nil` 值的列表

#### 返回值

含有给定字段及其值的列表，并保持与请求相同的顺序

#### 例子

```shell
redis> HSET myhash field1 "Hello"
(integer) 1
redis> HSET myhash field2 "World"
(integer) 1
redis> HMGET myhash field1 field2 nofield
1) "Hello"
2) "World"
3) (nil)
redis> 
```

### HGETALL key 

#### 描述

返回 key 指定的哈希集中所有的字段和值。返回值中，每个字段名的下一个是它的值，所以返回值的长度是哈希集大小的两倍

#### 返回值

哈希集中字段和值的列表。当 key 指定的哈希集不存在时返回空列表。

#### 例子

```shell
redis> HSET myhash field1 "Hello"
(integer) 1
redis> HSET myhash field2 "World"
(integer) 1
redis> HGETALL myhash
1) "field1"
2) "Hello"
3) "field2"
4) "World"
redis> 
```

### HLEN  key

#### 描述

返回 `key` 指定的哈希集包含的字段的数量。

#### 返回值

哈希集中字段的数量，当 `key` 指定的哈希集不存在时返回 0

#### 例子

```shell
redis> HSET myhash field1 "Hello"
(integer) 1
redis> HSET myhash field2 "World"
(integer) 1
redis> HLEN myhash
(integer) 2
redis> 
```

### HSTRLEN key field

#### 描述

返回hash指定field的value的字符串长度，如果hash或者field不存在，返回0.

#### 返回值

返回hash指定field的value的字符串长度，如果hash或者field不存在，返回0.

#### 例子

```shell
redis> HMSET myhash f1 HelloWorld f2 99 f3 -256
OK
redis> HSTRLEN myhash f1
(integer) 10
redis> HSTRLEN myhash f2
(integer) 2
redis> HSTRLEN myhash f3
(integer) 4
redis> 
```

### HKEYS key

#### 描述

返回 key 指定的哈希集中所有字段的名字。

#### 返回值

哈希集中的字段列表，当 key 指定的哈希集不存在时返回空列表。

#### 例子

```shell
redis> HSET myhash field1 "Hello"
(integer) 1
redis> HSET myhash field2 "World"
(integer) 1
redis> HKEYS myhash
1) "field1"
2) "field2"
redis> 
```

### HVALS key

#### 描述

返回 key 指定的哈希集中所有字段的值。

#### 返回值

希集中的值的列表，当 key 指定的哈希集不存在时返回空列表。

#### 例子

```shell
redis> HSET myhash field1 "Hello"
(integer) 1
redis> HSET myhash field2 "World"
(integer) 1
redis> HVALS myhash
1) "Hello"
2) "World"
redis>  
```

### HEXISTS  key  field

#### 描述

返回hash里面field是否存在

#### 返回值

- 1 hash里面包含该field。
- 0 hash里面不包含该field或者key不存在。

#### 例子

```shell
redis> HSET myhash field1 "foo"
(integer) 1
redis> HEXISTS myhash field1
(integer) 1
redis> HEXISTS myhash field2
(integer) 0
redis> 
```

### HDEL key field [field ...]

#### 描述

从 key 指定的哈希集中移除指定的域。在哈希集中不存在的域将被忽略。

如果 key 指定的哈希集不存在，它将被认为是一个空的哈希集，该命令将返回0。

#### 返回值

返回从哈希集中成功移除的域的数量，不包括指出但不存在的那些域

#### 例子

```shell
redis> HSET myhash field1 "foo"
(integer) 1
redis> HEXISTS myhash field1
(integer) 1
redis> HEXISTS myhash field2
(integer) 0
redis> 
```

### HINCRBY key field increment

#### 描述

增加 `key` 指定的哈希集中指定字段的数值。如果 `key` 不存在，会创建一个新的哈希集并与 `key` 关联。如果字段不存在，则字段的值在该操作执行前被设置为 0

`HINCRBY` 支持的值的范围限定在 64位 有符号整数

#### 返回值

增值操作执行后的该字段的值

#### 例子

```shell
redis> HSET myhash field 5
(integer) 1
redis> HINCRBY myhash field 1
(integer) 6
redis> HINCRBY myhash field -1
(integer) 5
redis> HINCRBY myhash field -10
(integer) -5
redis> 
```

### HINCRBYFLOAT key field increment

#### 描述

为指定`key`的hash的`field`字段值执行float类型的`increment`加。如果`field`不存在，则在执行该操作前设置为0.如果出现下列情况之一，则返回错误：

#### 返回值

 `field`执行`increment`加后的值

#### 例子

```shell
redis> HSET mykey field 10.50
(integer) 1
redis> HINCRBYFLOAT mykey field 0.1
"10.6"
redis> HSET mykey field 5.0e3
(integer) 0
redis> HINCRBYFLOAT mykey field 2.0e2
"5200"
redis> 
```

### HSACN

#### //TODO

请参考 [SCAN](http://redis.cn/commands/scan.html)命令， `HSCAN`与之类似 。