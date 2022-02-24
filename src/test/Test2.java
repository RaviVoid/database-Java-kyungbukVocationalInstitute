package test;

import test.dao.Simple2DAO;

public class Test2 {

	public static void main(String[] args) {
		Simple2DAO dao = new Simple2DAO();
		dao.create();
		System.out.println("너어쪄");
		//dao.read();
		//System.out.println("읽어쪄");
		//dao.update();
		//System.out.println("덮어쪄");
		//dao.delete();
		//System.out.println("지워쪄");
	}

}
