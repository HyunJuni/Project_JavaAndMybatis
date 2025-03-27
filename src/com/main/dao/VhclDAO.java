package com.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.SqlSessionConfig;

public class VhclDAO extends SqlSessionConfig{
	public List<Map<String, Object>> getCodeList() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("vhcl.getCodeList");
		return list;
	}
	
	public void insertDay(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("vhcl.insertDay", batchData);
	}

	public List<Map<String, Object>> getYearMonth() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("vhcl.getYearMonth");
		return list;
	}

	public void insertMonth(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("vhcl.insertMonth", batchData);
	}

	public List<Map<String, Object>> getYear() {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		List<Map<String, Object>> list = session.selectList("vhcl.getYear");
		return list;
	}

	public void insertYear(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("vhcl.insertYear", batchData);
	}

	public void insertHour(List<Map<String, Object>> batchData) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(true);
		session.insert("vhcl.insertHour", batchData);
	}
	
}
