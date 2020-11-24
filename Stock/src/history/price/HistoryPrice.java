package history.price;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import calbao.GetCaiBao;

public class HistoryPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<String> strs = toArrayByFileReader1("s_code.txt");
	        for(String str:strs) {
	        	 try{
	        		 GetCaiBao.downLoadFromUrl("http://quotes.money.163.com/service/chddata.html?code=0"+str+"&start=20001105&end=20201124&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP",
	                         str+"_historyprice.xls","./historyprice/");
	                 Thread.sleep(100);
	             }catch (Exception e) {
	                 e.printStackTrace();
	             }
	        }

	}
	public static ArrayList<String> toArrayByFileReader1(String name) {
		// 使用ArrayList来存储每行读取到的字符串
		ArrayList<String> arrayList = new ArrayList<>();
		try {
			FileReader fr = new FileReader(name);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			// 按行读取字符串
			while ((str = bf.readLine()) != null) {
				arrayList.add(str.split(" ")[1]);
			}
			bf.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrayList;
	}


}
