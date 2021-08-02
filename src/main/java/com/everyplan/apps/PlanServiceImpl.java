package com.everyplan.apps;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements PlanService {
	@Autowired
	PlanDao planDao;

	@Override
	public String create(Map<String, Object> map) {
		int affectCount = this.planDao.insert(map);
		if(affectCount == 1) {
			return map.get("plan_id").toString();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.planDao.selectDetail(map);
	}

	@Override
	public boolean edit(Map<String, Object> map) {
		int affectRowCount = this.planDao.updateDetail(map);
		return affectRowCount == 1;
	}

	@Override
	public boolean remove(Map<String, Object> map) {
		int affectRowCount = this.planDao.deleteDetail(map);
		return affectRowCount == 1;
	}
	
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.planDao.selectList(map);
	}
}
