package com.everyplan.apps;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlanDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		  return this.sqlSessionTemplate.insert("plan.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("plan.select_detail", map);
	}
	
	public int updateDetail(Map<String, Object> map){
		return this.sqlSessionTemplate.update("plan.update_detail", map);
	}
	
	public int deleteDetail(Map<String, Object> map){
		return this.sqlSessionTemplate.delete("plan.delete_detail", map);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map){
		return this.sqlSessionTemplate.selectList("plan.select_list", map);
	}
}
