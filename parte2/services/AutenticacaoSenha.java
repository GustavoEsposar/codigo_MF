package parte2.services;

public class AutenticacaoSenha {
    private static final char[] CARACTERES_ESPECIAIS = { '!', '@', '#', '$', '%', '^', '&', '*' };
    private static final char[] NUMEROS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    private static final char[] LETRAS_MAIUSCULAS = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    private static final char[] LETRAS_MINUSCULAS = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    public  boolean ehUmaSenhaSegura(String s) {
        return contemCaracterEspecial(s) &&
               contemNumero(s) &&
               contemLetraMaiuscula(s) &&
               contemLetraMinuscula(s) &&
               comprimentoSuficiente(s);
    }

    private  boolean contemCaracterEspecial(String s) {
        for (char c : s.toCharArray()) {
            for (char especial : CARACTERES_ESPECIAIS) {
                if (c == especial) {
                    return true;
                }
            }
        }
        return false;
    }

    private  boolean contemNumero(String s) {
        for (char c : s.toCharArray()) {
            for (char num : NUMEROS) {
                if (c == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private  boolean contemLetraMaiuscula(String s) {
        for (char c : s.toCharArray()) {
            for (char maiuscula : LETRAS_MAIUSCULAS) {
                if (c == maiuscula) {
                    return true;
                }
            }
        }
        return false;
    }

    private  boolean contemLetraMinuscula(String s) {
        for (char c : s.toCharArray()) {
            for (char minuscula : LETRAS_MINUSCULAS) {
                if (c == minuscula) {
                    return true;
                }
            }
        }
        return false;
    }

    private  boolean comprimentoSuficiente(String s) {
        return s.length() >= 14;
    }
}
