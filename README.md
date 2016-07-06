## MChat - 基于Photobuf序列化的Netty聊天服务器

### 1.0 架构


### 2.0 通讯协议

  所有MChat内的报文，都遵循以下格式

  type 报文类型，枚举类型，包含：TEXT，LOCATION，VOICE，IMAGE，ACK，ERROR
  
  version 版本号，32位整形
  
  from 发送方ID,64位整形
  
  to 接受方ID，64位整形
  
  bytes 数据主体
  
  flag = 6 标志位,32位整形， 用于代表各种协议代码
  
  hash = 7 哈希，32位整形，用于校验，暂时没用，报文完整性依赖于Protobuf

  具体组织形式依赖于Protobuf

通讯报文列表

  ACK_SC_ 既从服务端发到客户端(SC)的ACK报文


### 2.1 服务器-客户端通信协议

  服务器询问客户端，要求注册:
  
  客户端提交注册信息→服务端记录→返回注册成功→开始聊天
  
  客户端未提交注册信息（超时ClientRegisterTimeOut）→服务端关闭当前连接
  
  信息明细:

  服务器要求注册 ACK_SC_REG_PING Message.TYPE = ACK Message.FLAG flag = 0

  客户端注册信息 ACK_CS_REG_PONG Message.TYPE = ACK Message.FLAG flag = 1
