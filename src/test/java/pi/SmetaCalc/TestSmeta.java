package pi.SmetaCalc;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestSmeta {

	@Test
	public void test1() {
		//создали смету
		Smeta newsm=new Smeta();
		//создали материал 1
		Material m1=new Material(3,"ручка(EROS_RS286)" ,"ручка-скобка" , new ArrayList<Parametr>(), "stoimost",10);
		//задали его стоимость
		m1.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, "303.16"));
		//добавили его в смету
		newsm.addMaterial(m1);

		//создали материал 2
		Material m2=new Material(3,"брус(дуб20x20x100)" ,"пиломатериалы" , new ArrayList<Parametr>(), "stoimost",4);
		//задали его стоимость
		m2.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, "150.50"));
		//добавили его в смету
		newsm.addMaterial(m2);
		
		//получаем результат
		String res=newsm.result();
		//сравниваем с правильным
		System.out.println("Тест 1. Пример 1: "+res);
		assertEquals(Double.valueOf(res),Double.valueOf(3633.6));
		//создали материал 3
		Material m3=new Material(3,"ножка" ,"фурнитура" , new ArrayList<Parametr>(), "stoimost",5);
		//задали его стоимость
		m3.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, "50.00"));
		//добавили его в смету
		newsm.addMaterial(m3);
		
		//получаем результат
		res=newsm.result();
		//сравниваем с правильным
		System.out.println("Тест 1. Пример 2: "+res);
		assertEquals(Double.valueOf(res),Double.valueOf(3883.6));
		
		//создали материал 4 на основе 3-го
		Material m4=m3.copy();
		//изменяем количество на 1
		m4.setCount(1);
		//изменяем стоимость
		m4.setValues(new String[] {"110.00"});
		//добавили материал к смете
		newsm.addMaterial(m4);
		
		//получаем результат
		res=newsm.result();
		System.out.println("Тест 1. Пример 3: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(3993.6));
		//создали материал 5 на основе 3-го
		Material m5=new Material(3,"сборка" ,"услуги" , new ArrayList<Parametr>(), "stoimost",1);
		//задали его стоимость
		m5.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, "300у.00"));

		//добавили материал 5 к смете
		newsm.addMaterial(m5);
		//получаем результат
		res=newsm.result();
		System.out.println("Тест 1. Пример 4: "+res);
		//сравниваем с правильным
		assertEquals(res,"Произошла ошибка при вычисления стоимости (строка 4)");
	}
	@Test
	public void test2() {
		
		//создали смету
		Smeta newsm=new Smeta();
		//получаем результат (для пустой сметы)
		String res=newsm.result();
		System.out.println("Тест 2. Пример 1: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(0.));
		
		//создали материал 1
		Material m1=new Material(3,"Подушка" ,"подушки" , new ArrayList<Parametr>(), "stoimost",2);
		//задали его стоимость
		m1.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, "400.00"));
		//добавили его в смету
		newsm.addMaterial(m1);
		//получаем результат
		res=newsm.result();
		System.out.println("Тест 2. Пример 2: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(800.));
		
		//изменяем стоимость материала m1
		m1.setValues(new String[] {"500.00"});
		//получаем результат
		res=newsm.result();
		System.out.println("Тест 2. Пример 3: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(1000.));
		
		//изменяем количество
		m1.setCount(3);
		//получаем результат
		res=newsm.result();
		System.out.println("Тест 2. Пример 4: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(1500.));	
	}
	@Test
	public void test3() {
		Object testdata[][]=new Object[][] {
			{1,"Материал1","имякласса",5,"100.20"},
			{2,"Материал2","имякласса",1,"250.00"},
			{3,"Материал3","имякласса",1,"350.00"},
			{4,"Материал4","имякласса",2,"200.00"},
			{5,"Материал5","имякласса",10,"20.00"},
			{6,"Материал6","имякласса",100,"2.00"},
			{7,"Материал7","имякласса",1,"1000.00"},
			{8,"Материал8","имякласса",8,"30.00"}
		};
		//создали смету
		Smeta newsm=new Smeta();
		
		for(int i=0;i<testdata.length;i++) {
			//создали материал
			Material m1=new Material((int)testdata[i][0],(String)testdata[i][1],(String)testdata[i][2],new ArrayList<Parametr>(),"stoimost",(int)testdata[i][3]);
			//задали его стоимость
			m1.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, (String)testdata[i][4]));
			//добавили в смету
			newsm.addMaterial(m1);
		}
		//получаем результат (для пустой сметы)
		String res=newsm.result();
		System.out.println("Тест 3. Пример 1: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(3141.0));
		
	}
	@Test
	public void test4() {
		Object testdata[][]=new Object[][] {
			{0,"Материал1","имякласса",10,"100.00"},
			{1,"Материал2","имякласса",8,"200.00"},
			{2,"Материал3","имякласса",6,"300.00"},
			{3,"Материал4","имякласса",4,"400.00"},
			{4,"Материал5","имякласса",2,"500.00"},
			
		};
		//создали смету
		Smeta newsm=new Smeta();
		
		for(int i=0;i<testdata.length;i++) {
			//создали материал
			Material m1=new Material((int)testdata[i][0],(String)testdata[i][1],(String)testdata[i][2],new ArrayList<Parametr>(),"stoimost",(int)testdata[i][3]);
			//задали его стоимость
			m1.addParametr(new Parametr("Стоимость", "stoimost", TypeName.floatType, (String)testdata[i][4]));
			//добавили в смету
			newsm.addMaterial(m1);
		}
		//получаем результат (для пустой сметы)
		String res=newsm.result();
		System.out.println("Тест 4. Пример 1: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(7000.0));
		
		//удаляем пятый материал
		newsm.deleteMaterial(4);
		
		//получаем результат 
		res=newsm.result();
		System.out.println("Тест 4. Пример 2: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(6000.0));
		//удаляем первый материал
		newsm.deleteMaterial(0);
		//удаляем первый материал
		newsm.deleteMaterial(0);
		//удаляем первый материал
		newsm.deleteMaterial(0);
		//удаляем первый материал
		newsm.deleteMaterial(0);
		
		//получаем результат 
		res=newsm.result();
		System.out.println("Тест 4. Пример 3: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(0.0));
	}
	@Test
	public void test5() {
		
		//создали смету
		Smeta newsm=new Smeta();
		//создали склад
		Store newstr=new Store();
		//выбираем первый материал
		newstr.selectMaterial(0);
		Material localm=newstr.getActionMaterial().copy();
		//задаем количество
		localm.setCount(2);
		//добавляем в смету
		newsm.addMaterial(localm);
		//получаем результат 
		String res=newsm.result();
		System.out.println("Тест 5. Пример 1: "+res);
		//сравниваем с правильным
		assertEquals(Double.valueOf(res),Double.valueOf(606.32));
	}
}
