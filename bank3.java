
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA_2_3.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import Servant.BanqueServiceImpl;
public class ServeurCORBA {
public static void main(String[] args) {
try {
org.omg.CORBA.ORB orb = ORB.init(args, null);
System.out.println("CRéer l'ORB ....");
/// intialisation de l’ORB
POA rootPOA=
POAHelper.narrow(orb.resolve_initial_references("RootPOA"));// récupérer le POA
System.out.println("Récupérer le POA ...");
//caster l'objet ou la référence en objet POA en utlilisant narrow qui
permet de caster les objet CORBA
rootPOA.the_POAManager().activate(); // Activer le POA
System.out.println("Activer le POA ....");
BanqueServiceImpl od = new BanqueServiceImpl();// Créer l'objet distant
System.out.println("creer Objet CORBA ....");
Context ctx = new InitialContext();// crear l'annuair jndi
System.out.println("Initialiser l'annuair JNDI ....");
Object ref = rootPOA.servant_to_reference(od); //générer la référence
ctx.rebind("BANQUE", ref);// publier la référence
System.out.println("Publier l'Objet CORBA ....");
orb.run();// démarrer l'ORB
} catch (InvalidName | AdapterInactive | NamingException |
ServantNotActive | WrongPolicy e) {
e.printStackTrace();
}
}
}