package com.zakrzewski.intentionbook.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.zakrzewski.intentionbook.entities.BookOfIntentionModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;

@Component
public class GeneratePdfIntention {
    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfIntention.class);

    private PdfPTable table;
    private Font headFont;
    private PdfPCell hCell;
    private Document document;
    private ByteArrayOutputStream outPutStream;
    private String showDateFormat;

    private PdfPCell dateCell;
    private PdfPCell intentionCell;

    private void createPdfTable(int numColumns, int widthPercentage, int[] setWidths) throws DocumentException {
        table = new PdfPTable(numColumns);
        table.setWidthPercentage(widthPercentage);
        table.setWidths(setWidths);
    }

    private Font createFont(String fontFactory){
        return headFont = FontFactory.getFont(fontFactory);
    }

    private void createCellAndAddToTable(String cellName, Font font, int horizontalAlignment, PdfPCell cell, PdfPTable table){
        cell = new PdfPCell(new Phrase(cellName, font));
        cell.setHorizontalAlignment(horizontalAlignment);
        table.addCell(cell);
    }

    private void createCellWithTimeOfMas(String timeOfMass, int setPaddingLeft, int verticalAlignment, int setHorizontalAlignment, PdfPCell cell, PdfPTable table){
        cell = new PdfPCell(new Phrase(timeOfMass));
        cell.setPaddingLeft(setPaddingLeft);
        cell.setVerticalAlignment(verticalAlignment);
        cell.setHorizontalAlignment(setHorizontalAlignment);
        table.addCell(cell);
    }

    public ByteArrayInputStream intentionReport(List<BookOfIntentionModel> intentionModelList, LocalDate dateOfMass){
        document = new Document();
        outPutStream = new ByteArrayOutputStream();
        showDateFormat = "Data: " + dateOfMass + "\n" + "Godz.";
        try {
            createPdfTable(2, 80, new int[] {1, 3});
            createFont(FontFactory.TIMES_ROMAN);
            createCellAndAddToTable(showDateFormat, headFont, Element.ALIGN_CENTER, hCell, table);
            createCellAndAddToTable("Intencja", headFont, Element.ALIGN_CENTER, hCell, table);

            for (BookOfIntentionModel intentionModel : intentionModelList){
                createCellWithTimeOfMas(intentionModel.getTimeOfMass().toString(), 0, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER, dateCell, table);
                createCellWithTimeOfMas(intentionModel.getDescriptionOfIntention(), 5, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT, intentionCell, table);
            }

            PdfWriter.getInstance(document, outPutStream);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException e) {
            logger.error("Error: {0}", e);
        }

        return new ByteArrayInputStream(outPutStream.toByteArray());

    }
}
