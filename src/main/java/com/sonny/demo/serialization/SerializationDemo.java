package com.sonny.demo.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {

		// Object serialization 物件序列化
		try {
			MyClass object1 = new MyClass("Hello", 32139604, 2.7e10);
			System.out.println("物件1: " + object1);
			FileOutputStream fos = new FileOutputStream("d:/Cat.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object1);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Object deserialization 物件反序列化
        try {
            MyClass object2;
            FileInputStream fis = new FileInputStream("d:/Cat.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            object2 = (MyClass) ois.readObject();
            ois.close();
            System.out.println("物件2: " + object2);
        } catch (Exception e) {
        }

	}

}
