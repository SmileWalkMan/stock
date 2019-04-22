import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadXLS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Workbook workbook = Workbook.getWorkbook(new File("caibao/600000_benefit.xls"));
			Sheet sheet = workbook.getSheet(0);
//			sheet.
			Cell a1 = sheet.getCell(0,0); 
			Cell b2 = sheet.getCell(1,1); 
			Cell c2 = sheet.getCell(2,1); 

			String stringa1 = a1.getContents(); 
			String stringb2 = b2.getContents(); 
			String stringc2 = c2.getContents(); 
			System.out.println(stringa1);
			System.out.println(stringb2);
			System.out.println(stringc2);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
