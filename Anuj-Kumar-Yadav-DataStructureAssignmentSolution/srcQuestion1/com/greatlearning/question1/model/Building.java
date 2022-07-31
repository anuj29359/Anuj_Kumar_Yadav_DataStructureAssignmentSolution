package com.greatlearning.question1.model;

import java.util.Arrays;
import java.util.Scanner;

public class Building {
	int floors;
	int[] floorSize = new int[floors];
	int[][] floorPlan = new int[floors][];
	
	public int getIndex(int n) {
		int indx =-1;
		for (int i = 0; i < floorSize.length; i++) {
			if(floorSize[i] == n) {
				indx = i;
			}
		}
		return indx;
	}
	
	public int getMaxSize() {
		int max =floorSize[0];
		for (int i = 1; i < floorSize.length; i++) {
			
			if(max < floorSize[i]) {
				max = floorSize[i];
			}
			
		}
		return max;
	}
	
	
	public int[][] getFloorPlan() {
		return floorPlan;
	}

	public void setFloorPlan(int[][] floorPlan) {
		this.floorPlan = floorPlan;
	}

	/**
	 * @param floors
	 * @param floorSize
	 */
	public Building() {
		super();
		
		int[] floorSize;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the floors-");
		this.floors = sc.nextInt();
		this.floorSize = new int[this.floors];
		
		for (int i = 0; i < this.floors; i++) {
			System.out.println("Enter the floor size for " + i + " floor:");
			int sz = sc.nextInt();
			while(sz <=0) {
				System.out.println("Invalid Input, floor size must be a positive number, \n enter again:");
				sz = sc.nextInt();
			}
			this.floorSize[i]=sz;
		}
		
	}
	
	public int getFloors() {
		return floors;
	}
	public int[] getFloorSize() {
		return floorSize;
	}
	
	public void showFloors() {
		System.out.println(Arrays.toString(this.floorSize));
		
	}
	

}
