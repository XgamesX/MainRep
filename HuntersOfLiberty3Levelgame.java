import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.*;//импорт библиотеки Swing 
import javax.xml.stream.events.StartDocument;

import org.omg.CORBA.PUBLIC_MEMBER;

public class HuntersOfLiberty3Levelgame extends JPanel {

	public static final int[][] map = new int[][] {
		{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2 },
		{ 2, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,2 },
		{ 2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2,2 },
		{ 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2,2 },
		{ 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2,2 },
		{ 3, 1, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 2, 1, 1, 3,2 },
		{ 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2,2 },
		{ 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2,2 },
		{ 2, 2, 1, 1, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2,2 },
		{ 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 2,2 },
		{ 2, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 1, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2,2 },
		{ 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 2,2 },
		{ 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2,2 },
		{ 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2,2 },
		{ 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 2, 2,2 },
        { 2, 2, 1, 1, 1, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2, 2, 2, 2,2 },
        { 2, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 2, 2,2 },
        { 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 2, 1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1,2 },
        { 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2,2 },
        { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2,2 },
        };

	/** The width in grid cells of our map */
	private static final int row = 20;
	/** The height in grid cells of our map */
	private static final int collums = 38;
	/** The rendered size of the tile (in pixels) */
	public static final int TILE_SIZE = 50;

	public Image trava;
	public Image voda;
	public Image door;
	public Image fountain;
	public Image teleport;
	public Image target;
	public Image patron;
	public Image spell;
	Graphics g;

	int UnitSpeed = 10;
	URL url = HuntersOfLiberty3Levelgame.class.getResource("img/Shag.wav");
	URL url2 = HuntersOfLiberty3Levelgame.class.getResource("img/mech3.wav");
	URL url3 = HuntersOfLiberty3Levelgame.class.getResource("img/scream.wav");
	URL url4 = HuntersOfLiberty3Levelgame.class.getResource("img/arrow.wav");
	URL url5 = HuntersOfLiberty3Levelgame.class.getResource("img/VaseSmash.wav");
	URL url6 = HuntersOfLiberty3Levelgame.class.getResource("img/QUICK_AP.wav");
	URL url7 = HuntersOfLiberty3Levelgame.class.getResource("img/DoorCreakSlam.wav");
	AudioClip clip = Applet.newAudioClip(url);
	AudioClip clip2 = Applet.newAudioClip(url2);
	AudioClip clip3 = Applet.newAudioClip(url3);
	AudioClip clip4 = Applet.newAudioClip(url4);
	AudioClip clip5 = Applet.newAudioClip(url5);
	AudioClip clip6 = Applet.newAudioClip(url6);
	AudioClip clip7 = Applet.newAudioClip(url7);
	static int min = 0;

	int x_MyHero = 0;
	int y_MyHero = 250;

	int x_EnemyMage = 100; // начальная координата первого врага
	int y_EnemyMage = 400;

	int xWraith = 150;
	int yWraith = 700;

	int x_EnemyPaladin1 = 250;
	int y_EnemyPaladin1 = 350;

	int x_EnemyPaladin2 = 150;
	int y_EnemyPaladin2 = 250;

	int x_FlyEnemy = 650;
	int y_FlyEnemy = 450;

	int countBalls = 0;

	int xForPatron = 100;
	int yForPatron = -50;

	int xForSpell = 100;
	int yForSpell = -50;

	int i;
	int j;

	int xBlood = -50;
	int yBlood = -50;

	int x1item = 50;
	int y1item = 150;

	int x2item = 700;
	int y2item = 600;

	int x3item = 500;
	int y3item = 900;

	int countLives = 3;

	int xVlog = 300;
	int yVlog = 550;



	int xShadow = 850;
	int yShadow = 800;

	int x1live = 0;
	int y1live = 0;

	int x2live = 50;
	int y2live = 0;

	int x3live = 100;
	int y3live = 0;

	int x_Staff;
	int y_Staff;

	int xChest = 800;
	int yChest = 600;

	volatile static int xOskolki1Item = -50;
	volatile static int yOskolki1Item = 150;

	volatile static int xOskolki2Item = -50;
	volatile static int yOskolki2Item = 600;

	volatile static int xOskolki3Item = -50;
	volatile static int yOskolki3Item = 900;

	static volatile int countVzriv1Item = 0;
	static volatile int countVzriv2Item = 0;
	static volatile int countVzriv3Item = 0;

	int weighMyHero = 49;
	int heighMyHero = 49;

	int downLeftCornerOfHero = 10;
	int rightAndLeftCornerOfHero = 15;

