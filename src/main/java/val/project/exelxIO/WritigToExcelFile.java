package val.project.exelxIO;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import val.project.dao.UserOrderDao;
import val.project.entities.UserOrder;
import val.project.services.OrderMakeService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class WritigToExcelFile {

    private Workbook workbook;
    private FileOutputStream outputStream;

    private File fileToWrite;
    private CreateExcelFile createExcelFile;

    @Autowired
    UserOrderDao userOrderDao;

    public WritigToExcelFile() throws IOException {
        createExcelFile = new CreateExcelFile("test");
        fileToWrite = createExcelFile.getFile();
        outputStream = new FileOutputStream(fileToWrite);
        workbook = new HSSFWorkbook();
    }

    public void organizeExcelFile() throws IOException {
        Sheet sheet = workbook.createSheet("Заказы");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 6000);
        sheet.setColumnWidth(4, 6000);
        sheet.setColumnWidth(5, 6000);
        sheet.setColumnWidth(6, 6000);
        sheet.setColumnWidth(7, 6000);
        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();

        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("ID");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Тип доставки");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Тип оплаты");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("Адрес дял курьера");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(4);
        headerCell.setCellValue("К оплате");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(5);
        headerCell.setCellValue("Кому доставить");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(6);
        headerCell.setCellValue("Номер телефона");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(7);
        headerCell.setCellValue("Электронная почта");
        headerCell.setCellStyle(headerStyle);

        writeInfoToExcelFile(sheet);

    }

    public void writeInfoToExcelFile(Sheet sheet) throws IOException {
        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        List<UserOrder> orders = userOrderDao.findAll();
        if (orders != null) {
            for (int i = 0; i < orders.size(); i++) {
                Row row = sheet.createRow(i + 1);

                Cell cell = row.createCell(0);
                cell.setCellValue(orders.get(i).getId());
                cell.setCellStyle(style);

                cell = row.createCell(1);
                cell.setCellValue(makeUnderstandableTypeOfPayment(orders.get(i).getTypeOfPayment()));
                cell.setCellStyle(style);

                cell = row.createCell(2);
                cell.setCellValue(makeUnderstandableTypeOfDelivery(orders.get(i).getTypeOfDelivery()));
                cell.setCellStyle(style);

                cell = row.createCell(3);
                cell.setCellValue(orders.get(i).getAddressForCourier());
                cell.setCellStyle(style);

                cell = row.createCell(4);
                cell.setCellValue(orders.get(i).getFullPrice());
                cell.setCellStyle(style);

                cell = row.createCell(5);
                cell.setCellValue(orders.get(i).getAccount().getUserName());
                cell.setCellStyle(style);

                cell = row.createCell(6);
                cell.setCellValue(orders.get(i).getAccount().getUserPhoneNumber());
                cell.setCellStyle(style);

                cell = row.createCell(7);
                cell.setCellValue(orders.get(i).getAccount().getMail());
                cell.setCellStyle(style);
            }
        }

        workbook.write(outputStream);
        workbook.close();
    }

    private String makeUnderstandableTypeOfPayment(String typeOfPayment) {
        String res = "";
        switch (typeOfPayment) {
            case "0":
                res = "PayPal";
                break;
            case "1":
                res = "Ерип";
                break;
            case "2":
                res = "Наличные";
                break;
            default:
                break;
        }
        return res;
    }

    private String makeUnderstandableTypeOfDelivery(String typeOfDelivery) {
        String res = "";
        switch (typeOfDelivery) {
            case "0":
                res = "Курьером";
                break;
            case "1":
                res = "Самовывоз";
                break;
            default:
                break;
        }
        return res;
    }
}
