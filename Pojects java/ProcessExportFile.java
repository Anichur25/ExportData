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


	public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2)
	{

		for(CSVRecord rec : parser)
		{
			if(rec.get("Exports").contains(exportItem1) && rec.get("Exports").contains(exportItem2))
			{
				System.out.println(rec.get("Country"));
			}
		}
	}

	public int numberOfExporters(CSVParser parser, String string) 
	{
		int exporters = 0;
		for(CSVRecord record : parser)
		{
			if(record.get("Exports").contains(string))
			{
				exporters++;
			}
		}
		return exporters;
	}

	public void bigExporters(CSVParser parser, String string)
	{
		String x = string.replace("$", "");
		x = x.replaceAll(",", "");
		long i = Long.parseLong(x);

		for(CSVRecord record : parser)
		{
			String a = record.get("Value (dollars)");
			String b = a.replace("$", "");
			b = b.replaceAll(",", "");
			long j = Long.parseLong(b);
			if(j > i)
			{
				System.out.println(record.get("Country") + " " + record.get("Value (dollars)"));
			}
		}

	}


	public void tester()
	{
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		System.out.println("Number of exporters : " + numberOfExporters(parser,"gold"));

		String sp = countryInfo(parser,"Malaysia");
		listExportersTwoProducts(parser,"gold","diamonds");
		System.out.println(sp);
		bigExporters(parser, "$999,999,999");
	}

	public static void main(String[] args) {

		ProcessExportFile test = new ProcessExportFile();

		test.tester();

	}

}
