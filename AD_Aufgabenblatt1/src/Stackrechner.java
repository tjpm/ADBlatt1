import javax.swing.JOptionPane;

public class Stackrechner
{
	public static void main(String[] args) {
		String s = "";
		s = JOptionPane.showInputDialog(null, "Bitte gib deinen vollständig geklammerten algebraischer Ausdruck ein:");
		System.out.println(rechne(s));
	}
	
	public static int rechne(String s) {
		String ausdruck = s;
		Stack<String> operator = new Stack<String>();
		Stack<Integer> operand = new Stack<Integer>();
		while(ausdruck.length() > 0) {
			String snippet = ausdruck.substring(0, 1);
			ausdruck = ausdruck.substring(1);
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
				snippet = snippet + getDigits(ausdruck);
				ausdruck = ausdruck.substring(getDigits(ausdruck).length());
				operand.push(new Integer(snippet));
			}
			else {
				if (!snippet.equals("(")) {
					throw new IllegalArgumentException("Kein gültiger Ausdruck");
				}
			}
		}
		return operand.pop().intValue();
	}
	private static String getDigits(String s) {
		String digits = s.substring(0, 1);
		String result ="";
		int i = 1;
		while (digits.matches("[0-9]+")) {
			result = digits;
			++i;
			digits = s.substring(0, i);
		}
		return result;
	}
}
