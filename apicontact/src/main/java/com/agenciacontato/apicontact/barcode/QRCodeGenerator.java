package com.agenciacontato.apicontact.barcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.common.BitMatrix;
import lombok.Getter;

import java.util.HashMap;

import static com.google.zxing.BarcodeFormat.AZTEC;
import static com.google.zxing.EncodeHintType.ERROR_CORRECTION;

@Getter
public class QRCodeGenerator {

    public static final int MATRIX_WIDTH = 200;
    public static final int MATRIX_HEIGHT = 200;

    public BitMatrix generatedQRCode(String reprintBarcodeString) {
        final int levelErrorCorrection = 25;

        HashMap<EncodeHintType, Integer> hashMapLevelErrorCorrection = new HashMap<>();
        hashMapLevelErrorCorrection.put(ERROR_CORRECTION, levelErrorCorrection);

        return new AztecWriter().encode(reprintBarcodeString, AZTEC, MATRIX_WIDTH, MATRIX_HEIGHT, hashMapLevelErrorCorrection);
    }
}
