import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import corbaBanque.Compte;
import corbaBanque.IBanqueRemot;
import corbaBanque.IBanqueRemotHelper;
public class ClientCORBA {
public static void main(String[] args) {
try {
Context ctx = new InitialContext();// chercher le context JNDI
System.out.println("Initialiser le Context JNDI ....");
Object ref = ctx.lookup("BANQUE");// recuperer la reference du service
System.out.println("Chercher la référence de l'objet distant BANQUE ");
IBanqueRemot stub = IBanqueRemotHelper.narrow((org.omg.CORBA.Object)
ref);// caster la reference
System.out.println("Caster la référence en un Objet IBanqueRemot ....");
System.out.println("23 EURO = " + stub.conversion(23) + " en DA ");
Compte cp = stub.getCompte(3);
System.out.println("crer un compte ....");
System.out.println("code =" + cp.code);
System.out.println(" Solde =" + cp.solde);
} catch (NamingException e) {
e.printStackTrace();
}
}
}