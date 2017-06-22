package bg.jwd.ejb;

import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class StatelessHelloWorldImpl implements StatelessHelloWorld{
	
	
	Date stateDate = new Date();
	private int counter = 0;
	@Override
	public String helloStatelessEjb(String ipaddress) {
		
		return "IP Address is "+ ipaddress +" " + stateDate +"counter" + + counter++;
	}

}
