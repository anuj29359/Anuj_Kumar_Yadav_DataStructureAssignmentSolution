package com.greatlearning.question1.driver;
import com.greatlearning.question1.services.*;
import java.util.*;

public class BuildingSkyscraper{
    public static void main(String[] args) {
        SkyscraperOrganizer test = new SkyscraperOrganizer();

        System.out.println("Enter the total number of floors in the building-");
        Scanner sc = new Scanner(System.in);
        int floors = sc.nextInt();
        List<Integer> floorSizes = new ArrayList<>();
        //(5, 4, 7, 3, 6, 2, 1)
        for (int i = 0; i < floors; i++) {
			System.out.println("Enter the size given on day:" + i);
			floorSizes.add(sc.nextInt());
		}
        List<List<Integer>> result =
                test.calculateFloorConstruction(floorSizes);

        System.out.println(result);
    }

}

