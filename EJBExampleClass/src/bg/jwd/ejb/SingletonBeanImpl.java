package bg.jwd.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class SingletonBeanImpl implements SingletonBean {

	private int counter = 0;
	@Override
	public String singletonHelloWorld() {
		// TODO Auto-generated method stub
		return "Singlton counter " + counter++;
	}
	@PostConstruct
	public void postConstruct(){
		System.out.println("Singleton Post Construct");
	}

}
