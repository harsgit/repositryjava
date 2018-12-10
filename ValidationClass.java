import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationClass {
	
	public boolean validatePname(String name)
	{
		
		Pattern pattern = Pattern.compile("[A-Z][a-z]{9}");
		Matcher matcher = pattern.matcher(name);
		boolean validate=matcher.matches();
		return validate;
			
		
			
	}
	public boolean validatePrice(int Price)
	{
		String StringPrice=Integer.toString(Price);
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(StringPrice);
		boolean validate=matcher.matches();
		return validate;
			
		
			
	}

}
