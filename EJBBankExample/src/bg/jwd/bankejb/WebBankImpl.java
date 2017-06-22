package bg.jwd.bankejb;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateful;


@Stateful
public class WebBankImpl implements WebBank {

	private static final Map<String,Double> bankAccounts = new HashMap<>();
	private static final Map<String,Double> totalWithdraws = new HashMap<>();

	@Override
	public String updated() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  Double withdraw(String client,Double withdraw) {
		Double currentAmount = bankAccounts.get(client);
		if (currentAmount== null){
			currentAmount = 0.0;
		}
		if(withdraw>=currentAmount*0.5){
			return 0.0;
			}
			currentAmount=currentAmount-withdraw;
		return currentAmount;
		}
		//
	

	@Override
	public Double deposit(String client, Double deposit) {
		Double currentAmount = bankAccounts.get(client);
		if (currentAmount== null){
			currentAmount = 0.0;
		}
			currentAmount = deposit +currentAmount;
			bankAccounts.put(client, currentAmount);
		
		
		
		return currentAmount;
	}

	
	

}
