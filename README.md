## 简介
yiming-boot 是一个基于Spring Boot & MyBatis & Mybatis Plus的脚手架项目，用于快速构建中小型API、RESTful API项目。

## 功能点
- 最佳实践的项目结构、配置文件、精简的POM
- 统一响应结果封装及生成工具
- 统一异常处理
- 集成MyBatis、Mybatis plus，实现单表业务零SQL
- 提供代码生成器根据表名生成对应的Model、Mapper、MapperXML、Service、ServiceImpl、Controller等基础代码
- 一键执行脚本```doc```目录下```start.sh```，查找进程，关闭进程，重启服务一步呵成。
- 提供Swagger管理api文档，可以直接在文档页面尝试 API 的调用，省去了准备复杂的调用参数的过程。
- 数据库实体基类，提供基础字段，详见```BaseEntity```。
- 基于Mybatis plus提供逻辑删除功能。
 
## 生成代码(MyBatis plus 提供)
1. 配置```CodeGenerator```的数据库地址和用户名，密码
2. 运行```CodeGenerator.main()```方法，在控制台输入模块名和表名，生成基础代码
 
## 开发建议
- 表名，建议使用小写，多个单词使用下划线拼接。
- Model内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加```@TableField(exist = false)```注解。
- 建议业务失败直接使用```BusinessException("message")```抛出，由统一异常处理器来封装业务失败的响应结果，比如```throw new BusinessException("该手机号已被注册")```，会直接被封装为```{"code":400,"message":"该手机号已被注册"}```返回，无需自己处理，尽情抛出
- 需要工具类的话建议先从```hutool```中找，实在没有再造轮子或引入类库，尽量精简项目
- 开发规范建议遵循阿里巴巴Java开发手册（[最新版下载](https://github.com/alibaba/p3c))
 
## 技术选型&文档
- Spring Boot（[查看Spring Boot学习&使用指南](http://www.jianshu.com/p/1a9fd8936bd8)）
- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- MyBatis plus（[查看官方中文文档](https://mybatis.plus/)）