package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Calculator extends JFrame{


	JPanel p;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bminus,bplus,bmul,bdiv,bmod,bclear,bcal;
	JTextField ansbar,num1bar,num2bar;
	StringBuilder sb = new StringBuilder("");
	long num1=0,num2=0;
	byte mark=1;
	String op="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Calculator();
		
	}
	
	public Calculator()
	{
		this.setSize(600,400);				
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Calculator");
		
		p = new JPanel();
		p.setLayout( new GridBagLayout());
		
		ListenForButton lb = new ListenForButton();
		
		ansbar = new JTextField("0",7);
		num1bar  = new JTextField("",7);
		num2bar  = new JTextField("",7);
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		bminus = new JButton("-");
		bplus = new JButton("+");
		bdiv = new JButton("/");
		bmod = new JButton("%");
		bmul = new JButton("*");
		bclear= new JButton("CE");
		bcal = new JButton("switch");
		
		b1.addActionListener(lb);
		b2.addActionListener(lb);
		b3.addActionListener(lb);
		b4.addActionListener(lb);
		b5.addActionListener(lb);
		b6.addActionListener(lb);
		b7.addActionListener(lb);
		b8.addActionListener(lb);
		b9.addActionListener(lb);
		b0.addActionListener(lb);
		bplus.addActionListener(lb);
		bminus.addActionListener(lb);
		bmul.addActionListener(lb);
		bclear.addActionListener(lb);
		bcal.addActionListener(lb);
		bdiv.addActionListener(lb);

		Font f = new Font("Serif",Font.PLAIN , 22);
		
		ansbar.setEditable(false);
		ansbar.setHorizontalAlignment(JTextField.RIGHT);
		ansbar.setFont(f);
		
		num1bar.setEditable(false);
		num1bar.setHorizontalAlignment(JTextField.RIGHT);
		num1bar.setFont(f);
		num2bar.setEditable(false);
		num2bar.setHorizontalAlignment(JTextField.RIGHT);
		num2bar.setFont(f);
		
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth =1;
		constraints.gridheight=1;
		constraints.weightx=100;
		constraints.weighty=100;
		
		
		
		constraints.insets= new Insets(5, 5, 5, 5);
		constraints.fill=GridBagConstraints.BOTH;
		
		p.add(num1bar,constraints);
		constraints.gridx=3;
		constraints.gridy=1;
		p.add(num2bar,constraints);
		constraints.gridx=5;
		constraints.gridy=1;
		constraints.gridwidth= 4;
		p.add(ansbar,constraints);
		
		constraints.gridx=1;
		constraints.gridy=2;
		constraints.gridwidth= 1;
		p.add(bclear,constraints);
		constraints.gridx=3;
		constraints.gridy=2;
		
		p.add(b0,constraints);
		constraints.gridx=5;
		constraints.gridy=2;
		
		p.add(bdiv,constraints);
		
		constraints.gridx=7;
		constraints.gridy=2;
		p.add(bmul,constraints);
		
		constraints.gridx=1;
		constraints.gridy=3;
		p.add(b9,constraints);
		
		constraints.gridx=3;
		constraints.gridy=3;
		p.add(b8,constraints);
		
		constraints.gridx=5;
		constraints.gridy=3;
		p.add(b7,constraints);
		
		constraints.gridx=7;
		constraints.gridy=3;
		p.add(bplus,constraints);
		
		constraints.gridx=1;
		constraints.gridy=4;
		p.add(b6,constraints);
		
		constraints.gridx=3;
		constraints.gridy=4;
		p.add(b5,constraints);
		
		constraints.gridx=5;
		constraints.gridy=4;
		p.add(b4,constraints);
		
		constraints.gridx=7;
		constraints.gridy=4;
		p.add(bminus,constraints);
		
		constraints.gridx=1;
		constraints.gridy=5;
		p.add(b3,constraints);
		
		constraints.gridx=3;
		constraints.gridy=5;
		p.add(b2,constraints);
		
		constraints.gridx=5;
		constraints.gridy=5;
		p.add(b1,constraints);
		
		constraints.gridx=7;
		constraints.gridy=5;
		p.add(bcal,constraints);
		
		
		this.add(p);
		this.setVisible(true);
		
		
	}

private class ListenForButton implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==bcal)
			{
				if(mark==1)
				{
				    mark = 2;
				    sb.delete(0, sb.length());
				    sb.append(num2bar.getText());
				}
				else
				{
					mark=1;
					sb.delete(0, sb.length());
				    sb.append(num1bar.getText());
				}
			}
			if(e.getSource()!=bclear && e.getSource()!=bplus && e.getSource()!=bcal && e.getSource()!=bminus &&e.getSource()!=bmul &&e.getSource()!=bdiv)
			{
				sb.append(e.getActionCommand());
				if(mark==1)
					num1bar.setText(sb.toString());
				else
					num2bar.setText(sb.toString());
				
			}
			if(e.getSource()==bplus || e.getSource()==bminus || e.getSource()==bdiv || e.getSource()==bmul)
			{
				
				num1 = Long.parseLong(num1bar.getText());
				num2 = Long.parseLong(num2bar.getText());
				switch(e.getActionCommand())
				{
				case "+" : ansbar.setText(String.valueOf(num1+num2));
							break;
				case "-" : ansbar.setText(String.valueOf(num1-num2));
							break;
				case "*" : ansbar.setText(String.valueOf(num1*num2));
							break;
				case "/" : ansbar.setText(String.valueOf(num1/num2));
							break;
				default : break;
				}
			}
			
			if(e.getSource()==bclear){
				sb.delete(0,sb.length());
				num1bar.setText("");
				num2bar.setText("");
			}
			
			
	}

}
}


