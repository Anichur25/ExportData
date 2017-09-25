import org.apache.commons.csv.*;
import edu.duke.*;

public class ProcessExportFile {


	public String countryInfo(CSVParser parser,String country)
	{
		String result = "NOT FOUND";

		for(CSVRecord rec : parser)
		{
			if(rec.get(0).equals(country))
			{
				result = rec.get(0) + " : " + rec.get(1) + " : " + rec.get(2);
				break;
			}


		}


		return result;
	}


	/*public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
	{

		for(CSVRecord rec : parser)
		{
			if(rec.get(1).contains(exportItem1) && rec.get(1).contains(exportItem2))
			{
				System.out.println(rec.get(0));
			}
		}
	}*/


	public void tester()
	{
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();

		String sp = countryInfo(parser,"Malaysia");
		//listExportersTwoProducts(parser,"gold","diamonds");

		System.out.println(sp);
	}

	public static void main(String[] args) {

		ProcessExportFile test = new ProcessExportFile();

		test.tester();

	}

}
