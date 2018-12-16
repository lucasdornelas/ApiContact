package com.agenciacontato.apicontact.barcode;

import com.google.zxing.common.BitMatrix;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class QRCodeGeneratorTest {

    @Test
    public void shouldBuildCorrectQRCode() {

        QRCodeGenerator generateAZTEC = new QRCodeGenerator();
        BitMatrix bitMatrix = generateAZTEC.generatedQRCode("STRING ENCODE TO AZTEC");

        assertThat(bitMatrix).isNotNull();
        assertThat(bitMatrix.getWidth()).isEqualTo(200);
        assertThat(bitMatrix.getHeight()).isEqualTo(200);
    }

}