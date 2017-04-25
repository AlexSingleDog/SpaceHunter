package gamecore;

import java.awt.*;
import java.awt.image.*;

public class Ribbon {
	public BufferedImage bim;	//ͼ�����
	private int xImHead;		//ͼ��ͷָ��
	private int pWidth;			//���ڿ��
	private int pHeight;		//���ڸ߶�
	private int width;			//ͼ����
	private int moveSize;		//�ƶ��ٶ�
	public boolean canMove;
	
	public Ribbon(int moveSize,BufferedImage im,int pWidth,int pHeight){
		bim =im;
		
		canMove = false;
		
		xImHead =0;
		this.pWidth = pWidth;
		this.pHeight = pHeight;
		width = bim.getWidth();
		this.moveSize = moveSize;
	}
	
	private void drawRibbon(Graphics g,BufferedImage im,
			int dx1, int dx2,int sx1,int sx2){
		g.drawImage(im, dx1, 0, dx2, pHeight, sx1, 0, sx2, pHeight, null);

		
	}
	
	public void draw(Graphics g){
		if(xImHead == 0){
			drawRibbon(g,bim,0,pWidth,0,pWidth);
		}else if((xImHead >0 )&&(xImHead < pWidth) ){
			drawRibbon(g,bim,0,xImHead,width-xImHead,width);
			drawRibbon(g,bim,xImHead,pWidth,0,pWidth - xImHead);
		}else if(xImHead >= pWidth){
			drawRibbon(g,bim,0,pWidth,
					width - xImHead,width - xImHead + pWidth);
		}else if(xImHead < pWidth - width){
			drawRibbon(g,bim,0,width + xImHead,-xImHead,width);
			drawRibbon(g,bim,width + xImHead,pWidth,0,pWidth - width - xImHead);
		}else if((xImHead <0 )&& (xImHead >= pWidth -width)){
			drawRibbon(g,bim,0,pWidth,-xImHead,pWidth - xImHead);
		}
	}
	
	public void updatePic(int d){
		if(d < 0){
			xImHead = (xImHead + moveSize) % width;
		}else if(d > 0){
			xImHead = (xImHead - moveSize) % width;
		}


	}
	
}
