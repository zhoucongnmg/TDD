package Pro_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_1 {

	@Test
	public void testMultiplication() {
		
		//1.���ȱ�ݵ��£����Բ�ͨ���������ȱ��ת��Ϊ�µĲ�������
//		Dollar five = new Dollar(5);
//		five.times(2);
//		assertEquals(10,five.amount);
//		five.times(3);
//		assertEquals(15, five.amount);
		//2.��������Զ�����д��������
//		Dollar five = new Dollar(5);
//		Dollar product = five.times(2);
//		assertEquals(10, product.amount);
//		product = five.times(3);
//		assertEquals(15, product.amount);
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}
	
	@Test
	public void testEquality(){
		//ͨ�����ǲ�����֤�����
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.dollar(5).equals(Money.franc(5)));
	}
	
	//���Ի�������
	@Test
	public void testCurrency(){
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency);
	}
	
	//���Լӷ�
	@Test
	public void testSimpleAddition(){
		//w���Ա���ת���ӷ�����д����
//		Money sum = Money.dollar(5).plus(Money.dollar(5));
//		assertEquals(Money.dollar(10), sum);
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum,"USD");
		assertEquals(Money.dollar(10), reduced);
	}
	
	//˫������Ͳ���
	@Test
	public void testPlusReturnsSum(){
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum)result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}
	
	@Test
	public void testReduceSum(){
		Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(7), reduced);
	}
	
	@Test
	public void testReduceMoney(){
		Bank bank = new Bank();
		Money reduced = bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1), reduced);
	}
	
	@Test
	public void testReduceMoneyDifferentCurrency(){
		Bank bank = new Bank();
		bank.addRate("CHF","USD",2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}
	
	@Test
	public void testMixedAddition(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
		assertEquals(Money.dollar(10), result);
	}
	
	@Test
	public void testSumPlusMoney(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrans = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks,tenFrans).plus(fiveBucks);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(15), result);
	}
	
	@Test
	public void testSumTimes(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrans = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Expression sum = new Sum(fiveBucks,tenFrans).times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
	}
	
//	@Test
//	public void testOlusSameCurrencyReturnsMoney(){
//		Expression sum = Money.dollar(1).plus(Money.dollar(1));
//		assertTrue(sum instanceof Money);
//	}
}
