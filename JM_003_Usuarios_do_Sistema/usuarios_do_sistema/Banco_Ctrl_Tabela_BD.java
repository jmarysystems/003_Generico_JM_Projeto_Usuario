package usuarios_do_sistema;

import br.com.jmary.home.jpa.DB_Bean;
import usuarios_do_sistema_beans.UsuarioSistema;

/**
 *
 * @author ana
 */
public class Banco_Ctrl_Tabela_BD {
    
    // VERIFICAR A TABELA BEANS
    // @Table(name = "AREA", catalog = "", schema = "JM")
    
    public static UsuarioSistema Classe_Bean_Recebida;
    
    public static String schema = "JM."; //"alone"; //network
    public static String tabela = "USUARIO_SISTEMA"; //"derby"; "mysql"
    public static String tabela_imagem = "USUARIO_IMAGENS"; //"derby"; "mysql"

    public static String get() {
        
        if( DB_Bean.tipoDeBanco.equals( "derby" ) ){
            
            return schema+tabela;
        }
        else{
            
            return tabela;
        }
    }
    
    public static String get_schema() {
        
        if( DB_Bean.tipoDeBanco.equals( "derby" ) ){
            
            return schema;
        }
        else{
            
            return "";
        }
    }
    
    public static String get_imagem() {
        
        if( DB_Bean.tipoDeBanco.equals( "derby" ) ){
            
            return schema+tabela_imagem;
        }
        else{
            
            return tabela_imagem;
        }
    }
        
}