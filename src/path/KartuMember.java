package path;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
=======
>>>>>>> upstream/main
<<<<<<< HEAD
=======
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;

public class KartuMember {

    public static void cetakKartu(String namaMember, String rfidCode) {
        try {
            float width = 559;
            float height = 351;
            
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            // Tentukan path absolut folder tujuan (di luar dinda_salon)
            String outputPath = "C:/Users/ASUS/Documents/KartuMember/Kartu_" + namaMember + ".pdf";
=======
            String outputPath = "D:/KartuMember/Kartu_" + namaMember + ".pdf";
>>>>>>> upstream/main
<<<<<<< HEAD
=======
            String outputPath = "D:/KartuMember/Kartu_" + namaMember + ".pdf";
>>>>>>> upstream/main
=======
>>>>>>> 49a97e0045e2a45eda10793666a89f011bea1896
            
            Document document = new Document(new Rectangle(width, height));
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputPath));
            document.open();

            // Halaman Depan
            Image depan = Image.getInstance("cardDepan.png");
            depan.setAbsolutePosition(0, 0);
            depan.scaleToFit(width, height);
            document.add(depan);

            document.newPage();

            // Halaman Belakang
            Image belakang = Image.getInstance("cardBelakang.png");
            belakang.setAbsolutePosition(0, 0);
            belakang.scaleToFit(width, height);
            document.add(belakang);

            // Tulis RFID di kolom putih
            PdfContentByte cb = writer.getDirectContent();
            BaseFont bf = BaseFont.createFont();
            cb.beginText();
            cb.setFontAndSize(bf, 20);
            cb.setTextMatrix(360, 244);
            cb.showText(namaMember);
            cb.endText();

            document.close();
            System.out.println("Kartu member berhasil dicetak.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
