package entity;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePannel;
import Main.KeyHandler;

public class Player extends Entity{

	GamePannel GP;
	KeyHandler keyH;
	
	public int screenX;
	public int screenY;
	
	public Player(GamePannel GP, KeyHandler keyH) {
		
		this.GP = GP;
		this.keyH = keyH;
		
		screenX = GP.ScreenWidth/2 - (GP.tileSize/2);
		screenY = GP.ScreenHight/2 - (GP.tileSize/2);
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		Worldx = GP.tileSize * 23;
		Worldy = GP.tileSize * 21;
		speed = 4;
		Direction = "Down";
	}
	
	public void getPlayerImage() {
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerUp 1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerUp 2.png"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerUp 3.png"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerUp 4.png"));
			up5 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerUp 5.png"));
			up6 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerUp 6.png"));
			
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerDownWalk 1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerDownWalk 2.png"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerDownWalk 3.png"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerDownWalk 4.png"));
			down5 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerDownWalk 5.png"));
			down6 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerDownWalk 6.png"));
			
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerRightWalk 1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerRightWalk 2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerRightWalk 3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerRightWalk 4.png"));
			left5 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerRightWalk 5.png"));
			left6 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerRightWalk 6.png"));
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerLeftWalk 1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerLeftWalk 2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerLeftWalk 3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerLeftWalk 4.png"));
			right5 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerLeftWalk 5.png"));
			right6 = ImageIO.read(getClass().getResourceAsStream("/player/PlayerLeftWalk 6.png"));
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.upPressed) {
				if(keyH.upPressed) {
				Direction = "up";
				Worldy -= speed;
			}
			if(keyH.downPressed) {
				Direction = "Down";
				Worldy  += speed;
			}
			if(keyH.leftPressed) {
				Direction = "left";
				Worldx -= speed;
			}
			if(keyH.rightPressed) {
				Direction = "right";
				Worldx += speed;
			}
		
		
			spriteCounter++;
			if(spriteCounter > 12) {
				if(spriteNum == 1) {
					spriteNum = 2;
					}
				else if(spriteNum == 2) {
					spriteNum = 3;
					}
				else if(spriteNum == 3) {
					spriteNum = 4;
					}
				else if(spriteNum == 4) {
					spriteNum = 5;
					}
				else if(spriteNum == 5) {
					spriteNum = 6;
					}
			else if(spriteNum == 6) {
				spriteNum = 1;
					}
			spriteCounter = 0;
			}
		}
		
	}
	
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, GP.tileSize, GP.tileSize);
		
		BufferedImage image = null;
		
		switch(Direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up3;
			}
			if(spriteNum == 4) {
				image = up4;
			}
			if(spriteNum == 5) {
				image = up5;
			}
			if(spriteNum == 6) {
				image = up6;
			}
			
			break;
			
		case "Down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down3;
			}
			if(spriteNum == 4) {
				image = down4;
			}
			if(spriteNum == 5) {
				image = down5;
			}
			if(spriteNum == 6) {
				image = down6;
			}
			break;
			
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			if(spriteNum == 3) {
				image = left3;
			}
			if(spriteNum == 4) {
				image = left4;
			}
			if(spriteNum == 5) {
				image = left5;
			}
			if(spriteNum == 6) {
				image = left6;
			}
			break;
			
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right3;
			}
			if(spriteNum == 4) {
				image = right4;
			}
			if(spriteNum == 5) {
				image = right5;
			}
			if(spriteNum == 6) {
				image = right6;
			}
			
			break;
		}
		g2.drawImage(image, screenX, screenY, GP.tileSize, GP.tileSize, null);
		
		
	}
}
