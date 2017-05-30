package com.fujitsu.cn.iot.console.mapper;


import com.fujitsu.cn.iot.console.model.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user WHERE user_code = #{userCode}")
    User queryByUsrCd(@Param("userCode") String userCode);

}
