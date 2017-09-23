package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class FooTest {

	@Test
	public void testF1() {
		Foo foo = new Foo();
		foo.f1();
	}
	
	@Test
	public void testF2() {
		Foo foo = new Foo();
		foo.f2();
	}

}
