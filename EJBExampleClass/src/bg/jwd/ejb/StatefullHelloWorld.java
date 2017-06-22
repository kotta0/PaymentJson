package bg.jwd.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

@Local
public interface StatefullHelloWorld {
	String helloStatefullEjb();

}
