package com.fujitsu.cn.iot.console.common.dto;

import com.fujitsu.cn.iot.console.common.dto.impl.BaseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DtoHelper {

	public static Dto DtoConvert(Dto tagDto,String... names){

		Dto d = new BaseDto();
		for (String name : names) {
			d.put(name, tagDto.getAsString(name));
		}

		return d;

	}

	public static List<Dto> DtoConvertList(List<Dto> tagDtoList,String... names){

		List<Dto> tmpList = new ArrayList<Dto>();
		for (Dto singleDto : tagDtoList) {

			Dto tmpDto = DtoConvert(singleDto,names);
			tmpList.add(tmpDto);
		}
		return tmpList;
	}

	public static Dto JsonToDto(Map<String,Object> map,String ...nm){

		Dto d = new BaseDto();

		for (String key : nm) {
			d.put(key, map.get(key));
		}

		return d;


	}

}
