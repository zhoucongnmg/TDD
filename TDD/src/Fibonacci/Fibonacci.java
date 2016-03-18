package Fibonacci;

public class Fibonacci {
	int valueOfIndex(int index){
		if(index == 0)
			return 0;
		else if(index == 1)
			return 1;
		return
			this.valueOfIndex(index-1) + this.valueOfIndex(index-2);
	}
}
