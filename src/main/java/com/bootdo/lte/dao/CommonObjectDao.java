package com.bootdo.lte.dao;

import com.bootdo.lte.domain.CommonObjectDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 通用对象
 * @author Roger Wang
 * @email 476410060@qq.com
 * @date 2018-09-12 16:21:07
 */
@Mapper
public interface CommonObjectDao {

	CommonObjectDO get(Long id);
	
	List<CommonObjectDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CommonObjectDO commonObject);
	
	int update(CommonObjectDO commonObject);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
