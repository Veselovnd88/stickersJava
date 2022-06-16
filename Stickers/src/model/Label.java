package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

public class Label extends AbstractLabel{

	@Override
	public void paint(Graphics g) {
	      Image img = createImage();
	      g.drawImage(img, 20,20,(ImageObserver) this);
		
	}

	@Override
	public Image createImage() {
		// TODO Auto-generated method stub
		return null;
	}

}
