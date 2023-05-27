package com.example.virusmap.controller;
import com.example.virusmap.Domain.datastr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.virusmap.Mapper.datadao;
//负责具体模块的业务流程控制，负责接受用户的请求，展示数据
import java.util.List;
@CrossOrigin  //解决跨域问题
@RestController //将对象以可序列化对象传递给前端
public class HelloController {
    @Autowired //它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。
    private datadao data;
    @RequestMapping("/data") //注解请求路径
    public List hello(){
        List<datastr> list= data.getList();
        return list;
    }
}
