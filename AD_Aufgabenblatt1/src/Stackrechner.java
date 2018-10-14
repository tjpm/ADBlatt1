import javax.swing.JOptionPane;

public class Stackrechner
{
//	private static Stack<T> _operator;
//	private static Stack<T> _operand;
	
	
	
	public static void main(String[] args) {
		Stack<String> operator = new Stack<String>();
		Stack<Integer> operand = new Stack<Integer>();
		String s = "";
		s = JOptionPane.showInputDialog(null, "Bitte gib deinen vollständig geklammerten algebraischer Ausdruck ein:");
//		operator.push(s);
//		operand.push(igd);
		while(s.length() > 0) {
			String snippet = s.substring(0, 1);
			s = s.substring(1);
			if (snippet.matches("[)]")) {
				
				int partResult = 0;
				char ch = operator.pop().charAt(0);
				switch (ch) {
					case '+': 	
						partResult = operand.pop().intValue() + operand.pop().intValue();
						break;
					case '*': 	
						partResult = operand.pop().intValue() * operand.pop().intValue();	
						break;
					case '-': 	
						partResult = 0 - operand.pop().intValue() + operand.pop().intValue();
						break;
					case '/': 	
						partResult = operand.pop().intValue();
						partResult = operand.pop().intValue() / partResult;
				}
				
				
				operand.push(new Integer(partResult));
			}
			else if (snippet.matches("[+-/*]")) {
				operator.push(snippet);
			}
			else if (snippet.matches("[0-9]")) {
				operand.push(new Integer(snippet));
			}
			else {
				if (!snippet.equals("(")) {
					throw new IllegalArgumentException("Kein gültiger Ausdruck");
				}
				
			}
		}
		System.out.println(operand.pop().intValue());
	}
	
	
	public void rechne(String s) {
		
	}
}
