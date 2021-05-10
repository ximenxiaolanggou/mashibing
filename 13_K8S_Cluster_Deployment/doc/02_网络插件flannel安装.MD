## 主要解决镜像拉取不下来问题

### Github上下载镜像文件

https://github.com/flannel-io/flannel/releases/tag/v0.11.0

[flanneld-v0.11.0-amd64.docker](https://github.com/flannel-io/flannel/releases/download/v0.11.0/flanneld-v0.11.0-amd64.docker)

### 加载镜像文件

```shell
docker load -i flanneld-v0.11.0-amd64.docker 
```

### 启动

```shell
kubectl apply -f kube-flannel.yml 
```

### 查看

```shell
kubectl get pods --all-namespaces
```

