package tile;

import java.awt.Graphics2D;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import javax.imageio.ImageIO;

import Main.GamePannel;
import java.util.Random;

public class TileManager {
	
	Random random = new Random();
	GamePannel GP;
	Tile[] tile;
	int TileMapNum[][];
	
	public TileManager(GamePannel GP) {
		this.GP = GP;
		tile = new Tile[10];
		TileMapNum = new int[GP.MaxWorldColumns] [GP.MaxWorldRows];
		
		GetTileImage();
		loadMap();
	}
	
	public void GetTileImage() {
		
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass_Middle.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GrassTile 1.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GrassTile 2.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/GrassTile 3.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water_Middle.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water_TileBlok 1.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water_TileBlok 2.png"));
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water_TileBlok 3.png"));
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brikBlock 1.png"));
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Oak_Tree.png"));
			
			//tile[10] = new Tile();
			//tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/cuttree.png"));
			
			//tile[11] = new Tile();
			//tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Path_Middle.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void loadMap() {
		
		try {
			InputStream is = getClass().getResourceAsStream("/map/map1.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int columns = 0;
			int Row = 0;
			
			while(columns < GP.MaxWorldColumns && Row < GP.MaxWorldRows){
				String line = br.readLine();	
				
				while(columns < GP.MaxWorldColumns) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[columns]);
					
					TileMapNum[columns][Row] = num;
					columns++;
					}
				if(columns == GP.MaxWorldColumns) {
					columns = 0;
					Row ++;
				}
				}
			br.close();
			
			
		}catch(IOException e) {
			
		}
		
	}
	
	//random world generation

	
	public void draw(Graphics2D g2) {
		/*g2.drawImage(tile[0].image, 0, 0, GP.tileSize, GP.tileSize, null);
		g2.drawImage(tile[1].image, 48, 0, GP.tileSize, GP.tileSize, null);
		g2.drawImage(tile[2].image, 96, 0, GP.tileSize, GP.tileSize, null);
		g2.drawImage(tile[3].image, 144, 0, GP.tileSize, GP.tileSize, null);
		g2.drawImage(tile[4].image, 192, 0, GP.tileSize, GP.tileSize, null);
		g2.drawImage(tile[5].image, 240, 0, GP.tileSize, GP.tileSize, null);
		 */
		
		
		
		int Worldcolumns = 0;
		int WorldRows = 0;
		
		while(Worldcolumns < GP.MaxWorldColumns && WorldRows < GP.MaxWorldRows) {
			
				int tilenum = TileMapNum[Worldcolumns][WorldRows];
				int worldx = Worldcolumns * GP.tileSize;
				int worldy = WorldRows * GP.tileSize;
				
				int screenx = worldx - GP.Player.Worldx + GP.Player.screenX;
				int screeny = worldy - GP.Player.Worldy + GP.Player.screenY;

			g2.drawImage(tile[tilenum].image, screenx, screeny, GP.tileSize, GP.tileSize, null);
				
				
			Worldcolumns++;
			
			if (Worldcolumns == GP.MaxWorldColumns) {
				Worldcolumns = 0;
				WorldRows ++;
			}
		}
	}
}
