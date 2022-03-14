#MVC三层结构
Model
- 业务处理：业务逻辑（Service）
- 数据持久层：CRUD（Dao）

View
- 展示数据
- 提供链接发起Servlet请求（a,form,img...）

Controller(Servlet)
- 接收用户请求：(req：请求参数，Session信息...)
- 交给业务层处理对应的代码
- 控制视图跳转
