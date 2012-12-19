package com.gmail.robmadeyou;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.gmail.robmadeyou.EnemyList.Enemies;

public class Save {
	
	
	public static void saveMap(Enemy[] enemy){
		int mapID = 0;
		File file = null;
		
		while(new File(mapID + ".txt").exists()){
			mapID++;
		}
		
			try{
				FileWriter fstream = new FileWriter(mapID + ".txt");
				BufferedWriter out = new BufferedWriter(fstream);
				for(int i = 0; i < EnemyList.maxEnemies; i++){
					int x = -1;
					int y = -1;
					int live = -1;
					x = enemy[i].x;
					y = enemy[i].y;
					if(enemy[i].isOnScreen){
						live = 1;
					}
					
					out.write(""+x);
					out.newLine();
					out.write(""+y);
					out.newLine();
					out.write(""+live);
					out.newLine();
				}
				//Close the output stream
				out.close();
				}catch (Exception e){//Catch exception if any
					System.err.println("Error: " + e.getMessage());
				}
	}
	public static void loadMap(){
		// Open the file that is the first command line parameter 
		FileInputStream fstream;
		try {
			fstream = new FileInputStream("0.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			int i = 0;
			int ar = 0;
			int x = -1;
			int y = -1;
			int live = -1;
			while ((strLine = br.readLine()) != null) {
				if(ar < EnemyList.maxEnemies * 3){
				if(i == 0 && !strLine.equals("-1")){
					x = Integer.parseInt(strLine);
				}else if(i == 1 && !strLine.equals("-1")){
					y = Integer.parseInt(strLine);
				}else if(i == 2){
					live = Integer.parseInt(strLine);
				}
				if(x != -1 && y != -1 && live == 1){
					EnemyList.enemy[EnemyList.getArrayNumber(x, y)].isOnScreen = true;
				}else if(x != -1 && y != -1 && live == -1){
					EnemyList.enemy[EnemyList.getArrayNumber(x,y)].isOnScreen = false;
				}
				i++;
				ar++;
				if(i == 3){
					i = 0;
				}
				}
				
			}
			// Close the input stream
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
