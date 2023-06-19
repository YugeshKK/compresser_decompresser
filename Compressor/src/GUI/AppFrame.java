package GUI;

import java.awt.event.*;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;

public class AppFrame extends JFrame implements ActionListener {
	
	JButton compressButton;
	JButton decompressButton;
	
	AppFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		decompressButton= new JButton("Decompress");
		decompressButton.setBounds(500,200,120, 40);
		decompressButton.addActionListener(this);
		this.add(decompressButton);
		
		compressButton= new JButton("Compress");
		compressButton.setBounds(300,200, 120, 40);
		compressButton.addActionListener(this);	
		this.add(compressButton);
		
		
		
		this.setLayout(null);
		this.setSize(1000, 500);
		this.getContentPane().setBackground(Color.black);
		this.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==compressButton) {
			JFileChooser fileChooser= new JFileChooser();
			int response= fileChooser.showSaveDialog(null);
			if(response==JFileChooser.APPROVE_OPTION){
				File file= new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.print(file.getName());
				try {
					compressor.method(file);
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee.toString());
				}
			}
		}
		
		if(e.getSource()==decompressButton) {
			JFileChooser fileChooser= new JFileChooser();
			int response= fileChooser.showSaveDialog(null);
			if(response==JFileChooser.APPROVE_OPTION){
				File file= new File(fileChooser.getSelectedFile().getAbsolutePath());
				System.out.print(file);
				try {
					decompressor.method(file);
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee.toString());
				}
			}
		}
	}
}
