import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class fdemo extends JFrame
 {
	JPdemo jp;
	fdemo()
	{
		jp = new JPdemo();
		add(jp);
	}
 }
//..........................................
class JPdemo extends JPanel implements ActionListener,KeyListener
 {
	int x[] = new int [100];
	int y[] = new int[100];
	int dots = 5;
	boolean start_game = false;
	boolean left = false , right=true,up=false,down = false;
	int r1=0,r2=0;
	JButton b1;
	JLabel s,s1;
	Timer t;
	Font f;
	
	int score = 0;
	JPdemo()
	{
		f= new Font("",Font.BOLD,30);
		
		x[0] = 120;
		y[0] = 100;
		x[1] = 100;
		y[1] = 100;
		x[2] = 80;
		y[2] = 100;
		x[3] = 60;
		y[3] = 100;
		x[4] = 40;
		y[4] = 100;
		
		setBackground(Color.gray);
		
		 t= new Timer(120,this);
		t.start();
		
		addKeyListener(this);
		setFocusable(true);
		randomdemo();
		
	}
	void randomdemo()
	{
		r1 = (int)Math.round(Math.random()*25+1);
		r1 = r1*20;
		
		r2 = (int)Math.round(Math.random()*25+1);
		r2 = r2*20;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
// Rectangle.................................		
		g.setColor(Color.blue);
		g.fillRect(785,3,777,560);
		
//Food.......................................
		g.setColor(Color.red);
		g.fillOval(r1,r2,20,20);
	
//Head and Body..............................	
		for(int i=0;i<dots;i++)
		{
			if(i==0)
			{
				g.setColor(Color.black);
				g.fillOval(x[i],y[i],20,20);
			}
			else
			{	
				g.setColor(Color.yellow);
				g.fillOval(x[i],y[i],20,20);
			}
		}
		
//SCORE BOARD...................    
	g.setColor(Color.cyan);
	g.setFont(f);	
	g.drawString("Score Board  ",800,40);
	g.drawString("Score   "+score,820,80);

//GAME OVER.....................	
	if(x[0]==0||x[0]==760||y[0]==0||y[0]==540)
	{
		start_game=false;
		JLabel l1 = new JLabel("Game Over");
		l1.setSize(200,100);
		l1.setLocation(330,250);
        l1.setFont(f);
		add(l1);
		b1 = new JButton("Restart");
		b1.setSize(100,50);
		b1.setLocation(360,320);
		add(b1);
		b1.addActionListener(this);
	g.setColor(Color.red);
	g.drawRect(3,3,777,555);
		
	}
 }
 public void actionPerformed(ActionEvent e)
 {
	 if(e.getSource()==b1)
	{
		start_game=true;
		dots=5;
		JLabel l1=new JLabel("  ");
		add(l1);
	}
		
	if(x[0]==r1 && y[0]==r2)
	{
		dots++;
		score++;
		randomdemo();
	}
	if(start_game)
	{
		for(int i=dots;i>0;i--)
		{
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		if(right)
		{
			x[0] = x[0] +20;
		}
		if(left)
		{
			x[0] = x[0] -20;
		}
		if(up)
		{
			y[0] = y[0] -20;
		}
		if(down)
		{
			y[0] = y[0] +20;
		}
	}
	repaint();
 }
public void keyReleased(KeyEvent e)
{}
public void keyPressed(KeyEvent e)
 {
	start_game = true;
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{
		left = true;
		right=false;
		up=false;
		down=false;
	}
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	{
		left = false;
		right=true;
		up=false;
		down=false;
	}
	if(e.getKeyCode()==KeyEvent.VK_UP)
	{
		left = false;
		right=false;
		up=true;
		down=false;
	}
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	{
		left = false;
		right=false;
		up=false;
		down=true;
	}
	 
	if(x[0]==0||x[0]==760||y[0]==0||y[0]==540)
	{
		start_game=false;
	}
 }
public void keyTyped(KeyEvent e){}
 }
class snake_game 
 {
	public static void main(String ar[])
	{
		fdemo f = new fdemo ();
		f.setVisible(true);
		f.setSize(1000,600);
		f.setLocation(200,50);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setResizable(false);
	}
 }
 