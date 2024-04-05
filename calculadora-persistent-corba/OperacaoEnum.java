import CalculadoraApp.Calculadora;

public enum OperacaoEnum {
    SOMA {
        @Override
        public double calcular(double a, double b, Calculadora CalculadoraImpl) {
            return CalculadoraImpl.soma(a,b);
        }
    }, 
    SUBTRACAO {
        @Override
        public double calcular(double a, double b, Calculadora CalculadoraImpl) {
            return CalculadoraImpl.subtracao(a,b);
        }
    }, 
    MULTIPLICACAO {
        @Override
        public double calcular(double a, double b, Calculadora CalculadoraImpl) {
            return CalculadoraImpl.multiplicacao(a,b);
        }
    }, 
    DIVISAO {
        @Override
        public double calcular(double a, double b, Calculadora CalculadoraImpl) {
            return CalculadoraImpl.divisao(a,b);
        }
    }, 
    POTENCIA {
        @Override
        public double calcular(double a, double b, Calculadora CalculadoraImpl) {
            return CalculadoraImpl.potencia(a,b);
        }
    }, 
    RAIZ {
        @Override
        public double calcular(double a, double b, Calculadora CalculadoraImpl) {
            return CalculadoraImpl.raiz(a,b);
        }
    }, 
    LOGARITMO {
        @Override
        public double calcular(double a, double b, Calculadora CalculadoraImpl) {
            return CalculadoraImpl.logaritmo(a,b);
        }
    }, 
    MODULO {
        @Override
        public double calcular(double a, double b, Calculadora CalculadoraImpl) {
            return CalculadoraImpl.modulo(a,b);
        }
    };

    public double calcular(double a, double b, Calculadora CalculadoraImpl) {
        return 0;
    }
}
