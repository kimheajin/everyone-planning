package com.everyplan.apps;

import java.util.List;
import java.util.Map;

public interface PlanService {
	public String create(Map<String, Object> map);
	
	public Map<String, Object> selectDetail(Map<String, Object> map);
	
	public boolean edit(Map<String, Object> map);
	
	public boolean remove(Map<String, Object> map);
	
	public List<Map<String, Object>> list(Map<String, Object> map);
}
