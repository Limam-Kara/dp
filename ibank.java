module corbaBanque {
struct Compte {
long code;
double solde;
};
interface IBanqueRemot {
double conversion(in double mt);
Compte getCompte(in long code);
};}