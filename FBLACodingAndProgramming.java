/*Chat Tea
Poke Delight
EastBrew Cafe and Bakery
JINYA Ramen Bar
Starbucks
Panera Bread
Tacos Del Rio
McDonald’s
Yoshiharu Ramen
Golden Chopsticks
ZIP Sushi
Pinkberry
ChickFilA
Miguel’s Jr.
Taco Bell
InNOut Burger
Target
Vons
TJ Max
ROSS
Q
Dick’s Sporting Goods
Gemma's Jewelers
Kohl’s
Tillys
Famous Footwear
Home Goods
99 Cents Only Stores
Eatsvale
EEKVALE
Eastvale Lunar Festival
Miracle On Citrus St.
Picnic In The Park2
9/11 Memorial
Massage Envy Spa Eastvale
The Joint Chiropractic
Mes Amies Nail & Beauty Spa
The Pretty Kitty
Great Clips
Supercuts
LUXE 9 Nail & Spa
Revol Nail Spa
Harada Heritage Park
Cedar Creek Park
River Walk Park
Orchard Park
American Heroes Park
SilverLakes
Edwards Eastvale Gateway Stadium 14
Half Moon Park
McCune Family Park
*/



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import java.awt.Checkbox;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

public class FBLACodingAndProgramming extends JFrame {

	//launching the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FBLACodingAndProgramming frame = new FBLACodingAndProgramming();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//creates identifiers to store which attraction is selected
	String restaurantselected = "";
	String entertainmentselected = "";
	String eventsselected = "";
	String personalserviceselected = "";
	String shoppingselected ="";
	String getValue="";
	
	//creates identifiers to store which attraction is selected for YELP link
	String shop = "";
	String ryelp = "";
	String pyelp = "";
	
	//connects database to application
	static final String DB_URL = "jdbc:mysql://localhost/login";
	static final String USER = "root";
	static final String PASS = "18187720";
	protected static final String String = null;
	private JTextField textinput;
	
	public static int count = 0;
		
