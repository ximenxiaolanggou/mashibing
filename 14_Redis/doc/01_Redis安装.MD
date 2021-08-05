### 使用wget下载Redis压缩包

**安装wget**

```shell
yum install wget
```

**下载redis压缩包**

```shell
wget http://download.redis.io/releases/redis-5.0.11.tar.gz
```

### 解压

```shell
tar xzf redis-5.0.11.tar.gz
```

### 编译

```shell
# 前置环境
yum install gcc

cd redis-5.0.11

make
```

**注意：**

如果未安装gcc时执行make命令，再装完gcc之后需要执行

### 安装

```shell
cd src

make install [/opt/redis5] # 后面接安装路径，不写有默认的安装路径
```

### 添加环境变量

```shell
vi /etc/profile

export REDIS_HOME=/usr/local
export PATH=$PATH:$REDIS_HOME/bin

source /etc/profile
```

### 安装自启服务

```shell
./install_service.sh(可执行一次或多次)
```

1. 一个物理机可以有多个redis实例(进程)，通过端口port区别
2. 可执行程序就一份在目录中，但是内存中未来的多个实例需要各自的配置文件，持久化目录资源
3. service redis5 start/stop/status/restart

### 查看进程

```shell
ps -fe | grep redis
```

