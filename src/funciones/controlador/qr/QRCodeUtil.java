package funciones.controlador.qr;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import variables.DirectorioImagen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class QRCodeUtil {
    /**
     *���ܣ�  ������Ϣ ->��ά��.png
     * @param content ������Ϣ
     * @param imgPath ��ά��·��
     * @param imgType ��ά�����ͣ�png
     * @param size    ��ά��ߴ�
     * @throws Exception
     */
    public void encoderQRCode(String content, OutputStream outputStream)  throws Exception{
        //BufferedImage ���ڴ��е�һ��ͼƬ
        BufferedImage bufImg =   qRcodeCommon(content,"png",15);

       // File file = new File(imgPath);// "src/��ά��.png" --> ��ά��.png
       
      
        //����ͼƬ
        ImageIO.write(bufImg,"png", outputStream);
    }

    /**
     *����һ����ά���BufferedImage
     * @param content ��ά��������Ϣ
     * @param imgType ͼƬ��ʽ
     * @param size    ͼƬ��С
     * @return
     */
    
    
 
    private BufferedImage qRcodeCommon(String content, String imgType, int size) throws Exception {
      
  
    	
    	BufferedImage bufImg =null;
        //Qrcode�����ַ���->boolean[][]
        Qrcode qrCodeHandler = new Qrcode();
        //���ö�ά����Ŵ��ʣ�7% L<M<Q<H30%  ���Ŵ���Խ��,�ɴ洢����ϢԽ�٣����ǶԶ�ά��������Ҫ��ԽС
        
        qrCodeHandler.setQrcodeErrorCorrect('M');
        //�ɴ�ŵ���Ϣ���ͣ�N�����֡�  A������+A-Z  B������
        
        qrCodeHandler.setQrcodeEncodeMode('B');
        //�ߴ磺ȡֵ��Χ��1-40
        qrCodeHandler.setQrcodeVersion(size);

        //"Hello world" -> byte[]"Hello world" -->boolean[][]
        byte[] contentBytes = content.getBytes("UTF-8");
        
        boolean[][] codeOut = qrCodeHandler.calQrcode(contentBytes);
        
        
        
        int imgSize =  67 + 12*(size -1) ;
        
        
         

        //BufferedImage���ڴ��е�ͼƬ
        bufImg = new BufferedImage(imgSize,imgSize,BufferedImage.TYPE_INT_RGB );//red green blue

        //����һ������
        Graphics2D gs = bufImg.createGraphics();
        gs.setBackground(Color.WHITE);//������ı���ɫ����Ϊ��ɫ
        gs.clearRect( 0,0, imgSize,imgSize); //��ʼ��
        gs.setColor(Color.BLACK);//���� ������ ͼ�����ɫ����ά�����ɫ��
       // gs.setColor(Color.GREEN);
        int pixoff = 2 ;

        
        
        for(int j=0;j<codeOut.length;j++) {
            for(int i=0;i<codeOut.length;i++) {
                if(codeOut[j][i]) {
                    gs.fillRect(j*3+pixoff , i*3+pixoff, 3, 3);
                }
            }
        }
        
        
        //����LOGO
        //��Ӳ���е�src/logo.png  ����Ϊһ��Image����
        Image logo =  ImageIO.read(new File(DirectorioImagen.DIRECTORIO_LOGO) ) ;
        int maxHeight = bufImg.getHeight();
        int maxWdith = bufImg.getWidth();

        //�������ɵĶ�ά���� ��logo
        gs.drawImage(logo,imgSize/5*2,imgSize/5*2, maxWdith/5,maxHeight/5 ,null) ;

        gs.dispose(); //�ͷſռ�
        bufImg.flush(); //����
        return bufImg ;
    }

    
    //���ܣ�  ��ά��(ͼƬ·��) -> ������Ϣ
    public String decoderQRCode(String imgPath) throws Exception{

        //BufferedImage�ڴ��е�ͼƬ  ��Ӳ���е�imgPathͼƬ ->�ڴ�BufferedImage
        BufferedImage bufImg =  ImageIO.read( new File(imgPath) ) ;
        //����
        QRCodeDecoder decoder = new QRCodeDecoder() ;

        TwoDimensionCodeImage tdcImage = new TwoDimensionCodeImage(bufImg);
        
        byte[] bs = decoder.decode(tdcImage) ;    //bufImg
        //byte[] -->String
        
       
        
        String content  = new String(bs,"UTF-8");
        
        return content;
    }


}