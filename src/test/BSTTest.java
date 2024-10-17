package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BST.BST;

class BSTTest {
	BST<String,Integer> b;
	
	void setUpEmptyBST() {
		b = new BST<String,Integer>();
	}
	
	void setUpBST() {
		b = new BST<String,Integer>();
		b.add("Carlos", 12);
		b.add("Daniel", 9);
		b.add("Andrea", 11);
		b.add("Andrew", 13);
		b.add("Antoni", 7);
		b.add("Ante", 14);
		
	}
	
	@Test
	void testSearch1() {
		setUpBST();

        assertEquals("Ante", b.search(14));
	}
	@Test
	void testSearch2() {
		setUpBST();

        assertEquals("Antoni", b.search(7));
	}
	

	@Test
	void testAdd1() {
		setUpBST();
		
		b.add("Sujeto de prueba", 19);

        assertEquals("Sujeto de prueba", b.search(19));
	}
	
	@Test
	void testAdd2() {
		setUpEmptyBST();
		
		b.add("Sujeto de prueba", 19);

        assertEquals("Sujeto de prueba", b.search(19));
	}
	
	@Test
	void testAdd3() {
		setUpBST();
		
		
		b.add("Problema", 12);
		b.add("Sujeto de prueba", 19);
		b.add("Sujeto de choque", 19);

        assertEquals("Sujeto de prueba", b.search(19));
	}
	@Test
	void testDelete1() {
		setUpBST();
		
		b.delete(12);

        assertNotEquals("Carlos", b.search(12));
	}
	
	@Test
	void testDelete2() {
		setUpEmptyBST();
		
		b.add("Problema", 12);
		b.add("Sujeto de prueba", 18);
		b.add("Sujeto de choque", 19);
		b.delete(12);

        assertEquals("Sujeto de prueba", b.search(18));
	}

}
