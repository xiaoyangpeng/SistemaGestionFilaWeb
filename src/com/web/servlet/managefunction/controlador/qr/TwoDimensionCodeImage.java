package com.web.servlet.managefunction.controlador.qr;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

public class TwoDimensionCodeImage implements QRCodeImage {
    BufferedImage bufImg;  //将图片加载到内存中
    public TwoDimensionCodeImage(BufferedImage bufImg) {
        this.bufImg = bufImg;
    }
    public int getWidth() {
        return bufImg.getWidth();
    }

    public int getHeight() {
        return bufImg.getHeight();
    }

    public int getPixel(int x, int y) {
        return bufImg.getRGB(x,y);
    }
}