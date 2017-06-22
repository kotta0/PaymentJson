package bg.jwd.ejb;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful
public class StatefullHelloWorldImpl implements StatefullHelloWorld {

	private int counter = 0 ;
	private List<String> dateList = new ArrayList<>();
	@Override
	public String helloStatefullEjb() {
		dateList.add(new Date().toString());
		// TODO Auto-generated method stu
		return "HelloWorld from StateFull " + counter++ + "Date List time "+ Arrays.toString(dateList.toArray()) ;
	}
	@PrePassivate
	public void beforePassivate(){
		System.out.println("Statefull Before Passivate");
	}
	@PostConstruct
	public void postConstruct(){
		System.out.println("Statefull Post Construct");
	}

}
