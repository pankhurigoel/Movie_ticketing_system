import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.io.*;

public class booking extends JFrame implements ActionListener
{
	JTextField seat, totalcost;
	Choice type, Screen, Movie; // Choices for the GUI
	JLabel typelbl, Screenlbl, Movielbl, lblbl, mblbl, rblbl, inputseatlbl, totallbl, title;
	JButton submitbut, showbut, paybut;
	String selectedMovie, total, selectedseat, selectedScreen, tickettype;
	int Moviechoice, convertedseat1, convertedseat2, totalprice;
	int totaltickets = 0, currenti;

	Seat ls1[][] = new Seat [4] [4];
	Seat ms1[][] = new Seat [4] [4];
	Seat rs1[][] = new Seat [4] [4]; // Each one of these creates an array for each Screen

	Seat ls3[][] = new Seat [4] [4];
	Seat ms3[][] = new Seat [4] [4];
	Seat rs3[][] = new Seat [4] [4];

	Seat ls5[][] = new Seat [4] [4];
	Seat ms5[][] = new Seat [4] [4];
	Seat rs5[][] = new Seat [4] [4];

	Seat ls7[][] = new Seat [4] [4];
	Seat ms7[][] = new Seat [4] [4];
	Seat rs7[][] = new Seat [4] [4];

	Seat ls9[][] = new Seat [4] [4];
	Seat ms9[][] = new Seat [4] [4];
	Seat rs9[][] = new Seat [4] [4];

	Ticket tickets[] = new Ticket[30]; //Array for storing the tickets booked

	public booking()
	{
		setSize(800,500);
		setLocation(400,200);
		setResizable(false);
		setLayout(new FlowLayout());
		
		typelbl = new JLabel("Ticket Type: ");
		typelbl.setFont(new Font("Verdana", Font.BOLD, 22));
		
                type = new Choice();
		type.add("Gold");
		type.add("Silver");
		
                Screenlbl = new JLabel("Screen:");
		Screenlbl.setFont(new Font("Verdana", Font.BOLD, 22));
                
		Screen = new Choice();
		Screen.add("Screen 1");
		Screen.add("Screen 2");
		Screen.add("Screen 3");
                
		Movielbl = new JLabel("Movie: ");
		Movielbl.setFont(new Font("Verdana", Font.BOLD, 22));
                
		Movie = new Choice();
		Movie.add("Movie 1");
		Movie.add("Movie 2");
		Movie.add("Movie 3");
		Movie.add("Movie 4");
		Movie.add("Movie 5");
                
		paybut = new JButton("Pay");
		paybut.setBackground(Color.white);
		
		inputseatlbl = new JLabel ("Enter Seat Num: ");
		inputseatlbl.setFont(new Font("Verdana", Font.BOLD, 22));

                seat = new JTextField(2);
		seat.setFont(new Font("Verdana", Font.BOLD, 20));
		seat.setHorizontalAlignment(seat.CENTER);
                
		totallbl = new JLabel ("Total Price: ");
		totallbl.setFont(new Font("Verdana", Font.BOLD, 22));
		
                totalcost = new JTextField(7);
		totalcost.setFont(new Font("Verdana", Font.BOLD, 22));
		totalcost.setHorizontalAlignment(totalcost.CENTER);
		totalcost.setEditable(false);
		
                submitbut = new JButton("Submit");
		submitbut.setBackground(Color.white);
		
                showbut = new JButton("Show");
		showbut.setBackground(Color.white);

		/* The following delcarations
		initialise the variables for
		the positions of the Screens */

		int xleft = 0;
		int yleft = 0;
		int xmid = 0;
		int ymid = 0;
		int xright = 0;
		int yright = 0;


		xleft = 50;
		yleft = 310; //Initial positions
		int totalls1 = 0; 

		for (int i = 0; i < ls1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ls1[i][j]=new Seat(totalls1, 0, xleft, yleft);
				xleft += 50; //Moving the next seat along the x position by 50
				totalls1 ++; //Adding one to the total for the next seat
			}
			xleft = 50; //Moving back to the left for the next row
			yleft += 30; //Moving down for the next row
		}

