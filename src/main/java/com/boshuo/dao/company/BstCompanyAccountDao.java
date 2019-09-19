package com.boshuo.dao.company;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boshuo.entity.pojo.BstCompanyAccountEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * ${comments}
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 08:50:46
 */
@Mapper
public interface BstCompanyAccountDao extends BaseMapper<BstCompanyAccountEntity> {

    @Select("select count(1)")
    int queryComany(@Param("comname")String comname);
	
}
