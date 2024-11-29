package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePannel extends JPanel implements Runnable{
	
	//screen settings
		 final public int originalTileSize = 16;					//16 x 16 tile
		 final public int scale = 3;
		 final public int maxScreenColumns = 16;
		 final public int maxScreenRow = 12;
		 
		 final public int tileSize = originalTileSize * scale;
		 final public int ScreenWidth = tileSize * maxScreenColumns;		// 768px
		 final public int ScreenHight = tileSize * maxScreenRow;			// 576px
		 
		 TileManager tileM	= new TileManager(this);
		 KeyHandler keyH = new KeyHandler();
		 Thread GameThread;									//game time (you have to implement runnable)
		 public Player Player = new Player(this, keyH);
		 
		 int Fps = 60;
		 
		 
		 public GamePannel() { 								//constructor has to have the same name as the class
				this.setPreferredSize(new Dimension(ScreenWidth, ScreenHight));
				this.setBackground(Color.decode("#FFCCEE"));				//Color.decode("#FFCCEE"); for hex color
				this.setDoubleBuffered(true);   				//improve game rendering performance
				this.addKeyListener(keyH);
				this.setFocusable(true);						//to make game panel focused on receiving input
			}
		 
		 public void StartGameThread() {
				GameThread = new Thread(this);
				GameThread.start();
			}
		 
		 	@Override
			public void run() {
				
				double DrawInterval = 1000000000/Fps;
				double nextInterval = System.nanoTime() + DrawInterval;//	System.nanoTime(); =>	return the value of present time in nanosecond
				
				while(GameThread != null) {
					
					update();
					repaint();
					
					
					try {
						double remainTime = nextInterval - System.nanoTime();
						remainTime /= 1000000;
						
						if(remainTime<0) {
							remainTime = 0;
						}
						
						Thread.sleep((long) remainTime);//wait intil the remaining time finish to make next move
						nextInterval += DrawInterval;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			public void update() {
				Player.update();
			}
			public void paintComponent(Graphics g) {
				
				super.paintComponent(g);
				
				Graphics2D g2 = (Graphics2D)g;
				tileM.draw(g2);
				Player.draw(g2);
				g2.dispose();										//?
			}
}
