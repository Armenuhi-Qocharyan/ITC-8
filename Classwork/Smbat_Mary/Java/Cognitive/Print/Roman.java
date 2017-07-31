package Print;
public class Roman {
	public static void print(int n) {
		if(n < 0 || n > 3999){
			System.out.println("ERROR! NUmber must be between 1 and 3999 (0 to quit): ");
		} else if(n > 0) {
			String roman = convertNumberToNumeral(n);
			System.out.println("Your number in roman numeral format is: " + roman);
		}
	}

	private static String convertNumberToNumeral(int n) {
		String romanOnes = ("");
		String romanTens = ("");
		String romanHundreds = ("");
		String romanThousands = ("");
		int ones = n % 10;
		int tens2 = n / 10;
		if (tens2 < 10)
		{
			tens2 = n / 10;
		}
		else {
			tens2 = tens2 % 100;
		}
		int tens = tens2;

		int hundreds2 = n / 100;
		if (hundreds2 < 10)
		{
			hundreds2 = n / 10;
		}
		else {
			hundreds2 = hundreds2 % 1000;
		}

		int hundreds = hundreds2;

		int thousands2 = n / 1000;
		if (thousands2 < 10)
		{
			thousands2 = n / 10;
		}
		else {
			thousands2 = thousands2 % 10000;
		}

		int thousands = n & 10000;
		{
			if (ones == 0)
			{
				romanOnes = ("");
			}
			else if (ones == 1)
			{
				romanOnes = ("I");
			}
			else if (ones == 2)
			{
				romanOnes = ("II");
			}
			else if(ones == 3)
			{
				romanOnes = ("III");
			}
			else if(ones == 4)
			{
				romanOnes = ("IV");
			}
			else if(ones == 5)
			{
				romanOnes = ("V");
			}
			else if(ones == 6)
			{
				romanOnes = ("VI");
			}
			else if(ones == 7)
			{
				romanOnes = ("VII");
			}
			else if(ones == 8)
			{
				romanOnes = ("VIII");
			}
			else if(ones == 9)
			{
				romanOnes = ("IX");
			}
		}
		{
			if (tens == 0)
			{
				romanTens = ("");
			}
			else if (tens == 1)
			{
				romanTens = ("X");
			}
			else if (tens == 2)
			{
				romanTens = ("XX");
			}
			else if(tens == 3)
			{
				romanTens = ("XXX");
			}
			else if(tens == 4)
			{
				romanTens = ("XL");
			}
			else if(tens == 5)
			{
				romanTens = ("L");
			}
			else if(tens == 6)
			{
				romanTens = ("LX");
			}
			else if(tens == 7)
			{
				romanTens = ("LXX");
			}
			else if(tens == 8)
			{
				romanTens = ("LXXX");
			}
			else if(tens == 9)
			{
				romanTens = ("XC");
			}
		}
		{
			if (hundreds == 0)
			{
				romanHundreds = ("");
			}
			else if (hundreds == 1)
			{
				romanHundreds = ("C");
			}
			else if (hundreds == 2)
			{
				romanHundreds = ("CC");
			}
			else if(hundreds == 3)
			{
				romanHundreds = ("CCC");
			}
			else if(hundreds == 4)
			{
				romanHundreds = ("CD");
			}
			else if(hundreds == 5)
			{
				romanHundreds = ("D");
			}
			else if(hundreds == 6)
			{
				romanHundreds = ("DC");
			}
			else if(hundreds == 7)
			{
				romanHundreds = ("DCC");
			}
			else if(hundreds == 8)
			{
				romanHundreds = ("DCCC");
			}
			else if(hundreds == 9)
			{
				romanHundreds = ("CM");
			}
		}
		{
			if (thousands == 0)
			{
				romanThousands = ("");
			}
			else if (thousands == 1)
			{
				romanThousands = ("M");
			}
			else if (thousands == 2)
			{
				romanThousands = ("MM");
			}
			else if(thousands == 3)
			{
				romanThousands = ("MMM");
			}
		}
		String roman = (romanThousands + romanHundreds + romanTens + romanOnes);
		return roman;
	}
}
