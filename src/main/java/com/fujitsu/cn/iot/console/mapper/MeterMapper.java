package com.fujitsu.cn.iot.console.mapper;


import com.fujitsu.cn.iot.console.common.dto.Dto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeterMapper {

    List<Dto> queryMeter(Dto d);

}
