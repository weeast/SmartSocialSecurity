package actuarial.calculator;

import java.util.ArrayList;
import java.util.List;

import actuarial.calculator.*;
public class ActuaryCalculator {
	public  double calculator(String str) throws Exception{
		String strTemp2 = "" ;
		char[] charAll = str.toCharArray() ;
		List<Character> listAll = new ArrayList<Character>() ;         //存储所有数据
		List<Character> listBracket = new ArrayList<Character>() ;     //存储括号
		List<Character> listTemp1 = new ArrayList<Character>() ;        //存储括号内的算式
		List<Character> listTemp2 = new ArrayList<Character>() ;        //存储带左括号的算式，得出括号内结果后需要替换的内容
		for(int i=0;i<charAll.length;i++){
			listAll.add(charAll[i]) ;                                     //存储所有数据到listAll中           char[]类型转为ArrayList类型
		}
		int tempFir = 0 ;
		int tempSec = 0 ;
		int tempThr = 0 ;
		
		int tempFif = 0 ;
		for(int i=0;i<charAll.length;i++){
			if(charAll[i]=='('||charAll[i]==')'){	
				tempFir++ ;                                     //得到左右括号总数
			}
		}
		boolean bool = true ; 
		int tempnum = tempFir/2 ;
		while(tempnum!=-1){
			int tempFor = 0 ;
			if(tempnum!=0&&listAll.size()!=1){
				for(int i=0;i<listAll.size();i++){
					if(listAll.get(i)=='('){
						tempSec++ ;
						tempThr = i ;                                   //得到中间的左括号位置
					}
				}			
				for(int i=tempThr;i<listAll.size();i++){
					if(listAll.get(i)==')'&&tempFor==0){
						tempFor++ ;
						tempFif = i ;                                   //得到对应的右号位置
					}
				}
				listTemp1 = (List<Character>)listAll.subList(tempThr+1,tempFif) ;        //存储括号内的算式,不带括号
				System.out.println(listTemp1) ;
				listTemp2 = (List<Character>)listAll.subList(tempThr,tempFif+1) ;       //存储带左括号的算式，以便替换
				String strTemp1 = new Operator(listTemp1).toString() ;
				
				for(int i=tempThr;i<=tempFif;i++){
					listAll.remove(tempThr) ;
					System.out.println("listAll1  " + listAll) ;
				}
				listAll.addAll(tempThr,changeString(strTemp1)) ;
				tempnum-- ;
				
				System.out.println("listAll  " + listAll) ;
			
			}else{
				strTemp2 = new Operator(listAll).toString() ;
				System.out.print("结果" + strTemp2 ) ;
				tempnum = -1 ;
			}	
		}
		return Double.parseDouble(strTemp2) ;
	}

	//String类型转为List
	public static List<Character> changeString(String str){
		List<Character> listTem = new ArrayList<Character>() ;
		char[] cha = str.toCharArray() ;
		for(int i=0;i<cha.length;i++){
			listTem.add(cha[i]) ;
		}
		System.out.println("listTem" + listTem) ;
		return listTem ;
	}
}
