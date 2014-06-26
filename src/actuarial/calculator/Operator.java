package actuarial.calculator;

import java.util.ArrayList;
import java.util.List;

public class Operator {

	private String pass = null ;
	public Operator(List<Character> lis){
		this.Calculate(lis) ;
	}
	public  String Calculate(List<Character> lis){
		List<Character> lis1 = new ArrayList<Character>() ;       //存储符号的
		List<String> lis2 = new ArrayList<String>() ;             //存储数字的String
		List<Character> lis3 = new ArrayList<Character>() ;             //存储括号
		int temp1 = 0 ;
		int temp2 = 0 ; 
		int temp3 = 0 ;
		int temp4 = 0 ;
		int temp5 = 0 ;
		for(int i=0;i<lis.size();i++){
		//存储符号到了lis1中
			if(lis.get(i)=='+'||lis.get(i)=='-'||lis.get(i)=='*'||lis.get(i)=='/'){
				lis1.add(lis.get(i)) ;				
				temp2 = i ;
				temp3++ ;
			}
		/********************开始存储数字************************/
			if((temp3==1)&&(!(temp1==temp2))){
				Character[] character = lis.subList(temp1,temp2).toArray(new Character[]{}) ;
				String strList = new String(change(character)) ;
				lis2.add(strList) ;
			}else if(!(temp1==temp2)){
				Character[] character = lis.subList(temp1+1,temp2).toArray(new Character[]{}) ;
				String strList = new String(change(character)) ;
				lis2.add(strList) ;                                       	
			}
			temp1=temp2 ;
		}
		Character[] character = lis.subList(temp1+1,lis.size()).toArray(new Character[]{}) ;
		String strList = new String(change(character)) ;					
		lis2.add(strList) ;                                                 
		/*********************结束存储数字************************/

		/*********************开始计算乘除法**********************/
		for(int x=0;x<lis1.size();x++){
			if(lis1.get(x)=='*'||lis1.get(x)=='/'){
				double left = Double.parseDouble(lis2.get(x-temp4)) ;
				double right = Double.parseDouble(lis2.get(x+1-temp4)) ;
				double result ;
				if(lis1.get(x)=='*'){
					lis1.remove(x-temp4) ;
					result = left * right ;
				}else{
					lis1.remove(x-temp4) ;
					result = left / right ;
				}
				lis2.set(x-temp4,""+result) ;
				lis2.remove(x+1-temp4) ;
				temp4++ ;                                                  //X值在增加，而lis2长度在减小，所以remove和set对应的位置不对；利用temp4调整
			}
		}
		/*********************乘除法结束**********************/
		
		//开始加减法
		double end ;
		for(int x=0;x<lis1.size();x++){
			double left = Double.parseDouble(lis2.get(x-temp5)) ;
			double right = Double.parseDouble(lis2.get(x+1-temp5)) ;
			if(lis1.get(x)=='+'){
				end = left + right ;
			}else{
				end =left - right ;
			}
			lis2.set(x-temp5,""+end) ;
			lis2.remove(x+1-temp5) ;
			temp5++ ;
		}
		this.pass = lis2.get(0) ;
		System.out.println("我是" + lis2.get(0)) ;
		return lis2.get(0) ;
	}
	public static char[] change(Character[] character){
		char[] charch = new char[character.length] ;
		for(int k=0;k<character.length;k++){
			charch[k] = character[k] ;
		}
		return charch ;
	}
	public String toString(){
		return this.pass ;
	}
}
