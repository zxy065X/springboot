package com.boshuo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExcelUtil {

	private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	/**
	 * 判断Excel的版本,获取Workbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbok(InputStream in, File file) throws IOException {
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel 2003
			wb = new HSSFWorkbook(in);
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}

	public static List<Map<String, String>> readExcel2String(String filePath) {

		try {
			// 同时支持Excel 2003、2007
			File excelFile = new File(filePath); // 创建文件对象
			FileInputStream in = new FileInputStream(excelFile); // 文件流
			Workbook workbook = getWorkbok(in, excelFile);
			// Workbook workbook = WorkbookFactory.create(is); // 这种方式
			// Excel2003/2007/2010都是可以处理的
			// int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量
			Sheet sheet = workbook.getSheetAt(0); // 遍历第1个Sheet
			// 为跳过第一行目录设置count
			int count = -1;
			List<Map<String, String>> listMap = new ArrayList<>();
			for (Row row : sheet) {
				count++;
				// 跳过第一的目录
				if (count < 1) {

					continue;
				}
				System.out.println(count);
				try {
					String clientName = "";
					String mobile = "";
					Cell cell1 = row.getCell(0);
					Cell cell2 = row.getCell(1);
					if (null == cell2) {
						continue; // 手机号码没有，就跳过
					} else {
						cell2.setCellType(CellType.STRING);
						;
						mobile = cell2.getStringCellValue();
						if (mobile.length() != 11) {
							continue; // 手机号码不对，就跳过
						}

					}
					if (null != cell1) {
						cell1.setCellType(CellType.STRING);
						;
						clientName = cell1.getStringCellValue();
					}

					Map<String, String> map = new HashMap<>();
					map.put("clientName", clientName);
					map.put("mobile", mobile);
					listMap.add(map);

				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}

			return listMap;

		} catch (Exception e) {
			logger.error(filePath + "资源导入报错", e);
			return null;
		}

	}

//	public static boolean list2Excel(List<Resource> resources, File file) {
//
//		@SuppressWarnings("resource")
//		XSSFWorkbook xssfworkbook = new XSSFWorkbook();
//		Sheet sheet = xssfworkbook.createSheet("new sheet");
//		Row row = sheet.createRow(0);
//		int count = 0;
//		row.createCell(0).setCellValue("客户姓名");
//		row.createCell(1).setCellValue("客户手机号");
//		for (Resource resource : resources) {
//			Row _row = sheet.createRow(++count);
//			_row.createCell(0).setCellValue(resource.getClientName());
//			_row.createCell(1).setCellValue(resource.getMobile());
//		}
//		try {
//			FileOutputStream fileoutputstream = new FileOutputStream(file);
//			xssfworkbook.write(fileoutputstream);
//			fileoutputstream.flush();
//			fileoutputstream.close();
//			return true;
//		} catch (Exception e) {
//			logger.error("资源导出报错", e);
//			return false;
//		}
//
//	}

	public static boolean callList2Excel(List<List<String>> lists, File file) {

		@SuppressWarnings("resource")
		XSSFWorkbook xssfworkbook = new XSSFWorkbook();
		Sheet sheet = xssfworkbook.createSheet("new sheet");
		Row row = sheet.createRow(0);
		int count = 0;
		row.createCell(0).setCellValue("手机号");
		row.createCell(1).setCellValue("任务名称");
		row.createCell(2).setCellValue("等级");
		row.createCell(3).setCellValue("通话时长");
		row.createCell(4).setCellValue("通话时间");
		row.createCell(5).setCellValue("分配员工名");
		row.createCell(6).setCellValue("是否查看");
		row.createCell(7).setCellValue("查看时间");
		for (List<String> list : lists) {
			Row _row = sheet.createRow(++count);
			_row.createCell(0).setCellValue(list.get(0));
			_row.createCell(1).setCellValue(list.get(1));
			_row.createCell(2).setCellValue(list.get(2));
			_row.createCell(3).setCellValue(list.get(3));
			_row.createCell(4).setCellValue(list.get(4));
			_row.createCell(5).setCellValue(list.get(5));
			_row.createCell(6).setCellValue(list.get(6));
			_row.createCell(7).setCellValue(list.get(7));
		}
		try {
			FileOutputStream fileoutputstream = new FileOutputStream(file);
			xssfworkbook.write(fileoutputstream);
			fileoutputstream.flush();
			fileoutputstream.close();
			return true;
		} catch (Exception e) {
			logger.error("资源导出报错", e);
			return false;
		}
	}

}
