# OpenVPN静态IP

1. 创建存放客户端静态IP文件夹

   ```shell
   /usr/local/openvpn/ccd
   ```

2. 在服务端配置文件夹路径

   ```shell
   vim /usr/local/openvpn/server.conf
   
   # 添加
   client-config-dir /usr/local/openvpn/ccd
   ```

3. cdd文件夹中的文件为对应客户端所使用的`登录名称`

   ```shell
   vim /usr/local/openvpn/ccd/client-edge-service
   
   # 添加
   ifconfig-push 10.8.0.2 10.8.0.3
   ```

   **以上设置可配置使用`mac`帐号登录的客户端ip地扯为`10.8.0.2`**

**注意事项**

`ifconfig-push` 后面是紧跟着两个连续的成组IP地扯，以第一个为客户端的IP地扯。

可能有人会想为什么要制定两个IP，这是因为openvpn只支持255.255.255.252 的子网，而且252的子网只有两个IP，一个分配给客户端，一个留给服务器用。