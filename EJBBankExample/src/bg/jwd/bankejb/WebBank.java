package bg.jwd.bankejb;

import javax.ejb.Local;

@Local
public interface WebBank {
	
	String updated();
	Double withdraw(String client,Double withdraw);
	Double deposit(String client,Double deposit) ;
	

}
