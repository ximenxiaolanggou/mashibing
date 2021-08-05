# GitHub配置
1. 创建Token(以后Jenkins配置GitHub服务器需要用到)
   ![](./images/75.jpg)
>Settings -> Developer settings -> Personal access tokens -> Generate New Token
![](./images/76.jpg)

2.配置WebHook
> 进入GitHub上指定的项目 --> setting --> WebHooks --> add webhook
![](./images/77.jpg)

**注意：** 地址需要'/'结尾
# Jenkins配置
1. 安装GitHub Plugin插件
2. 配置GitHub Plugin
系统管理 --> 系统设置 --> GitHub --> Add GitHub Sever
![](./images/78.jpg)
**凭据中的Secret就是之前GitHub上生成的Token
![](./images/79.jpg)

# 编写pipeline脚本
