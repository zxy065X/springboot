package com.boshuo.dao.person;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boshuo.entity.pojo.BstPersonBasicEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ${comments}
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-16 18:13:55
 */
@Mapper
public interface BstPersonBasicDao extends BaseMapper<BstPersonBasicEntity> {

    @Select("select count(1) from bst_Person_Basic where phone = #{phone}")
    int queryEntity(@Param("phone")String phone);
	
}
