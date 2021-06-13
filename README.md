



# 基于MVC+Maven+JDBC+JSP+Servlet实现的JavaWeb项目

一个用户一个购物车，有登录功能但是没截图
## 1、界面展示

![image-20210604203951211](https://i.loli.net/2021/06/08/SfTF2CtjMueZp9o.png)
![image-20210604204016216](https://i.loli.net/2021/06/08/5BikSqwl9vpaCUJ.png)

![image-20210604204201608](https://i.loli.net/2021/06/08/FJcQenrNgGO75bP.png)

![image-20210604204221254](https://i.loli.net/2021/06/08/vpu4Fx6GBe28X1h.png)



## 2、如何在你的电脑上运行这个项目


** 
需要的环境
jdk8 + maven + mysql 8.0.23
**
1. 下载完成后再idea导入这个包

   ![image-20210608140645442](https://i.loli.net/2021/06/08/szZ8ug5BQC13nk2.png)

2. 将resource目录marked as resourceRepositories

   ![image-20210608141150330](https://i.loli.net/2021/06/08/XbVThcnNaD3SUgY.png)

3. 创建一个MySQL数据库，创建表的sql语句在同级目录中

4. 修改db.properties中的用户名和密码和使用的数据库

   ```properties
   #数据库配置文件,然后在Basedao读取这个文件
   driver=com.mysql.jdbc.Driver
   url=jdbc:mysql://localhost:3306/使用的数据库
   username=MySQL账号
   password=MySQL登录密码
   ```


