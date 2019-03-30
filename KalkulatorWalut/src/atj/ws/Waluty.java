package atj.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

@Path("waluty")
public class Waluty {

	@GET
	@Path("{table}/{code}/{topCount}")
	public String hello(@PathParam("table") String table, @PathParam("code") String code, @PathParam("topCount") Long topCount) {
		
		Client client = ClientBuilder.newClient();
		
		ExchangeRatesSeries response = client
			.target("http://api.nbp.pl/api/exchangerates")
			.path("/rates/" + table + "/" + code + "/last/" + topCount)
			.request("application/xml")
        	.get(ExchangeRatesSeries.class);
		
		return calculateAvg(response);
	}

	private String calculateAvg(ExchangeRatesSeries e) {
		List<Rate> rates = e.getRates();
		Double average = 0d;
		for (Rate rate : rates) {
			average = average+rate.getMid();
		}
		average = average/rates.size();
		
		
		return average.toString();
	}
}
