package com.example.virusmap.Mapper;

import com.example.virusmap.Domain.datastr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //@Mapper注解是由Mybatis框架中定义的一个描述数据层接口的注解，注解往往起到的都是一个描述性作用，用于告诉sprigng框架此接口的实现类由Mybatis负责创建，并将其实现类对象存储到spring容器中。

public interface datadao {
    public List<datastr> getList();


}
