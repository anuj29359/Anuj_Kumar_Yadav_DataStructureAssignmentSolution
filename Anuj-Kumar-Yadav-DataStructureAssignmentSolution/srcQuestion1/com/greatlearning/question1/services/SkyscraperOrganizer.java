package com.greatlearning.question1.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SkyscraperOrganizer{
    public List<List<Integer>> calculateFloorConstruction(List<Integer> floorSizes){
        Integer totalFloors = floorSizes.size();
        PriorityQueue<Integer> visitedFloors = new PriorityQueue<>(Collections.reverseOrder());
        List<List<Integer>> results = new ArrayList<>();

        //We start with the highest numbered floor
        Integer currentDesiredFloor = totalFloors;

        for(Integer floor: floorSizes) {
            visitedFloors.add(floor);
            List<Integer> floorsToBeConstructedToday = new ArrayList<>();

            //Heap top is the highest numbered floor we have visited till now
            //Keep popping elements from heap till we can build it on top of
            //current floor
            while(canConstruct(visitedFloors, currentDesiredFloor)){
                Integer topElement = visitedFloors.poll();
                floorsToBeConstructedToday.add(topElement);

                currentDesiredFloor--;
            }
            results.add(floorsToBeConstructedToday);
        }
        return results;
    }

    private boolean canConstruct(PriorityQueue<Integer> visitedFloorsHeap, Integer currentDesiredFloor) {
        return visitedFloorsHeap.peek() != null &&
               visitedFloorsHeap.peek().equals(currentDesiredFloor);
    }
}