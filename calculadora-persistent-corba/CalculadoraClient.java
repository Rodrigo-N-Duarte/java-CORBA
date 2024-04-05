import CalculadoraApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class CalculadoraClient {
    static Calculadora calculadoraImpl;

    public static void main(String args[]) {
        double firstValue = Double.parseDouble(args[0]), secondValue = Double.parseDouble(args[1]);
        OperacaoEnum operacao = OperacaoEnum.valueOf(args[2]);
        try {
            // Cria e inicializa o ORB
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Hello";
            calculadoraImpl = CalculadoraHelper.narrow(ncRef.resolve_str(name));

            System.out.println("-----------------------------");
            System.out.println("O valor da operação " + operacao + " de " + firstValue + " e " + secondValue + " é " +
             operacao.calcular(firstValue, secondValue, calculadoraImpl));
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}
