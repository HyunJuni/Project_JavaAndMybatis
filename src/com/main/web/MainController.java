package com.main.web;

public class MainController {

	public static void main(String[] args) {
		// 도시
		LocationController location = new LocationController();
		location.insert_data();
		
		// 차종별
		VhclController vhcl = new VhclController();
		vhcl.insert_data();
		
		// 도로유형별		
		RoadTypeController roadType = new RoadTypeController();
		roadType.insert_data();
		
		// 성별
		GenderController gender = new GenderController();
		gender.insert_data();
		
		// 나이그룹별
		AgeRangeController ageRange = new AgeRangeController();
		ageRange.insert_data();

		// 사고원인별
		AccidentReasonController acidReason = new AccidentReasonController();
		acidReason.insert_data();
	}
}
