package demo.handler_of_format_file;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Calendar;

public class ExcelHandlerByPOI {

	public static void main(String[] args) throws IOException {
		ExcelHandlerByPOI eh = new ExcelHandlerByPOI();
		eh.editExcelByPattern1();
	}

	public void editExcelByPattern1() {
		// HSSFWorkbook wb = new HSSFWorkbook();
		Workbook wb = null;
		BufferedOutputStream bos = null;
		try {
			// 创建一个空的工作本
			wb = WorkbookFactory.create(false);
			CreationHelper ch = wb.getCreationHelper();
			CellStyle cs = wb.createCellStyle();

			// 超链接样式
			Font hl_font = wb.createFont();
			hl_font.setUnderline(Font.U_SINGLE);
			hl_font.setColor(IndexedColors.BLUE.getIndex());
			cs.setFont(hl_font);

			Sheet sheet = wb.createSheet(WorkbookUtil.createSafeSheetName("虫草花"));
			Row row = sheet.createRow(0);
			Hyperlink link = ch.createHyperlink(HyperlinkType.URL);
			Cell cell;

			// 设置字符串
			row.createCell(0).setCellValue("Jack");
			row.createCell(1).setCellValue("Rose");
			row.createCell(2).setCellValue("Mike");

			// 设置超链接
			cell = row.createCell(3);
			cell.setCellValue("百度");
			link.setAddress("https:\\\\www.baidu.com");
			cell.setHyperlink(link);
			cell.setCellStyle(cs);

			// 设置日期
			cell = row.createCell(5);
			Calendar theTime = Calendar.getInstance();
			theTime.set(2019, 8, 20);
			cell.setCellValue(theTime);
			// 设置单元格使用哪种已在Excel中预置的格式（此处针对日期格式）
			cs.setDataFormat(ch.createDataFormat().getFormat("yyyy\"年\"mm\"月\"dd\"日\""));
			cell.setCellStyle(cs);

			// 把编辑好的工作本导出到Excel
			File file = new File("src\\main\\resources\\my-table.xls");
			if (!file.exists()) {
				file.createNewFile();
			}
			bos = new BufferedOutputStream(new FileOutputStream(file));
			wb.write(bos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(bos, wb);
			System.out.println("complete");
		}
	}

	public void editExcelByPattern2() {
		Workbook wb = null;
		POIFSFileSystem fs1 = null, fs2 = null;
		OPCPackage pkg1 = null, pkg2 = null;
		HSSFWorkbook wb1 = null, wb2 = null;
		XSSFWorkbook xb1 = null, xb2 = null;
		try {
			// 打开Excel,把读取到的数据载入工作本
			wb = WorkbookFactory.create(new File("src\\main\\resources\\my-table.xls"));

			// HSSFWorkbook, File
			fs1 = new POIFSFileSystem(new File("file.xls"));
			wb1 = new HSSFWorkbook(fs1.getRoot(), true);

			// HSSFWorkbook, InputStream, needs more memory
			fs2 = new POIFSFileSystem(new FileInputStream("file.xlsx"));
			wb2 = new HSSFWorkbook(fs2.getRoot(), true);

			// XSSFWorkbook, File
			pkg1 = OPCPackage.open(new File("file.xlsx"));
			xb1 = new XSSFWorkbook(pkg1);

			// XSSFWorkbook, InputStream, needs more memory
			pkg2 = OPCPackage.open(new FileInputStream("file.xlsx"));
			xb2 = new XSSFWorkbook(pkg2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(wb, fs1, pkg1, pkg2, fs2, wb1, wb2, xb1, xb2);
		}
	}
	
	// 关闭资源
	private static void close(AutoCloseable... resourceList) {
		for (AutoCloseable resource : resourceList) {
			if (resource != null) {
				try {
					resource.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
