package com.agenciacontato.apicontact.barcode;

import com.google.zxing.common.BitMatrix;

public class SVGConverter {

    public String qrToSvg(BitMatrix bitMatrixEncodedAZTEC, int matrixWidth, int matrixHeight) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuilder.append("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
        stringBuilder.append(String.format("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" viewBox=\"0 0 %1$d %1$d\" stroke=\"none\">", matrixWidth));
        stringBuilder.append("<rect width=\"100%\" height=\"100%\" fill=\"#FFFFFF\"/>");
        stringBuilder.append("<path d=\"");
        boolean head = true;

        for (int y = 0; y < matrixWidth; ++y) {
            for (int x = 0; x <= matrixHeight; ++x) {
                if (bitMatrixEncodedAZTEC.get(x, y)) {
                    if (head) {
                        head = false;
                    } else {
                        stringBuilder.append(" ");
                    }

                    stringBuilder.append(String.format("M%d,%dh1v1h-1z", x, y));
                }
            }
        }

        stringBuilder.append("\" fill=\"#000000\"/>");
        stringBuilder.append("</svg>");
        return stringBuilder.toString();
    }
}

