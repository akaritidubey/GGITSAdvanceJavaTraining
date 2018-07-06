package webDynamic;

public class Calculator {
	public String Hello(String Name){
		String res= "";
		
		res="Hello"+Name;
		
		return res;
	}
	
	public int Add(int a, int b){
		return (a+b);
	}
	public int Subtract(int a, int b){
		if (a>b){
		return a-b;
		}
		else{
			return b-a;
		}
	}
	public int Multiply(int a, int b){
		return a*b;
	}
	public int Divide(int a, int b){
		if (a>b){
			return a/b;
			}
			else{
				return b/a;
			}
	}
}
