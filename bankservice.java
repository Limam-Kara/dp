package Servant;
import corbaBanque.Compte;
import corbaBanque.IBanqueRemotPOA;
public class BanqueServiceImpl extends IBanqueRemotPOA{
@Override
public double conversion(double mt) {
// TODO Auto-generated method stub
return mt*215;
}
@Override
public Compte getCompte(int code) {
// TODO Auto-generated method stub
return new Compte(code, Math.random()*3000);
}
}