package com.agenciacontato.apicontact.barcode;

import com.google.zxing.common.BitMatrix;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static com.agenciacontato.apicontact.barcode.QRCodeGenerator.MATRIX_HEIGHT;
import static com.agenciacontato.apicontact.barcode.QRCodeGenerator.MATRIX_WIDTH;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class SVGConverterTest {

    @Test
    public void shoulSVGAZTECCode() {

        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
        BitMatrix bitMatrix = qrCodeGenerator.generatedQRCode("STRING ENCODE TO AZTEC");

        SVGConverter svgConverter = new SVGConverter();

        String stringEncodedAZTEC = svgConverter.qrToSvg(bitMatrix, MATRIX_WIDTH, MATRIX_HEIGHT);

        assertThat(stringEncodedAZTEC).isEqualTo(openTextArchiveAZTECCode());
    }

    private String openTextArchiveAZTECCode() {
        try {
            File file = new File("src/test/resources/textsbarcode/QR_CODE_ENCODED_SVG");
            byte[] buffer;
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                int size = fileInputStream.available();
                buffer = new byte[size];
                fileInputStream.read(buffer);
                fileInputStream.close();
            }
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}