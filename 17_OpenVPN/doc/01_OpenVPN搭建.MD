# OpenVPN搭建

## 服务端

1. 安装依赖

   ```shell
   yum install -y gcc-c++ openssl glibc-headers openssl-devel net-tools lzo lzo-devel pam pam-devel
   ```

2. 打开官网下载openVPN，（需要梯子）

   ```shell
   https://openvpn.net/community-downloads/
   下载SOURCE TARBALL (GZIP)
   下载完成上传服务器
   ```

3. 解压文件进入文件

   ```shell
   tar -zxf openvpn-2.4.7.tar.gz
   cd openvpn-2.4.7/
   ```

4. 配置并指定生成路径

   ```
   ./configure --prefix=/usr/local/openvpn/
   ```

5. 编译安装

   ```shell
   make
   make install
   ```

6. 添加环境变量

   ```shell
   vim /etc/profile
   export PATH=$PATH:/usr/local/openvpn/sbin
   source /etc/profile
   ```

7. 查看一下版本

   ```shell
   openvpn --version
   ```

8. 复制一份server端的配置文件

   ```shell
   cp ./sample/sample-config-files/server.conf /usr/local/openvpn/
   ```

9. 退出文件夹并删除源码文件

   ```shell
   cd ..
   rm -rf openvpn-2.4.7*
   ```

10. 下载最新版easy-rsa的tar.gz包

    ```shell
    该程序用于生成秘钥文件
    https://github.com/OpenVPN/easy-rsa/releases
    下载完成上传服务器，或者使用wget直接下载
    ```

11. 解压 进入

    ```shell
    tar -zxf easy-rsa-3.0.6.tar.gz
    rm -rf easy-rsa-3.0.6
    cd easy-rsa-3.0.6/easyrsa3/
    ```

12. 初始化

    ```shell
    ./easyrsa init-pki
    ```

13. 生成根证书，nopass表示不加密，直接回车。

    ```shell
    ./easyrsa build-ca nopass
    ```

14. 创建Diffie-Hellman，时间可能会有点长，耐心等待

    ```shell
    ./easyrsa gen-dh
    ```

15. 创建server端证书和private key，nopass表示不加密private key。直接回车就好。server即创建后的文件名，可自定义

    ```shell
    ./easyrsa gen-req server nopass
    ```

16. 给server端证书做签名，首先是对一些信息的确认，输入yes。第一个server代表签为server端，第二个server为上一步的文件名

    ```shell
    ./easyrsa sign server server
    ```

17. 创建client端证书和private key，nopass表示不加密private key。直接回车就好。client即创建后的文件名，可自定义

    ```shell
    ./easyrsa gen-req client nopass
    ```

18. 给client端证书做签名，首先是对一些信息的确认，输入yes，第一个client代表签为client端，第二个client为上一步的文件名

    ```shell
    ./easyrsa sign client client
    ```

19. **如果需要多个客户端，则重复最后两步，注意，client端文件名需要不同，每个客户端都需要一个唯一的证书**

20. 复制服务端的秘钥到配置文件同级目录下

    ```shell
    cp -p pki/ca.crt pki/dh.pem pki/private/server.key pki/issued/server.crt /usr/local/openvpn/
    ```

21. 编辑配置文件，修改如下配置

    ```shell
    vim /usr/local/openvpn/server.conf
    
    # 监听端口：默认1194，可自定义修改
    port 1194
    # ca证书路径
    ca /usr/local/openvpn/ca.crt
    # 服务器证书
    cert /usr/local/openvpn/server.crt
    # 服务器秘钥
    key /usr/local/openvpn/server.key
    # 秘钥交换协议：注意名称
    dh /usr/local/openvpn/dh.pem
    # 给客服端分配的地址池：不能和服务器内网ip一个网段
    server 10.8.0.0 255.255.255.0
    # IP配置文件
    ifconfig-pool-persist /usr/local/openvpn/ipp.txt
    # 开启DHCP
    push "redirect-gateway def1 bypass-dhcp"
    # DHCP分配dns
    push "dhcp-option DNS 114.114.114.114"
    push "dhcp-option DNS 223.5.5.5"
    # 没有这个key，注释掉
    ;tls-auth ta.key 0 # This file is secret
    # 传输数据压缩
    comp-lzo
    # 状态文件
    status /usr/local/openvpn/openvpn-status.log
    # 日志文件
    log /usr/local/openvpn/server/openvpn.log
    
    ;dev tap
    dev tun
    
    保存退出
    ```

22. 启动firewalld防火墙

    ```shell
    systemctl start firewalld.service
    ```

23. 开放openvpn的监听端口以及协议

    ```shell
    firewall-cmd --add-service=openvpn --permanent
    firewall-cmd --add-port=1194/udp --permanent
    firewall-cmd --add-source=10.8.0.0 --permanent
    firewall-cmd --add-masquerade --permanent
    firewall-cmd --reload
    ```

24. 启动进程

    ```shell
    openvpn --connect-retry 5 30 --daemon --config /usr/local/openvpn/server.conf
    ```

25. 编辑开机自启文件

    ```shell
    vim /etc/init.d/openvpn
    
    #!/bin/bash
    #
    # chkconfig: 2345 98 10
    # description:openvpn service
    #
    /usr/local/openvpn/sbin/openvpn --connect-retry 5 30 --daemon --config /usr/local/openvpn/server.conf
    ```

26. 授予执行权限

    ```shell
    chmod 755 /etc/init.d/openvpn
    ```

27. 添加服务

    ```shell
    chkconfig --add openvpn
    ```

**服务端至此结束**





## 客户端

1. 安装依赖

   ```shell
   apt install -y libssl-dev liblzo2-dev libpam0g-dev net-tools
   yum install -y gcc-c++ openssl glibc-headers openssl-devel net-tools lzo lzo-devel pam pam-devel
   ```

2. 上传openvpn-2.4.7.tar.gz并编译安装

   ```shell
   
   tar -zxf openvpn-2.4.7.tar.gz
   cd openvpn-2.4.7/
   ./configure --prefix=/usr/local/openvpn/
   make
   make install
   cd ..
   rm -rf openvpn-2.4.7*
   ```

3. 上传配置文件与证书文件到安装目录(/usr/local/openvpn/)

   ```shell
   ca.crt
   client.conf
   client.crt
   client.key
   ```

4. 启动

   ```shell
   /usr/local/openvpn/sbin/openvpn --daemon --config /usr/local/openvpn/client.conf --log-append /usr/local/openvpn/openvpn.log
   ```

   

**注意**

client.conf中需要修改服务端地址和端口，以及证书位置

