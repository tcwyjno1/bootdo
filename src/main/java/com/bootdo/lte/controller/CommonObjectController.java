package com.bootdo.lte.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.DeptDO;
import com.bootdo.system.domain.RoleDO;
import com.bootdo.system.domain.UserDO;
import com.bootdo.system.service.DeptService;
import com.bootdo.system.service.MenuService;
import com.bootdo.system.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.lte.domain.CommonObjectDO;
import com.bootdo.lte.service.CommonObjectService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 通用对象
 * 
 * @author Roger Wang
 * @email 476410060@qq.com
 * @date 2018-09-12 16:21:07
 */
 
@Controller
@RequestMapping("/lte/commonObject")
public class CommonObjectController {
	@Autowired
	private CommonObjectService commonObjectService;

    @Autowired
    private RoleService roleService;
	@Autowired
	private DeptService deptService;
    @Autowired
    private MenuService menuService;
	@GetMapping()
	@RequiresPermissions("lte:commonObject:commonObject")
	String CommonObject(){
	    return "lte/commonObject/commonObject";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("lte:commonObject:commonObject")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        UserDO user = ShiroUtils.getUser();
        List<RoleDO> roles = roleService.list(user.getUserId());
		boolean checkDetp = true;
        for(RoleDO roleDO:roles){
			if(Objects.equals("true",roleDO.getRoleSign())){
				if(Objects.equals("超级用户角色",roleDO.getRoleName())){
					checkDetp = false;
				}
			}
		}
		if(checkDetp){
        	DeptDO deptDO = deptService.get(user.getDeptId());
        	if(deptDO.getParentId() != null && deptDO.getParentId() == 0){
                query.put("deptParentId",user.getDeptId());
            }else{
                query.put("deptParentId",deptDO.getParentId());
                query.put("deptId",user.getDeptId());
            }

		}
		List<CommonObjectDO> commonObjectList = commonObjectService.list(query);
         

		int total = commonObjectService.count(query);
		PageUtils pageUtils = new PageUtils(commonObjectList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("lte:commonObject:add")
	String add(){
	    return "lte/commonObject/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("lte:commonObject:edit")
	String edit(@PathVariable("id") Long id,Model model){
		CommonObjectDO commonObject = commonObjectService.get(id);
		model.addAttribute("commonObject", commonObject);
	    return "lte/commonObject/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("lte:commonObject:add")
	public R save( CommonObjectDO commonObject){
		if(commonObjectService.save(commonObject)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("lte:commonObject:edit")
	public R update( CommonObjectDO commonObject){
		commonObjectService.update(commonObject);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("lte:commonObject:remove")
	public R remove( Long id){
		if(commonObjectService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("lte:commonObject:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		commonObjectService.batchRemove(ids);
		return R.ok();
	}
	
}
