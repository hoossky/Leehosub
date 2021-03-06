package com.jse.grade;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class GradeView extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
    private Container container; 
    private JLabel title,nameLabel,koreanLabel,englishLavel,
    				mathLabel,javaLabel; 
    private JTextField nameText, koreanText, englishText, mathText,
    					javaText; 
    private JTextArea resultText; 
    private JButton saveButton, listButton;
	GradeService gradeService;
	public GradeView() {
		gradeService = new GradeServiceImpl();
	}
	public void open() {
		
		gradeService = new GradeServiceImpl();
    	setTitle("Swing Exercise"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        container = getContentPane(); 
        container.setLayout(null); 
  
        title = new JLabel("성적 관리"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        container.add(title); 
  
        nameLabel = new JLabel("이 름"); 
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nameLabel.setSize(100, 20); 
        nameLabel.setLocation(100, 100); 
        container.add(nameLabel); 
  
        nameText = new JTextField(); 
        nameText.setFont(new Font("맑은고딕", Font.PLAIN, 15)); 
        nameText.setSize(190, 20); 
        nameText.setLocation(200, 100); 
        container.add(nameText); 
  
        koreanLabel = new JLabel("국 어"); 
        koreanLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        koreanLabel.setSize(100, 20); 
        koreanLabel.setLocation(100, 150); 
        container.add(koreanLabel); 
  
        koreanText = new JTextField(); 
        koreanText.setFont(new Font("맑은고딕", Font.PLAIN, 15)); 
        koreanText.setSize(150, 20); 
        koreanText.setLocation(200, 150); 
        container.add(koreanText); 
  
        englishLavel = new JLabel("영 어"); 
        englishLavel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        englishLavel.setSize(100, 20); 
        englishLavel.setLocation(100, 200); 
        container.add(englishLavel); 
        
        englishText = new JTextField(); 
        englishText.setFont(new Font("맑은고딕", Font.PLAIN, 15)); 
        englishText.setSize(150, 20); 
        englishText.setLocation(200, 200); 
        container.add(englishText);
  
        mathLabel = new JLabel("수 학"); 
        mathLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mathLabel.setSize(100, 20); 
        mathLabel.setLocation(100, 250); 
        container.add(mathLabel); 
        
        mathText = new JTextField(); 
        mathText.setFont(new Font("맑은고딕", Font.PLAIN, 15)); 
        mathText.setSize(150, 20); 
        mathText.setLocation(200, 250); 
        container.add(mathText);
  
        javaLabel = new JLabel("자 바"); 
        javaLabel.setFont(new Font("Arial", Font.PLAIN, 20)); 
        javaLabel.setSize(100, 20); 
        javaLabel.setLocation(100, 300); 
        container.add(javaLabel); 
        
        javaText = new JTextField(); 
        javaText.setFont(new Font("맑은고딕", Font.PLAIN, 15)); 
        javaText.setSize(150, 20); 
        javaText.setLocation(200, 300); 
        container.add(javaText);
        
  
        saveButton = new JButton("저 장"); 
        saveButton.setFont(new Font("Arial", Font.PLAIN, 15)); 
        saveButton.setSize(100, 20); 
        saveButton.setLocation(150, 450);
        saveButton.addActionListener(this);
        container.add(saveButton); 
  
        listButton = new JButton("목 록"); 
        listButton.setFont(new Font("Arial", Font.PLAIN, 15)); 
        listButton.setSize(100, 20); 
        listButton.setLocation(270, 450); 
        listButton.addActionListener(this);
        container.add(listButton); 
  
        resultText = new JTextArea(); 
        resultText.setFont(new Font("맑은고딕", Font.PLAIN, 15)); 
        resultText.setSize(300, 400); 
        resultText.setLocation(500, 100); 
        resultText.setLineWrap(true); 
        resultText.setEditable(false); 
        container.add(resultText); 
 
        setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == saveButton) {
			nameText.setText("홍길동,유관순,이순신,신사임당,이도");
			koreanText.setText("100,90,80,70,60");
			englishText.setText("100,90,80,70,60");
			mathText.setText("100,90,80,70,60");
			javaText.setText("100,90,80,70,60");
			
			String[] names = nameText.getText().split(",");
			String[] koreans = koreanText.getText().split(",");
			String[] englishs = englishText.getText().split(",");
			String[] maths = mathText.getText().split(",");
			String[] javas = javaText.getText().split(",");
			Grade[] grades = new Grade[5];
			
			for(int i=0; i<grades.length; i++) {
				grades[i] = new Grade();
				
				grades[i].setName(names[i]);
				
				grades[i].setKorean(Integer.parseInt(koreans[i]));
				grades[i].setEnglish(Integer.parseInt(englishs[i]));
				grades[i].setMath(Integer.parseInt(maths[i]));
				grades[i].setJava(Integer.parseInt(javas[i]));
				gradeService.add(grades[i]);
				
			}
			
//			String data = String.format("%s/ %s/ %s/ %s/ %s",
//					nameText.getText(),
//					koreanText.getText(),
//					englishText.getText(),
//					mathText.getText(),
//					javaText.getText());
//			
//			String[] datas = data.split("/");
//			String[] names = datas[0].split(",");
//			String[] koreans = datas[1].split(",");
//			String[] englishs = datas[2].split(",");
//			String[] maths = datas[3].split(",");
//			String[] javas = datas[4].split(",");
//			Grade[] grades = new Grade[5];
//			
//			for(int i=0; i<datas.length; i++) {
//				grades[i] = new Grade();
//				grades[i].setName(names[i]);
////				grades[i].setKorean(Integer.parseInt(koreans[i]));
////				grades[i].setEnglish(Integer.parseInt(englishs[i]));
////				grades[i].setMath(Integer.parseInt(maths[i]));
////				grades[i].setJava(Integer.parseInt(javas[i]));
//				gradeService.add(grades[i]);
//				System.out.println(grades[i]);
//			}
//			
//			
		}else if(e.getSource() == listButton) {
			Grade[] grades = gradeService.list();
			String result = "";
			for(int i=0; i < grades.length; i++) {
				result += (grades[i]+"\n");				
			}
			nameText.setText("");
			koreanText.setText("");
			englishText.setText("");
			mathText.setText("");
			javaText.setText("");
			resultText.setText(result);
	}
}
}




