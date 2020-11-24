package history.price;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;

public class ReadCSV {

	static int satifyNum = 0;
	static int totalNum = 0;

	public static int readCSV(String filePath, int count, double percent) {
		satifyNum = 0;
		totalNum = 0;
		double previous[] = new double[count];
		ArrayList<Double> ar = new ArrayList<Double>();
		ArrayList<String> dateAr = new ArrayList<String>();
		try {
			// 创建CSV读对象
			CsvReader csvReader = new CsvReader(filePath);

			// 读表头
			csvReader.readHeaders();
			while (csvReader.readRecord()) {
//				// 读一整行
//				System.out.println(csvReader.getRawRecord());
//				// 读这行的某一列
//				System.out.println("涨跌幅："+csvReader.get(9));
				if (!"None".equals(csvReader.get(9))) {
					ar.add(Double.parseDouble(csvReader.get(9)));
					dateAr.add(csvReader.get(0));
				}
			}

			for (int i = 0; i < ar.size() - count - 1; i++) {
				int n = 0;
				for (int k = i + 1; k <= i + count; k++) {
					if (ar.get(k) > 0)
						n++;
				}
				if (n == count) {
					totalNum++;
					if (ar.get(i) > percent) {
						System.out.print("(" + dateAr.get(i) + ":" + ar.get(i) + "):");
						for (int k = i + 1; k <= i + count; k++) {
							System.out.print("(" + dateAr.get(k) + ":" + ar.get(k) + ") ");
						}
						System.out.println();
						satifyNum++;
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(filePath + ":" + satifyNum + "/" + totalNum);
		return satifyNum;

	}

	public static void main(String[] args) {
		String dir[] = new File("historyprice").list();
//		String dir[] = { "600180_historyprice.xls" };
		int total = 0;
		int num = 0;
		for (int i = 0; i < 2000 && i < dir.length; i++) {
			int n = ReadCSV.readCSV("historyprice/" + dir[i],3, 0.0);
			total += totalNum;
			num += satifyNum;
		}
		System.out.println(num + "/" + total + ":" + num / total);
	}
}
