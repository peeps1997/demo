import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
public class Texture {
	public static Texture wood = new Texture("C:\\Users\\ashekhawat\\eclipse-workspace\\DemoGame\\src\\res\\texture\\wood.png", 64);
	public static Texture brick = new Texture("C:\\Users\\ashekhawat\\eclipse-workspace\\DemoGame\\src\\res\\texture\\brick.png", 64);
//	public static Texture bluestone = new Texture("res/bluestone.png", 64);
//	public static Texture stone = new Texture("C:\\Users\\ashekhawat\\eclipse-workspace\\DemoGame\\src\\res\\texture\\stone.png", 64);
	public static Texture stick = new Texture("C:\\Users\\ashekhawat\\eclipse-workspace\\DemoGame\\src\\res\\texture\\stick.png", 64);
	public int[] pixels;
	private String loc;
	public final int SIZE;
	public ArrayList<Texture> textures;
	public Texture(String location, int size) {
		loc = location;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		textures = new ArrayList<Texture>();
		textures.add(Texture.brick);
		textures.add(Texture.stick);
		textures.add(Texture.wood);
		load();
	}
	private void load() {
		try {
			BufferedImage image =ImageIO.read(new File(loc));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels	, 0, w);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
