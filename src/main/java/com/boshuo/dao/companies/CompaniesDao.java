package com.boshuo.dao.companies;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boshuo.entity.pojo.CompaniesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-10 16:36:24
 */
@Mapper
public interface CompaniesDao extends BaseMapper<CompaniesEntity> {


    @Select("select id from companies where comname = #{name}")
    List<String> selectIdByName(@Param("name")String name);
}
