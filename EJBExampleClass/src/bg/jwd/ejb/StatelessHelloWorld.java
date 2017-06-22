package bg.jwd.ejb;

import javax.ejb.Local;

@Local
public interface StatelessHelloWorld {
String helloStatelessEjb(String ipaddress);
}
