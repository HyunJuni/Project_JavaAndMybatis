package com.main.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.main.dao.AccidentReasonDAO;
import com.main.dao.LocationDAO;

public class AccidentReasonController {
	LocationDAO locationDao = new LocationDAO();
	AccidentReasonDAO dao = new AccidentReasonDAO();
	
	// 작년데이터(도로유형별)
	public void insert_data() {
		System.out.println("****************accident reason start**************");
		// 지자체 리스트 조회 
		List<Map<String, Object>> list = locationDao.getLocation();
		List<Map<String, Object>> codeList = dao.getCodeList();
		List<Map<String, Object>> batchData = new ArrayList<>();
		
		try {
			// 시간 데이터(양이 많아서 따로 진행)
			for(Map<String, Object> map : list) {
				LocalDate startDate = LocalDate.of(2025, 2, 13);
		        LocalDate endDate = LocalDate.of(2025, 2, 20);
		        
		        // 날짜를 출력할 포맷 설정 (yyyy-MM-dd)
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		        
		        // 현재 날짜가 끝 날짜보다 작거나 같은 동안 반복
		        LocalDate currentDate = startDate;
		        System.out.println("start : "+map.get("CITY_CD"));
		        
		        while (!currentDate.isAfter(endDate)) {
		        	String day = currentDate.format(formatter);
		        	for(int j=0; j<codeList.size(); j++) {
		        		for(int k=0; k<24; k++) {
		        			String hour = "";
		        			if(k < 10) {
		        				hour = "0"+k;
		        			}else {
		        				hour = ""+k;
		        			}
		        			
		        			int randomNumber1 = (int) (Math.random() * 101);
				    		int randomNumber2 = (int) (Math.random() * 101);
				    		int randomNumber3 = (int) (Math.random() * 101);
				    		int randomNumber4 = (int) (Math.random() * 101);
				    		
				    		Map<String, Object> param = new HashMap<String, Object>();
				    		param.put("stat", day+hour);
				    		param.put("city_cd", map.get("CITY_CD"));
				    		param.put("code_id", codeList.get(j).get("CODE_ID"));
				    		param.put("acdnt_cnt", randomNumber1);
				    		param.put("injpsn_cnt", randomNumber2);
				    		param.put("dcsd_cnt", randomNumber3);
				    		param.put("vhcl_cnt", randomNumber4);
				    		
				    		batchData.add(param);
				    		
				    		// 배치 처리
			                if (batchData.size() >= 1000) { // 예를 들어, 1000개마다 배치 실행
			                	dao.insertHour(batchData);
			                    batchData.clear(); // 배치 데이터 초기화
			                }
		        		}
		        	}
		            currentDate = currentDate.plusDays(1);  // 하루씩 증가
		        }
		        System.out.println("end : "+map.get("CITY_CD"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 배치 처리
            if (batchData.size() > 0) { // 예를 들어, 1000개마다 배치 실행
            	dao.insertHour(batchData);
                batchData.clear(); // 배치 데이터 초기화
            }
		}
		
		System.out.println("****************day start**************");
		
		try {
			
			// 일 데이터
			for(Map<String, Object> map : list) {
				LocalDate startDate = LocalDate.of(2024, 1, 1);
		        LocalDate endDate = LocalDate.of(2025, 3, 2);
		        
		        // 날짜를 출력할 포맷 설정 (yyyy-MM-dd)
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		        
		        // 현재 날짜가 끝 날짜보다 작거나 같은 동안 반복
		        LocalDate currentDate = startDate;
		        System.out.println("start : "+map.get("CITY_CD"));
		        
		        while (!currentDate.isAfter(endDate)) {
		        	String day = currentDate.format(formatter);
		        	for(int j=0; j<codeList.size(); j++) {
		        		int randomNumber1 = (int) (Math.random() * 101);
			    		int randomNumber2 = (int) (Math.random() * 101);
			    		int randomNumber3 = (int) (Math.random() * 101);
			    		int randomNumber4 = (int) (Math.random() * 101);
			    		
			    		Map<String, Object> param = new HashMap<String, Object>();
			    		param.put("stat", day);
			    		param.put("city_cd", map.get("CITY_CD"));
			    		param.put("code_id", codeList.get(j).get("CODE_ID"));
			    		param.put("acdnt_cnt", randomNumber1);
			    		param.put("injpsn_cnt", randomNumber2);
			    		param.put("dcsd_cnt", randomNumber3);
			    		param.put("vhcl_cnt", randomNumber4);
			    		
			    		batchData.add(param);
			    		
			    		// 배치 처리
		                if (batchData.size() >= 1000) { // 예를 들어, 1000개마다 배치 실행
		                	dao.insertDay(batchData);
		                    batchData.clear(); // 배치 데이터 초기화
		                }
			    		
		        	}
		            currentDate = currentDate.plusDays(1);  // 하루씩 증가
		        }
		        System.out.println("end : "+map.get("CITY_CD"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 배치 처리
            if (batchData.size() > 0) { // 예를 들어, 1000개마다 배치 실행
            	dao.insertDay(batchData);
                batchData.clear(); // 배치 데이터 초기화
            }
		}
		System.out.println("****************day end**************");
		
		System.out.println("****************month start**************");
		
		try {
			// 월 데이터
			List<Map<String, Object>> monthList = dao.getYearMonth();
			for(Map<String, Object> month : monthList) {
				
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("stat", month.get("MONTH"));
				param.put("city_cd", month.get("CITY_CD"));
				param.put("code_id", month.get("ACDNT_RSN_CD"));
				param.put("acdnt_cnt", month.get("ACDNT_CNT_TOTAL"));
				param.put("injpsn_cnt", month.get("INJPSN_CNT_TOTAL"));
				param.put("dcsd_cnt", month.get("DCSD_CNT_TOTAL"));
				param.put("vhcl_cnt", month.get("VHCL_CNT_TOTAL"));
				
				batchData.add(param);
	    		
	    		// 배치 처리
                if (batchData.size() >= 500) { // 예를 들어, 1000개마다 배치 실행
                	dao.insertMonth(batchData);
                    batchData.clear(); // 배치 데이터 초기화
                }
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 배치 처리
            if (batchData.size() > 0) { // 예를 들어, 1000개마다 배치 실행
            	dao.insertMonth(batchData);
                batchData.clear(); // 배치 데이터 초기화
            }
		}
		
		System.out.println("****************month end**************");
		
		// 년 데이터
		System.out.println("****************year start**************");
		
		try {
			// 월 데이터
			List<Map<String, Object>> yearList = dao.getYear();
			for(Map<String, Object> year : yearList) {
				
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("stat", year.get("YEAR"));
				param.put("city_cd", year.get("CITY_CD"));
				param.put("code_id", year.get("ACDNT_RSN_CD"));
				param.put("acdnt_cnt", year.get("ACDNT_CNT_TOTAL"));
				param.put("injpsn_cnt", year.get("INJPSN_CNT_TOTAL"));
				param.put("dcsd_cnt", year.get("DCSD_CNT_TOTAL"));
				param.put("vhcl_cnt", year.get("VHCL_CNT_TOTAL"));
				
				batchData.add(param);
	    		
	    		// 배치 처리
                if (batchData.size() >= 100) { // 예를 들어, 1000개마다 배치 실행
                	dao.insertYear(batchData);
                    batchData.clear(); // 배치 데이터 초기화
                }
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 배치 처리
            if (batchData.size() > 0) { // 예를 들어, 1000개마다 배치 실행
            	dao.insertYear(batchData);
                batchData.clear(); // 배치 데이터 초기화
            }
		}
		
		System.out.println("****************year end**************");
		
		System.out.println("****************accident reason end**************");
	}
}
