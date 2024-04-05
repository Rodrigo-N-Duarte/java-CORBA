import CalculadoraApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import CalculadoraApp.CalculadoraPOA;

import java.util.Properties;

class HelloImpl extends CalculadoraPOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public double soma(double a, double b) {
        return a + b;
    }


    @Override
    public double subtracao(double a, double b) {
        return a - b;
    }


    @Override
    public double multiplicacao(double a, double b) {
        return a * b;
    }


    @Override
    public double divisao(double a, double b) {
        return a / b;
    }


    @Override
    public double potencia(double a, double b) {
        return Math.pow(a, b);
    }


    @Override
    public double raiz(double a, double b) {
        return Math.pow(a, 1 / b);
    }


    @Override
    public double logaritmo(double a, double b) {
        return Math.log(a) / Math.log(b);
    }


    @Override
    public double modulo(double a, double b) {
        return a % b;
    }

    // implementação do método shutdown()
    public void shutdown() {
        orb.shutdown(false);
    }
}


public class CalculadoraServer {

    public static void main(String args[]) {
        try{
            // Criação e inicialização do ORB
            ORB orb = ORB.init(args, null);

            // obtém a referência do rootpoa e ativa o POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // cria o servant e registra com o ORB
            HelloImpl helloImpl = new HelloImpl();
            helloImpl.setORB(orb);

            // obtém referência do objeto servant
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Calculadora href = CalculadoraHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            // Especifica o servidor de nomes(INS)
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Especifica uma referência de objeto
            String name = "Hello";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("HelloServer ready and waiting ...");

            // Aguarda a invocação de clientes
            orb.run();
        }

        catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("HelloServer Exiting ...");
    }
}
