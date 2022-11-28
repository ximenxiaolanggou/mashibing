# 服务端（CentOS7环境）：

## 安装依赖

```bash
yum install -y gcc-c++ openssl openssl-devel net-tools lzo lzo-devel pam pam-devel
```

## 安装OpenVPN

### 下载

1. 打开OpenVPN官网下载地址：[https://openvpn.net/community-downloads/](https://openvpn.net/community-downloads/)
2. 下载`openvpn-2.5.3.tar.gz`
3. 下载完成上传到服务器

或者

```bash
wget https://swupdate.openvpn.org/community/releases/openvpn-2.5.3.tar.gz
```

### 解压、编译、安装

```bash
# 解压
tar -zxf openvpn-2.5.3.tar.gz
# 进入该目录
cd openvpn-2.5.3/
# 配置
./configure --prefix=/usr/local/openvpn/
# 编译
make
# 安装
make install
```

> 添加环境变量

编辑环境变量文件

```bash
vim /etc/profile
```

`PATH`添加`:/usr/local/openvpn/sbin`，例如：

```
export PATH=$PATH:/usr/local/openvpn/sbin
```

立即生效

```bash
source /etc/profile
```

> 查看是否成功

```bash
openvpn --version
```

退出当前目录

```bash
cd ..
```

## 生成证书

### 下载`easy-rsa`工具

1. 打开GitHub地址[https://github.com/OpenVPN/easy-rsa/releases](https://github.com/OpenVPN/easy-rsa/releases)
2. 下载最新版easy-rsa的tgz包
3. 下载完成上传服务器，或者使用wget直接下载

或者

```bash
wget https://github.com/OpenVPN/easy-rsa/releases/download/v3.0.8/EasyRSA-3.0.8.tgz
```

### 解压

```bash
# 解压
tar -zxf EasyRSA-3.0.8.tgz
# 进入该目录
cd EasyRSA-3.0.8/
```

### 生成服务端与客户端证书

1. 初始化<br>`./easyrsa init-pki`
2. 生成根证书<br>`./easyrsa build-ca nopass`
    - `nopass`表示不加密
    - 提示输入通用名，可以输入`服务器IP`或者`域名`或者`不输入`，然后直接回车
    - 此时看到提示`ca`文件在`/root/EasyRSA-3.0.8/pki/ca.crt`
4. 服务端：
    1. 创建服务端证书<br>`./easyrsa gen-req server nopass`
        - `server`即创建后的证书文件名，可自定义
        - `nopass`表示不加密
        - 提示输入通用名，直接回车
    2. 给服务端证书做签名<br>`./easyrsa sign server server`
        - 第一个`server`代表签为服务端
        - 第二个`server`为**服务端证书文件名**
        - 提示一些确认信息，输入`yes`并回车
5. 客户端：（如果需要多个客户端，每个客户端都需要一个唯一的证书。重复以下两步：client端文件名不相同即可，例如：client1 client2）
    1. 创建客户端证书<br>`./easyrsa gen-req client nopass`
        - `nopass`表示不加密
        - `client`即创建后的文件名，可自定义
        - 提示输入通用名，直接回车
    2. 给客户端证书做签名<br>`./easyrsa sign client client`
        - 第一个`client`代表签为客户端
        - 第二个`client`为**客户端证书文件名**
        - 提示一些确认信息，输入`yes`并回车

## 配置服务端

### 拷贝证书

复制服务端秘钥至安装目录

```bash
# PS：当前命令还在上文的 /root/EasyRSA-3.0.8 目录下
cp -p pki/ca.crt pki/private/server.key pki/issued/server.crt /usr/local/openvpn/
```

复制服务端配置文件至安装目录

```bash
# 退出当前文件夹并进入openvpn源码文件夹
cd ../openvpn-2.5.3/
# 复制配置文件示例
cp ./sample/sample-config-files/server.conf /usr/local/openvpn/
```

### 生成其他文件

进入到安装目录

```bash
cd /usr/local/openvpn/
```

生成`pem`文件

```bash
openssl dhparam -out dh2048.pem 2048
```

生成`key`文件

```bash
openvpn --genkey tls-auth ta.key
```

### 修改配置文件

编辑配置文件

```bash
vim server.conf
```

修改如下配置

```ini
# 监听端口：默认1194，可自定义修改
port 1194
# 使用TCP协议
proto tcp
;proto udp
# 证书文件
ca /usr/local/openvpn/ca.crt
cert /usr/local/openvpn/server.crt
key /usr/local/openvpn/server.key
# pem文件
dh /usr/local/openvpn/dh2048.pem
# 给客服端分配的地址池：不能和服务器内网ip一个网段
server 10.8.0.0 255.255.255.0
# IP配置文件
ifconfig-pool-persist /usr/local/openvpn/ipp.txt
# 允许客户端访问服务器上的其他网络
push "route 10.0.4.0 255.255.255.0"
# key文件
tls-auth /usr/local/openvpn/ta.key 0
# 加密方式
cipher AES-256-GCM
# 状态文件
status /usr/local/openvpn/openvpn-status.log
# 日志文件
log /usr/local/openvpn/openvpn.log
# 明确的退出通知（TCP模式需要设置为0）
explicit-exit-notify 0

dev tun
```


```ini
# 开启DHCP
push "redirect-gateway def1 bypass-dhcp"
# DHCP分配dns
push "dhcp-option DNS 114.114.114.114"
push "dhcp-option DNS 223.5.5.5"
```

保存退出

```
启动firewalld防火墙
systemctl start firewalld.service
开放openvpn的监听端口以及协议
firewall-cmd --add-port=1194/udp --permanent
firewall-cmd --add-masquerade --permanent
firewall-cmd --complete-reload
```

启动进程
openvpn --daemon --config /usr/local/openvpn/server.conf

编辑开机自启文件
vim /etc/init.d/openvpn
```
#!/bin/bash
#
# chkconfig: 2345 98 10
# description:openvpn service
#
/usr/local/openvpn/sbin/openvpn --connect-retry 5 30 --daemon --config /usr/local/openvpn/server.conf
```
授予执行权限
chmod 755 /etc/init.d/openvpn

添加服务
chkconfig --add openvpn

服务端至此结束







# 客户端（Windows）

用ftp导出easyrsa3文件夹下的客户端证书文件


pki/ca.crt
pki/private/client.key
pki/issued/client.crt

下载Windows客户端并安装

打开https://openvpn.net/community-downloads/
点击WINDOWS INSTALLER (NSIS)后面的下载链接进行下载
下载完成后安装

安装完成后，复制一份
C:\Program Files\OpenVPN\sample-config\client.ovpn
到
C:\Program Files\OpenVPN\config
路径下，并将导出的证书文件也存放在改路径下

编辑client.ovpn文件

```ini
# 使用TCP
proto tcp
;proto udp
# 服务端地址与端口
remote x.x.x.x 1194
# 没有这个文件，注释掉
;tls-auth ta.key 1
# 打开数据压缩
comp-lzo
# 结尾添加
auth-nocache
```

保存并退出
双击桌面上的OpenVPN GUI
再右下角右击新出来的一个小电脑图片并选择连接

看到小图标变绿色就行

客户端至此完成

自动连接：
快捷方式右击，地址添加   --connect client.ovpn
