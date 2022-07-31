package com.greatlearning.question1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.greatlearning.question1.model.Building;

public class AssemblyUnit {
	Building b;
	List<Integer> sizes = new ArrayList<Integer>();
	
	
	
	public AssemblyUnit(Building b) {
		this.b = b;
		for(int s: b.getFloorSize()) {
			this.sizes.add(s);
		}
		
	}
	
	public List<Integer> getSubFloorSize(int min, int max) {
		List<Integer> subFloorSize= new ArrayList<Integer>();
		for (int i = min; i <= max; i++) {
			subFloorSize.add(this.b.getFloorSize()[i]);
		}
		return subFloorSize;
	}
	
	public Map<Integer, List<Integer>> planning(){
		Map<Integer, List<Integer>> dayFloor = new HashMap<Integer, List<Integer>>();
		List<Integer> constructedSize = new ArrayList<Integer>();
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < this.sizes.size(); i++) {
			
				int max = Collections.max(sizes);
				int maxIndx = this.b.getIndex(max);
				ls.add(max);
				constructedSize.add(max);
				this.sizes.set(maxIndx, -1);
				dayFloor.put(i+1, ls);
				
				
				
				for (int j = 0; j < this.sizes.size(); j++) {

					
				}
			
		}
		
		return dayFloor;
	}
	
	public Map<Integer, List<Integer>> assembleFloors(){
		Map<Integer, List<Integer>> dayFloor = new HashMap<Integer, List<Integer>>();
		List<Integer> constructedSize = new ArrayList<Integer>();
		List<Integer> ls = new ArrayList<Integer>();
		
		for (int i = 0; i < this.sizes.size(); i++) {
			
			int max = Collections.max(sizes);
			int maxIndx = this.b.getIndex(max);
			ls.add(max);
			constructedSize.add(max);
			this.sizes.set(maxIndx, -1);
			if(maxIndx > 0 && maxIndx < this.b.getFloorSize().length-1) {
				List<Integer> left = this.getSubFloorSize(0, maxIndx-1);
				List<Integer> right = this.getSubFloorSize(maxIndx + 1, this.b.getFloors()-1);
				for (int j = 0; j < left.size(); j++) {
					if(right.isEmpty()) {
						while(Collections.max(left) > 0) {
							ls.add(Collections.max(left));
						}
						
					}
					else
					if(this.sizes.get(j) > Collections.max(right)) {
						ls.add(sizes.get(j));
						constructedSize.add(sizes.get(j));
						this.sizes.set(this.b.getIndex(sizes.get(j)), -1);
					}
				}
			}
			else if(maxIndx == this.b.getFloorSize().length-1) {
				
			}
			else if(maxIndx == 0) {
				
			}
			
			dayFloor.put(i+1, new ArrayList<Integer>(ls));
			ls.clear();
			
		}
		
		return dayFloor;
	}
	
	public Map<Integer, List<Integer>> assembleFloor(){
		int[] sortedFloors = this.b.getFloorSize().clone();
		Arrays.sort(sortedFloors);
		Map<Integer, List<Integer>> tmp = new HashMap<Integer, List<Integer>>();
		List<Integer> ls = new ArrayList<Integer>();
		int keyIndx;
		for (int i =sortedFloors.length-1; i>=0; i--) {
			
			for (int j = 0; j < sortedFloors.length; j++) {
				if(sortedFloors[i] == this.b.getFloorSize()[j]) {
					keyIndx = j;
					//ls.add(sortedFloors[i]);
					List<Integer> left = this.getSubFloorSize(0, keyIndx);
					List<Integer> right = this.getSubFloorSize(keyIndx + 1, this.b.getFloors()-1);
					for (Integer size : left) {
						if(!right.isEmpty()) {
							if(size > Collections.max(right)) {
								ls.add(size);
								left.remove(size);
								i--;
							}
						}
						else {
							
						}
					}
					
				}
				System.out.println(tmp);
				tmp.put(j, ls);
				ls.clear();
				
			}
			
			
		}
		
		/*
		 * for (int i = 0; i < b.getFloors(); i++) {
			System.out.println("Day "+ i);
			int[] left = this.getSubFloorSize(0, i);
			int[] right = this.getSubFloorSize(i, this.b.getFloors());
			Arrays.sort(left);
			Arrays.sort(right);
			for (int j = 0; j < left.length; j++) {
				int[] size = new int[left.length];
				if(left[left.length-1-j] > right[right.length-1]) {
					size[j]=left[left.length-1-j];
					ls.add(left[left.length-1-j]);
				}
				tmp[i]=size.clone();
				
			}	
		}
		 * 
		 */
		
		return tmp;
	}

}
