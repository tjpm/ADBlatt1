import javax.swing.JOptionPane;

public class Stackrechner
{
//	private static Stack<T> _operator;
//	private static Stack<T> _operand;
	
	
	
	public static void main(String[] args) {
		Stack<String> operator = new Stack<String>();
		Stack<Integer> operand = new Stack<Integer>();
		String s = "";
		Integer igd = new Integer(21);
		s = JOptionPane.showInputDialog(null, s);
		operator.push(s);
		operand.push(igd);
	}
	
	
	public void rechne() {
		
	}
}
