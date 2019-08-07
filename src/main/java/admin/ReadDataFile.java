package admin;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFile {
	
	Sheet sheet;
	Row row;
	private Workbook workbook;
	int colNum = 0;
	
	public void dataFile(String fileName)
	{
		String pathTillProject = System.getProperty("user.dir");
		
		FileInputStream fis;
		
		try {
				fis = new FileInputStream(pathTillProject + "\\Data Files\\" + fileName);
				
//				workbook = new XSSFWorkbook(fis);
				
				String fileExtensionName = fileName.substring(fileName.indexOf("."));
				
			    //Check condition if the file is xlsx file
			    if(fileExtensionName.equals(".xlsx"))
			    {
				    //If it is xlsx file then create object of XSSFWorkbook class
				    	workbook = new XSSFWorkbook(fis);
			    }
			    
			    //Check condition if the file is xls file
			    else if(fileExtensionName.equals(".xls"))
			    {
			        //If it is xls file then create object of XSSFWorkbook class
			    	workbook = new HSSFWorkbook(fis);
			    }
				
				sheet = workbook.getSheet("Sheet1");
				
				row = sheet.getRow(0);
			}
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String ReadFile(String rowName, String columnName)
	{
		try {
			int row_num = -1;
			int column_num = -1;
			
		    for(int i=0; i < sheet.getPhysicalNumberOfRows(); i++)
		    {
		        if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equalsIgnoreCase(rowName))
		        {
		           row_num = i;
		           break;
		        }
		    }
		        
		        for(int j=0; j < row.getLastCellNum(); j++)
		        {
		        	Cell cell = row.getCell(j);
		        	if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
		        	       // Can't be this cell - it's empty
		        	       continue;
		        	   }
		        	   if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
		        	      String text = cell.getStringCellValue();
		        	      if (columnName.equals(text)) {
		        	    	  column_num = j;
		        	         break;
		        	      }
		        	   }
		        }	
		        
		        DataFormatter formatter = new DataFormatter();
		        
		        String cellText = formatter.formatCellValue(sheet.getRow(row_num).getCell(column_num));
		    		
		        return cellText;
		} 
		
	
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		finally
		{
			try {
				workbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
	