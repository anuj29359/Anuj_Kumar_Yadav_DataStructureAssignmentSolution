package com.greatlearning.question1.driver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.greatlearning.question1.model.Building;
import com.greatlearning.question1.services.AssemblyUnit;

public class SkyScraper {

	public static void main(String[] args) {
		
		Building bld = new Building();
		bld.showFloors();
		
		AssemblyUnit au = new AssemblyUnit(bld);
		Map<Integer, List<Integer>> bldProgress = new HashMap<Integer, List<Integer>>();
		bldProgress = au.assembleFloors();
		System.out.println(bldProgress);

	}

}
