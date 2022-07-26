import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.logging.Level;

import com.snc.l10n.tools.SncL10NIMRImportProcess;
import com.snc.l10n.tools.transformer.Cell;
import com.snc.l10n.tools.transformer.Row;
import com.snc.l10n.tools.transformer.Sheet;
import com.snc.l10n.tools.transformer.XSSFWorkbook;

public class WriteExcel {
	
	public static void writeExcelRows(XSSFWorkbook workbook, Sheet sheet,
			Map<String, Object> map){
		
		Row header = sheet.createRow(0);

		header.createCell(0).setCellValue("Key"); //Key
		header.createCell(1).setCellValue("Issue Type"); //category
		header.createCell(2).setCellValue("Current Label (Target)"); //Current label
		header.createCell(3).setCellValue("Fixed Hint (Target)");  //target hint
		
		Row row = sheet.createRow(count);
		
		Cell cell = row.createCell(15);
		cell.setCellValue(choiceObj.getLang());

		cell = row.createCell(1);
		cell.setCellValue("choice");

		cell = row.createCell(8);
		cell.setCellValue(choiceObj.getTable().trim());

		cell = row.createCell(9);
		cell.setCellValue(choiceObj.getElement().trim());

		cell = row.createCell(2);
		cell.setCellValue(choiceObj.getCurrentLabel().trim());
		count++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet modifiedSheet = workbook.createSheet("Names");
		
		writeExcelRows(workbook, modifiedSheet, updatedMap);
		
		try {
			File file = new File( "/imported.xlsx");
			if (!file.exists())
				file.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();

		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