	int xPoison = 150;
	int yPoison = 350;

	JFrame lastFrame = new JFrame();
	JPanel lastPanel = new JPanel();
	JTextArea lastArea1 = new JTextArea();
	JTextArea lastArea2 = new JTextArea();
	Font lastFont = new Font(null, Font.BOLD, 35);
	JButton exitLastButton = new JButton();
	
	static JFrame JF1 = new JFrame();
	static JPanel JP1 = new JPanel();
	static JLabel JL1 = new JLabel();
	static JLabel JL2 = new JLabel();
	static JPanel JP2 = new JPanel();
	static JTextField JT1 = new JTextField("Hero");
	static JTextField JT2 = new JTextField("Enemies");
	static JTextField JT3 = new JTextField("add.items");
	static Font font = new Font("Chiller", Font.BOLD, 35);
	static Font font2 = new Font("Curlz MT", Font.BOLD, 17);
	static Font font3 = new Font("Chiller", Font.BOLD, 20);
	static JTextField JT4 = new JTextField("Exit");
	
	static int isec = 0;
	CleverVlog cv = new CleverVlog();
	Thread cv1 = new Thread(cv);
	void time(){
	lastArea2.setText("                                                                                                 Ваше время:             " + min + " : " + "" + isec);
	}
	static void timee() {
		while (true) {
			 isec = 0;
			while (isec < 60) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				JL2.setText("" + min + " : " + "" + isec);
				
				isec++;
				if (isec == 59) {
					isec = 0;
					min++;
				}
			}

		}

	}

	public static void main(String[] args) {
		HuntersOfLiberty3Levelgame h2 = new HuntersOfLiberty3Levelgame();

		JF1.setSize(1910, 1000);
		JF1.setLayout(new BorderLayout());
		JF1.add(JP1, BorderLayout.WEST);
		JP1.setLayout(new BorderLayout());
		JP1.add(JL1, BorderLayout.NORTH);
		JL1.setText("Game time     ");
		JP1.add(JL2, BorderLayout.SOUTH);
		JP1.setLayout(new BoxLayout(JP1, BoxLayout.Y_AXIS));
		JT1.setFont(font3);
		JT2.setFont(font3);
		JT3.setFont(font3);
		JT4.setFont(font3);
		JT1.setBackground(Color.lightGray);
		JT2.setBackground(Color.lightGray);
		JT3.setBackground(Color.lightGray);
		JT4.setBackground(Color.lightGray);
		JP1.add(JT1);
		JP1.add(JT2);
		JP1.add(JT3);
		JP1.add(JT4);
		JL2.setFont(font);
		JL1.setFont(font2);
		JP1.setBackground(Color.LIGHT_GRAY);
		JF1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выгружает окно из
		JF1.setLocationRelativeTo(null); // ровняет окно посередине
		JF1.add(h2);

		JF1.setVisible(true);
		timee();
		/*
	
*/
	}

	HuntersOfLiberty3Levelgame() {

		moveEnemy me = new moveEnemy();
		Thread t1 = new Thread(me);
		t1.start();

		move2Enemy me2 = new move2Enemy();
		Thread t2 = new Thread(me2);
		t2.start();

		moveShadow ms = new moveShadow();
		Thread t7 = new Thread(ms);
		t7.start();

		moveWraith mw = new moveWraith();
		Thread t8 = new Thread(mw);
		t8.start();

		addKeyListener(new moveSoldier());

	}

	public void paintComponent(Graphics g) {

		ImageIcon r20 = new ImageIcon(getClass().getResource("img/halfling.png"));
		Image heroImage2 = r20.getImage();

		ImageIcon r25 = new ImageIcon(getClass().getResource("img/door.png"));
		Image doorr = r25.getImage();
		
		ImageIcon r21 = new ImageIcon(getClass().getResource("img/cloud.png"));
		Image oskolki = r21.getImage();

		Graphics g2 = JP1.getGraphics();

		ImageIcon abcd = new ImageIcon(getClass().getResource("img/closedDoor.png"));
		Image door = abcd.getImage();

		ImageIcon ab = new ImageIcon(getClass().getResource("img/sand.png"));
		Image trava = ab.getImage();

		ImageIcon abc = new ImageIcon(getClass().getResource("img/lava.png"));
		Image voda = abc.getImage();

		for (i = 0; i < row; i++) {
			for (j = 0; j < collums; j++) {
				if (map[i][j] == 1) {
					g.drawImage(trava, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE,
							TILE_SIZE, null);
				} else if (map[i][j] == 2) {
					g.drawImage(voda, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE,
							TILE_SIZE, null);
				} else if (map[i][j] == 3) {
					g.drawImage(door, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE,
							TILE_SIZE, null);

				}
			}
		}
		// для того, чтобы изображение сразу появилось в окне
		this.updateUI();

		ImageIcon abcdef = new ImageIcon(getClass().getResource("img/fountain2.png"));
		Image fountain = abcdef.getImage();
		g.drawImage(fountain, 100, 100, 50, 50, null);
		g.drawImage(fountain, 1300, 850, 50, 50, null);

		ImageIcon q = new ImageIcon(getClass().getResource("img/lich.png"));
		Image image3 = q.getImage();
		g.drawImage(image3, x_EnemyMage, y_EnemyMage, 50, 50, null);

		ImageIcon q4 = new ImageIcon(getClass().getResource("img/wraith.png"));
		Image enemy = q4.getImage();
		g.drawImage(enemy, xWraith, yWraith, 50, 50, null);

		ImageIcon q5 = new ImageIcon(getClass().getResource("img/dngn_trap_zot.png"));
		Image portal = q5.getImage();
		g.drawImage(portal, 300, 100, 50, 50, null);
		g.drawImage(portal, 900, 100, 50, 50, null);

		ImageIcon q3 = new ImageIcon(getClass().getResource("img/shadow.png"));
		Image image4 = q3.getImage();
		g.drawImage(image4, xShadow, yShadow, 50, 50, null);

		ImageIcon q8 = new ImageIcon(getClass().getResource("img/item.png"));
		Image image6 = q8.getImage();
		g.drawImage(image6, x1item, y1item, 50, 50, null);
		g.drawImage(image6, x2item, y2item, 50, 50, null);
		g.drawImage(image6, x3item, y3item, 50, 50, null);

		ImageIcon q7 = new ImageIcon(getClass().getResource("img/live.png"));
		Image live = q7.getImage();
		g.drawImage(live, x1live, y1live, 50, 50, null);
		g.drawImage(live, x2live, y2live, 50, 50, null);
		g.drawImage(live, x3live, y3live, 50, 50, null);

		ImageIcon q6 = new ImageIcon(getClass().getResource("img/shadowSpell.png"));
		Image spellNecr = q6.getImage();

		ImageIcon p1 = new ImageIcon(getClass().getResource("img/teleport.png"));
		Image teleport = p1.getImage();
		g.drawImage(teleport, 400, 200, 50, 50, null);
		g.drawImage(teleport, 550, 450, 50, 50, null);
		g.drawImage(teleport, 650, 350, 50, 50, null);
		g.drawImage(teleport, 750, 150, 50, 50, null);
		 g.drawImage(teleport, 1600, 550, 50, 50, null);
		 g.drawImage(teleport, 1350, 700, 50, 50, null);

		ImageIcon p2 = new ImageIcon(getClass().getResource("img/dngn_portal.png"));
		Image teleportV2 = p2.getImage();
		g.drawImage(teleportV2, 250, 500, 50, 50, null);
		g.drawImage(teleportV2, 700, 550, 50, 50, null);
		g.drawImage(teleportV2, 400, 400, 50, 50, null);
		g.drawImage(teleportV2, 150, 800, 50, 50, null);

		ImageIcon abcdefg = new ImageIcon(getClass().getResource("img/cursor_red.png"));
		Image target = abcdefg.getImage();
		g.drawImage(target, 200, 300, 50, 50, null);

		ImageIcon k = new ImageIcon(getClass().getResource("img/paladin.png"));
		Image image8 = k.getImage();
		g.drawImage(image8, x_EnemyPaladin1, y_EnemyPaladin1, 50, 50, null);

		ImageIcon r2 = new ImageIcon(getClass().getResource("img/chest2_closed.png"));
		Image chest = r2.getImage();
		g.drawImage(chest, xChest, yChest, 50, 50, null);
		// главный персонаж
		ImageIcon r = new ImageIcon(getClass().getResource("img/halfling.png"));
		Image heroImage = r.getImage();
		g.drawImage(heroImage, x_MyHero, y_MyHero, weighMyHero, heighMyHero,null);

		g.drawImage(oskolki, xOskolki1Item, yOskolki1Item, 50, 50, null);
		g.drawImage(oskolki, xOskolki2Item, yOskolki2Item, 50, 50, null);
		g.drawImage(oskolki, xOskolki3Item, yOskolki3Item, 50, 50, null);

		g.drawImage(image8, x_EnemyPaladin2, y_EnemyPaladin2, 50, 50, null);

		ImageIcon o7 = new ImageIcon(getClass().getResource("img/dangerous.png"));
		Image exit = o7.getImage();
		g.drawImage(exit, 1650, 800, 50, 50, null);

		ImageIcon o3 = new ImageIcon(getClass().getResource("img/cloud_poison2.png"));
		Image poi3 = o3.getImage();

		ImageIcon o4 = new ImageIcon(getClass().getResource("img/cursor.png"));
		Image cursor = o4.getImage();
		g.drawImage(cursor, 1000, 500, 50, 50, null);


		ImageIcon o5 = new ImageIcon(getClass().getResource("img/bolt04.png"));
		Image spellPlayer = o5.getImage();

		ImageIcon a1 = new ImageIcon(getClass().getResource("img/tree2_red.png"));
		Image tree = a1.getImage();
		g.drawImage(tree, 600, 100, 50, 50, null);

		ImageIcon a4 = new ImageIcon(getClass().getResource("img/blood_red.png"));
		Image blood = a4.getImage();
		g.drawImage(blood, xBlood, yBlood, 50, 50, null);

		ImageIcon a2 = new ImageIcon(getClass().getResource("img/bolt2.png"));
		patron = a2.getImage();
		g.drawImage(patron, xForPatron, yForPatron, 50, 50, null);

		ImageIcon r22 = new ImageIcon(getClass().getResource("img/spectral_warrior.png"));
		Image vlog = r22.getImage();
		g.drawImage(vlog, xVlog, yVlog, 50, 50, null);

		ImageIcon a3 = new ImageIcon(getClass().getResource("img/flying_skull.png"));
		Image cherep = a3.getImage();
		g.drawImage(cherep, x_FlyEnemy, y_FlyEnemy, 50, 50, null);

		g2.drawImage(image6, 80, 600, 45, 45, null);
		g2.drawImage(heroImage2, 75     , 150, 45, 45, null);
		g2.drawImage(image3, 80, 295, 35, 35, null);
		g2.drawImage(enemy, 80, 330, 35, 35, null);
		g2.drawImage(image4, 80, 365, 35, 35, null);
		g2.drawImage(image8, 80, 400, 35, 35, null);
		g2.drawImage(vlog, 80, 435, 35, 35, null);
		g2.drawImage(cherep, 80, 470, 35, 35, null);
		g2.drawImage(exit, 80, 835, 35, 35, null);

		if (x_MyHero == 550 && y_MyHero == 450) {
			CherepAttack Cha = new CherepAttack();
			Thread t5 = new Thread(Cha);
			t5.start();
		}

		if (200 == x_MyHero && 300 == y_MyHero) {
			g.drawImage(poi3, xPoison, yPoison, 50, 50, null);
			Bullet bullet = new Bullet();
			Thread t3 = new Thread(bullet);
			t3.start();

		}

		requestFocus();// отдельное окно для работы с управлением клавишами
						// стрелками(обязательно)

	


		if (x_MyHero == 1350 && y_MyHero == 700) {
			x_MyHero = 1600;
			y_MyHero = 550;
		

		}

		if (x_MyHero == 400 && y_MyHero == 400) {
			x_MyHero = 150;
			y_MyHero = 800;

		}
	
		if (x_MyHero == 1650 && y_MyHero == 800) {

			setupLastFrame();

		}
		if (x_MyHero == 400 && y_MyHero == 200) {
			x_MyHero = 550;
			y_MyHero = 450;
			
			
			
			cv1.start();
		}



		if (x_MyHero == 1050 && y_MyHero == 650) {
		clip7.play();
		g.drawImage(doorr, 1050, 650, null);
		}
		firstItem();
		secondItem();
		thirdItem();

		if (x_MyHero == 250 && y_MyHero == 500) {
			x_MyHero = 700;
			y_MyHero = 550;
			CleverVlog cv = new CleverVlog();
			Thread cv1 = new Thread(cv);
			cv1.start();

		}
		if (xForPatron == x_EnemyPaladin1 && y_EnemyPaladin1 <= yForPatron
				&& yForPatron <= y_EnemyPaladin1 + 50) {
			y_EnemyPaladin1 = 200000;
		}

		if (xForPatron == x_FlyEnemy && y_FlyEnemy <= yForPatron
				&& yForPatron <= y_FlyEnemy + 50) {
			y_FlyEnemy = 200000;
		}
		if (xForPatron == x_EnemyPaladin2 && y_EnemyPaladin2 <= yForPatron
				&& yForPatron <= y_EnemyPaladin2 + 50) {
			y_EnemyPaladin2 = 200000;
		}

		

		if (x_MyHero == 650 && y_MyHero == 350) {
			x_MyHero = 750;
			y_MyHero = 150;

		}

		firstPaladin();
		secondPaladin();
		wraith();
		Shadow();
		PoisonBullet();
        Vlog();
        FlyEnemy();
		if (x_MyHero == x_FlyEnemy && y_MyHero == y_FlyEnemy) {

		}
		if (x_MyHero == x_EnemyPaladin2 && y_MyHero == y_EnemyPaladin2) {

			y_MyHero = -450;

		}
	}
