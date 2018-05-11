package com.cts.himalaya;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Himalaya {
	
	/**
	 * Method to check if two rectangles overlaps each other or not
	 * @param mine1
	 * @param mine2
	 * @return
	 */
	public boolean isOverlapping(Mine mine1, Mine mine2){
		
		if((mine1.x0 > mine2.x1)||(mine1.x1<mine2.x0)||( mine1.y0 > mine2.y1)||(mine1.y1 < mine2.y0)){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	/**
	 * A recursion method to perform a DFS similar search to check if rest of the nodes are connected the root node or not.
	 * In each recursion, this method will fetch the next connected node and remove it from the list as well as make it the root node
	 * It will then search connected node using the new root node and so on... 
	 * @param mine: The root node
	 * @param mineArray: remaining node list
	 */
	public void checkNode(Mine mine, List<Mine> mineArray){
		Mine tempMine;
		Iterator<Mine> mineIterator = mineArray.iterator();
		//Iterate over the list till we find a connected node
		while(mineIterator.hasNext()){
			tempMine = mineIterator.next();
			if(isOverlapping(mine, tempMine)){
				//remove the connected node and make it root node for next recursion
				mineIterator.remove();
				checkNode(tempMine, mineArray);
			}
		}
	}
	
	public static void main(String args[]) throws IOException{
		
		Himalaya himalaya = new Himalaya();
		
		//Open a scanner to read inputs from user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of mines\n");
		//Read the total number of mines
		int rectangles = Integer.parseInt(sc.next());
		
		String coordinates;
		String coordinateArray[];
		Mine mine;
		List<Mine> mineArray = new LinkedList<Mine>();
		
		//Read coordinates of each rectangular mine
		for(int rectNo = 1; rectNo <= rectangles; rectNo++){
			System.out.println("Enter comma separatd coordinates as x1,y1,x2,y2\n");
			coordinates = sc.next();
			coordinateArray = coordinates.split(",");
			//Take a mine object
			mine = new Mine();
			//Set the coordinates
			mine.setX0(Integer.parseInt(coordinateArray[0]));
			mine.setY0(Integer.parseInt(coordinateArray[1]));
			mine.setX1(Integer.parseInt(coordinateArray[2]));
			mine.setY1(Integer.parseInt(coordinateArray[3]));
			//Store the mine object into the mine list
			mineArray.add(mine);
		}
		//Close the stream
		sc.close();
		
		//Search the items in DFS similar fashion using recursion
		mine = mineArray.get(0);
		mineArray.remove(0);
		himalaya.checkNode(mine, mineArray);
		
		//If the mines are connected then there will be no item left
		if(mineArray.isEmpty()){
			System.out.println("We can go for expedition");
		} else{
			System.out.println("We cannot go for expedition");
		}
		
		
	}

}
