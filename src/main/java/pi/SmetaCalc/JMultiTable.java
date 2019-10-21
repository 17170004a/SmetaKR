package pi.SmetaCalc;


import javax.swing.table.AbstractTableModel;
/*
 * JMultiTable это класс, предназначенный дл¤ создани¤ абстрактных таблиц, которые в свою очередь
 * вывод¤тс¤ на экран, и не измен¤ют содержимое
 * 
 * */

public class JMultiTable extends AbstractTableModel{
	//данные	 
	String data[][];
	//названи¤ столбцев
	private String title[];
	//конструктор абстрактной таблицы
	public JMultiTable(String data[][],String title[]) {
		this.data=data;
		this.title=title;
	}
	//метод замен¤ет содержимое
	public void setContent(String data[][],String title[]){
		this.data=data;
		this.title=title;
	}
	//получает им¤ столбца(вызываетс¤ при перерисовке)
	public String getColumnName(int c) {
		 return title[c];
	}

	//возвращает количество колонок(нужно дл¤ прорисовки)
	
	public int getColumnCount() {
			// TODO Auto-generated method stub
			return title.length;
	}
	//возвращает количество строк(нужно дл¤ прорисовки)
	
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}
	//возвращает содержимое ¤чейки(нужно дл¤ прорисовки)
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	//возврашает редактируетс¤ ¤чейка или нет
	public boolean isCellEditable(int rowIndex,int columnIndex) {
		return false;	
	}

}

