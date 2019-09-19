package com.boshuo.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

public class QrCodeCreateUtil {


    /**
     * 生成包含字符串信息的二维码图片
     * @param outputStream
     * @param content 二维码携带信息
     * @param qrCodeSize 二维码图片大小
     * @param imgFormat 二维码的格式
     * @return
     */
    public static boolean createQrCode(OutputStream outputStream,String content,int qrCodeSize,String imgFormat) throws WriterException, IOException {

        Hashtable<EncodeHintType, ErrorCorrectionLevel> hashtable = new Hashtable();
        hashtable.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE,qrCodeSize,qrCodeSize,hashtable);

        int matriWidth = bitMatrix.getWidth();
        BufferedImage image = new BufferedImage(matriWidth -200,matriWidth -200,BufferedImage.TYPE_INT_RGB);

        image.createGraphics();
        Graphics2D graphics2D = (Graphics2D) image.getGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,matriWidth,matriWidth);
        graphics2D.setColor(Color.BLACK);

        for (int i = 0; i < matriWidth; i++) {
            for (int j = 0; j < matriWidth; j++) {
                if (bitMatrix.get(i,j)){
                    graphics2D.fillRect(i-100,j-100,1,1);
                }
            }
        }
        return ImageIO.write(image,imgFormat,outputStream);
    }

    public static void readQrCode(InputStream inputStream) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);

        LuminanceSource source = new BufferedImageLuminanceSource(image);

        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        QRCodeReader reader = new QRCodeReader();

        Result result = null;
        try {
            result = reader.decode(bitmap);
        }catch (ReaderException e){
            e.printStackTrace();
        }
    }

}
