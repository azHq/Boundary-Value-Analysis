package boundary_value_analysis;

import java.util.Scanner;

public class MainClass {
	
	public int[][] boundary_values;
	public final int MIN=10,MAX=100;
	public int numOfVarriable;
	public int[][] range;
	int[][] testCases;
	int numoFTestCases;
	String[] var= {"A","B","C","D","E","F","G","H","I","J"};
	public static void main(String[] args) {
		
		MainClass main=new MainClass();
		main.takeInput();
		//main.BVC();
		//main.Robust();
		main.worst();
	}
	
	public boolean inputValidityCheck(int inputValue) {
		
		if(inputValue>=MIN&&inputValue<=MAX) {
			
			return true;
		}
		else return false;
	}
	
	public void takeInput() {
		
		Scanner scr=new Scanner(System.in);
		System.out.println("Please Enter Number of Varriable:\n");
		numOfVarriable=scr.nextInt();
		range=new int[numOfVarriable][2];
		String str=scr.nextLine();
		System.out.println("Please Enter The Range of Varriable(Like: [1-100]):\n");
		for(int i=0;i<numOfVarriable;i++) {
			String[] s=scr.nextLine().replace("[", "").replace("]","").split("-");
			range[i][0]=Integer.parseInt(s[0]);
			range[i][1]=Integer.parseInt(s[1]);
		}
	}
	
	public void BVC() {
		
		
		numoFTestCases=4*numOfVarriable+1;
		testCases=new int[numoFTestCases][numOfVarriable];
		
		for(int i=0;i<numOfVarriable;i++) {
						
			for(int j=0;j<numoFTestCases;j++) {
				
				testCases[j][i]=(int)Math.ceil(range[i][0]+range[i][1])/2;
			}
		}
		
		int index=0;
		for(int i=0;i<numOfVarriable;i++) {
			
			testCases[index][i]=range[i][0];
			testCases[++index][i]=range[i][0]+1;
			testCases[++index][i]=range[i][1]-1;
			testCases[++index][i]=range[i][1];
			
			index++;
			
		}
		System.out.println("***************** Boundary Value Check Test Cases ************************\n");
		printTestCases();
	}
	
   public void Robust() {
		
		numoFTestCases=6*numOfVarriable+1;
		testCases=new int[numoFTestCases][numOfVarriable];
		
		for(int i=0;i<numOfVarriable;i++) {
						
			for(int j=0;j<numoFTestCases;j++) {
				
				testCases[j][i]=(int)Math.ceil(range[i][0]+range[i][1])/2;
			}
		}
		
		int index=0;
		for(int i=0;i<numOfVarriable;i++) {
			
			testCases[index][i]=range[i][0]-1;
			testCases[++index][i]=range[i][0];
			testCases[++index][i]=range[i][0]+1;
			testCases[++index][i]=range[i][1]-1;
			testCases[++index][i]=range[i][1];
			testCases[++index][i]=range[i][1]+1;
			
			index++;
		}
		System.out.println("***************** Robust Test Cases ************************\n");
		printTestCases();
	}
	
	public void printTestCases() {
		
		System.out.println("Test-Id\t\tdescription\t\toutput");
		System.out.print("\t\t");
		for(int i=0;i<numOfVarriable;i++) {
			
			System.out.print(var[i]+"\t");
		}
		
		System.out.println();
		for(int i=0;i<numoFTestCases;i++) {
			
			System.out.print("  "+(i+1)+"\t\t");
			for(int j=0;j<numOfVarriable;j++) {
				
				System.out.print(testCases[i][j]+"\t");
			}
			System.out.println();
		}
		
	}
	
	public void worst() {
		
		numoFTestCases=(int) Math.pow(5, numOfVarriable);
		boundary_values=new int[numOfVarriable][5];
		testCases=new int[numoFTestCases][numOfVarriable];
		for(int i=0;i<numOfVarriable;i++) {
			
			
			boundary_values[i][0]=range[i][0];
			boundary_values[i][1]=range[i][0]+1;
			boundary_values[i][2]=range[i][1]-1;
			boundary_values[i][3]=range[i][1];
			boundary_values[i][4]=(int)Math.ceil(range[i][0]+range[i][1])/2;
			
		}
		
		int[] temp=new int[numOfVarriable];
		allPossibleConbination(0,temp,0);
		printTestCases();
		
	}
	
	public int allPossibleConbination(int i,int[] temp,int k) {
		
		
		
		if(i>=numOfVarriable) {
			

			
			System.arraycopy(temp,0, testCases[k],0,temp.length);
			k++;
			return k;
		}
		
		for(int j=0;j<5;j++) {
			
			
			temp[i]=boundary_values[i][j];
			k=allPossibleConbination(i+1,temp,k);
			
		}
		
		
		return k;
	}
	
	

}