		xmid = 300;
		ymid = 310; //Initial positions
		int totalms1 = 0; //Total and is used to label the seats
		for (int i = 0; i < ms1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ms1[i][j]=new Seat(totalms1, 0, xmid, ymid);
				xmid += 50; //Moving the next seat along the x position by 50
				totalms1 ++; //Adding one to the total for the next seat
			}
			xmid = 300; //Moving back to the left for the next row
			ymid += 30;  //Moving down for the next row
		}

		xright = 550;
		yright = 310; //Initial positions
		int totalrs1 = 0; //'Total' is the total and is used to label the seats
		for (int i = 0; i < rs1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rs1[i][j]=new Seat(totalrs1, 0, xright, yright);
				xright += 50; //Moving the next seat along the x position by 50
				totalrs1 ++; //Adding one to the total for the next seat
			}
			xright = 550; //Moving back to the left for the next row
			yright += 30; //Moving down for the next row
		}

		/* The next lines of code perform the same processes as the ones before such as positions for each Screen */

		xleft = 50;
		yleft = 310;
		int totalls3 = 0;

		for (int i = 0; i < ls3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ls3[i][j]=new Seat(totalls3, 0, xleft, yleft);
				xleft += 50;
				totalls3 ++;
			}
			xleft = 50;
			yleft += 30;
		}

		xmid = 300;
		ymid = 310;
		int totalms3 = 0;
		for (int i = 0; i < ms3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ms3[i][j]=new Seat(totalms3, 0, xmid, ymid);
				xmid += 50;
				totalms3 ++;
			}
			xmid = 300;
			ymid += 30;
		}

		xright = 550;
		yright = 310;
		int totalrs3 = 0;
		for (int i = 0; i < rs3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rs3[i][j]=new Seat(totalrs3, 0, xright, yright);
				xright += 50;
				totalrs3 ++;
			}
			xright = 550;
			yright += 30;
		}


		xleft = 50;
		yleft = 310;
		int totalls5 = 0;

		for (int i = 0; i < ls5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ls5[i][j]=new Seat(totalls5, 0, xleft, yleft);
				xleft += 50;
				totalls5 ++;
			}
			xleft = 50;
			yleft += 30;
		}

		xmid = 300;
		ymid = 310;
		int totalms5 = 0;
		for (int i = 0; i < ms5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ms5[i][j]=new Seat(totalms5, 0, xmid, ymid);
				xmid += 50;
				totalms5 ++;
			}
			xmid = 300;
			ymid += 30;
		}

		xright = 550;
		yright = 310;
		int totalrs5 = 0;
		for (int i = 0; i < rs5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rs5[i][j]=new Seat(totalrs5, 0, xright, yright);
				xright += 50;
				totalrs5 ++;
			}
			xright = 550;
			yright += 30;
		}


		xleft = 50;
		yleft = 310;
		int totalls7 = 0;

		for (int i = 0; i < ls7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ls7[i][j]=new Seat(totalls7, 0, xleft, yleft);
				xleft += 50;
				totalls7 ++;
			}
			xleft = 50;
			yleft += 30;
		}

		xmid = 300;
		ymid = 310;
		int totalms7 = 0;
		for (int i = 0; i < ms7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ms7[i][j]=new Seat(totalms7, 0, xmid, ymid);
				xmid += 50;
				totalms7 ++;
			}
			xmid = 300;
			ymid += 30;
		}

		xright = 550;
		yright = 310;
		int totalrs7 = 0;
		for (int i = 0; i < rs7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rs7[i][j]=new Seat(totalrs7, 0, xright, yright);
				xright += 50;
				totalrs7 ++;
			}
			xright = 550;
			yright += 30;
		}

		xleft = 50;
		yleft = 310;
		int totalls9 = 0;

		for (int i = 0; i < ls9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ls9[i][j]=new Seat(totalls9, 0, xleft, yleft);
				xleft += 50;
				totalls9 ++;
			}
			xleft = 50;
			yleft += 30;
		}

		xmid = 300;
		ymid = 310;
		int totalms9 = 0;
		for (int i = 0; i < ms9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				ms9[i][j]=new Seat(totalms9, 0, xmid, ymid);
				xmid += 50;
				totalms9 ++;
			}
			xmid = 300;
			ymid += 30;
		}

		xright = 550;
		yright = 310;
		int totalrs9 = 0;
		for (int i = 0; i < rs9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rs9[i][j]=new Seat(totalrs9, 0, xright, yright);
				xright += 50;
				totalrs9 ++;
			}
			xright = 550;
			yright += 30;
		}
		/* Adding the labels and text boxes to the Screen */

		
		getContentPane().add(typelbl);
		getContentPane().add(type);
		getContentPane().add(Screenlbl);
		getContentPane().add(Screen);
		getContentPane().add(Movielbl);
		getContentPane().add(Movie);
		getContentPane().add(showbut);
		getContentPane().add(inputseatlbl);
		getContentPane().add(seat);
		getContentPane().add(submitbut);
		getContentPane().add(totallbl);
		getContentPane().add(totalcost);
		getContentPane().add(paybut);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Color mycolor = new Color(255,255,255);
		getContentPane().setBackground(mycolor);

		submitbut.addActionListener(this);
		showbut.addActionListener(this); //Action listener for each individual button
		paybut.addActionListener(this);
	}
	public void paint(Graphics graf)
	{
		super.paint(graf);

		switch(Moviechoice)
		{
			case 1:
				for (int i = 0; i < ls1.length; i++) //Looping throw the leftside at 1 Screen - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						ls1[i][j].display(graf); //Displaying the left side @ 1
						ms1[i][j].display(graf); //Displaying the mid side @ 1
						rs1[i][j].display(graf); //Displaying the right side @ 1
					}
				}
				break;
			case 3:
				for (int i = 0; i < ls3.length; i++) //Looping through the leftside at 3 Screen - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						ls3[i][j].display(graf); //Displaying the left side @ 3
						ms3[i][j].display(graf); //Displaying the mid side @ 3
						rs3[i][j].display(graf); //Displaying the right side @ 3
					}
				}
				break;
			case 5:
				for (int i = 0; i < ls5.length; i++) //Looping through the leftside at 5 Screen - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						ls5[i][j].display(graf); //Displaying the left side @ 5
						ms5[i][j].display(graf); //Displaying the mid side @ 5
						rs5[i][j].display(graf); //Displaying the right side @ 5
					}
				}
				break;
			case 7:
				for (int i = 0; i < ls7.length; i++) //Looping through the leftside at 7 Screen - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						ls7[i][j].display(graf); //Displaying the left side @ 7
						ms7[i][j].display(graf); //Displaying the mid side @ 7
						rs7[i][j].display(graf); //Displaying the right side @ 7
					}
				}
				break;
			case 9:
				for (int i = 0; i < ls9.length; i++) //Looping through the leftside at 9 Screen - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						ls9[i][j].display(graf); //Displaying the left side @ 9
						ms9[i][j].display(graf); //Displaying the mid side @ 9
						rs9[i][j].display(graf); //Displaying the right side @ 9
					}
				}
				break;
			default:
			/* Used as what appears when the program starts */
				for (int i = 0; i < ls1.length; i++) //Looping through the leftside at 1 Screen - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						ls1[i][j].display(graf); //Displaying the left side @ 1
						ms1[i][j].display(graf); //Displaying the mid side @ 1
						rs1[i][j].display(graf); //Displaying the right side @ 1
					}
				}
				break;
		}
	}
	public void actionPerformed(ActionEvent ev)
	{
		selectedScreen = Screen.getSelectedItem(); //The values neeeded to book seats and check for availability taken from text boxes
		selectedMovie = Movie.getSelectedItem();
		tickettype = type.getSelectedItem();

		if (ev.getSource() == submitbut)
		{
			selectedseat = seat.getText();
			int selectseat = Integer.parseInt(selectedseat); //Getting the seat number and converting it to an integer

			/* The following set of if statements checks for seat number and converts it
			to an X, Y position which can be used for booking */

			if (selectseat == 0)
				{convertedseat1 = 0;
				convertedseat2 = 0;}
			if (selectseat == 1)
				{convertedseat1 = 0;
				convertedseat2 = 1;}
			if (selectseat == 2)
				{convertedseat1 = 0;
				convertedseat2 = 2;}
			if (selectseat == 3)
				{convertedseat1 = 0;
				convertedseat2 = 3;}
			if (selectseat == 4)
				{convertedseat1 = 1;
				convertedseat2 = 0;}
			if (selectseat == 5)
				{convertedseat1 = 1;
				convertedseat2 = 1;}
			if (selectseat == 6)
				{convertedseat1 = 1;
				convertedseat2 = 2;}
			if (selectseat == 7)
				{convertedseat1 = 1;
				convertedseat2 = 3;}
			if (selectseat == 8)
				{convertedseat1 = 2;
				convertedseat2 = 0;}
			if (selectseat == 9)
				{convertedseat1 =2;
				convertedseat2 = 1;}
			if (selectseat == 10)
				{convertedseat1 = 2;
				convertedseat2 = 2;}
			if (selectseat == 11)
				{convertedseat1 = 2;
				convertedseat2 = 3;}
			if (selectseat == 12)
				{convertedseat1 = 3;
				convertedseat2 = 0;}
			if (selectseat == 13)
				{convertedseat1 = 3;
				convertedseat2 = 1;}
			if (selectseat == 14)
				{convertedseat1 = 3;
				convertedseat2 = 2;}
			if (selectseat == 15)
				{convertedseat1 = 3;
				convertedseat2 = 3;}


				if (selectedMovie == "Movie 1") //If they are trying to book a ticket for movie1
				{
				Moviechoice = 1;
				repaint();
				if (selectedScreen == "Screen 1") // If they are trying to book a seat in the Screen 1
				{
					int iftaken = ls1[convertedseat1][convertedseat2].isTaken(); //Uses the istaken() method to see if it is taken
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked"); //Seat is taken and outputs an error message
					}
					else if (iftaken == 0)
					{
						ls1[convertedseat1][convertedseat2].setSeat(); //Sets the seat to booked
						repaint(); //Re-displays it
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie); //Creates a new ticket objects in the tickets array
						int tempprice = tickets[totaltickets].getSeatPrice(); //Gets the seat price using the getSeatPrice() method
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice)); //Updates and adds to the text box
						totaltickets += 1; //Updates the total amount of tickets booked
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 2")  // If they are trying to book a seat in the Screen 2
				{
					int iftaken = ms1[convertedseat1][convertedseat2].isTaken(); //Uses the istaken() method to see if it is taken
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked"); //Seat is taken and outputs an error message
					}
					else if (iftaken == 0)
					{
						ms1[convertedseat1][convertedseat2].setSeat(); //Sets the seat to booked
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie); //Creates a new ticket objects in the tickets array
						int tempprice = tickets[totaltickets].getSeatPrice();  //Gets the seat price using the getSeatPrice() method
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice)); //Updates and adds to the text box
						totaltickets += 1; //Updates the total amount of tickets booked
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 3")  // If they are trying to book a seat in the Screen 3
				{
					int iftaken = rs1[convertedseat1][convertedseat2].isTaken(); //Uses the istaken() method to see if it is taken
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");  //Seat is taken and outputs an error message
					}
					else if (iftaken == 0)
					{
						rs1[convertedseat1][convertedseat2].setSeat(); //Sets the seat to booked
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);  //Creates a new ticket objects in the tickets array
						int tempprice = tickets[totaltickets].getSeatPrice(); //Gets the seat price using the getSeatPrice() method
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice)); //Updates and adds to the text box
						totaltickets += 1; //Updates the total amount of tickets booked
						seat.setText("");
					}
				}
			}

			/* Code is replicated for each of the Movies the user wants to book*/

			if (selectedMovie == "Movie 2")
			{
				Moviechoice = 3;
				repaint();

				if (selectedScreen == "Screen 1")
				{
					int iftaken = ls3[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						ls3[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 2")
				{
					int iftaken = ms3[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						ms3[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 3")
				{
					int iftaken = rs3[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rs3[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}

			}
			if (selectedMovie == "Movie 3")
			{
				Moviechoice = 5;
				repaint();

				if (selectedScreen == "Screen 1")
				{
					int iftaken = ls5[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						ls5[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 2")
				{
					int iftaken = ms5[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						ms5[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 3")
				{
					int iftaken = rs5[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rs5[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
			}
			if (selectedMovie == "Movie 4")
			{
				Moviechoice = 7;
				repaint();

				if (selectedScreen == "Screen 1")
				{
					int iftaken = ls7[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						ls7[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 2")
				{
					int iftaken = ms7[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						ms7[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 3")
				{
					int iftaken = rs7[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rs7[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
			}
			if (selectedMovie == "Movie 5")
			{
				Moviechoice = 9;
				repaint();

				if (selectedScreen == "Screen 1")
				{
					int iftaken = ls9[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						ls9[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 2")
				{
					int iftaken = ms9[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						ms9[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
				if (selectedScreen == "Screen 3")
				{
					int iftaken = rs9[convertedseat1][convertedseat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rs9[convertedseat1][convertedseat2].setSeat();
						repaint();
						tickets[totaltickets] = new Ticket(tickettype, selectseat, selectedScreen, selectedMovie);
						int tempprice = tickets[totaltickets].getSeatPrice();
						totalprice = totalprice + tempprice;
						totalcost.setText("Rs"+ Integer.toString(totalprice));
						totaltickets += 1;
						seat.setText("");
					}
				}
			}
		}
		if (ev.getSource() == showbut)
		{
			/* If the user has clicked the show button it sets a variable and then repaints the desired Movie */

			if (selectedMovie == "Movie 1")
			{
				Moviechoice = 1;
				repaint();
			}
			if (selectedMovie == "Movie 2")
			{
				Moviechoice = 3;
				repaint();
			}
			if (selectedMovie == "Movie 3")
			{
				Moviechoice = 5;
				repaint();
			}
			if (selectedMovie == "Movie 4")
			{
				Moviechoice = 7;
				repaint();
			}
			if(selectedMovie == "Movie 5")
			{
				Moviechoice = 9;
				repaint();
			}

		}
		if (ev.getSource() == paybut) //Pay button to generate tickets
		{

  				try{
  					FileWriter stream= new FileWriter("tickets.txt"); //Opening the tickets.txt file
  					BufferedWriter output = new BufferedWriter(stream);

					for (int i = 0; i < totaltickets; i++) //Looping through the number of tickets booked
					{
  						/* Getting the variables needed from methods related to the object */

  						int ticketnum = tickets[i].getSeatNum();
						int ticketprice = tickets[i].getSeatPrice();
						String tickettype = tickets[i].getType();
						String ticketMovie = tickets[i].getMovie();
						String ticketScreen = tickets[i].getScreen();
						String newline = System.getProperty("line.separator");

						output.write(newline);
						output.write("Ticket Details");
						output.write(newline);
						output.write(newline);
						output.write("Ticket Number: " + ticketnum); //Writing ticketnum
						output.write(newline);
						output.write("Ticket Price: " + ticketprice);
						output.write(newline);
						output.write("Ticket Type: " + tickettype);
						output.write(newline);
						output.write("Ticket Movie: " + ticketMovie);
						output.write(newline);
						output.write("Ticket Screen: " + ticketScreen);
						output.write(newline);
						output.write("____________________________________________________________________________________");
						output.write(newline);
					}
					output.close();
  					}catch (Exception e){//Catch exception if any
  					System.err.println("Error: " + e.getMessage());}

  				JOptionPane.showMessageDialog(null, "These tickets have been printed out to the file 'tickets.txt'"); //Success message

  				for(int i=0; i < tickets.length; i++)
  				{
					tickets[i] = null; //Setting the tickets array values to null so new tickets can be booked
				}
				totaltickets = 0; //Resets totaltickets to 0
				totalprice = 0; //Resets totalprice to 0
				totalcost.setText(""); //Sets totalcost to an empty text field
				seat.setText(""); //Wipes seat number text field
		}
	}
	public static void main(String args[])
	{
		Thread t = new Thread(new Runnable() {
                     public void run() {
                        try { 
                            long numMillisecondsToSleep = 40000; // time taken 40 seconds instead of 4 hours 
                            Thread.sleep(numMillisecondsToSleep); 
                        } catch (InterruptedException e) { } 
                                if(Ticket.flag1)
                                Ticket.dp();
                        }
                });
		Thread t1 = new Thread(new Runnable() {
                    public void run() {
                        new booking();
                    }
                });
		
		t.start();
		t1.start();
	}
}
class Seat
{
	private final int boxheight = 30; //Height of text box
	private final int boxwidth = 50; //Width of text box
	private int seatnumber;
	private int seattaken;
	private int x;
	private int y;

	public Seat(int number, int taken, int xstart, int ystart)
	{
		seatnumber = number; //Setting the seatnumber
		seattaken = taken; //Setting whether it is taken
		x = xstart; //Display position
		y = ystart;
	}
	public void display(Graphics graf)
	{
		int xdraw, ydraw;
		switch (seattaken)
		{
		case 0:
			xdraw = x +  boxwidth;
			ydraw = y +  boxheight;
			graf.drawRect(x,y,boxwidth,boxheight);
			graf.drawString(Integer.toString(seatnumber),x+20,y+boxheight*3/4); //Painting the seat with the seat number printed inside
			break;
		case 1:
			xdraw = x +  boxwidth;
			ydraw = y +  boxheight;
			graf.drawRect(x,y,boxwidth,boxheight);
			String msg = "N/A";
			graf.drawString(msg,x+20,y+boxheight*3/4); //Painting the seat with N/A printed inside
			break;
		default:
			break;
		}

	}
	public int isTaken()
	{
		return seattaken;
	}
	public void setSeat()
	{
		seattaken = 1;
	}
}
class Ticket
{
        public static int finalprice = 100;
	public static boolean flag1=true;
	private int price;
	private String tickettype;
	private int seatnum;
	private String Movieticket;
	private String Screenticket;

	public static void dp (){   //function for price decrement
		finalprice = (int)((double)finalprice*0.9);
	}
	public static void firstbooked(){
		flag1=false;
	}

	public Ticket (String type, int seatnumber, String Screen, String Movie)
	{
		seatnum = seatnumber; //Setting tickets seat number
		tickettype = type; //Setting ticket type
		Screenticket = Screen; //Setting Screen
		Movieticket = Movie; //Setting Movie

		if (Screenticket == "Screen 1")
		{

			if (type == "Gold")
			{
				price = (int)((double)finalprice*1.1); //Setting Gold price
			}
			if (type == "Silver")
			{
				price = finalprice; //Setting Silver price
			}
		}

		if (Screenticket == "Screen 2")
		{

			if (type == "Gold")
			{
				price = (int)((double)price*1.1); 
			}
			if (type == "Silver")
			{
				price = finalprice; 
			}
		}

		if (Screenticket == "Screen 3")
		{

			if (type == "Gold")
			{
				price = price = (int)((double)price*1.1);
			}
			if (type == "Silver")
			{
				price = finalprice; 
			}
		}
	}
	/* Get methods to print tickets */
	public int getSeatPrice()
	{
		return price;
	}
	public String getMovie()
	{
		return Movieticket;
	}
	public String getScreen()
	{
		return Screenticket;
	}
	public String getType()
	{
		return tickettype;
	}
	public int getSeatNum()
	{
		return seatnum;
	}
}