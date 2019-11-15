package boundary_value_analysis;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class MainClassTest {

	MainClass mainclass=new MainClass();
	public int numOfVarriable;
	public String[] range;
	public int max,min,below_max,below_min,upper_min,upper_max,nominal;
	@Test
	public void BVC() {
		
		
		
		
	
		below_max=max-1;
		upper_min=min+1;
		nominal=(int) Math.ceil((max+min)/2);
		
		System.out.println("***************** Boundary Value Check ************************\n");
		
		
		
		
	}

}
