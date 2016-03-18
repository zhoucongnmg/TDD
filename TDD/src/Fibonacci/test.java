package Fibonacci;

import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void testFibonacci() {
		Fibonacci fib = new Fibonacci();
//		assertEquals(0, fib.valueOfIndex(0));
//		assertEquals(1, fib.valueOfIndex(1));
		int[][] cases = {{0,0},{1,1},{2,1},{3,2}};
		for (int[] is : cases) {
			assertEquals(is[1], fib.valueOfIndex(is[0]));
		}
		
	}

}
