
---------------------
##### 2018/10/13 CommitVersion

---------------------
1. 本项目意在做一个SpringCloud版本的定时任务方案的持续探索，实现方式和业务逻辑尽可能解耦；
2. 本模块为当前项目所有定时任务的管理模块，job-admin调度平台只负责任务的触发，触发后由schedule节点准备统一的基础参数，然后通过远程调用具体业务节点的指定方法实现定时任务的逻辑内容；
3. 业务调度模式：
- A、集中调度，远程实现
如2所述，schedule仅负责接收job-admin管理端调度后的远程方法的分发调用；与此同时，每个业务节点自身的定时任务需要在本业务节点中进行准备供远程调用；
此时：业务代码更为集中，schedule模块功能范畴更为清晰，实现了更可观的可扩展和易维护性；

- B、集中完程调度和实现
即在schedule模块中接收job-admin管理端调度后持续完成定时任务的逻辑内容，即定时任务不在需要编写在对应的业务节点中，而是各业务节点的定时任务都集中编写在
schedule模块中；对应的，schedule模块中会同时存在业务逻辑和调度逻辑，是否有弊端需根据项目实际情况而定；

- 选择：
两种业务调度模式的选择以项目而定，模式的切换其实仅按照实现代码的位置而定；

4. 目录:
本模块目录在开发伊始为了照顾所有可能性，采取了保守策略，目录规划较为完整：
- common：本模块通用内容
- dao：本模块数据层
- rest：本模块控制层
- service：本模块业务层
- xxl-job-admin：调度管理平台
- xxl-job-core：job调度核心模块

5. 
xxl-job是一款优秀成熟的轻量级项目，非常感谢作者xxl的贡献，更多了解请移步
xxl-job官方仓库地址：https://github.com/xuxueli/xxl-job


---------------------
##### 2018/07/11 InitVersion

---------------------
1. 使用xxl-job作为基础；封装为SpringCloud版本；

---------------------
