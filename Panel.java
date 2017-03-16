package sti;

import java.util.Random;

public class Panel {
	
	Random gen = new Random();
	Boolean lit;
	int number;
	
	public Panel(int i){
		lit=false;
		number = i;
	}
	public int getNumber() {
		return number;
	}
	public boolean isLit(){
		int j=gen.nextInt(10);
		if(j>5){
			lit=true;
		}
		else{
			lit=false;
		}
		return lit;
	}

}
