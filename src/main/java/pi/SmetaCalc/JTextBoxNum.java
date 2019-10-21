package pi.SmetaCalc;

import java.awt.event.KeyEvent;

import javax.swing.JTextField;
/*
 *  ласс JTextBoxNum позвол¤ет создовать текстовые пол¤ 
 * целочисленного типа.
 * »з объ¤влени¤ класса ¤сно что это, в первую очередь, текстовое поле.
 * 
 * */
public class JTextBoxNum extends JTextField{
	//максимальна¤ длина
	private int maxlen=6;
	JTextBoxNum(){
		
		//ƒобавл¤ем слушатель
		addKeyListener(new java.awt.event.KeyAdapter() {
	 	     //данный метод сработает когда будет нажата кнопка при фокусе на текстовом поле
	 	      public void keyTyped(KeyEvent e) {
	 	        //обработка нажати¤ именно символьной кнопки
	 	    	 char ch=e.getKeyChar();
	 	    	 //здесь будут отбрасыватьс¤ символы не ¤вл¤ющиес¤ цифрами
	 	    	 if(ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9'){
	 	    		//а также ограничение длины
	 	    		 if(getText().length()==maxlen){
		 	    		 //отбрасываем символ
	 	    			e.consume();
		 	    	}
	 	    	 }else{
	 	    		 //отбрасываем символ
	 	    		e.consume();
	 	    	 }
	 	      }

	 	    });
	}
	

}

