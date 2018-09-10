package com.bootdo.seahigh.lte.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.seahigh.lte.dao.CommonObjectDao;
import com.bootdo.seahigh.lte.domain.CommonObjectDO;
import com.bootdo.seahigh.lte.service.CommonObjectService;



@Service
public class CommonObjectServiceImpl implements CommonObjectService {
	@Autowired
	private CommonObjectDao commonObjectDao;
	
	@Override
	public CommonObjectDO get(Long id){
		return commonObjectDao.get(id);
	}
	
	@Override
	public List<CommonObjectDO> list(Map<String, Object> map){
		return commonObjectDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return commonObjectDao.count(map);
	}
	
	@Override
	public int save(CommonObjectDO commonObject){
		return commonObjectDao.save(commonObject);
	}
	
	@Override
	public int update(CommonObjectDO commonObject){
		return commonObjectDao.update(commonObject);
	}
	
	@Override
	public int remove(Long id){
		return commonObjectDao.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return commonObjectDao.batchRemove(ids);
	}
	
}
