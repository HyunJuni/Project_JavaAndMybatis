package com.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.SqlSessionConfig;

public class LocationDAO extends SqlSessionConfig{
	public List<Map<String, Object>> getLocation() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("location.getLocation");
		return list;
	}
	
	public void insertDay(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("location.insertDay", batchData);
	}

	public List<Map<String, Object>> getYearMonth() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("location.getYearMonth");
		return list;
	}

	public void insertMonth(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("location.insertMonth", batchData);
	}

	public List<Map<String, Object>> getYear() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("location.getYear");
		return list;
	}

	public void insertYear(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("location.insertYear", batchData);
	}

	public void insertHour(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("location.insertHour", batchData);
	}
}