	public FBLACodingAndProgramming() {
		
		//creates the application panel as a whole
		JPanel contentPane;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new LineBorder(new Color(65, 105, 225)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		//creates X button to leave application
		JLabel lblX = new JLabel("X");
		lblX.setBackground(Color.BLACK);
		lblX.setBounds(570, 0, 30, 30);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblX);
		//when user clicks on the X button they can choose to leave application
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
				{
					FBLACodingAndProgramming.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
							lblX.setForeground(Color.WHITE);
			}
		});
		
		JPanel lightbluetop_1 = new JPanel();
		lightbluetop_1.setBackground(new Color(176, 196, 222));
		lightbluetop_1.setBounds(0, 0, 600, 34);
		contentPane.add(lightbluetop_1);
		lightbluetop_1.setLayout(null);
		
		//creates icon for the help button
		ImageIcon h = new ImageIcon("help.png");
		
		//creates panel where the 5 options are
		JPanel choosing = new JPanel();
		choosing.setBackground(new Color(100, 149, 237));
		choosing.setBounds(10, 0, 600, 400);
		contentPane.add(choosing);
		choosing.setForeground(new Color(0, 0, 0));
		choosing.setLayout(null);
		choosing.setVisible(false);
		JLabel helpbutton = new JLabel("");
		helpbutton.setHorizontalAlignment(SwingConstants.CENTER);
		helpbutton.setIcon(h);
		
		//creates the light blue top portion of application
		JPanel lightbluetop = new JPanel();
		lightbluetop.setBounds(0, 0, 600, 34);
		choosing.add(lightbluetop);
		lightbluetop.setBackground(new Color(176, 196, 222));
		helpbutton.setBounds(45, 344, 55, 56);
		choosing.add(helpbutton);
			
			//creates events button
			JButton events = new JButton("Events");
			events.setBounds(221, 191, 143, 44);
			choosing.add(events);
			
			//creates shopping button
			JButton shopping = new JButton("Shopping");
			shopping.setBounds(221, 135, 143, 44);
			choosing.add(shopping);
			
			//creates restaurants button
			JButton restaurants = new JButton("Restaurants");
			restaurants.setBackground(new Color(0, 0, 205));
			restaurants.setBounds(221, 75, 143, 44);
			choosing.add(restaurants);
			
			JButton personalservices = new JButton("Personal Services");
			personalservices.setBounds(221, 249, 143, 45);
			choosing.add(personalservices);
		
		JPanel help = new JPanel();
		help.setBackground(new Color(100, 149, 237));
		help.setBounds(0, 0, 600, 400);
		contentPane.add(help);
		help.setLayout(null);
		help.setVisible(false);
		
		//when user clicks help button they will be taken to forum
		helpbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				help.setVisible(true);
				choosing.setVisible(false);
				lightbluetop.setVisible(true);
			}
		});
		
		textinput = new JTextField();
		textinput.setBounds(68, 336, 415, 46);
		help.add(textinput);
		textinput.setColumns(10);
		
		JLabel computer = new JLabel("Hi! What can I help you with?");
		computer.setBounds(60, 71, 292, 33);
		help.add(computer);
		
		JLabel user = new JLabel("");
		user.setHorizontalAlignment(SwingConstants.RIGHT);
		user.setBounds(237, 104, 292, 33);
		help.add(user);
		
		JLabel computer1 = new JLabel("");
		computer1.setHorizontalAlignment(SwingConstants.LEFT);
		computer1.setBounds(60, 144, 292, 33);
		help.add(computer1);
		
		JLabel user1 = new JLabel("");
		user1.setHorizontalAlignment(SwingConstants.RIGHT);
		user1.setBounds(237, 189, 292, 33);
		help.add(user1);
		
		JLabel computer2 = new JLabel("");
		computer2.setHorizontalAlignment(SwingConstants.LEFT);
		computer2.setBounds(60, 234, 292, 33);
		help.add(computer2);
		
		JLabel user2 = new JLabel("");
		user2.setHorizontalAlignment(SwingConstants.RIGHT);
		user2.setBounds(237, 268, 292, 33);
		help.add(user2);
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean flag=false;
				count++;
				getValue = textinput.getText();
				if (count==1)
				{
					user.setText(getValue);
				}
				else if (count==2)
				{
					user1.setText(getValue);
				}
				else if (count==3)
				{
					user2.setText(getValue);
				}
				else
				{
					String a = user1.getText();
					String b = user2.getText();
					user.setText(a);
					user1.setText(b);
					user2.setText(getValue);
				}
				try {
					String data = "jdbc:mysql://localhost/qanda";
		            Connection conn = DriverManager.getConnection(data, "root", "18187720");
		            Statement st = conn.createStatement();
		            ResultSet rec = st.executeQuery("SELECT question, answer FROM q");
			        while (rec.next()) {
			            String x = textinput.getText();
			            if (x.equals(rec.getString("question"))) 
			            {
			            	if (count==1)
							{
								computer1.setText(rec.getString("answer"));
							}
							else if (count==2)
							{
								computer2.setText(rec.getString("answer"));
							}
							else
							{
								String a = computer1.getText();
								String b = computer2.getText();
								computer.setText(a);
								computer1.setText(b);
								computer2.setText(rec.getString("answer"));
							}
			            	flag=true;
			            }
			        }
		        st.close();
				}
		        catch(SQLException d) {
		            System.out.println(d.toString());
		        }
				if (flag==false)
				{
					String ss = textinput.getText();
					Wrapper conn = null;
					try 
					{
						String IQuery = "INSERT INTO `qanda`.`q`(`question`) VALUES('"+ss+"')";
						conn = DriverManager.getConnection(DB_URL, USER, PASS);
						((Connection)conn).createStatement().execute(IQuery);
	                	((java.sql.Connection)conn).close();			
					}
					catch (SQLException se) 
					{
						se.printStackTrace();
					}
					catch (Exception a) 
					{
						a.printStackTrace();
					}
					if (count==1)
					{
						computer1.setText("Sorry, we don't have an answer right now!");
					}
					else if (count==2)
					{
						computer2.setText("Sorry, we don't have an answer right now!");
					}
					else
					{
						String a = computer1.getText();
						String b = computer2.getText();
						computer.setText(a);
						computer1.setText(b);
						computer2.setText("Sorry, we don't have an answer right now!");
					}
				}
			}
		});
		btnNewButton.setBounds(489, 341, 105, 39);
		help.add(btnNewButton);
		
		JButton questionback = new JButton("←");
		questionback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choosing.setVisible(true);
				help.setVisible(false);
			}
		});
		questionback.setBounds(6, 341, 55, 39);
		help.add(questionback);
		
		//ButtonGroups - allows user to only choose one radio button at a time
		ButtonGroup cuisinegroup = new ButtonGroup();
		ButtonGroup group = new ButtonGroup();
		ButtonGroup goodssold = new ButtonGroup();
		ButtonGroup shoppingprice = new ButtonGroup();
		ButtonGroup seasons = new ButtonGroup();
		ButtonGroup activities = new ButtonGroup();
		ButtonGroup eventprice= new ButtonGroup();
		ButtonGroup restuarantprice = new ButtonGroup();
		ButtonGroup personalserviceprice = new ButtonGroup();
		ButtonGroup service = new ButtonGroup();
		ButtonGroup entertainmentserviceprice = new ButtonGroup();
		ButtonGroup trail = new ButtonGroup();
		ButtonGroup appoint = new ButtonGroup();
		ButtonGroup analyze = new ButtonGroup();
		
		//creates login info
		JTextField txtUsername;
		JTextField txtPassword;
		JLabel lblLoginMessage = new JLabel("");
		
		// creates username panel
		JPanel username = new JPanel();
		username.setBounds(168, 110, 283, 37);
		username.setBackground(new Color(255, 255, 255));
		contentPane.add(username);
		username.setLayout(null);
		
		// creates username textbox
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setText("Username");
		txtUsername.setBounds(6, 6, 239, 26);
		username.add(txtUsername);
		txtUsername.setColumns(10);
		
		// creates password panel
		JPanel password = new JPanel();
		password.setBounds(168, 174, 283, 37);
		password.setBackground(new Color(255, 255, 255));
		contentPane.add(password);
		password.setLayout(null);
		
		//creates password textbox
		txtPassword = new JTextField();
		txtPassword.setBorder(null);
		txtPassword.setText("Password");
		txtPassword.setBounds(6, 6, 239, 26);
		password.add(txtPassword);
		txtPassword.setColumns(10);
		
		//creates signup panel
		JPanel signup = new JPanel();
		signup.setBounds(168, 340, 279, 50);
		signup.setBackground(new Color(25, 25, 112));
		contentPane.add(signup);
		signup.setLayout(null);
		
		//put username/password into the database
		signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Wrapper conn = null;
				try 
				{
					String username = "";
					String password = "";
					username = txtUsername.getText();
					password = txtPassword.getText();
					if (username.equals("")|| password.equals(""))
					{
						lblLoginMessage.setText("Invalid Information");
					}
					else 
                	{
						String IQuery = "INSERT INTO `login`.`account`(`username`,`password`) VALUES('"+username+"', '"+password+"')";
						lblLoginMessage.setText("Signed up!");
						conn = DriverManager.getConnection(DB_URL, USER, PASS);
						((Connection)conn).createStatement().execute(IQuery);
                		((java.sql.Connection)conn).close();
                	}				
				}
				catch (SQLException se) 
				{
					se.printStackTrace();
				}
				catch (Exception a) 
				{
					a.printStackTrace();
				}
			}
		});
		
		// creates signup label
		JLabel lblSignup = new JLabel("SIGN UP");
		lblSignup.setBounds(114, 10, 60, 39);
		lblSignup.setForeground(new Color(255, 255, 255));
		signup.add(lblSignup);
		
		//creates login panel
		JPanel login = new JPanel();
		login.setBounds(168, 275, 279, 50);
		login.setBackground(new Color(25, 25, 112));
		contentPane.add(login);
		login.setLayout(null);
		
		//checks if username/password inputted matches with anything in the database
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String data = "jdbc:mysql://localhost/login";
		            Connection conn = DriverManager.getConnection(data, "root", "18187720");
		            Statement st = conn.createStatement();
		            ResultSet rec = st.executeQuery("SELECT username, password FROM account");
			        while (rec.next()) {
			            String x = txtUsername.getText();
			            String y = txtPassword.getText();
			            if (x.equals(rec.getString("username"))) {
			                if (y.equals(rec.getString("password"))) {
			                	login.setVisible(false);
								username.setVisible(false);
								password.setVisible(false);
								signup.setVisible(false);
								lblLoginMessage.setVisible(false);
								choosing.setVisible(true);
			                } 
			            } else {
			            	lblLoginMessage.setText("Invalid Information");
			            }
			        }
		        st.close();
				}
		        catch(SQLException d) {
		            System.out.println(d.toString());
		        } 
				}
			}
		);
		
		//creates login title
		JLabel lblLogin = new JLabel("LOG IN");
		lblLogin.setBounds(114, 6, 50, 39);
		lblLogin.setForeground(new Color(255, 255, 255));
		login.add(lblLogin);
		lblLoginMessage.setBounds(168, 234, 283, 29);
		contentPane.add(lblLoginMessage);
		
		// get images used for shopping panel
		ImageIcon famous = new ImageIcon("famous.jpeg");
		ImageIcon sporting = new ImageIcon("sporting.jpeg");
		ImageIcon tj = new ImageIcon("tj.png");
		ImageIcon ross = new ImageIcon("ross.jpeg");
		ImageIcon q = new ImageIcon("q.jpeg");
		ImageIcon kohl = new ImageIcon("kohl.jpeg");
		ImageIcon target = new ImageIcon("target.jpeg");
		ImageIcon gemma = new ImageIcon("gemma.jpeg");
		ImageIcon homegood = new ImageIcon("homegood.jpeg");
		ImageIcon ninety = new ImageIcon("ninety.jpeg");
		ImageIcon vons = new ImageIcon("vons.jpeg");
		ImageIcon tilly = new ImageIcon("tilly.jpeg");
		
		//creates personal services panel
		JPanel personalservicespanel = new JPanel();
		personalservicespanel.setBackground(new Color(100, 149, 237));
		personalservicespanel.setVisible(false);
		

		personalservices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choosing.setVisible(false);
				personalservicespanel.setVisible(true);
				lightbluetop.setVisible(false);
				lightbluetop_1.setVisible(false);
			}
		});
		
		//goes back to main page
		choosing.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				choosing.setVisible(true);
				personalservicespanel.setVisible(false);
				lightbluetop.setVisible(true);
			}
		});
		
		//creates shopping panel
		JPanel shoppingpanel = new JPanel();
		shoppingpanel.setVisible(false);
		shoppingpanel.setBackground(new Color(100, 149, 237));
		shoppingpanel.setBounds(0, 0, 600, 400);
		contentPane.add(shoppingpanel);
		shoppingpanel.setLayout(null);
		
		shopping.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choosing.setVisible(false);
				shoppingpanel.setVisible(true);
				lightbluetop_1.setVisible(false);
			}
		});
		
		//creates dark blue portion on left hand side
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(0, 0, 128));
		panel1.setBounds(0, 0, 258, 400);
		shoppingpanel.add(panel1);
		panel1.setLayout(null);
		
		//below are the creation of labels
		JLabel Price_1 = new JLabel("Price");
		Price_1.setBounds(11, 19, 30, 16);
		Price_1.setForeground(Color.WHITE);
		Price_1.setFont(new Font("Arial", Font.PLAIN, 13));
		Price_1.setBackground(Color.WHITE);
		panel1.add(Price_1);
		
		JLabel GoodsSold = new JLabel("Goods Sold");
		GoodsSold.setBounds(11, 121, 92, 16);
		panel1.add(GoodsSold);
		GoodsSold.setForeground(Color.WHITE);
		GoodsSold.setFont(new Font("Arial", Font.PLAIN, 13));
		GoodsSold.setBackground(Color.WHITE);
		
		JLabel PickupOptions = new JLabel("Pickup Options");
		PickupOptions.setForeground(Color.WHITE);
		PickupOptions.setFont(new Font("Arial", Font.PLAIN, 13));
		PickupOptions.setBackground(Color.WHITE);
		PickupOptions.setBounds(11, 271, 92, 16);
		panel1.add(PickupOptions);
		
		JLabel Payment1 = new JLabel("Payment");
		Payment1.setForeground(Color.WHITE);
		Payment1.setFont(new Font("Arial", Font.PLAIN, 13));
		Payment1.setBackground(Color.WHITE);
		Payment1.setBounds(129, 19, 70, 16);
		panel1.add(Payment1);
		
		//below are the creations of the buttons
		JRadioButton Clothing = new JRadioButton("Clothing");
		Clothing.setActionCommand("Clothing");
		Clothing.setForeground(new Color(255, 255, 255));
		Clothing.setBounds(6, 141, 95, 23);
		panel1.add(Clothing);
		
		JRadioButton Footwear = new JRadioButton("Footwear");
		Footwear.setForeground(Color.WHITE);
		Footwear.setBounds(6, 164, 95, 23);
		panel1.add(Footwear);
		
		JRadioButton Decor = new JRadioButton("Decor");
		Decor.setForeground(Color.WHITE);
		Decor.setBounds(6, 188, 95, 23);
		panel1.add(Decor);
		
		JRadioButton FoodProducts = new JRadioButton("Food Products");
		FoodProducts.setForeground(Color.WHITE);
		FoodProducts.setBounds(6, 212, 122, 23);
		panel1.add(FoodProducts);
		
		JRadioButton Jewelry = new JRadioButton("Jewelry");
		Jewelry.setForeground(Color.WHITE);
		Jewelry.setBounds(6, 236, 95, 23);
		panel1.add(Jewelry);
		
		JRadioButton onedollarsign_2_1 = new JRadioButton("$");
		onedollarsign_2_1.setForeground(Color.WHITE);
		onedollarsign_2_1.setBounds(6, 38, 81, 23);
		panel1.add(onedollarsign_2_1);
		
		JRadioButton twodollar_1 = new JRadioButton("$$");
		twodollar_1.setForeground(Color.WHITE);
		twodollar_1.setBounds(6, 62, 81, 23);
		panel1.add(twodollar_1);
		
		JRadioButton threedollarsign_2_1 = new JRadioButton("$$$");
		threedollarsign_2_1.setForeground(Color.WHITE);
		threedollarsign_2_1.setBounds(6, 85, 76, 23);
		panel1.add(threedollarsign_2_1);
		
		//groups buttons so user can only choose one
		goodssold.add(Clothing);
		goodssold.add(Footwear);
		goodssold.add(Decor);
		goodssold.add(FoodProducts);
		goodssold.add(Jewelry);
		
		shoppingprice.add(onedollarsign_2_1);
		shoppingprice.add(twodollar_1);
		shoppingprice.add(threedollarsign_2_1);
		
		//below are the creation of checkboxes
		JCheckBox walkin = new JCheckBox("Walk In");
		walkin.setForeground(Color.WHITE);
		walkin.setFont(new Font("Arial", Font.PLAIN, 13));
		walkin.setBackground(Color.WHITE);
		walkin.setBounds(6, 291, 76, 23);
		panel1.add(walkin);
		
		JCheckBox Curbside = new JCheckBox("Curbside");
		Curbside.setForeground(Color.WHITE);
		Curbside.setFont(new Font("Arial", Font.PLAIN, 13));
		Curbside.setBackground(Color.WHITE);
		Curbside.setBounds(6, 315, 95, 23);
		panel1.add(Curbside);
		
		JCheckBox ApplePayment = new JCheckBox("Apple Payment");
		ApplePayment.setForeground(Color.WHITE);
		ApplePayment.setFont(new Font("Arial", Font.PLAIN, 13));
		ApplePayment.setBackground(Color.WHITE);
		ApplePayment.setBounds(123, 38, 122, 23);
		panel1.add(ApplePayment);
		
		JCheckBox GooglePayment = new JCheckBox("Google Payment");
		GooglePayment.setForeground(Color.WHITE);
		GooglePayment.setFont(new Font("Arial", Font.PLAIN, 13));
		GooglePayment.setBackground(Color.WHITE);
		GooglePayment.setBounds(123, 62, 129, 23);
		panel1.add(GooglePayment);
		
		JCheckBox creditdebit1 = new JCheckBox("Credit/Debit");
		creditdebit1.setForeground(Color.WHITE);
		creditdebit1.setFont(new Font("Arial", Font.PLAIN, 13));
		creditdebit1.setBackground(Color.WHITE);
		creditdebit1.setBounds(123, 84, 106, 23);
		panel1.add(creditdebit1);
		
		JCheckBox cash1 = new JCheckBox("Cash");
		cash1.setForeground(Color.WHITE);
		cash1.setFont(new Font("Arial", Font.PLAIN, 13));
		cash1.setBackground(Color.WHITE);
		cash1.setBounds(123, 105, 106, 23);
		panel1.add(cash1);
		
		// "enter" button for shopping
		JButton shoppinggo = new JButton("→");
		shoppinggo.setBounds(144, 350, 92, 44);
		panel1.add(shoppinggo);
		shoppinggo.setForeground(new Color(0, 0, 128));
		shoppinggo.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		shoppinggo.setBackground(new Color(0, 0, 128));
		
		// creates button for going back
		JButton shoppinggo_1 = new JButton("←");
		shoppinggo_1.setActionCommand("");
		shoppinggo_1.setForeground(new Color(0, 0, 128));
		shoppinggo_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		shoppinggo_1.setBackground(new Color(0, 0, 128));
		shoppinggo_1.setBounds(27, 350, 92, 44);
		panel1.add(shoppinggo_1);
		
		//returns user to the option choices pages when clicked
		shoppinggo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shoppingpanel.setVisible(false);
				choosing.setVisible(true);
				lightbluetop.setVisible(true);
			}
		});
		
		//creation of label for shopping image
		JLabel shoppingprint = new JLabel("");
		shoppingprint.setHorizontalAlignment(SwingConstants.CENTER);
		shoppingprint.setFont(new Font("Arial", Font.PLAIN, 20));
		shoppingprint.setBounds(276, 308, 300, 36);
		shoppingpanel.add(shoppingprint);
		
		//creation of label for shopping image source
		JLabel shoppingsource = new JLabel("");
		shoppingsource.setHorizontalAlignment(SwingConstants.CENTER);
		shoppingsource.setForeground(Color.WHITE);
		shoppingsource.setBounds(285, 238, 280, 16);
		shoppingpanel.add(shoppingsource);
		
		// prints out where we got the picture from
		JLabel shoppingpic = new JLabel("");
		shoppingpic.setBounds(270, 31, 314, 248);
		shoppingpanel.add(shoppingpic);
		shoppingpic.setHorizontalAlignment(SwingConstants.CENTER);
		shoppingpic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (shoppingselected!="")
				{
					shoppingsource.setText("Picture By "+ shoppingselected);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				shoppingsource.setText("");
			}
		});
		
		//picks a shopping place
		shoppinggo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				shop="";
				shoppingpic.setVisible(true);
				if (Footwear.isSelected())
				{
					shop = "Famous Footwear";
					shoppingprint.setText("Famous Footwear");
					shoppingpic.setIcon(famous);
					shoppingselected = "Mapsus.net";
				}
				else if (Clothing.isSelected())
				{
					String[] clothes = {"Dick's Sporting Goods", "Kohl's"};
					String[] one = {"TJ Max", "Ross", "Q"};
					if (threedollarsign_2_1.isSelected())
					{
						shoppingprint.setText("None");
						shoppingpic.setVisible(false);
						shoppingselected = "";

					}
					else if (twodollar_1.isSelected())
					{
						if (Curbside.isSelected() || GooglePayment.isSelected() || ApplePayment.isSelected())
						{
							String c = clothes[(int)Math.floor(Math.random()*(1-0+1)+0)];
							shoppingprint.setText(c);
							shop = c;
							if (c.equals("Dick's Sporting Goods"))
							{
								shoppingpic.setIcon(sporting);
								shoppingselected = "City of Eastvale";
							}
							else
							{
								shoppingpic.setIcon(kohl);
								shoppingselected = "Foursquare";
							}
						}
						else
						{
							shop = "Tillys";
							shoppingprint.setText("Tillys");
							shoppingpic.setIcon(tilly);
							shoppingselected = "Tillys";
						}
					}
					else if (onedollarsign_2_1.isSelected())
					{
						if (Curbside.isSelected())
						{
							shop = "Target";
							shoppingprint.setText("Target");
							shoppingpic.setIcon(target);
							shoppingselected = "Lewis Retail Centers";
						}
						else if (GooglePayment.isSelected() || ApplePayment.isSelected())
						{
							String o = one[(int)Math.floor(Math.random()*(2-0+1)+0)];
							shoppingprint.setText(o);
							shop = o;
							if (o.equals("TJ Max"))
							{
								shoppingpic.setIcon(tj);
								shoppingselected = "24/7 Headline News";
							}
							else if (o.equals("Ross"))
							{
								shoppingpic.setIcon(ross);
								shoppingselected = "Merlone Geier Partners";
							}
							else
							{
								shoppingpic.setIcon(q);
								shoppingselected = "Fashion Q";
							}
						}
						else
						{
							shop = "Target";
							shoppingprint.setText("Target");
							shoppingpic.setIcon(target);
							shoppingselected = "Lewis Retail Centers";
						}
					}
					else
					{
						shoppingprint.setText("Choose a price!");
						shoppingpic.setVisible(false);
						shoppingselected = "";
					}
				}
				else if (Jewelry.isSelected())
				{
					shop = "Gemmas's Jewelers";
					shoppingprint.setText("Gemmas's Jewelers");
					shoppingpic.setIcon(gemma);
					shoppingselected = "Gemma's Jewelers";
				}
				else if (Decor.isSelected())
				{
					shop = "HomeGoods";
					shoppingprint.setText("HomeGoods");
					shoppingpic.setIcon(homegood);
					shoppingselected = "HomeGoods";
				}
				else if (FoodProducts.isSelected())
				{
					if (GooglePayment.isSelected()==true || Curbside.isSelected()==true)
					{
						shop = "Target";
						shoppingprint.setText("Target");
						shoppingpic.setIcon(target);
						shoppingselected = "Lewis Retail Centers";
					}
					else if (onedollarsign_2_1.isSelected())
					{
						shop = "99 Cents Store";
						shoppingprint.setText("99 Cents Store");
						shoppingpic.setIcon(ninety);
						shoppingselected = "99 Cents Store";
					}
					else
					{
						shop = "Vons";
						shoppingprint.setText("Vons");
						shoppingpic.setIcon(vons);
						shoppingselected = "";
					}
				}
				else
				{
					shoppingprint.setText("Choose a good's sold");
					shoppingpic.setVisible(false);
				}
			}
		});	
		
		//when YELP button is clicked user is taken to the YELP review
		JButton shoppingyelp = new JButton("YELP Reviews");
		shoppingyelp.setBounds(300, 354, 248, 40);
		shoppingpanel.add(shoppingyelp);
		shoppingyelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (shop.equals("Famous Footwear"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/famous-footwear-mira-loma").toURI());
					}
					catch (Exception e1)
					{}
				}
				else if (shop.equals("Dick's Sporting Goods"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/dicks-sporting-goods-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("Kohl's"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/kohls-mira-loma-mira-loma?osq=kohl%27s").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("TJ Max"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/tj-maxx-mira-loma?osq=tj+maxx").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("Ross"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/search?find_desc=ross+store&find_loc=Eastvale%2C+CA").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("Q"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.google.com/search?q=fashion+q+eastvale+ca&rlz=1C5CHFA_enUS909US909&oq=fashion+q&aqs=chrome.0.69i59j69i57j0i402l2j0i433i512j69i60l3.1828j0j7&sourceid=chrome&ie=UTF-8#lrd=0x80dcb58b194f9899:0x18affee4c516e36e,1,,,").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("Tillys"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/tillys-mira-loma?osq=tilly%27s").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("Target"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/target-mira-loma-2?osq=target").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("Gemmas's Jewelers"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/gemmas-jewelers-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("HomeGoods"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/homegoods-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("99 Cents Store"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/99-cents-only-stores-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (shop.equals("Vons"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/vons-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				
			}
		});
		
		//creates personal service panel
		personalservicespanel.setBounds(0, 0, 600, 400);
		contentPane.add(personalservicespanel);
		personalservicespanel.setLayout(null);
		
		//creates dark blue portion on left hand side
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 128));
		panel_3.setBounds(0, 0, 218, 400);
		personalservicespanel.add(panel_3);
		panel_3.setLayout(null);
		
		//creates labels on the personal services panel
		JLabel Price_1_1_1 = new JLabel("Price");
		Price_1_1_1.setBounds(11, 19, 30, 16);
		Price_1_1_1.setForeground(Color.WHITE);
		Price_1_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		Price_1_1_1.setBackground(Color.WHITE);
		panel_3.add(Price_1_1_1);
		
		JLabel Service = new JLabel("Service");
		Service.setForeground(Color.WHITE);
		Service.setFont(new Font("Arial", Font.PLAIN, 13));
		Service.setBackground(Color.WHITE);
		Service.setBounds(11, 118, 70, 16);
		panel_3.add(Service);
		
		JLabel Payment2 = new JLabel("Payment");
		Payment2.setForeground(Color.WHITE);
		Payment2.setFont(new Font("Arial", Font.PLAIN, 13));
		Payment2.setBackground(Color.WHITE);
		Payment2.setBounds(11, 220, 70, 16);
		panel_3.add(Payment2);
		
		JLabel Appointment = new JLabel("Appointment");
		Appointment.setForeground(Color.WHITE);
		Appointment.setFont(new Font("Arial", Font.PLAIN, 13));
		Appointment.setBackground(Color.WHITE);
		Appointment.setBounds(93, 18, 100, 16);
		panel_3.add(Appointment);
		
		//creates buttons on the personal services panel
		JRadioButton onedollar2 = new JRadioButton("$");
		onedollar2.setForeground(new Color(255, 255, 255));
		onedollar2.setBounds(6, 37, 56, 23);
		panel_3.add(onedollar2);
		
		JRadioButton twodollar2 = new JRadioButton("$$");
		twodollar2.setForeground(new Color(255, 255, 255));
		twodollar2.setBounds(6, 60, 56, 23);
		panel_3.add(twodollar2);
		
		JRadioButton threedollar2 = new JRadioButton("$$$");
		threedollar2.setForeground(new Color(255, 255, 255));
		threedollar2.setBounds(6, 83, 56, 23);
		panel_3.add(threedollar2);
	
		JRadioButton nails = new JRadioButton("Nails");
		nails.setForeground(Color.WHITE);
		nails.setBounds(6, 138, 141, 23);
		panel_3.add(nails);
		
		JRadioButton hair = new JRadioButton("Hair");
		hair.setForeground(Color.WHITE);
		hair.setBounds(6, 161, 141, 23);
		panel_3.add(hair);
		
		JRadioButton Massage = new JRadioButton("Massage");
		Massage.setForeground(Color.WHITE);
		Massage.setBounds(6, 184, 141, 23);
		panel_3.add(Massage);
		
		JRadioButton yes = new JRadioButton("Yes");
		yes.setForeground(Color.WHITE);
		yes.setBounds(91, 37, 56, 23);
		panel_3.add(yes);
		
		JRadioButton no = new JRadioButton("No");
		no.setForeground(Color.WHITE);
		no.setBounds(91, 60, 56, 23);
		panel_3.add(no);
		
		//groups buttons so user can only choose one
		personalserviceprice.add(onedollar2);
		personalserviceprice.add(twodollar2);
		personalserviceprice.add(threedollar2);
		
		appoint.add(yes);
		appoint.add(no);
		
		service.add(Massage);
		service.add(nails);
		service.add(hair);
		
		//creates checkboxes for the personal services page
		JCheckBox GooglePay1 = new JCheckBox("Google Pay");
		GooglePay1.setForeground(new Color(255, 255, 255));
		GooglePay1.setBounds(6, 240, 128, 23);
		panel_3.add(GooglePay1);
		
		JCheckBox ApplePay1 = new JCheckBox("Apple Pay");
		ApplePay1.setForeground(new Color(255, 255, 255));
		ApplePay1.setBounds(6, 264, 128, 23);
		panel_3.add(ApplePay1);
		
		JCheckBox creditdebit2 = new JCheckBox("Credit/Debit");
		creditdebit2.setForeground(new Color(255, 255, 255));
		creditdebit2.setBounds(6, 288, 128, 23);
		panel_3.add(creditdebit2);
		
		JCheckBox Cash1 = new JCheckBox("Cash");
		Cash1.setForeground(new Color(255, 255, 255));
		Cash1.setBounds(6, 313, 128, 23);
		panel_3.add(Cash1);
		
		//creates label to print out picture
		JLabel personalservicesprint = new JLabel("");
		personalservicesprint.setHorizontalAlignment(SwingConstants.CENTER);
		personalservicesprint.setFont(new Font("Arial", Font.PLAIN, 20));
		personalservicesprint.setBounds(235, 305, 345, 36);
		personalservicespanel.add(personalservicesprint);
		
		//creates label to print out picture source
		JLabel personalservicessource = new JLabel("");
		personalservicessource.setForeground(new Color(255, 255, 255));
		personalservicessource.setHorizontalAlignment(SwingConstants.CENTER);
		personalservicessource.setBounds(246, 260, 337, 16);
		personalservicespanel.add(personalservicessource);
		
		//prints out source of our picture
		JLabel personalservicespic = new JLabel("");
		personalservicespic.setHorizontalAlignment(SwingConstants.CENTER);
		personalservicespic.setBounds(230, 50, 353, 248);
		personalservicespanel.add(personalservicespic);
		personalservicespic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (personalserviceselected!="")
				{
					personalservicessource.setText("Picture By "+ personalserviceselected);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				personalservicessource.setText("");
			}
		});
		
		//returns back to main page when button is clicked
		JButton personalservicesback = new JButton("←");
		personalservicesback.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		personalservicesback.setForeground(new Color(0, 0, 128));
		personalservicesback.setBounds(23, 348, 74, 34);
		panel_3.add(personalservicesback);
		personalservicesback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choosing.setVisible(true);
				personalservicespanel.setVisible(false);
				lightbluetop.setVisible(true);
			}
		});
		
		// creates images for personal services
		ImageIcon mes = new ImageIcon("mes.jpg");
		ImageIcon revol = new ImageIcon("revol.jpeg");
		ImageIcon massage = new ImageIcon("massage.png");
		ImageIcon kitty = new ImageIcon("pretty.jpeg");
		ImageIcon joint = new ImageIcon("joint.jpeg");
		ImageIcon great = new ImageIcon("great.jpeg");
		ImageIcon supercuts = new ImageIcon("super.jpeg");
		
		// creates a button for the personal service
		JButton personalservicesgo = new JButton("→");
		personalservicesgo.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		personalservicesgo.setForeground(new Color(0, 0, 128));
		personalservicesgo.setBounds(122, 348, 70, 34);
		panel_3.add(personalservicesgo);
		
		//chooses a personal service place for user
		personalservicesgo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				personalservicespic.setVisible(true);
				pyelp = "";
				if (Massage.isSelected())
				{
					personalservicespic.setVisible(true);
					String[] massagetwodollar = {"Mes Amies Nail & Beauty Spa", "Revol Nail Spa", "Massage Envy Spa"};
					if (onedollar2.isSelected())
					{
						personalservicesprint.setText("None");
						personalservicespic.setVisible(false);
						personalserviceselected = "";
					}
					else if (twodollar2.isSelected())
					{
						String personal = massagetwodollar[(int)Math.floor(Math.random()*(2-0+1)+0)];
						personalservicesprint.setText(personal);
						if (personal.equals("Mes Amies Nail & Beauty Spa"))
						{
							personalservicespic.setIcon(mes);
							personalserviceselected = "Mes Amies Nail & Beauty Spa";
							pyelp = "Mes Amies Nail & Beauty Spa";
						}
						else if (personal.equals("Revol Nail Spa"))
						{
							personalservicespic.setIcon(revol);
							personalserviceselected = "Mapsus.net";
							pyelp = "Revol Nail Spa";
						}
						else if (personal.equals("Massage Envy Spa"))
						{
							personalservicespic.setIcon(massage);
							personalserviceselected = "Trip.com";
							pyelp = "Massage Envy Spa";
						}
					}
					else if (threedollar2.isSelected())
					{
						if (yes.isSelected())
						{
							personalservicesprint.setText("The Joint Chiropractic");
							personalservicespic.setIcon(joint);
							personalserviceselected = "The Joint Chiropractic";
							pyelp = "The Joint Chiropractic";

						}
						else 
						{
							personalservicesprint.setText("The Pretty Kitty");
							personalservicespic.setIcon(kitty);
							personalserviceselected = "Yelp";
							pyelp = "The Pretty Kitty";
						}	
					}
					else
					{
						personalservicesprint.setText("Choose a price!");
						personalservicespic.setVisible(false);
						personalserviceselected = "";
					}
				}
				else if (nails.isSelected())
				{
					if (onedollar2.isSelected() || threedollar2.isSelected())
					{
						personalservicesprint.setText("None");
						personalservicespic.setVisible(false);
						personalserviceselected = "";
					}
					else if (twodollar2.isSelected())
					{
						String[] nailstwodollar = {"Mes Amies Nail & Beauty Spa", "Revol Nail Spa"};
						String per = nailstwodollar[(int)Math.floor(Math.random()*(1-0+1)+0)];
						personalservicesprint.setText(per);
						pyelp = "per";
						if (per.equals("Mes Amies Nail & Beauty Spa"))
						{
							personalservicespic.setIcon(mes);
							personalserviceselected = "Mes Amies Nail & Beauty Spa";

						}
						else if (per.equals("Revol Nail Spa"))
						{
							personalservicespic.setIcon(revol);
							personalserviceselected = "Mapsus.net";
						}
					}
					else
					{
						personalservicesprint.setText("Choose a price!");
						personalservicespic.setVisible(false);
						personalserviceselected = "";
					}
				}
				else if (hair.isSelected())
				{
					if (onedollar2.isSelected())
					{
						if (GooglePay1.isSelected())
						{
							personalservicesprint.setText("None");
							personalservicespic.setVisible(false);
							personalserviceselected = "";
						}
						else
						{
							personalservicesprint.setText("Great Clips");
							personalservicespic.setIcon(great);
							personalserviceselected = "Great Clips Salons";
							pyelp = "Great Clips Salons";						
						}
					}
					else if (twodollar2.isSelected())
					{
						if (GooglePay1.isSelected())
						{
							personalservicesprint.setText("None");
							personalservicespic.setVisible(false);
							personalserviceselected = "";
						}
						else
						{
							personalservicesprint.setText("Supercuts");
							personalservicespic.setIcon(supercuts);
							personalserviceselected = "Mapsus.net";
							pyelp = "Supercuts";	
						}
					}
					else if (threedollar2.isSelected())
					{
						personalservicesprint.setText("None");
						personalservicespic.setVisible(false);
						personalserviceselected = "";
					}
					else
					{
						personalservicesprint.setText("Choose a price!");
						personalservicespic.setVisible(false);
						personalserviceselected = "";
					}
				}
				else
				{
					personalservicesprint.setText("Choose a service!");
					personalservicespic.setVisible(false);
					personalserviceselected = "";
				}
			}
		});
		
		//when YELP button is clicked it will take user to YELP review
		JButton personalyelp = new JButton("YELP Reviews");
		personalyelp.setBounds(290, 354, 248, 40);
		personalservicespanel.add(personalyelp);
		personalyelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (pyelp.equals("Mes Amies Nail & Beauty Spa"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/mes-amies-nails-and-beauty-spa-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				else if (pyelp.equals("Revol Nail Spa"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/revol-nail-spa-corona").toURI());
					}
					catch (Exception e1)
					{}
				}
				else if (pyelp.equals("Massage Envy Spa"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/massage-envy-eastvale-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				else if (pyelp.equals("The Joint Chiropractic"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/the-joint-chiropractic-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				else if (pyelp.equals("The Pretty Kitty"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/the-pretty-kitty-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				else if (pyelp.equals("Great Clips Salons"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/great-clips-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				else if (pyelp.equals("Supercuts"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/supercuts-corona-2?osq=supercuts").toURI());
					}
					catch (Exception e1)
					{}
				}
			}
		});
		
		//creates event panel
		JPanel eventspanel_1 = new JPanel();
		eventspanel_1.setVisible(false);
		eventspanel_1.setBackground(new Color(100, 149, 237));
		eventspanel_1.setBounds(0, 0, 600, 400);
		contentPane.add(eventspanel_1);
		eventspanel_1.setLayout(null);
		
		events.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				choosing.setVisible(false);
				eventspanel_1.setVisible(true);
				lightbluetop.setVisible(false);
				lightbluetop_1.setVisible(false);
			}
		});
		
		// set the left side to dark blue
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 128));
		panel_2.setBounds(0, 0, 256, 400);
		eventspanel_1.add(panel_2);
		panel_2.setLayout(null);
		
		//creates labels for event panel
		JLabel Price_1_1 = new JLabel("Price");
		Price_1_1.setBounds(11, 19, 30, 16);
		Price_1_1.setForeground(Color.WHITE);
		Price_1_1.setFont(new Font("Arial", Font.PLAIN, 13));
		Price_1_1.setBackground(Color.WHITE);
		panel_2.add(Price_1_1);
		
		JLabel Season = new JLabel("Season");
		Season.setForeground(Color.WHITE);
		Season.setFont(new Font("Arial", Font.PLAIN, 13));
		Season.setBackground(Color.WHITE);
		Season.setBounds(11, 119, 68, 16);
		panel_2.add(Season);
		
		JLabel Activities = new JLabel("Activities");
		Activities.setForeground(Color.WHITE);
		Activities.setFont(new Font("Arial", Font.PLAIN, 13));
		Activities.setBackground(Color.WHITE);
		Activities.setBounds(114, 19, 101, 16);
		panel_2.add(Activities);
		
		//creates buttons for event panel
		JRadioButton onedollarsign_2 = new JRadioButton("$");
		onedollarsign_2.setForeground(Color.WHITE);
		onedollarsign_2.setBounds(6, 37, 68, 23);
		panel_2.add(onedollarsign_2);
		
		JRadioButton twodollar = new JRadioButton("$$");
		twodollar.setForeground(Color.WHITE);
		twodollar.setBounds(6, 61, 68, 23);
		panel_2.add(twodollar);
		
		JRadioButton threedollarsign_2 = new JRadioButton("$$$");
		threedollarsign_2.setForeground(Color.WHITE);
		threedollarsign_2.setBounds(6, 84, 68, 23);
		panel_2.add(threedollarsign_2);
		
		JRadioButton Spring = new JRadioButton("Spring");
		Spring.setForeground(new Color(255, 255, 255));
		Spring.setBounds(6, 138, 141, 23);
		panel_2.add(Spring);
		
		JRadioButton Summer = new JRadioButton("Summer");
		Summer.setForeground(new Color(255, 255, 255));
		Summer.setBounds(6, 162, 141, 23);
		panel_2.add(Summer);
		
		JRadioButton Fall = new JRadioButton("Fall");
		Fall.setForeground(new Color(255, 255, 255));
		Fall.setBounds(6, 185, 141, 23);
		panel_2.add(Fall);
		JRadioButton Winter = new JRadioButton("Winter");
		Winter.setForeground(new Color(255, 255, 255));
		Winter.setBounds(6, 209, 141, 23);
		panel_2.add(Winter);
		
		JRadioButton CarnivalGames = new JRadioButton("Carnival Games");
		CarnivalGames.setForeground(Color.WHITE);
		CarnivalGames.setBounds(109, 41, 141, 23);
		panel_2.add(CarnivalGames);
		
		JRadioButton Jumpers = new JRadioButton("Jumpers");
		Jumpers.setForeground(Color.WHITE);
		Jumpers.setBounds(109, 65, 141, 23);
		panel_2.add(Jumpers);
		
		JRadioButton Rides = new JRadioButton("Rides");
		Rides.setForeground(Color.WHITE);
		Rides.setBounds(109, 88, 141, 23);
		panel_2.add(Rides);
		
		JRadioButton Tubing = new JRadioButton("Tubing");
		Tubing.setForeground(Color.WHITE);
		Tubing.setBounds(109, 112, 141, 23);
		panel_2.add(Tubing);
		
		//groups buttons together so user can only choose one at a time
		eventprice.add(onedollarsign_2);
		eventprice.add(twodollar);
		eventprice.add(threedollarsign_2);
		
		seasons.add(Spring);
		seasons.add(Summer);
		seasons.add(Fall);
		seasons.add(Winter);

		activities.add(CarnivalGames);
		activities.add(Jumpers);
		activities.add(Rides);
		activities.add(Tubing);
		
		//creates checkboxes for event panel
		JCheckBox LivePerformances = new JCheckBox("Live Performances");
		LivePerformances.setForeground(Color.WHITE);
		LivePerformances.setFont(new Font("Arial", Font.PLAIN, 13));
		LivePerformances.setBackground(Color.WHITE);
		LivePerformances.setBounds(6, 265, 141, 23);
		panel_2.add(LivePerformances);
		
		JCheckBox Fireworks = new JCheckBox("Fireworks");
		Fireworks.setForeground(Color.WHITE);
		Fireworks.setFont(new Font("Arial", Font.PLAIN, 13));
		Fireworks.setBackground(Color.WHITE);
		Fireworks.setBounds(6, 287, 141, 23);
		panel_2.add(Fireworks);
		
		JCheckBox Picnic = new JCheckBox("Picnic");
		Picnic.setActionCommand("");
		Picnic.setForeground(Color.WHITE);
		Picnic.setFont(new Font("Arial", Font.PLAIN, 13));
		Picnic.setBackground(Color.WHITE);
		Picnic.setBounds(6, 310, 120, 23);
		panel_2.add(Picnic);
		
		JCheckBox FoodTrucks = new JCheckBox("Food Trucks");
		FoodTrucks.setForeground(Color.WHITE);
		FoodTrucks.setFont(new Font("Arial", Font.PLAIN, 13));
		FoodTrucks.setBackground(Color.WHITE);
		FoodTrucks.setActionCommand("");
		FoodTrucks.setBounds(6, 332, 141, 23);
		panel_2.add(FoodTrucks);
		
		//allows user to go back
		JButton eventsgo = new JButton("←");
		eventsgo.setForeground(new Color(0, 0, 128));
		eventsgo.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		eventsgo.setBackground(new Color(0, 0, 128));
		eventsgo.setBounds(32, 360, 92, 34);
		panel_2.add(eventsgo);
		eventsgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventspanel_1.setVisible(false);
				choosing.setVisible(true);
				lightbluetop.setVisible(true);
			}
		});
		
		//creates label to print image
		JLabel eventsprint = new JLabel("");
		eventsprint.setHorizontalAlignment(SwingConstants.CENTER);
		eventsprint.setFont(new Font("Arial", Font.PLAIN, 12));
		eventsprint.setBounds(275, 340, 300, 36);
		eventspanel_1.add(eventsprint);
		
		//creates label to print image source
		JLabel eventssource = new JLabel("");
		eventssource.setHorizontalAlignment(SwingConstants.CENTER);
		eventssource.setForeground(new Color(255, 255, 255));
		eventssource.setBounds(302, 275, 243, 16);
		eventspanel_1.add(eventssource);
		
		//shows source of picture
		JLabel eventspic = new JLabel("");
		eventspic.setFont(new Font("Arial", Font.PLAIN, 20));
		eventspic.setBounds(269, 63, 314, 248);
		eventspanel_1.add(eventspic);
		eventspic.setHorizontalAlignment(SwingConstants.CENTER);
		eventspic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (eventsselected!="")
				{
					eventssource.setText("Picture By "+ eventsselected);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				eventssource.setText("");
			}
		});
		
		// creates images for events
		ImageIcon eek = new ImageIcon("eek.png");
		ImageIcon nine = new ImageIcon("nine.jpeg");
		ImageIcon picnic = new ImageIcon("picnic.jpeg");
		ImageIcon lantern = new ImageIcon("lunar.png");
		ImageIcon eatsvale = new ImageIcon("eatsvale.png");
		ImageIcon miracle = new ImageIcon("miracle.jpeg");
		
		//gives user a events attraction when button is clicked
		JButton eventsgo_2 = new JButton("→");
		eventsgo_2.setForeground(new Color(0, 0, 128));
		eventsgo_2.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		eventsgo_2.setBackground(new Color(0, 0, 128));
		eventsgo_2.setBounds(148, 360, 92, 34);
		panel_2.add(eventsgo_2);
		eventsgo_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eventspic.setVisible(true);
				if (Winter.isSelected())
				{
					eventsprint.setText("Miracle On Citrus Street - Coming in December");
					eventspic.setIcon(miracle);
					eventsselected = "City of Eastvale";
				}
				else if (Spring.isSelected())
				{
					if(onedollarsign_2.isSelected())
					{
						eventsprint.setText("None");
						eventspic.setVisible(false);
						eventsselected = "";
					}
					else if (twodollar.isSelected())
					{
						eventsprint.setText("EATSvale");
						eventspic.setIcon(eatsvale);
						eventsselected = "City of Eastvale";

					}
					else if (threedollarsign_2.isSelected() || Jumpers.isSelected())
					{
						eventsprint.setText("Lantern Festival - Coming in February");
						eventspic.setIcon(lantern);
						eventsselected = "City of Eastvale";

					}
					else
					{
						eventsprint.setText("Choose a price!");
						eventspic.setVisible(false);
						eventsselected = "";
					}
				}
				else if (Summer.isSelected())
				{
					if (onedollarsign_2.isSelected())
					{
						eventsprint.setText("None");
						eventspic.setVisible(false);
						eventsselected = "";
					}
					else if (twodollar.isSelected())
					{
						eventsprint.setText("EATSvale");
						eventspic.setIcon(eatsvale);
						eventsselected = "City of Eastvale";
					}
					else if (threedollarsign_2.isSelected())
					{
						eventsprint.setText("Picnic In The Park - Coming in June");
						eventspic.setIcon(picnic);
						eventsselected = "ABC PR";
					}
					else
					{
						eventsprint.setText("Choose a price!");
						eventspic.setVisible(false);
						eventsselected = "";
					}
				}
				else if (Fall.isSelected())
				{
					if (threedollarsign_2.isSelected())
					{
						eventsprint.setText("None");
						eventspic.setVisible(false);
						eventsselected = "";
					}
					else if (onedollarsign_2.isSelected())
					{
						eventsprint.setText("9/11 Memorial - Coming on 9/11");
						eventspic.setIcon(nine);
						eventsselected = "The Press-Enterprise";
					}
					else if (twodollar.isSelected())
					{
						eventsprint.setText("EEKvale - Coming in October");
						eventspic.setIcon(eek);
						eventsselected = "City of Eastvale";
					}
					else
					{
						eventsprint.setText("Choose a price!");
						eventspic.setVisible(false);
						eventsselected = "";
					}
				}
				else
				{
					eventsprint.setText("Choose a season");
					eventspic.setVisible(false);
					eventsselected = "";
				}
			}
		});
		
		//sets label for entertainment type
		JLabel entertainmentype = new JLabel("Entertainment");
		entertainmentype.setForeground(Color.WHITE);
		entertainmentype.setFont(new Font("Arial", Font.PLAIN, 13));
		entertainmentype.setBackground(Color.WHITE);
		entertainmentype.setBounds(11, 244, 101, 16);
		panel_2.add(entertainmentype);
			
		//creates images for entertainment
		ImageIcon harada = new ImageIcon("harada.jpeg");
		ImageIcon cedar = new ImageIcon("cedar.jpeg");
		ImageIcon river = new ImageIcon("river.jpeg");
		ImageIcon american = new ImageIcon("american.jpeg");
		ImageIcon halfmoon = new ImageIcon("halfmoon.jpeg");
		ImageIcon mccune = new ImageIcon("mccune.jpeg");
		ImageIcon silverlakes = new ImageIcon("silverlakes.jpeg");
		ImageIcon orchard = new ImageIcon("orchard.jpeg");
		ImageIcon movie = new ImageIcon("movie.jpeg");
		
		// creates restaurant panel
		JPanel restaurantpanel = new JPanel();
		restaurantpanel.setBackground(new Color(100, 149, 237));
		restaurantpanel.setBounds(0, 0, 600, 400);
		contentPane.add(restaurantpanel);
		restaurantpanel.setLayout(null);
		restaurantpanel.setVisible(false);
		
		restaurants.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choosing.setVisible(false);
				restaurantpanel.setVisible(true);
				lightbluetop.setVisible(false);
				lightbluetop_1.setVisible(false);
			}
		});
		
		//creates dark blue portion on left hand side
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 257, 400);
		restaurantpanel.add(panel);
		panel.setLayout(null);
				
		//creates label for restaurant panel
		JLabel Price = new JLabel("Price");
		Price.setFont(new Font("Arial", Font.PLAIN, 13));
		Price.setBackground(new Color(255, 255, 255));
		Price.setForeground(new Color(255, 255, 255));
		Price.setBounds(11, 19, 61, 16);
		panel.add(Price);
		
		JLabel Cuisine = new JLabel("Cuisine");
		Cuisine.setFont(new Font("Arial", Font.PLAIN, 13));
		Cuisine.setBackground(new Color(255, 255, 255));
		Cuisine.setForeground(new Color(255, 255, 255));
		Cuisine.setBounds(11, 246, 61, 16);
		panel.add(Cuisine);
		
		JLabel Meal = new JLabel("Meal");
		Meal.setFont(new Font("Arial", Font.PLAIN, 13));
		Meal.setBackground(new Color(255, 255, 255));
		Meal.setForeground(new Color(255, 255, 255));
		Meal.setBounds(11, 124, 61, 16);
		panel.add(Meal);

		JLabel DiningOptions = new JLabel("Order Options");
		DiningOptions.setFont(new Font("Arial", Font.PLAIN, 13));
		DiningOptions.setBackground(new Color(255, 255, 255));
		DiningOptions.setForeground(new Color(255, 255, 255));
		DiningOptions.setBounds(136, 19, 123, 16);
		panel.add(DiningOptions);
		
		JLabel Payment = new JLabel("Payment Type");
		Payment.setFont(new Font("Arial", Font.PLAIN, 13));
		Payment.setBackground(new Color(255, 255, 255));
		Payment.setBounds(136, 121, 108, 16);
		panel.add(Payment);
		Payment.setForeground(new Color(255, 255, 255));
		
		//creates radio buttons for restaurant panel
		JRadioButton Mexican = new JRadioButton("Mexican");
		Mexican.setFont(new Font("Arial", Font.PLAIN, 13));
		Mexican.setBackground(new Color(255, 255, 255));
		Mexican.setForeground(new Color(255, 255, 255));
		Mexican.setBounds(6, 266, 141, 23);
		panel.add(Mexican);
		
		JRadioButton Chinese = new JRadioButton("Chinese");
		Chinese.setFont(new Font("Arial", Font.PLAIN, 13));
		Chinese.setBackground(new Color(255, 255, 255));
		Chinese.setForeground(new Color(255, 255, 255));
		Chinese.setBounds(6, 289, 141, 23);
		panel.add(Chinese);
		
		JRadioButton Japanese = new JRadioButton("Japanese");
		Japanese.setFont(new Font("Arial", Font.PLAIN, 13));
		Japanese.setBackground(new Color(255, 255, 255));
		Japanese.setForeground(new Color(255, 255, 255));
		Japanese.setBounds(6, 311, 141, 23);
		panel.add(Japanese);
		
		JRadioButton American = new JRadioButton("American");
		American.setFont(new Font("Arial", Font.PLAIN, 13));
		American.setBackground(new Color(255, 255, 255));
		American.setForeground(new Color(255, 255, 255));
		American.setBounds(6, 334, 141, 23);
		panel.add(American);
		
		JRadioButton Hawaiian = new JRadioButton("Hawaiian");
		Hawaiian.setFont(new Font("Arial", Font.PLAIN, 13));
		Hawaiian.setBackground(new Color(255, 255, 255));
		Hawaiian.setForeground(new Color(255, 255, 255));
		Hawaiian.setBounds(6, 357, 90, 23);
		panel.add(Hawaiian);
		
		JRadioButton Breakfast = new JRadioButton("Breakfast");
		Breakfast.setFont(new Font("Arial", Font.PLAIN, 13));
		Breakfast.setBackground(new Color(255, 255, 255));
		Breakfast.setForeground(new Color(255, 255, 255));
		Breakfast.setBounds(6, 143, 123, 23);
		panel.add(Breakfast);
		
		JRadioButton Lunch = new JRadioButton("Lunch");
		Lunch.setFont(new Font("Arial", Font.PLAIN, 13));
		Lunch.setBackground(new Color(255, 255, 255));
		Lunch.setForeground(new Color(255, 255, 255));
		Lunch.setBounds(6, 165, 123, 23);
		panel.add(Lunch);
		
		JRadioButton Dinner = new JRadioButton("Dinner");
		Dinner.setFont(new Font("Arial", Font.PLAIN, 13));
		Dinner.setBackground(new Color(255, 255, 255));
		Dinner.setForeground(new Color(255, 255, 255));
		Dinner.setBounds(6, 188, 128, 23);
		panel.add(Dinner);
		
		JRadioButton Dessert = new JRadioButton("Dessert");
		Dessert.setFont(new Font("Arial", Font.PLAIN, 13));
		Dessert.setBackground(new Color(255, 255, 255));
		Dessert.setForeground(new Color(255, 255, 255));
		Dessert.setBounds(6, 211, 128, 23);
		panel.add(Dessert);
		
		JRadioButton onedollarsign = new JRadioButton("$");
		onedollarsign.setForeground(Color.WHITE);
		onedollarsign.setBounds(6, 39, 96, 23);
		panel.add(onedollarsign);
		
		JRadioButton twodollar_2 = new JRadioButton("$$");
		twodollar_2.setForeground(Color.WHITE);
		twodollar_2.setBounds(6, 63, 81, 23);
		panel.add(twodollar_2);
		
		JRadioButton threedollarsign_2_2 = new JRadioButton("$$$");
		threedollarsign_2_2.setForeground(Color.WHITE);
		threedollarsign_2_2.setBounds(6, 86, 72, 23);
		panel.add(threedollarsign_2_2);
		
		//creates checkboxes for restaurant panel
		JCheckBox Delivery = new JCheckBox("Delivery");
		Delivery.setFont(new Font("Arial", Font.PLAIN, 13));
		Delivery.setBackground(new Color(255, 255, 255));
		Delivery.setForeground(new Color(255, 255, 255));
		Delivery.setBounds(129, 64, 128, 23);
		panel.add(Delivery);
		
		JCheckBox ToGo = new JCheckBox("To Go");
		ToGo.setFont(new Font("Arial", Font.PLAIN, 13));
		ToGo.setBackground(new Color(255, 255, 255));
		ToGo.setForeground(new Color(255, 255, 255));
		ToGo.setBounds(129, 38, 128, 23);
		panel.add(ToGo);
		
		JCheckBox DineIn = new JCheckBox("DineIn");
		DineIn.setActionCommand("Dine In");
		DineIn.setFont(new Font("Arial", Font.PLAIN, 13));
		DineIn.setBackground(new Color(255, 255, 255));
		DineIn.setForeground(new Color(255, 255, 255));
		DineIn.setBounds(129, 89, 128, 23);
		panel.add(DineIn);
		
		JCheckBox applePay = new JCheckBox("Apple Pay");
		applePay.setAlignmentX(Component.RIGHT_ALIGNMENT);
		applePay.setFont(new Font("Arial", Font.PLAIN, 13));
		applePay.setBackground(new Color(255, 255, 255));
		applePay.setBounds(129, 141, 128, 23);
		panel.add(applePay);
		applePay.setForeground(new Color(255, 255, 255));
		
		JCheckBox GooglePay = new JCheckBox("GooglePay");
		GooglePay.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GooglePay.setFont(new Font("Arial", Font.PLAIN, 13));
		GooglePay.setBackground(new Color(255, 255, 255));
		GooglePay.setBounds(129, 166, 128, 23);
		panel.add(GooglePay);
		GooglePay.setForeground(new Color(255, 255, 255));
		
		JCheckBox creditDebit = new JCheckBox("Credit/Debit");
		creditDebit.setAlignmentX(Component.RIGHT_ALIGNMENT);
		creditDebit.setFont(new Font("Arial", Font.PLAIN, 13));
		creditDebit.setBackground(new Color(255, 255, 255));
		creditDebit.setBounds(129, 190, 128, 23);
		panel.add(creditDebit);
		creditDebit.setForeground(new Color(255, 255, 255));
		
		JCheckBox Cash = new JCheckBox("Cash");
		Cash.setAlignmentX(Component.RIGHT_ALIGNMENT);
		Cash.setFont(new Font("Arial", Font.PLAIN, 13));
		Cash.setBackground(new Color(255, 255, 255));
		Cash.setBounds(129, 214, 128, 23);
		panel.add(Cash);
		Cash.setForeground(new Color(255, 255, 255));
		
		//creates button that returns to main page
		JButton restaurantgo = new JButton("→");
		restaurantgo.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		restaurantgo.setBounds(188, 358, 63, 36);
		panel.add(restaurantgo);
		restaurantgo.setForeground(new Color(0, 0, 128));
		restaurantgo.setBackground(new Color(0, 0, 128));
		
		// returns back to main page
		JButton restaurantgo_1 = new JButton("←");
		restaurantgo_1.setForeground(new Color(0, 0, 128));
		restaurantgo_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		restaurantgo_1.setBackground(new Color(0, 0, 128));
		restaurantgo_1.setBounds(113, 358, 63, 36);
		panel.add(restaurantgo_1);
		restaurantgo_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				restaurantpanel.setVisible(false);
				choosing.setVisible(true);	
				lightbluetop.setVisible(true);
			}
		});
		
		//creates label to print out image
		JLabel restaurantprint = new JLabel("");
		restaurantprint.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantprint.setFont(new Font("Arial", Font.PLAIN, 20));
		restaurantprint.setBounds(276, 308, 300, 36);
		restaurantpanel.add(restaurantprint);
		
		//creates label to print out image source
		JLabel restaurantsource = new JLabel("");
		restaurantsource.setForeground(new Color(255, 255, 255));
		restaurantsource.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantsource.setBounds(294, 238, 251, 16);
		restaurantpanel.add(restaurantsource);
		
		// shows source of picture
		JLabel restaurantpic = new JLabel("");
		restaurantpic.setForeground(new Color(255, 255, 255));
		restaurantpic.setHorizontalAlignment(SwingConstants.CENTER);
		restaurantpic.setBackground(Color.BLACK);
		restaurantpic.setBounds(269, 31, 314, 248);
		restaurantpanel.add(restaurantpic);
		restaurantpic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (restaurantselected!="")
				{
					restaurantsource.setText("Picture By "+ restaurantselected);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				restaurantsource.setText("");
			}
		});
		
		// creates images for restaurants
		ImageIcon chattea = new ImageIcon("chattea.jpeg");
		ImageIcon goldenchopsticks = new ImageIcon("goldenchopsticks.jpeg");
		ImageIcon poke = new ImageIcon("poke.jpeg");
		ImageIcon eastbrew = new ImageIcon("eastbrew.jpeg");
		ImageIcon taco = new ImageIcon("taco.jpeg");
		ImageIcon tacodel = new ImageIcon("tacodel.jpeg");
		ImageIcon miguel = new ImageIcon("miguel.png");
		ImageIcon jinya = new ImageIcon("jinya.jpeg");
		ImageIcon yoshiharu = new ImageIcon("yoshiharu.jpeg");
		ImageIcon sushi = new ImageIcon("zipsuhsi.jpeg");
		ImageIcon chick = new ImageIcon("chick.jpeg");
		ImageIcon panera = new ImageIcon("panera.jpeg");
		ImageIcon in = new ImageIcon("in.jpeg");
		ImageIcon starbucks = new ImageIcon("starbucks.jpeg");
		ImageIcon pinkberry = new ImageIcon("pinkberry.jpeg");
		ImageIcon mcdonald = new ImageIcon("mcdonald.jpeg");
		
		//gives users a restuarant option
		restaurantgo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				restaurantpic.setVisible(true);
				ryelp = "";
				if (Chinese.isSelected())
				{
					if (Dessert.isSelected()==false && Breakfast.isSelected()==false && applePay.isSelected()==false && GooglePay.isSelected()==false)
					{
						ryelp = "Golden Chopsticks";
						restaurantprint.setText("Golden Chopsticks");
						restaurantpic.setIcon(goldenchopsticks);
						restaurantselected = "Golden Chopstix";
					}
					else if (twodollar_2.isSelected() || threedollarsign_2_2.isSelected())
					{
						restaurantprint.setText("None");
						restaurantpic.setVisible(false);
						restaurantselected = "";
					}
					else
					{
						ryelp = "Chat Tea";
						restaurantprint.setText("Chat Tea");
						restaurantpic.setIcon(chattea);
						restaurantselected = "Chat Tea";
					}
				}
				else if (Hawaiian.isSelected())
				{
					if (Breakfast.isSelected() || threedollarsign_2_2.isSelected() || onedollarsign.isSelected())
					{
						restaurantprint.setText("None");
						restaurantpic.setVisible(false);
						restaurantselected = "";
					}
					else
					{
						ryelp = "Poke Delight";
						restaurantprint.setText("Poke Delight");
						restaurantpic.setIcon(poke);
						restaurantselected = "Poke Delight";
					}
				}
				else if (Mexican.isSelected())
				{
					if (threedollarsign_2_2.isSelected())
					{
						restaurantprint.setText("None");
						restaurantpic.setVisible(false);
						restaurantselected = "";
					}
					else if (twodollar_2.isSelected())
					{
						if (Delivery.isSelected() || Dinner.isSelected() || Dessert.isSelected())
						{
							restaurantprint.setText("None");
							restaurantpic.setVisible(false);
							restaurantselected = "";
						}
						else
						{
							ryelp = "Eastbrew Cafe and Bakery";
							restaurantprint.setText("Eastbrew Cafe and Bakery");
							restaurantpic.setIcon(eastbrew);
							restaurantselected = "Restaurant Guru";
						}
					}
					else if (onedollarsign.isSelected())
					{ 
						if (Dessert.isSelected())
						{
							restaurantprint.setText("None");
							restaurantpic.setVisible(false);
							restaurantselected = "";
						}
						else if (GooglePay.isSelected() || applePay.isSelected())
						{
							ryelp = "Miguel's Jr";
							restaurantprint.setText("Miguel's Jr");
							restaurantpic.setIcon(miguel);
							restaurantselected = "Miguel's Jr";
						}
						else if (Delivery.isSelected())
						{
							ryelp = "Taco Bell";
							restaurantprint.setText("Taco Bell");
							restaurantpic.setIcon(taco);
							restaurantselected = "Waymarking";
						}
						else
						{
							ryelp = "Taco Del Rio";
							restaurantprint.setText("Taco Del Rio");
							restaurantpic.setIcon(tacodel);
							restaurantselected = "Business Yab";
						}
					}
					else
					{
						restaurantprint.setText("Choose a price!");
					}
				}
				else if (Japanese.isSelected())
				{
					String[] japarr = {"JINYA Ramen Bar", "Yoshiharu Ramen"};
					if (threedollarsign_2_2.isSelected())
					{
						if (Breakfast.isSelected() || Dessert.isSelected())
						{
							restaurantprint.setText("None");
							restaurantpic.setVisible(false);
							restaurantselected = "";
						}
						else
						{
							ryelp = "ZIP Sushi";
							restaurantprint.setText("ZIP Sushi");
							restaurantpic.setIcon(sushi);
							restaurantselected = "Restaurant Guru";
						}
					}
					else if (twodollar_2.isSelected())
					{
						if (Breakfast.isSelected() || Dessert.isSelected())
						{
							restaurantprint.setText("None");
							restaurantpic.setVisible(false);
							restaurantselected = "";
						}
						else
						{
							String j = japarr[(int)Math.floor(Math.random()*(1-0+1)+0)];
							restaurantprint.setText(j);
							ryelp = j;
							if (j.equals("JINYA Ramen Bar"))
							{
								restaurantpic.setIcon(jinya);
								restaurantselected = j;
							}
							else
							{
								restaurantpic.setIcon(yoshiharu);
								restaurantselected = "City of Eastvale";
							}
							
						}
					}
					else if (onedollarsign.isSelected())
					{
						restaurantprint.setText("None");
						restaurantpic.setVisible(false);
						restaurantselected = "";
					}
					else
					{
						restaurantprint.setText("Choose a price!");
					}
				}
				else if (American.isSelected())
				{
					if (threedollarsign_2_2.isSelected())
					{
						restaurantprint.setText("None");
						restaurantpic.setVisible(false);
						restaurantselected = "";
					}
					else if (twodollar_2.isSelected())
					{
						if (Dessert.isSelected())
						{
							ryelp = "Chick-Fil-A";
							restaurantprint.setText("Chick-Fil-A");
							restaurantpic.setIcon(chick);
							restaurantselected = "Chick-Fil-A";
						}
						else if (GooglePay.isSelected())
						{
							ryelp = "Panera Bread";
							restaurantprint.setText("Panera Bread");
							restaurantpic.setIcon(panera);
							restaurantselected = "Mapsus.net";
						}
						else
						{
							ryelp = "In-N-Out Burger";
							restaurantprint.setText("In-N-Out Burger");
							restaurantpic.setIcon(in);
							restaurantselected = "In-N-Out Burger";
						}
					}
					else if (onedollarsign.isSelected())
					{
						if (Dessert.isSelected())
						{
							if (GooglePay.isSelected() || applePay.isSelected() || Delivery.isSelected())
							{
								ryelp = "Starbucks";
								restaurantprint.setText("Starbucks");
								restaurantpic.setIcon(starbucks);
								restaurantselected = "Lewis Retail Centers";
							}
							else
							{
								ryelp = "Pinkberry";
								restaurantprint.setText("Pinkberry");
								restaurantpic.setIcon(pinkberry);
								restaurantselected = "Pinkberry";
								//change color to black
							} 
							
						}
						else 
						{
							ryelp = "Mcdonald's";
							restaurantprint.setText("McDonald's");
							restaurantpic.setIcon(mcdonald);
							restaurantselected = "USA Restaurants";
						}
					}
					else
					{
						restaurantprint.setText("Choose a price!");
					}
				}
				else
				{
					restaurantprint.setText("Choose a cuisine first!");
				}
			}
		});
		
		// creates button groups so user can only choose one at a time
		cuisinegroup.add(Mexican);
		cuisinegroup.add(Chinese);
		cuisinegroup.add(Japanese);
		cuisinegroup.add(American);
		cuisinegroup.add(Hawaiian);
		
		group.add(Dessert);
		group.add(Dinner);
		group.add(Breakfast);
		group.add(Lunch);
		
		restuarantprice.add(onedollarsign);
		restuarantprice.add(twodollar_2);
		restuarantprice.add(threedollarsign_2_2);
		
		// YELP button for restaurant
		JButton restaurantyelp = new JButton("YELP Review");
		restaurantyelp.setBounds(300, 354, 248, 40);
		restaurantpanel.add(restaurantyelp);
		restaurantyelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (ryelp.equals("Chat Tea"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/chat-tea-eastvale-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				else if (ryelp.equals("Golden Chopsticks"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/golden-chopsticks-lake-elsinore?osq=golden+chopsticks").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Poke Delight"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/poke-delight-eastvale-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Eastbrew Cafe and Bakery"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/eastbrew-cafe-and-bakery-eastvale-6").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Taco Bell"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/taco-bell-mira-loma?osq=taco+bell").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Taco Del Rio"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/tacos-del-rio-corona").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Miguel's Jr"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/miguels-jr-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("JINYA Ramen Bar"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/jinya-ramen-bar-eastvale-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Yoshiharu Ramen"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/yoshiharu-ramen-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("ZIP Sushi"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/zip-fusion-sushi-eastvale-3").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Chick-Fil-A"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/chick-fil-a-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Panera Bread"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/panera-bread-eastvale-2").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("In-N-Out Burger"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/in-n-out-burger-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Pinkberry"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/pinkberry-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("Starbucks"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/starbucks-eastvale-6").toURI());
					}
					catch (Exception e1)
					{}
				}
				if (ryelp.equals("McDonald's"))
				{
					try {
						Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/mcdonalds-eastvale").toURI());
					}
					catch (Exception e1)
					{}
				}
			}
		});
		
		// creates entertainment panel
		JPanel entertainmentpanel = new JPanel();
		entertainmentpanel.setBounds(0, 0, 600, 400);
		contentPane.add(entertainmentpanel);
		entertainmentpanel.setLayout(null);
		
		//creates entertainment button
		JButton entertainment = new JButton("Entertainment");
		entertainment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				choosing.setVisible(false);
				entertainmentpanel.setVisible(true);
				lightbluetop.setVisible(false);
				lightbluetop_1.setVisible(false);
			}
		});
		
		JLabel usagebutton = new JLabel("");
		usagebutton.setIcon(new ImageIcon("/Users/chloewu/Downloads/analytics-icon-design-template-isolated-vector-24019618-removebg-preview (1).png"));
		usagebutton.setHorizontalAlignment(SwingConstants.CENTER);
		usagebutton.setBounds(-13, 346, 77, 54);
		choosing.add(usagebutton);
		entertainment.setBounds(221, 306, 143, 44);
		choosing.add(entertainment);
		
		JPanel analyticpanel = new JPanel();
		analyticpanel.setBackground(new Color(230, 230, 250));
		analyticpanel.setBounds(30, 121, 151, 205);
		choosing.add(analyticpanel);
		analyticpanel.setLayout(null);
		
		analyticpanel.setVisible(false);
		
		usagebutton.addMouseListener(new MouseAdapter() {
			int clicked = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked++;
				if (clicked%2==0)
				{
					analyticpanel.setVisible(true);
				}
				else
				{
					analyticpanel.setVisible(false);
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("ANALYTICS");
		lblNewLabel.setBounds(40, 6, 71, 16);
		analyticpanel.add(lblNewLabel);
		
		JRadioButton favorite = new JRadioButton("Favorite");
		favorite.setBounds(6, 34, 141, 23);
		analyticpanel.add(favorite);
		
		JRadioButton mostviewed = new JRadioButton("Most Viewed");
		mostviewed.setBounds(6, 69, 141, 23);
		analyticpanel.add(mostviewed);
		
		JRadioButton top3 = new JRadioButton("Top 3 Attractions");
		top3.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		top3.setBounds(6, 104, 141, 23);
		analyticpanel.add(top3);
		JRadioButton allstar = new JRadioButton("All Star");
		allstar.setBounds(6, 139, 141, 23);
		analyticpanel.add(allstar);
		
		analyze.add(mostviewed);
		analyze.add(top3);
		analyze.add(favorite);
		analyze.add(allstar);
		
		JButton btnNewButton_1 = new JButton("→");
		btnNewButton_1.setBounds(50, 182, 56, 17);
		analyticpanel.add(btnNewButton_1);
		
		JPanel favoritepanel = new JPanel();
		favoritepanel.setBounds(30, 121, 151, 205);
		choosing.add(favoritepanel);
		favoritepanel.setBackground(new Color(230, 230, 250));
		favoritepanel.setLayout(null);
		
		favoritepanel.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-107, 50, 258, 201);
		favoritepanel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/chloewu/Desktop/fbla/chick.jpeg"));
		
		JLabel toprestaurantlabel = new JLabel("FAVORITE ATTRACTION");
		toprestaurantlabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		toprestaurantlabel.setBounds(16, 6, 145, 16);
		favoritepanel.add(toprestaurantlabel);
		
		JLabel lblNewLabel_2 = new JLabel("Chick-Fil-A");
		lblNewLabel_2.setBounds(35, 30, 84, 16);
		favoritepanel.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("←");
		btnNewButton_2.setBounds(3, 30, 25, 18);
		favoritepanel.add(btnNewButton_2);
		
		JPanel mostviewedpanel = new JPanel();
		mostviewedpanel.setBackground(new Color(230, 230, 250));
		mostviewedpanel.setBounds(30, 116, 151, 210);
		choosing.add(mostviewedpanel);
		mostviewedpanel.setLayout(null);
		
		mostviewedpanel.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("MOST VIEWED");
		lblNewLabel_3.setBounds(33, 6, 87, 16);
		mostviewedpanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Half Moon Park");
		lblNewLabel_4.setBounds(30, 34, 102, 16);
		mostviewedpanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/chloewu/Desktop/fbla/halfmoon.jpeg"));
		lblNewLabel_5.setBounds(-31, 62, 182, 194);
		mostviewedpanel.add(lblNewLabel_5);
		
		JButton btnNewButton_2_1 = new JButton("←");
		btnNewButton_2_1.setBounds(3, 33, 25, 18);
		mostviewedpanel.add(btnNewButton_2_1);
		
		JPanel top3panel = new JPanel();
		top3panel.setBackground(new Color(230, 230, 250));
		top3panel.setBounds(30, 116, 151, 210);
		choosing.add(top3panel);
		top3panel.setLayout(null);
		
		top3panel.setVisible(false);
		
		JLabel lblNewLabel_6 = new JLabel("TOP 3");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(6, 6, 139, 16);
		top3panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("1. Edward's Movie");
		lblNewLabel_7.setBounds(16, 34, 115, 16);
		top3panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Theater");
		lblNewLabel_8.setBounds(34, 50, 61, 16);
		top3panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("2. Eastbrew Cafe");
		lblNewLabel_9.setBounds(16, 96, 115, 16);
		top3panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("3. Silverlakes");
		lblNewLabel_10.setBounds(16, 147, 115, 16);
		top3panel.add(lblNewLabel_10);
		
		JButton btnNewButton_2_1_1 = new JButton("←");
		top3panel.add(btnNewButton_2_1_1);
		btnNewButton_2_1_1.setBounds(30, 186, 95, 18);
		
		JPanel allstarpanel = new JPanel();
		allstarpanel.setBackground(new Color(230, 230, 250));
		allstarpanel.setBounds(30, 115, 151, 211);
		choosing.add(allstarpanel);
		allstarpanel.setLayout(null);
		
		allstarpanel.setVisible(false);
		
		JLabel lblNewLabel_11 = new JLabel("ALL STAR");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(6, 5, 139, 16);
		allstarpanel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ross");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(43, 25, 61, 16);
		allstarpanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(-94, 45, 245, 218);
		allstarpanel.add(lblNewLabel_13);
		lblNewLabel_13.setIcon(new ImageIcon("/Users/chloewu/Desktop/fbla/ross.jpeg"));
		
		JButton btnNewButton_2_1_2 = new JButton("←");
		btnNewButton_2_1_2.setBounds(16, 25, 25, 18);
		allstarpanel.add(btnNewButton_2_1_2);
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (mostviewed.isSelected())
				{
					mostviewedpanel.setVisible(true);
					analyticpanel.setVisible(false);
				}
				if (top3.isSelected())
				{
					top3panel.setVisible(true);
					analyticpanel.setVisible(false);
				}
				if (favorite.isSelected())
				{
					favoritepanel.setVisible(true);
					analyticpanel.setVisible(false);
				}
				if (allstar.isSelected())
				{
					allstarpanel.setVisible(true);
					analyticpanel.setVisible(false);
				}
			}
		});
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				favoritepanel.setVisible(false);
				analyticpanel.setVisible(true);
			}
		});
		
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostviewedpanel.setVisible(false);
				analyticpanel.setVisible(true);
			}
		});
		
		btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				top3panel.setVisible(false);
				analyticpanel.setVisible(true);
			}
		});
		
		btnNewButton_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allstarpanel.setVisible(false);
				analyticpanel.setVisible(true);
			}
		});
		
		//creates right side of the panel
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(100, 149, 237));
		panel_4.setBounds(257, 0, 343, 400);
		entertainmentpanel.add(panel_4);
		panel_4.setLayout(null);
		
		//creates buttons for entertainment panel
		JRadioButton onedollar3 = new JRadioButton("$");
		onedollar3.setForeground(new Color(255, 255, 255));
		onedollar3.setBounds(6, 35, 56, 23);
		entertainmentpanel.add(onedollar3);
			
		JRadioButton twodollar3 = new JRadioButton("$$");
		twodollar3.setForeground(new Color(255, 255, 255));
		twodollar3.setBounds(6, 59, 56, 23);
		entertainmentpanel.add(twodollar3);
			
		JRadioButton threedollar3 = new JRadioButton("$$$");
		threedollar3.setForeground(new Color(255, 255, 255));
		threedollar3.setBounds(6, 82, 65, 23);
		entertainmentpanel.add(threedollar3);
		
		JRadioButton HostsSportingEvents = new JRadioButton("Hosts Sporting Events");
		HostsSportingEvents.setForeground(Color.WHITE);
		HostsSportingEvents.setBounds(6, 325, 171, 23);
		entertainmentpanel.add(HostsSportingEvents);
		
		JRadioButton GrassTrail = new JRadioButton("Grass Trail");
		GrassTrail.setForeground(Color.WHITE);
		GrassTrail.setBounds(103, 35, 113, 23);
		entertainmentpanel.add(GrassTrail);
		
		JRadioButton DirtTrail = new JRadioButton("Dirt Trail");
		DirtTrail.setForeground(Color.WHITE);
		DirtTrail.setBounds(103, 59, 113, 23);
		entertainmentpanel.add(DirtTrail);
		
		JRadioButton CementTrail = new JRadioButton("Cement Trail");
		CementTrail.setForeground(Color.WHITE);
		CementTrail.setBounds(103, 82, 131, 23);
		entertainmentpanel.add(CementTrail);
		
		//creates button groups
		entertainmentserviceprice.add(threedollar3);
		entertainmentserviceprice.add(twodollar3);
		entertainmentserviceprice.add(onedollar3);
		
		trail.add(GrassTrail);
		trail.add(DirtTrail);
		trail.add(CementTrail);
		
		//creates labels for entertainment panel
		JLabel Price_1_1_2 = new JLabel("Price");
		Price_1_1_2.setBounds(11, 19, 30, 16);
		Price_1_1_2.setForeground(Color.WHITE);
		Price_1_1_2.setFont(new Font("Arial", Font.PLAIN, 13));
		Price_1_1_2.setBackground(Color.WHITE);
		entertainmentpanel.add(Price_1_1_2);
		entertainmentpanel.setBackground(new Color(0, 0, 128));
		entertainmentpanel.setVisible(false);
		
		JLabel SensitiveGroups = new JLabel("Sensitive Groups");
		SensitiveGroups.setForeground(Color.WHITE);
		SensitiveGroups.setFont(new Font("Arial", Font.PLAIN, 13));
		SensitiveGroups.setBackground(Color.WHITE);
		SensitiveGroups.setBounds(11, 202, 123, 16);
		entertainmentpanel.add(SensitiveGroups);
		
		JLabel LiveSportingEvent = new JLabel("Live Sporting Event");
		LiveSportingEvent.setForeground(Color.WHITE);
		LiveSportingEvent.setFont(new Font("Arial", Font.PLAIN, 13));
		LiveSportingEvent.setBackground(Color.WHITE);
		LiveSportingEvent.setBounds(11, 309, 131, 16);
		entertainmentpanel.add(LiveSportingEvent);
		
		JLabel ExerciseTrails = new JLabel("Exercise Trails");
		ExerciseTrails.setForeground(Color.WHITE);
		ExerciseTrails.setFont(new Font("Arial", Font.PLAIN, 13));
		ExerciseTrails.setBackground(Color.WHITE);
		ExerciseTrails.setBounds(108, 19, 108, 16);
		entertainmentpanel.add(ExerciseTrails);
		
		JLabel entertainmentprint = new JLabel("");
		entertainmentprint.setHorizontalAlignment(SwingConstants.CENTER);
		entertainmentprint.setBounds(23, 340, 300, 36);
		entertainmentprint.setFont(new Font("Arial", Font.PLAIN, 25));
		panel_4.add(entertainmentprint);
		
		JLabel entertainmentsource = new JLabel("");
		entertainmentsource.setForeground(new Color(255, 255, 255));
		entertainmentsource.setHorizontalAlignment(SwingConstants.CENTER);
		entertainmentsource.setBounds(49, 270, 243, 16);
		panel_4.add(entertainmentsource);
		
		//creates checkboxes for entertainment panel
		JCheckBox Indoor = new JCheckBox("Indoor");
		Indoor.setForeground(new Color(255, 255, 255));
		Indoor.setBounds(6, 136, 128, 23);
		entertainmentpanel.add(Indoor);
		
		JCheckBox Outdoor = new JCheckBox("Outdoor");
		Outdoor.setForeground(new Color(255, 255, 255));
		Outdoor.setBounds(6, 161, 128, 23);
		entertainmentpanel.add(Outdoor);
			
		JCheckBox ChildFriendly = new JCheckBox("Child Friendly");
		ChildFriendly.setForeground(Color.WHITE);
		ChildFriendly.setBounds(6, 244, 128, 23);
		entertainmentpanel.add(ChildFriendly);
		
		JCheckBox PetFriendly = new JCheckBox("Pet Friendly");
		PetFriendly.setForeground(Color.WHITE);
		PetFriendly.setBounds(6, 219, 128, 23);
		entertainmentpanel.add(PetFriendly);
		
		JCheckBox DisabilityFriendly = new JCheckBox("Disability Friendly");
		DisabilityFriendly.setForeground(Color.WHITE);
		DisabilityFriendly.setBounds(6, 267, 156, 23);
		entertainmentpanel.add(DisabilityFriendly);
			
		// shows the source of the picture
		JLabel entertainmentpic = new JLabel("");
		entertainmentpic.setHorizontalAlignment(SwingConstants.CENTER);
		entertainmentpic.setBounds(9, 56, 314, 248);
		panel_4.add(entertainmentpic);
		entertainmentpic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (entertainmentselected!="")
				{
					entertainmentsource.setText("Picture By "+ entertainmentselected);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				entertainmentsource.setText("");
			}
		});
			
		//gives user an entertainment option 
		JButton entertainmentgo = new JButton("→");
		entertainmentgo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] park = {"Harada Heritage Park", "Cedar Creek Park", "River Walk Park", "American Heroes Park",  "Half Moon Park", "McCune Family Park"};
				if (threedollar3.isSelected())
				{
					entertainmentprint.setText("SilverLakes");
					entertainmentpic.setIcon(silverlakes);
					entertainmentselected = "SilverLakes Tournaments";
				}
				else if (GrassTrail.isSelected())
				{
					entertainmentprint.setText("Orchard Park");
					entertainmentpic.setIcon(orchard);
					entertainmentselected = "JCSD";
				}	
				else if (twodollar3.isSelected())
				{
					entertainmentprint.setText("Edwards Theaters");
					entertainmentpic.setIcon(movie);
					entertainmentselected = "InNorco";
				}	
				else
				{
					String p = park[(int)Math.floor(Math.random()*(5-0+1)+0)];
					entertainmentprint.setText(p);
					if (p.equals("Harada Heritage Park"))
					{
						entertainmentpic.setIcon(harada);
					}
					else if (p.equals("Cedar Creek Park"))
					{
						entertainmentpic.setIcon(cedar);
					}
					else if (p.equals("River Walk Park"))
					{
						entertainmentpic.setIcon(river);
					}
					else if (p.equals("American Heroes Park"))
					{
						entertainmentpic.setIcon(american);
					}
					else if (p.equals("Half Moon Park"))
					{
						entertainmentpic.setIcon(halfmoon);
					}
					else if (p.equals("McCune Family Park"))
					{
						entertainmentpic.setIcon(mccune);
					}
					entertainmentselected = "JCSD";
				}	
				}
			});
			
			//when users click on YELP button they will be taken to a YELP review
			JButton entertainmentyelp = new JButton("YELP Reviews");
			entertainmentyelp.setBounds(300, 354, 248, 40);
			entertainmentpanel.add(entertainmentyelp);
			personalyelp.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (pyelp.equals("Mes Amies Nail & Beauty Spa"))
					{
						try {
							Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/mes-amies-nails-and-beauty-spa-eastvale-2").toURI());
						}
						catch (Exception e1)
						{}
					}
					else if (pyelp.equals("Revol Nail Spa"))
					{
						try {
							Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/revol-nail-spa-corona").toURI());
						}
						catch (Exception e1)
						{}
					}
					else if (pyelp.equals("Massage Envy Spa"))
					{
						try {
							Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/massage-envy-eastvale-eastvale-2").toURI());
						}
						catch (Exception e1)
						{}
					}
					else if (pyelp.equals("The Joint Chiropractic"))
					{
						try {
							Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/the-joint-chiropractic-eastvale-2").toURI());
						}
						catch (Exception e1)
						{}
					}
					else if (pyelp.equals("The Pretty Kitty"))
					{
						try {
							Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/the-pretty-kitty-eastvale").toURI());
						}
						catch (Exception e1)
						{}
					}
					else if (pyelp.equals("Great Clips"))
					{
						try {
							Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/great-clips-eastvale").toURI());
						}
						catch (Exception e1)
						{}
					}
					else if (pyelp.equals("Supercuts"))
					{
						try {
							Desktop.getDesktop().browse(new URL("https://www.yelp.com/biz/supercuts-corona-2?osq=supercuts").toURI());
						}
						catch (Exception e1)
						{}
					}
				}
			});
			
			entertainmentgo.setForeground(new Color(0, 0, 128));
			entertainmentgo.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			entertainmentgo.setBackground(new Color(0, 0, 128));
			entertainmentgo.setBounds(146, 360, 84, 34);
			entertainmentpanel.add(entertainmentgo);
			
			//returns back to main page
			JButton entertainmentgo_1 = new JButton("←");
			entertainmentgo_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					entertainmentpanel.setVisible(false);
					choosing.setVisible(true);
					lightbluetop.setVisible(true);
				}
			});
			entertainmentgo_1.setForeground(new Color(0, 0, 128));
			entertainmentgo_1.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
			entertainmentgo_1.setBackground(new Color(0, 0, 128));
			entertainmentgo_1.setBounds(36, 360, 84, 34);
			entertainmentpanel.add(entertainmentgo_1);
			
			JLabel Seating = new JLabel("Seating");
			Seating.setForeground(Color.WHITE);
			Seating.setFont(new Font("Arial", Font.PLAIN, 13));
			Seating.setBackground(Color.WHITE);
			Seating.setBounds(11, 117, 123, 16);
			entertainmentpanel.add(Seating);
			
			JLabel welcomelabel = new JLabel("JUST PIN IT");
			welcomelabel.setBounds(160, 50, 283, 50);
			contentPane.add(welcomelabel);
			welcomelabel.setFont(new Font("Verdana", Font.PLAIN, 35));
			welcomelabel.setHorizontalAlignment(SwingConstants.CENTER);
			
		}
	}
