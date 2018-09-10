package com.bootdo.seahigh.lte.service;

import com.bootdo.seahigh.lte.domain.CommonObjectDO;

import java.util.List;
import java.util.Map;

/**
 * 通用对象
 * 
 * @author Roger Wang
 * @email 476410060@qq.com
 * @date 2018-09-10 16:25:59
 */
public interface CommonObjectService {
	
	CommonObjectDO get(Long id);
	
	List<CommonObjectDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CommonObjectDO commonObject);
	
	int update(CommonObjectDO commonObject);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
