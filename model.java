package sti;

import java.util.ArrayList;

public class model {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ArrayList<Panel> Pan = new ArrayList<Panel>();
ArrayList<Panel> Active = new ArrayList<Panel>();

		for(int i=0; i<30;i++){
	Pan.add(new Panel(i));
}
		
		for(int g=0;g<1;g++){
			
			for(int f=0;f<Pan.size();f++){
				Boolean insert =Pan.get(f).isLit();
				if(insert){
					Active.add(Pan.get(f));
				}
			}
			for(int d=0;d<Active.size();d++){
				System.out.println( Active.get(d).getNumber()+1);
			}
		}
	}

}
