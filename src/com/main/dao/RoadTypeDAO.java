package com.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.SqlSessionConfig;

public class RoadTypeDAO extends SqlSessionConfig{
	public List<Map<String, Object>> getCodeList() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("roadtype.getCodeList");
		return list;
	}
	
	public void insertDay(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("roadtype.insertDay", batchData);
	}

	public List<Map<String, Object>> getYearMonth() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("roadtype.getYearMonth");
		return list;
	}

	public void insertMonth(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("roadtype.insertMonth", batchData);
	}

	public List<Map<String, Object>> getYear() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("roadtype.getYear");
		return list;
	}

	public void insertYear(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("roadtype.insertYear", batchData);
	}

	public void insertHour(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("roadtype.insertHour", batchData);
	}
	
}
