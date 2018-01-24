#前言
1、先不要看代码结构  
2、运行项目  
3、访问 localhost:8080/api/firstBlood  



#认识接口
1、看看 IndexController ，IndexController 中包含的就是后端接受请求的接口们。可以自己先照着葫芦画瓢，自己写一个可访问的接口（详细注释见 IndexController）  
2、看看 PersonController，这里面提到了传递复杂参数的案例  
3、大体瞜一眼那些加注释的地方，了解注入的大体意思  
4、可以自己尝试写一个新的 Controller



#项目结构
    |--src
        |--main
            |--java: 编译后都会指向 classpath
                |--com.luojunsheng
                    |--controller: 一般会把接口类都放在某个包下面，名称不一定叫controller，有的叫api，也有的叫web  
                        IndexController  
                        PersonController  
                    |--service: 一半会放业务接口
                        |--impl: 一般会放业务接口的实现类  
                        PersonService
                    |--domain: 实体类
                    |--enums: 枚举类
            |--resources: 此目录与java目录相同，编译后都会指向 classpath，存放各种配置文件的地方（xml（如Spring/springmvc的配置文件），properties，有可能还会有 html 或者 css js 等静态文件）
                |--config: resources下可以随意创建多级目录，也可以不创建，此目录可以不用特意创建，可以忽略
                    |--applicationContext.xml: springMVC的配置文件
            |--webapp: 这个文件是web基础中的内容，此处不做赘述
                |--WEB-INF: 同上
                    web.xml: 同上
    |--target: 这个文件是maven将项目打好包后存放的目标目录，属于maven的内容
ps: 可以代表一般项目结构，没有必要一一对应，可跑通demo后再细细的看


#真相
1、其实这是一个web项目上添加了SpringMVC，并没有特意配置Spring。
2、理解上SpringMVC是Spring中的一个模块，但实际上，一个web项目，只配置SpringMVC就可以完全实现Spring的任何功能。就目前而言，也就是说：Spring能做到的，SpringMVC都能做到，所以只配置SpringMVC就ok，而且完全不影响你跑一些Spring的demo

    

