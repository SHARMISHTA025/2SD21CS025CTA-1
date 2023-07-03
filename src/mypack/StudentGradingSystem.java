package mypack;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


class IAMarksException extends Exception {
	public IAMarksException(String message) {
		super(message);
	}
}

class CtaMarksException extends Exception{
	public CtaMarksException (String message) {
		super(message);
	}


}

class SeeMarksException extends Exception{
	public SeeMarksException (String message) {
		super(message);
	}

}

class   CieMarksException extends Exception{
	public  CieMarksException (String message) {
		super(message);
	}

}






class  Form extends JFrame implements ActionListener{

	Container ContentPane;
	JButton b;
	JPanel  p;
	JLabel  l, l1, l2, l3, l4, l5, l6, l7, l8;
	JTextField  t, t1, t2, t3, t4;


	public int IA1,IA2,IA3,CTA;
	public double SEE;	 
	void Student(int IA1, int IA2, int IA3, int CTA, int SEE) {
		this.IA1 = IA1;
		this.IA2 = IA2;
		this.IA3 = IA3;
		this.CTA = CTA;
		this.SEE = SEE;
	}




	Form(String title){
		super(title);



		ContentPane = this.getContentPane();
		b = new JButton("Calculate");
		b.setSize(10,5);
		l6 = new JLabel("total Marks : ");
		l7 = new JLabel("Grade: ");
		p = new JPanel(); 
		p.setLayout(new GridLayout(7,2,10,10));



		l  = new JLabel("GRADE CACULATOR");
		l1 = new JLabel("Enter IA-1 Marks:");
		t  = new JTextField(3);
		l2 = new JLabel("Enter IA-2 Marks:");
		t1 = new JTextField(3);
		l3 = new JLabel("Enter IA-3 Marks:");
		t2 = new JTextField(3);
		l4 = new JLabel("Enter CTA Marks:");
		t3 = new JTextField(3);
		l5 = new JLabel("Enter SEE Marks:");
		t4 = new JTextField(3);

		b.addActionListener(this);

		p.add(l);
		p.add(l1);
		p.add(t);
		p.add(l2);
		p.add(t1);
		p.add(l3);
		p.add(t2);
		p.add(l4);
		p.add(t3);
		p.add(l5);
		p.add(t4);
		p.add(b);
		p.add(l6);
		p.add(l7);



		ContentPane.add(p,BorderLayout.SOUTH);
		ContentPane.add(l,BorderLayout.CENTER);

	}



	public void actionPerformed(ActionEvent e) {





		IA1=Integer.parseInt(t.getText());
		IA2=Integer.parseInt(t1.getText());
		IA3=Integer.parseInt(t2.getText());
		CTA=Integer.parseInt(t3.getText());
		SEE=Integer.parseInt(t4.getText());

		try {
			if(IA1<0 || IA1>20 || IA2<0 || IA2>20 || IA3<0 || IA3>20) {

				throw new IAMarksException(" Student IA marks should be from 0 to 20.");
			}

		}	catch (IAMarksException iae) {
			JOptionPane.showMessageDialog(p, iae.getMessage(), " Invalid Input ", JOptionPane.ERROR_MESSAGE);

		} 


		try {
			if(CTA<0 || CTA>10) {

				throw new CtaMarksException(" Student CTA marks should be from 0 to 10.");
			}

		}	catch (CtaMarksException cta) {
			JOptionPane.showMessageDialog(p, cta.getMessage(), " Invalid Input ", JOptionPane.ERROR_MESSAGE);


		}


		try {
			if(SEE<0 || SEE>100) {

				throw new SeeMarksException(" Student SEE marks should be from 0 to 100.");
			}

		}	catch (SeeMarksException see) {
			JOptionPane.showMessageDialog(p, see.getMessage(), " Invalid Input ", JOptionPane.ERROR_MESSAGE);

		} 


		int CIE;
		if (IA2 >= IA1 && IA3 >= IA1) {
			CIE = IA2 + IA3 + CTA;
		} else if (IA1 >= IA2 && IA3 >= IA2) {
			CIE = IA1 + IA3 + CTA;
		} else {
			CIE = IA1 + IA2 + CTA;
		}



		try {

			if(CIE < 20) {

				throw new CieMarksException(" Student is detained from taking SEE ");
			}

		}	catch (CieMarksException cie) {
			JOptionPane.showMessageDialog(p, cie.getMessage(), " Invalid Input ", JOptionPane.ERROR_MESSAGE);


		}    

		if(SEE==38||SEE==39) {
			SEE=40;
		}


		double totalMarks = CIE + Math.ceil( SEE/2);



		l6.setText("total Marks : " + totalMarks);

		String grade;

		if (totalMarks >= 90 && totalMarks <= 100)
			grade =	"S";
		else if (totalMarks >= 80 && totalMarks <= 89)
			grade = "A";
		else if (totalMarks >= 70 && totalMarks <= 79)
			grade = "B";
		else if (totalMarks >= 60 && totalMarks <= 69)
			grade =  "C";
		else if (totalMarks >= 50 && totalMarks <= 59)
			grade = "D";
		else if (totalMarks >= 40 && totalMarks <= 49)
			grade = "E";
		else
			grade =  "F";

		l7.setText("Grade: " + grade );

	}


}


public class StudentGradingSystem {

	public static void main(String[] args) {


		JFrame f = new  Form("Student Grading System");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setBounds(100, 100,300,300);
		f.setVisible(true);


	}
}






