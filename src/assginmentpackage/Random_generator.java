package assginmentpackage;

import java.util.ArrayList;
import java.util.Random;

public class Random_generator {
	private String MacAdress;
	int column;
	int length;
	public Random_generator(String MacAdress,int column,int length) {
		try {
			this.column=column;
			this.length=length;
			this.MacAdress=MacAdress;
		} catch (Exception e) {
			throw e;
		}
		
		
	}
	public String generator() {
		String s ="";
		Random rnd=new Random();
		Random rnd2=new Random();
		Random rnd3=new Random();
		String [] l=MacAdress.split("-");
		//firstly this is a for loop
		//randomly,it is found  serial char
		
		for(int i=0;i<column;i++) {
			
			//mac_adress is called and random function run ,
			//
			s+=l[rnd3.nextInt(l.length)];
			
			//secondly, it is defined other char 
			//for serial
			for(int j=0;j<length-2;j++) {
			//we use  digit capital letter and small letter
				
				int is = (int) (rnd2.nextInt(3)+1);
				switch (is) {
				case 1:
					char s1=(char) ((Math.random()*('Z'-'A'))+'A');
					s+=s1;
					break;
				case 2:
					char s2=(char) ((Math.random()*('z'-'a'))+'a');
					s+=s2;
					break;
				case 3:
					char s3=(char) ((Math.random()*('9'-'0'))+'0');
					s+=s3;
					break;
				}
			}	
		}
		
			return s;
	}
	public ArrayList<String>  generatorwithmac(String  newkey) {
		Random random=new Random();
		//thirdly we use random function,
		//we want to new_key randomly
		//we dont want to sequential way
		// macadress is easily founded 
		
		
		ArrayList <Integer>ast=new ArrayList<>();
		ArrayList<String> ask=new ArrayList<>();
		int aa;
	
		for (int k = 0; k < column*length; k++) {
		
			aa=random.nextInt(column*length);
			
			
			//if this number is writen again,
			//random func  is called
	if(ast.contains(aa)) {aa=random.nextInt(column*length);}
			ast.add(aa);
	}
		for (int l = 0; l < column*length; l++) {
			//we use to change from string to arraylist 
			char s=newkey.charAt(ast.get(l));
			ask.add(String.valueOf(s));
		}
		
		return ask;
	}
	}
