package kr.hansigan;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static String getCellPureValue(XSSFCell cell) {
        String value = "";
        switch (cell.getCellType()) {
            case FORMULA:
                value = cell.getCellFormula();
                break;
            case NUMERIC:
                value = cell.getNumericCellValue() + "";
                break;
            case STRING:
                value = cell.getStringCellValue();
                break;
            case BLANK:
                value = cell.getBooleanCellValue() + "";
                break;
            case ERROR:
                value = cell.getErrorCellValue() + "";
                break;
        }
        return value.replaceAll("\\s+", "");
    }
    public static void main(String[] args) {
        List<Class> datas = new ArrayList<>();
        try {
            FileInputStream fin = new FileInputStream("src/main/resources/data/2024_01.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fin);
            XSSFSheet sheet = workbook.getSheetAt(0);
            //무시할 항목
            String[] ignores = {"비고", "학년도-학기", "교과목코드구분", "등록학부(과)", "수업합반과목", "성적합반과목", "학과제한적용", "수강학점미반영여부", "폐강여부", "폐강일자", "성적등급예외적용여부", "팀티칭"};
            String[] info = {"No.", "과목코드", "교과목명", "분반", "대표이수구분", "학점", "강의", "실습", "설계", "개설학부(과)", "학년", "담당교수", "수강정원", "강의시간", "수강신청가능학년", "학과,학년제한적용", "성적평가", "영어강의"};
            Set<Integer> ignoreId = new HashSet<>();
            int rows = sheet.getPhysicalNumberOfRows();
            XSSFRow infoRow = sheet.getRow(0);
            for (int i = 0; i < infoRow.getPhysicalNumberOfCells(); i++) {
                XSSFCell cell = infoRow.getCell(i);
                String value = getCellPureValue(cell);
                for (String ignore : ignores) {
                    if (value.equals(ignore)) {
                        ignoreId.add(i);
                    }
                }
            }
            for (int i = 1; i < rows; i++) {
                XSSFRow row = sheet.getRow(i);
                if (row == null) continue;
                int cells = row.getPhysicalNumberOfCells();
                List<String> tmp = new ArrayList<>();
                for (int j = 0; j < cells; j++) {
                    if (ignoreId.contains(j)) continue;
                    XSSFCell cell = row.getCell(j);
                    if (cell == null) continue;
                    String value = getCellPureValue(cell);
                    tmp.add(value);
                }
                datas.add(new Class(tmp));
            }
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("src/main/java/kr/hansigan/result/output.json"), datas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
