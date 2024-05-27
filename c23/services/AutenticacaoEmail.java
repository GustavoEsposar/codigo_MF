package c23.services;

public class AutenticacaoEmail {
    
    public boolean ehUmEmailCorreto(String email){
        return contemArroba(email) && temLocalEDominioNoEmail(email);
    }

    private boolean contemArroba(String email) {
        int len = email.length();
        for (int i = 1; i <= len; i++) {
            if (email.substring(i-1, i).equals("@")) {
                return true;
            }
        }
        return false;
    }

    private boolean temLocalEDominioNoEmail(String email) {
        String[] partes = dividir(email, "@");
        return partes.length == 2 &&
               partes[0].length() >= 1 &&
               partes[1].length() >= 1 &&
               partes[1].length() > 4 &&
               partes[1].endsWith(".com");
    }

    private String[] dividir(String valor, String delimitador) {
        int len = valor.length();
        int pos = 0;
        for (int i = 1; i <= len; i++) {
            if (valor.substring(i-1, i).equals(delimitador)) {
                pos = i;
                break;
            }
        }

        String[] partes = new String[2];
        partes[0] = valor.substring(0, pos - 1);
        partes[1] = valor.substring(pos, len);
        return partes;
    }
}