void parsClevVlog(){
	while(true){
	if(y_MyHero < yVlog){
		while(y_MyHero < yVlog){
		yVlog-=1;
		try {
			Thread.sleep(13);
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	}	
	
	
	try {
		Thread.sleep(80);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	if(y_MyHero > yVlog){
		while(y_MyHero > yVlog){
			yVlog+=1;
			try {
				Thread.sleep(13);
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
	}
	
	try {
		Thread.sleep(80);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	if(x_MyHero > xVlog){
		while(x_MyHero > xVlog){
			xVlog+=1;
			try {
				Thread.sleep(13);
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
	}
	
	
	try {
		Thread.sleep(80);
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	if(x_MyHero < xVlog){
		while(x_MyHero < xVlog){
			xVlog-=1;
			try {
				Thread.sleep(13);
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
	}
	try {
		Thread.sleep(80);
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
 	// /////////////////////проверка на красный квадратик
class CleverVlog implements Runnable{
	

	@Override
	public void run() {
		
parsClevVlog();
	}
}
	void setupLastFrame() {
		

		lastFrame.setSize(700, 300);
		clip6.play();
		lastFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lastFrame.setLocationRelativeTo(null);
		lastFrame.add(lastPanel);
		lastPanel.setLayout(new GridLayout(3, 1));
		lastPanel.add(lastArea1);
		lastPanel.add(lastArea2);
		lastPanel.add(exitLastButton);
		lastArea1.setFont(lastFont);
		lastArea1.setText("                        Позравляем!");
		
		exitLastButton.setText("   Нажмите для закрытия программы");
		exitLastButton.addActionListener(new lastButtonListener());
		time();
		lastFrame.setVisible(true);
		JF1.setVisible(false);
	}

	void firstItem() {
		if (x1item == x_MyHero && y1item == y_MyHero) {

			Vzriv1Item vzriv = new Vzriv1Item();
			Thread t11 = new Thread(vzriv);
			t11.start();
			if (countBalls == 0) {
				x1item = -50;
				countBalls = 1;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
		if (x1item == x_MyHero && y1item == y_MyHero) {

			Vzriv1Item vzriv = new Vzriv1Item();
			Thread t11 = new Thread(vzriv);
			t11.start();
			if (countBalls == 1) {
				x1item = -50;
				countBalls = 2;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
		if (x1item == x_MyHero && y1item == y_MyHero) {

			Vzriv1Item vzriv = new Vzriv1Item();
			Thread t11 = new Thread(vzriv);
			t11.start();
			if (countBalls == 2) {
				x1item = -50;
				countBalls = 3;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
	}

	void secondItem() {
		if (x2item == x_MyHero && y2item == y_MyHero) {

			Vzriv2Item vzriv2 = new Vzriv2Item();
			Thread t12 = new Thread(vzriv2);
			t12.start();

			if (countBalls == 0) {
				x2item = -50;
				countBalls = 1;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
		if (x2item == x_MyHero && y2item == y_MyHero) {

			Vzriv2Item vzriv2 = new Vzriv2Item();
			Thread t12 = new Thread(vzriv2);
			t12.start();

			if (countBalls == 1) {
				x2item = -50;
				countBalls = 2;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
		if (x2item == x_MyHero && y2item == y_MyHero) {

			Vzriv2Item vzriv2 = new Vzriv2Item();
			Thread t12 = new Thread(vzriv2);
			t12.start();

			if (countBalls == 2) {
				x2item = -50;
				countBalls = 3;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
	}

	void thirdItem() {
		if (x3item == x_MyHero && y3item == y_MyHero) {

			Vzriv3Item vzriv3 = new Vzriv3Item();
			Thread t13 = new Thread(vzriv3);
			t13.start();
			if (countBalls == 0) {
				x3item = -50;
				countBalls = 1;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
		if (x3item == x_MyHero && y3item == y_MyHero) {

			Vzriv3Item vzriv3 = new Vzriv3Item();
			Thread t13 = new Thread(vzriv3);
			t13.start();
			if (countBalls == 1) {
				x3item = -50;
				countBalls = 2;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
		if (x3item == x_MyHero && y3item == y_MyHero) {

			Vzriv3Item vzriv3 = new Vzriv3Item();
			Thread t13 = new Thread(vzriv3);
			t13.start();
			if (countBalls == 2) {
				x3item = -50;
				countBalls = 3;
				JL1.setText(countBalls + "     of      3   ");
			}
		}
	}

	void HoldItems() {

		if (x_MyHero == x2item && y2item == y_MyHero) {
			y2item = -50;
		}
		if (x_MyHero == x3item && y3item == y_MyHero) {
			y3item = -50;
		}
	}

	public boolean detecktForbiddenTile(int x_MyHero, int y_MyHero) {
		int rowTest;
		int collumsTest;

		collumsTest = Math.round(x_MyHero / TILE_SIZE);
		rowTest = Math.round(y_MyHero / TILE_SIZE);

		switch (map[rowTest][collumsTest]) {

		case 1: // земля
			return false;
		case 2:// лава
			return true;
		case 3:// дверь(выход)
			return false;
		}

		return false;
	}

	class BulletOfPlayer implements Runnable {

		@Override
		public void run() {
			xForPatron = x_MyHero;
			yForPatron = y_MyHero;
			while (xForPatron < 9000) {

				xForPatron += 10;
				repaint();
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
				}
			}

		}

	}

	class SpellOfPlayer implements Runnable {

		@Override
		public void run() {
			xForSpell = x_MyHero;
			yForSpell = y_MyHero;
			while (xForSpell < 9000) {

				xForSpell += 10;
				repaint();
				try {
					Thread.sleep(11);
				} catch (InterruptedException e) {
				}
			}

		}

	}

	class moveSoldier implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {

			int yOld, xOld;

			switch (e.getKeyCode()) {

			case KeyEvent.VK_UP:
				HoldItems();
				clip.play();
				yOld = y_MyHero;
				y_MyHero -= UnitSpeed;
				if ((detecktForbiddenTile(x_MyHero, y_MyHero))
						|| (detecktForbiddenTile((x_MyHero + weighMyHero),
								y_MyHero))) {
					y_MyHero = yOld;
				}
				repaint();
				break;

			case KeyEvent.VK_DOWN:
				HoldItems();
				clip.play();
				yOld = y_MyHero;
				y_MyHero += UnitSpeed;
				if (detecktForbiddenTile(x_MyHero, (y_MyHero + heighMyHero))
						|| detecktForbiddenTile((x_MyHero + weighMyHero),
								(y_MyHero + heighMyHero))) {
					y_MyHero = yOld;
				}
				repaint();
				break;

			case KeyEvent.VK_RIGHT:
				HoldItems();
				clip.play();
				xOld = x_MyHero;
				x_MyHero += UnitSpeed;
				if ((detecktForbiddenTile((x_MyHero + weighMyHero), y_MyHero))
						|| (detecktForbiddenTile((x_MyHero + weighMyHero),
								(y_MyHero + heighMyHero)))) {
					x_MyHero = xOld;
				}
				// System.out.println("x = " + x_MyHero + " y = " + y_MyHero);
				repaint();
				break;

			case KeyEvent.VK_LEFT:
				HoldItems();
				clip.play();
				xOld = x_MyHero;
				x_MyHero -= UnitSpeed;
				if (detecktForbiddenTile(x_MyHero, y_MyHero)
						|| detecktForbiddenTile(x_MyHero,
								(y_MyHero + heighMyHero))) {
					x_MyHero = xOld;
				}
				repaint();
				break;

			case KeyEvent.VK_D:
				clip4.play();
				BulletOfPlayer bulletOfPlayer = new BulletOfPlayer();
				Thread t4 = new Thread(bulletOfPlayer);
				t4.start();

				if (x_MyHero == 800 && y_MyHero == 600) {
					System.out.println("You has piked the new Staff!");
					SpellOfPlayer spellOfPlayer = new SpellOfPlayer();
					Thread t5 = new Thread(spellOfPlayer);
					t5.start();
					while (x_MyHero != 800 && y_MyHero != 600) {
						t5.start();
					}

				}

			}
		}

		@Override
		public void keyReleased(KeyEvent e) {

		}

		@Override
		public void keyTyped(KeyEvent e) {

		}

	}

	class moveEnemy implements Runnable {

		@Override
		public void run() {
			while (true) {
				while (y_EnemyPaladin1 > 250) {
					y_EnemyPaladin1 -= 1;
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}

				while (y_EnemyPaladin1 < 400) {
					y_EnemyPaladin1 += 1;
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			}
		}

	}

	class moveWraith implements Runnable {
		int speed = 2;

		@Override
		public void run() {
			while (true) {
				while (yWraith < 800 & xWraith < 250) {
					yWraith += 1;
					xWraith += 1;
					repaint();
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
					}
				}
				while (yWraith < 900 & xWraith > 150) {
					yWraith += 1;
					xWraith -= 1;
					repaint();
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
					}
				}
				while (yWraith > 800 & xWraith > 50) {
					yWraith -= 1;
					xWraith -= 1;
					repaint();
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
					}
				}
				while (yWraith > 700 & xWraith < 150) {
					yWraith -= 1;
					xWraith += 1;
					repaint();
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
					}
				}
			}
		}

	}

	class moveShadow implements Runnable {
		int speedOfShadow = 7;

		@Override
		public void run() {

			while (true) {

				while (xShadow < 1450) {

					xShadow += 1;
					repaint();
					if (x_MyHero == 1000 && y_MyHero == 500) {
						speedOfShadow = 4;

					}
					try {
						Thread.sleep(speedOfShadow);
					} catch (InterruptedException e) {
					}
				}
				if (x_MyHero == 1000 && y_MyHero == 500) {
					speedOfShadow = 4;

				}
				while (xShadow > 850) {

					xShadow -= 1;
					repaint();
					if (x_MyHero == 1000 && y_MyHero == 500) {
						speedOfShadow = 4;

					}
					try {
						Thread.sleep(speedOfShadow);
					} catch (InterruptedException e) {
					}
				}

			}

		}
	}

	class Bullet implements Runnable {

		@Override
		public void run() {
			while (xPoison < 1000 && yPoison > -50) {
				xPoison += 1;
				yPoison -= 1;
				repaint();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
				}
			}

		}
	}



	class move2Enemy implements Runnable {

		@Override
		public void run() {
			while (true) {
				while (y_EnemyPaladin2 > 50) {
					y_EnemyPaladin2 -= 1;
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
				while (x_EnemyPaladin2 > 50) {
					x_EnemyPaladin2 -= 1;
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
				while (x_EnemyPaladin2 < 150) {
					x_EnemyPaladin2 += 1;
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
				while (y_EnemyPaladin2 < 250) {
					y_EnemyPaladin2 += 1;
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
				}
			}
		}

	}

	class CherepAttack implements Runnable {

		@Override
		public void run() {

			while (x_FlyEnemy > 550) {
				x_FlyEnemy -= 1;

				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
				}
				repaint();
			}
		}

	}

	// МЕТОДЫ ОТВЕЧАЮЩИЕ ЗА ОТНИМАНИЕ СЕРДЕЦ

	void firstPaladin() {
		if (x_MyHero == x_EnemyPaladin1 && y_MyHero == y_EnemyPaladin1) {
			if (countLives == 3) {
				clip2.play();
				y3live = -50;
				countLives = 2;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == x_EnemyPaladin1 && y_MyHero == y_EnemyPaladin1) {
			if (countLives == 2) {
				clip2.play();
				y2live = -50;
				countLives = 1;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == x_EnemyPaladin1 && y_MyHero == y_EnemyPaladin1) {
			if (countLives == 1) {
				clip2.play();
				y1live = -50;
				clip3.play();
				x_MyHero = -50;
				countLives = 0;
			}
		}
	}

	void secondPaladin() {
		if (x_MyHero == x_EnemyPaladin2 && y_MyHero == y_EnemyPaladin2) {
			if (countLives == 3) {
				clip2.play();
				y3live = -50;
				countLives = 2;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == x_EnemyPaladin2 && y_MyHero == y_EnemyPaladin2) {
			if (countLives == 2) {
				clip2.play();
				y2live = -50;
				countLives = 1;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == x_EnemyPaladin2 && y_MyHero == y_EnemyPaladin2) {
			if (countLives == 1) {
				clip2.play();
				y1live = -50;
				clip3.play();
				x_MyHero = -50;
			}
		}
	}

	void wraith() {
		if (x_MyHero == xWraith && y_MyHero == yWraith) {
			if (countLives == 3) {
				clip2.play();
				y3live = -50;
				countLives = 2;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == xWraith && y_MyHero == yWraith) {
			if (countLives == 2) {
				clip2.play();
				y2live = -50;
				countLives = 1;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == xWraith && y_MyHero == yWraith) {
			if (countLives == 1) {
				clip2.play();
				y1live = -50;
				clip3.play();
				x_MyHero = -50;
			}
		}
	}

	void seconddPaladin() {

		if (x_MyHero == x_EnemyPaladin2 && y_MyHero == y_EnemyPaladin2) {
			if (countLives == 3) {
				clip2.play();
				y3live = -50;
				countLives = 2;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == x_EnemyPaladin2 && y_MyHero == y_EnemyPaladin2) {
			if (countLives == 2) {
				clip2.play();
				y2live = -50;
				countLives = 1;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == x_EnemyPaladin2 && y_MyHero == y_EnemyPaladin2) {
			if (countLives == 1) {
				clip2.play();
				y1live = -50;
				clip3.play();
				x_MyHero = -50;
			}
		}
	}

	

	void Shadow() {
		if (x_MyHero == xShadow && y_MyHero == yShadow) {
			if (countLives == 3) {
				clip2.play();
				y3live = -50;
				countLives = 2;
				y_MyHero = y_MyHero - 10;
			}
		}
		if (x_MyHero == xShadow && y_MyHero == yShadow) {
			if (countLives == 2) {
				clip2.play();
				y2live = -50;
				countLives = 1;
				y_MyHero = y_MyHero - 10;
			}
		}
		if (x_MyHero == xShadow && y_MyHero == yShadow) {
			if (countLives == 1) {
				clip2.play();
				y1live = -50;
				clip3.play();
				y_MyHero = -50;
			}
		}
	}

	void PoisonBullet() {
		if (x_MyHero == xPoison && y_MyHero == yPoison) {
			if (countLives == 3) {
				clip2.play();
				y3live = -50;
				countLives = 2;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == xPoison && y_MyHero == yPoison) {
			if (countLives == 2) {
				clip2.play();
				y2live = -50;
				countLives = 1;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == xPoison && y_MyHero == yPoison) {
			if (countLives == 1) {
				clip2.play();
				y1live = -50;
				clip3.play();
				y_MyHero = -50;
			}
		}
	}
	@SuppressWarnings("deprecation")
	void Vlog() {
		if (x_MyHero == xVlog && y_MyHero == yVlog) {
			if (countLives == 3) {
				clip2.play();
				y3live = -50;
				countLives = 2;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == xVlog && y_MyHero == yVlog) {
			if (countLives == 2) {
				clip2.play();
				y2live = -50;
				countLives = 1;
				x_MyHero = x_MyHero - 10;
			}
		}
		if (x_MyHero == xVlog && y_MyHero == yVlog) {
			if (countLives == 1) {
				clip2.play();
				y1live = -50;
				clip3.play();
				y_MyHero = -50;
			}
		}
	}

	void FlyEnemy() {
		if (x_MyHero == x_FlyEnemy && y_MyHero == y_FlyEnemy) {
			if (countLives == 3) {
				clip2.play();
				y3live = -50;
				countLives = 2;
				x_MyHero = x_MyHero + 10;
			}
		}
		if (x_MyHero == x_FlyEnemy && y_MyHero == y_FlyEnemy) {
			if (countLives == 2) {
				clip2.play();
				y2live = -50;
				countLives = 1;
				x_MyHero = x_MyHero + 10;			}
		}
		if (x_MyHero == x_FlyEnemy && y_MyHero == y_FlyEnemy) {
			if (countLives == 1) {
				clip2.play();
				y1live = -50;
				clip3.play();
				y_MyHero = -50;
			}
		}
	}
	
	class Vzriv1Item implements Runnable {

		@Override
		public void run() {

			if (countVzriv1Item == 0) {
				xOskolki1Item = 50;

				try {
					clip5.play();
					Thread.sleep(400);
				} catch (Exception e) {
					e.printStackTrace();
				}
				xOskolki1Item = -50;
				countVzriv1Item = 1;
			}
		}

	}

	class Vzriv2Item implements Runnable {

		@Override
		public void run() {

			if (countVzriv2Item == 0) {
				xOskolki2Item = 700;

				try {
					clip5.play();
					Thread.sleep(400);
				} catch (Exception e) {
					e.printStackTrace();
				}
				xOskolki2Item = -50;
				countVzriv2Item = 1;
			}
		}

	}

	class Vzriv3Item implements Runnable {

		@Override
		public void run() {

			if (countVzriv3Item == 0) {
				xOskolki3Item = 500;

				try {
					clip5.play();
					Thread.sleep(400);
				} catch (Exception e) {
					e.printStackTrace();
				}
				xOskolki3Item = -50;
				countVzriv3Item = 1;
			}
		}

	}

	class lastButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			lastFrame.setVisible(false);
		}

	}
}
