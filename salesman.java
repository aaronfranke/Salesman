
package Salesman;

import java.util.Arrays;
import java.util.Scanner;

public class salesman {

	public static void main(String[] args) {
		byte axisCount = 2;
		
		//Begin Point Input Section
		Scanner keyboard = new Scanner(System.in);
		System.out.print("How many points? ");
		int pointCount = keyboard.nextInt();
		//Define arrays and variables
		double[][] points = new double[pointCount][axisCount];
		double[][] distance = new double[pointCount][pointCount + 1];
		double distanceDifference, shortestDistance, totalDistance = 0;
		int[] pointOrder = new int[pointCount];
		int shortestPoint;
		//Sets initial values of the order of points
		Arrays.fill(pointOrder, -1);
		pointOrder[0] = 0; pointOrder[1] = 1; pointOrder[2] = 2;
		
		//Enter point coordinates
		for (int currentPoint = 0; currentPoint < pointCount; currentPoint++) {
			int displayPoint = currentPoint + 1;
			System.out.print("Enter point #" + displayPoint + "'s X coordinate: ");
			points[currentPoint][0] = keyboard.nextDouble();
			System.out.print("Enter point #" + displayPoint + "'s Y coordinate: ");
			points[currentPoint][1] = keyboard.nextDouble();
		}
		System.out.println();
		//End Point Input Section
		
		//Begin Point Readout Section
		System.out.println("Readout of the points for verification: ");
		for (int currentPoint = 0; currentPoint < pointCount; currentPoint++) {
			int displayPoint = currentPoint + 1;
			System.out.println("Point #" + displayPoint + "'s X: " + points[currentPoint][0] + ", Y: " + points[currentPoint][1]);
		}
		System.out.println();
		//End Point Readout Section
		
		
		
		//Begin Distance Calculation Section
		for (int currentPointX = 0; currentPointX < pointCount; currentPointX++) {
			for (int currentPointY = 0; currentPointY < pointCount; currentPointY++) {
				double distX = (points[currentPointX][0]-points[currentPointY][0]);
				double distY = (points[currentPointX][1]-points[currentPointY][1]);
				double pointDistance = Math.sqrt(distX * distX + distY * distY);
				distance[currentPointX][currentPointY] = pointDistance;
				distance[currentPointY][currentPointX] = pointDistance;
			}
		}
		//End Distance Calculation Section

		//Begin Distance Readout Section
		System.out.println("Readout of the distances for verification: ");
		for (int currentPointX = 0; currentPointX < pointCount; currentPointX++) {
			for (int currentPointY = 0; currentPointY < pointCount; currentPointY++) {
				if (currentPointX < currentPointY) {
					int displayPointX = currentPointX + 1;
					int displayPointY = currentPointY + 1;
					System.out.println("Distance from point #" + displayPointX + " to point #" + displayPointY + ": " + distance[currentPointX][currentPointY]);
				}
			}
		}
		System.out.println();
		//End Distance Readout Section
		
		
		
		//Start Point Order Calculation Section
		for (int currentPoint = 3; currentPoint < pointCount; currentPoint++) {
			shortestDistance = -1;
			shortestPoint = -1;
			for (int comparePoint = 0; comparePoint < currentPoint; comparePoint++) {
				
				//System.out.println("DEBUG: Compare Loop! " + comparePoint);
				
				if (comparePoint == currentPoint - 1) {
					distanceDifference = (distance[pointOrder[comparePoint]][currentPoint] + distance[pointOrder[0]][currentPoint]) - distance[pointOrder[comparePoint]][pointOrder[0]];
				} else {
					distanceDifference = (distance[pointOrder[comparePoint]][currentPoint] + distance[pointOrder[comparePoint + 1]][currentPoint]) - distance[pointOrder[comparePoint]][pointOrder[comparePoint + 1]];
				}
				
				if (distanceDifference < shortestDistance | shortestDistance == -1) {
					shortestDistance = distanceDifference;
					shortestPoint = comparePoint;
				}
			}
			
			for (int comparePoint = pointCount - 1; comparePoint > shortestPoint + 1; comparePoint--) {
				pointOrder[comparePoint] = pointOrder[comparePoint - 1];
			}
			pointOrder[shortestPoint + 1] = currentPoint;
			
			/*
			System.out.println("DEBUG: Readout of the order the points should go in: ");
			for (int printPoint = 0; printPoint < pointCount; printPoint++) {
				int displayPoint = printPoint + 1;
				int orderPoint = pointOrder[printPoint] + 1;
				System.out.println(displayPoint + "th Point: " + orderPoint);
			}*/
			
		}
		//End Point Order Calculation Section
		
		
		//Start Point Order Readout Section
		System.out.println("Readout of the order the points should go in: ");
		System.out.println("1st Point: " + (pointOrder[0] + 1));
		System.out.println("2nd Point: " + (pointOrder[1] + 1));
		for (int printPoint = 2; printPoint < pointCount; printPoint++) {
			int displayPoint = printPoint + 1;
			int orderPoint = pointOrder[printPoint] + 1;
			System.out.println(displayPoint + "th Point: " + orderPoint);
		}
		System.out.println();
		//End Point Order Readout Section
		
		// Start Total Distance Section
		System.out.print("Total Distance Travelled: ");
		for (int currentPoint = 0; currentPoint < pointCount - 1; currentPoint++) {
			totalDistance = totalDistance + distance[pointOrder[currentPoint]][pointOrder[currentPoint + 1]];
		}
		totalDistance = totalDistance + distance[pointOrder[0]][pointOrder[pointCount - 1]];
		System.out.println(totalDistance);
		//End Total Distance Section

		keyboard.close();
		System.out.println();
	}

}


