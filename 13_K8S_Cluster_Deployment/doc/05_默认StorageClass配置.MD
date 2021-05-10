# 安装 OpenEBS 创建 LocalPV 存储类型

由于 [在已有 Kubernetes 集群之上安装 KubeSphere](https://v2-1.docs.kubesphere.io/docs/zh-CN/installation/install-on-k8s) 需要依赖集群已有的存储类型（StorageClass），若集群还没有准备存储类型（StorageClass），可参考本文档，在 K8s 集群中安装 OpenEBS 并创建 LocalPV 的存储类型，从而可以在集群快速安装测试 KubeSphere。

注意：基于 OpenEBS 创建 LocalPV 的存储类型仅适用于开发测试环境，不建议在生产环境使用。生产环境建议准备符合 Kubernetes 要求的持久化存储（如 GlusterFS、Ceph、NFS、Neonsan 等分布式存储，或云上的块存储），然后再创建对应的 StorageClass。

### 前提条件

- 已有 Kubernetes 集群，并安装了 kubectl 或 Helm
- Pod 可以被调度到集群的 master 节点（可临时取消 master 节点的 Taint）

关于第二个前提条件，是由于安装 OpenEBS 时它有一个初始化的 Pod 需要在 master 节点启动并创建 PV 给 KubeSphere 的有状态应用挂载。因此，若您的 master 节点存在 Taint，建议在安装 OpenEBS 之前手动取消 Taint，待 OpenEBS 与 KubeSphere 安装完成后，再对 master 打上 Taint，以下步骤供参考：

1. 例如本示例有一个 master 节点，节点名称即 `master`，可通过以下命令查看节点名称：

   ```shell
   kubectl get node -o wide
   
   NAME     STATUS   ROLES    AGE     VERSION   INTERNAL-IP    EXTERNAL-IP   OS-IMAGE                KERNEL-VERSION          CONTAINER-RUNTIME
   master   Ready    master   6d18h   v1.15.5   192.168.0.6    <none>        CentOS Linux 7 (Core)   3.10.0-693.el7.x86_64   docker://18.9.7
   node1    Ready    worker   6d18h   v1.15.5   192.168.0.7    <none>        CentOS Linux 7 (Core)   3.10.0-693.el7.x86_64   docker://18.9.7
   node2    Ready    worker   6d18h   v1.15.5   192.168.0.10   <none>        CentOS Linux 7 (Core)   3.10.0-693.el7.x86_64   docker://18.9.7
   ```

2. 确认 master 节点是否有 Taint，如下看到 master 节点有 Taint。

   ```shell
   kubectl describe node master | grep Taint
   
   Taints:             node-role.kubernetes.io/master:NoSchedule
   ```

3. 去掉 master 节点的 Taint：

   ```shell
    kubectl taint nodes master node-role.kubernetes.io/master:NoSchedule-
   ```



### 安装 OpenEBS

1. 创建 OpenEBS 的 namespace，OpenEBS 相关资源将创建在这个 namespace 下：

   ```shell
   kubectl create ns openebs
   ```

2. 安装 OpenEBS，以下列出两种方法，可参考其中任意一种进行创建：

   A.	若集群已安装了 Helm，可通过 Helm 命令来安装 OpenEBS：

   ```shell
   helm init
   
   helm install --namespace openebs --name openebs stable/openebs --version 1.5.0
   ```

   B.	 **除此之外** 还可以通过 kubectl 命令安装：

   ```shell
   kubectl apply -f https://openebs.github.io/charts/openebs-operator-1.5.0.yaml
   ```

3. 安装 OpenEBS 后将自动创建 4 个 StorageClass，查看创建的 StorageClass：

   ```shell
   kubectl get sc
   
   NAME                        PROVISIONER                                                AGE
   openebs-device              openebs.io/local                                           10h
   openebs-hostpath            openebs.io/local                                           10h
   openebs-jiva-default        openebs.io/provisioner-iscsi                               10h
   openebs-snapshot-promoter   volumesnapshot.external-storage.k8s.io/snapshot-promoter   10h
   ```

4. 如下将 `openebs-hostpath`设置为 **默认的 StorageClass**：

   ```shell
   kubectl patch storageclass openebs-hostpath -p '{"metadata": {"annotations":{"storageclass.kubernetes.io/is-default-class":"true"}}}'
   ```

5. 至此，OpenEBS 的 LocalPV 已作为默认的存储类型创建成功。可以通过命令 `kubectl get pod -n openebs`来查看 OpenEBS 相关 Pod 的状态，若 Pod 的状态都是 running，则说明存储安装成功。

6. 由于在文档开头手动去掉了 master 节点的 Taint，我们可以在安装完 OpenEBS 和 KubeSphere 后，可以将 master 节点 Taint 加上，避免业务相关的工作负载调度到 master 节点抢占 master 资源：

   ```shell
   kubectl taint nodes master node-role.kubernetes.io/master=:NoSchedule
   ```

   







