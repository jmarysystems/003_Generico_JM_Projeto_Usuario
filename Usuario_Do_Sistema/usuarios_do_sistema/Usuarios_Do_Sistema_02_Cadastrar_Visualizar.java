
package usuarios_do_sistema;

import br.com.jmary.home.Home;
import br.com.jmary.home.imagens.Imagens_Internas;
import br.com.jmary.home.jpa.DAOGenericoJPA;
import br.com.jmary.home.jpa.JPAUtil;
import br.com.jmary.utilidades.Exportando;
import javax.swing.ImageIcon;
import br.com.jmary.utilidades.JOPM;
import br.com.jmary.utilidades.ValidarEmail;
import br.com.jmary.visualizador_imagens.Visualizador_Banco_de_Dados;
import home_controle_menus_norte.imagens.Imagens_Menu_Norte;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import login_do_sistema.Login;
import usuarios_do_sistema_beans.UsuarioSistema;
import usuarios_imagens_beans.UsuarioImagens;

/**
 *
 * @author AnaMariana
 */
public class Usuarios_Do_Sistema_02_Cadastrar_Visualizar extends javax.swing.JPanel {
    
    Home Home;
    String status_cadastro;
    UsuarioSistema UsuarioSistema_Recebido;
    JTabbedPane JTabbedPane_Recebido;
    
    public List<String> lista_de_Endereco_imagemExterna_ = new ArrayList<>();
    
    /** Creates new form SombraVendas
     * @param Home2
     * @param JTabbedPane_Recebido2
     * @param status_cadastro2 */
    public Usuarios_Do_Sistema_02_Cadastrar_Visualizar( Home Home2, JTabbedPane JTabbedPane_Recebido2, String status_cadastro2 ) {
        initComponents();
        
        Home = Home2;  
        status_cadastro = status_cadastro2;
        JTabbedPane_Recebido = JTabbedPane_Recebido2;
        setar_Dados_Iniciais();
    }
    
    public Usuarios_Do_Sistema_02_Cadastrar_Visualizar( Home Home2, JTabbedPane JTabbedPane_Recebido2, String status_cadastro2, UsuarioSistema UsuarioSistema_Recebido2 ) {
        initComponents();
        
        Home = Home2;  
        status_cadastro = status_cadastro2;
        UsuarioSistema_Recebido = UsuarioSistema_Recebido2;
        JTabbedPane_Recebido = JTabbedPane_Recebido2;
        
        setar_Dados_Iniciais();
    }
    
    private void setar_Dados_Iniciais(){
        new Thread() {   @Override public void run() { try {  
            
//////////////////////////////////////////////////////////////////////////////////////////////            
            imgURL  = Imagens_Menu_Norte.class.getResource("seta_para_baixo.png");
            icon    = new ImageIcon( imgURL );  
            
            imgURL2  = Imagens_Menu_Norte.class.getResource("seta_para_cima.png");
            icon2   = new ImageIcon( imgURL2 ); 
//////////////////////////////////////////////////////////////////////////////////////////////

            if(status_cadastro.equalsIgnoreCase("Cadastrando...")){
                
                btExcluir.setVisible(false);
                
                mostrar_Ocultar_Jp_Padrao_Tabela();
            }
            else if(status_cadastro.equalsIgnoreCase("Visualizando...")){
                
                btExcluir.setVisible(false);
                btSalvar.setVisible(false);
                
                setar_Visualizacao_Recebida();
                desabilitar_componentes();
                
                setarImagem_Principal();
            }
            else if(status_cadastro.equalsIgnoreCase("Alterando...")){
                
                setar_Visualizacao_Recebida();
                
                setarImagem_Principal();
            }
        } catch( Exception e ){  } } }.start();
    }
    
    public void setarImagem_Principal(){ 
    new Thread() {   @Override public void run() { try { 
        
        List<UsuarioImagens> UsuarioImagens = null;
        try{ 
            Query q = JPAUtil.em().createNativeQuery("SELECT * FROM JM.USUARIO_IMAGENS WHERE ID_USUARIO_SISTEMA = ?", UsuarioImagens.class );
            q.setParameter( 1, UsuarioSistema_Recebido.getId() );
            List<UsuarioImagens> lista_Banco = q.getResultList();   
            UsuarioImagens = lista_Banco;
        }catch( Exception e ){ }
        
        String rbusca = ""; 
        try{ rbusca = UsuarioImagens.get(0).getNome(); }catch( Exception e ){}
            
        if( !rbusca.equals("") ){	
            
	    BufferedImage bufImg = null;
            ImageIcon     icon   = null;
            Image         image  = null;
            try{
                
                bufImg = ImageIO.read(new ByteArrayInputStream( UsuarioImagens.get(0).getImagem() )); //ImageIO.read( img );
                icon   = new ImageIcon(bufImg);
                image  = icon.getImage();//ImageIO.read(f);  
            } catch (Exception ex) {} 
            
	    try{
                
                //image = icon.getImage();//ImageIO.read(f);  
                int widith = lbImagemPrincipal.getWidth();
                int height = lbImagemPrincipal.getHeight();
            
                lbImagemPrincipal.setIcon(new ImageIcon(image.getScaledInstance(
                    widith, height, Image.SCALE_DEFAULT)));
                
		//ImageIO.write(img, "PNG", new File("C:/Downloads/h.png"));
	    }catch(Exception e){ e.printStackTrace(); }          
        }
                            
    } catch( Exception e ){ } } }.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Pergunta = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jp_Padrao_Tabela = new javax.swing.JPanel();
        jpO = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        JPOpcao_14 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        JPOpcao_15 = new javax.swing.JPanel();
        lb_Cadastrado_Por = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        JPOpcao_13 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        JPOpcao_12 = new javax.swing.JPanel();
        lb_Alterado_Por = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        JPOpcao_18 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        JPOpcao_19 = new javax.swing.JPanel();
        lb_Data_Cadastro = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        JPOpcao_16 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        JPOpcao_17 = new javax.swing.JPanel();
        lb_Data_Ultima_Alteracao = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        JPOpcao_20 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        JPOpcao_21 = new javax.swing.JPanel();
        lb_Data_Ultima_Alteracao_Senha = new javax.swing.JLabel();
        jpIcon1 = new javax.swing.JPanel();
        lbImagemPrincipal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        JPOpcao_24 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        JPOpcao_25 = new javax.swing.JPanel();
        tfCodigoAuxiliar = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        JPOpcao_26 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        JPOpcao_27 = new javax.swing.JPanel();
        tf_Email = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        chPermitirAcessar = new javax.swing.JCheckBox();
        jpPermitirAcesso7 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        JPOpcao_32 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        JPOpcao_33 = new javax.swing.JPanel();
        tfSenha2 = new javax.swing.JPasswordField();
        jPanel30 = new javax.swing.JPanel();
        JPOpcao_30 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        JPOpcao_31 = new javax.swing.JPanel();
        tfSenha1 = new javax.swing.JPasswordField();
        jPanel29 = new javax.swing.JPanel();
        JPOpcao_28 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        JPOpcao_29 = new javax.swing.JPanel();
        tfLogin = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(948, 593));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1170, 1202));

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Usuários do Sistema - Cadastrar/Visualizar");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/seta_para_cima.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jpOLayout = new javax.swing.GroupLayout(jpO);
        jpO.setLayout(jpOLayout);
        jpOLayout.setHorizontalGroup(
            jpOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 913, Short.MAX_VALUE)
        );
        jpOLayout.setVerticalGroup(
            jpOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        JPOpcao_14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_14.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_14MousePressed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel68.setText("Cadastrado Por.: ");

        javax.swing.GroupLayout JPOpcao_14Layout = new javax.swing.GroupLayout(JPOpcao_14);
        JPOpcao_14.setLayout(JPOpcao_14Layout);
        JPOpcao_14Layout.setHorizontalGroup(
            JPOpcao_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        JPOpcao_14Layout.setVerticalGroup(
            JPOpcao_14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        JPOpcao_15.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_15.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_15MousePressed(evt);
            }
        });

        lb_Cadastrado_Por.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lb_Cadastrado_Por.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout JPOpcao_15Layout = new javax.swing.GroupLayout(JPOpcao_15);
        JPOpcao_15.setLayout(JPOpcao_15Layout);
        JPOpcao_15Layout.setHorizontalGroup(
            JPOpcao_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Cadastrado_Por, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_15Layout.setVerticalGroup(
            JPOpcao_15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_Cadastrado_Por, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPOpcao_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPOpcao_15, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPOpcao_14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPOpcao_13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_13.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_13MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_13MousePressed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel60.setText("Alterado Por (Última Alteração).: ");

        javax.swing.GroupLayout JPOpcao_13Layout = new javax.swing.GroupLayout(JPOpcao_13);
        JPOpcao_13.setLayout(JPOpcao_13Layout);
        JPOpcao_13Layout.setHorizontalGroup(
            JPOpcao_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        JPOpcao_13Layout.setVerticalGroup(
            JPOpcao_13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        JPOpcao_12.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_12.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_12MousePressed(evt);
            }
        });

        lb_Alterado_Por.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lb_Alterado_Por.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout JPOpcao_12Layout = new javax.swing.GroupLayout(JPOpcao_12);
        JPOpcao_12.setLayout(JPOpcao_12Layout);
        JPOpcao_12Layout.setHorizontalGroup(
            JPOpcao_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Alterado_Por, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_12Layout.setVerticalGroup(
            JPOpcao_12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_Alterado_Por, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPOpcao_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPOpcao_12, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPOpcao_13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPOpcao_18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_18.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_18MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_18MousePressed(evt);
            }
        });

        jLabel72.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel72.setText("Data Cadastro.: ");

        javax.swing.GroupLayout JPOpcao_18Layout = new javax.swing.GroupLayout(JPOpcao_18);
        JPOpcao_18.setLayout(JPOpcao_18Layout);
        JPOpcao_18Layout.setHorizontalGroup(
            JPOpcao_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        JPOpcao_18Layout.setVerticalGroup(
            JPOpcao_18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        JPOpcao_19.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_19.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_19MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_19MousePressed(evt);
            }
        });

        lb_Data_Cadastro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lb_Data_Cadastro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout JPOpcao_19Layout = new javax.swing.GroupLayout(JPOpcao_19);
        JPOpcao_19.setLayout(JPOpcao_19Layout);
        JPOpcao_19Layout.setHorizontalGroup(
            JPOpcao_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Data_Cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_19Layout.setVerticalGroup(
            JPOpcao_19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_Data_Cadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPOpcao_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPOpcao_19, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPOpcao_18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPOpcao_16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_16.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_16MousePressed(evt);
            }
        });

        jLabel70.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel70.setText("Data última Alteração.: ");

        javax.swing.GroupLayout JPOpcao_16Layout = new javax.swing.GroupLayout(JPOpcao_16);
        JPOpcao_16.setLayout(JPOpcao_16Layout);
        JPOpcao_16Layout.setHorizontalGroup(
            JPOpcao_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        JPOpcao_16Layout.setVerticalGroup(
            JPOpcao_16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        JPOpcao_17.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_17.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_17MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_17MousePressed(evt);
            }
        });

        lb_Data_Ultima_Alteracao.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lb_Data_Ultima_Alteracao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout JPOpcao_17Layout = new javax.swing.GroupLayout(JPOpcao_17);
        JPOpcao_17.setLayout(JPOpcao_17Layout);
        JPOpcao_17Layout.setHorizontalGroup(
            JPOpcao_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Data_Ultima_Alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_17Layout.setVerticalGroup(
            JPOpcao_17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_Data_Ultima_Alteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPOpcao_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPOpcao_17, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPOpcao_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPOpcao_20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_20.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_20MousePressed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel74.setText("Data última Alteração(Senha).: ");

        javax.swing.GroupLayout JPOpcao_20Layout = new javax.swing.GroupLayout(JPOpcao_20);
        JPOpcao_20.setLayout(JPOpcao_20Layout);
        JPOpcao_20Layout.setHorizontalGroup(
            JPOpcao_20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
        );
        JPOpcao_20Layout.setVerticalGroup(
            JPOpcao_20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        JPOpcao_21.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_21.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_21MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_21MousePressed(evt);
            }
        });

        lb_Data_Ultima_Alteracao_Senha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lb_Data_Ultima_Alteracao_Senha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout JPOpcao_21Layout = new javax.swing.GroupLayout(JPOpcao_21);
        JPOpcao_21.setLayout(JPOpcao_21Layout);
        JPOpcao_21Layout.setHorizontalGroup(
            JPOpcao_21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_Data_Ultima_Alteracao_Senha, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_21Layout.setVerticalGroup(
            JPOpcao_21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_Data_Ultima_Alteracao_Senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPOpcao_20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPOpcao_21, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPOpcao_20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpIcon1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpIcon1.setPreferredSize(new java.awt.Dimension(185, 200));
        jpIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpIcon1MousePressed(evt);
            }
        });

        lbImagemPrincipal.setBorder(new javax.swing.border.MatteBorder(null));
        lbImagemPrincipal.setPreferredSize(new java.awt.Dimension(184, 200));

        javax.swing.GroupLayout jpIcon1Layout = new javax.swing.GroupLayout(jpIcon1);
        jpIcon1.setLayout(jpIcon1Layout);
        jpIcon1Layout.setHorizontalGroup(
            jpIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagemPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );
        jpIcon1Layout.setVerticalGroup(
            jpIcon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImagemPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jp_Padrao_TabelaLayout = new javax.swing.GroupLayout(jp_Padrao_Tabela);
        jp_Padrao_Tabela.setLayout(jp_Padrao_TabelaLayout);
        jp_Padrao_TabelaLayout.setHorizontalGroup(
            jp_Padrao_TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jp_Padrao_TabelaLayout.createSequentialGroup()
                .addComponent(jpIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jp_Padrao_TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jp_Padrao_TabelaLayout.setVerticalGroup(
            jp_Padrao_TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_Padrao_TabelaLayout.createSequentialGroup()
                .addGroup(jp_Padrao_TabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_Padrao_TabelaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JPOpcao_24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_24.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_24MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_24MousePressed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel78.setText("Código Auxiliar.: ");

        javax.swing.GroupLayout JPOpcao_24Layout = new javax.swing.GroupLayout(JPOpcao_24);
        JPOpcao_24.setLayout(JPOpcao_24Layout);
        JPOpcao_24Layout.setHorizontalGroup(
            JPOpcao_24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        JPOpcao_24Layout.setVerticalGroup(
            JPOpcao_24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        JPOpcao_25.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_25.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_25.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_25MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_25MousePressed(evt);
            }
        });

        tfCodigoAuxiliar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfCodigoAuxiliar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tfCodigoAuxiliar.setPreferredSize(new java.awt.Dimension(209, 25));
        tfCodigoAuxiliar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfCodigoAuxiliarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfCodigoAuxiliarMouseExited(evt);
            }
        });
        tfCodigoAuxiliar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCodigoAuxiliarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_25Layout = new javax.swing.GroupLayout(JPOpcao_25);
        JPOpcao_25.setLayout(JPOpcao_25Layout);
        JPOpcao_25Layout.setHorizontalGroup(
            JPOpcao_25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCodigoAuxiliar, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_25Layout.setVerticalGroup(
            JPOpcao_25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_25Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tfCodigoAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPOpcao_24, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPOpcao_25, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPOpcao_24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        JPOpcao_26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_26.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_26MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_26MousePressed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel80.setText("Email.: ");

        javax.swing.GroupLayout JPOpcao_26Layout = new javax.swing.GroupLayout(JPOpcao_26);
        JPOpcao_26.setLayout(JPOpcao_26Layout);
        JPOpcao_26Layout.setHorizontalGroup(
            JPOpcao_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
        );
        JPOpcao_26Layout.setVerticalGroup(
            JPOpcao_26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        JPOpcao_27.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_27.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_27.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_27MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_27MousePressed(evt);
            }
        });

        tf_Email.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tf_Email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(201, 239, 237), 1, true));
        tf_Email.setPreferredSize(new java.awt.Dimension(209, 25));
        tf_Email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tf_EmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tf_EmailMouseExited(evt);
            }
        });
        tf_Email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_EmailKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_27Layout = new javax.swing.GroupLayout(JPOpcao_27);
        JPOpcao_27.setLayout(JPOpcao_27Layout);
        JPOpcao_27Layout.setHorizontalGroup(
            JPOpcao_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_Email, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPOpcao_27Layout.setVerticalGroup(
            JPOpcao_27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPOpcao_26, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPOpcao_27, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPOpcao_26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chPermitirAcessar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chPermitirAcessar.setSelected(true);
        chPermitirAcessar.setText("Permitir que este usuário acesse o sistema");
        chPermitirAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chPermitirAcessarMousePressed(evt);
            }
        });
        chPermitirAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chPermitirAcessarActionPerformed(evt);
            }
        });

        jpPermitirAcesso7.setBackground(new java.awt.Color(221, 219, 242));

        jPanel31.setBackground(new java.awt.Color(221, 219, 242));

        JPOpcao_32.setBackground(new java.awt.Color(221, 219, 242));
        JPOpcao_32.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_32MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_32MousePressed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("Repita a senha");

        javax.swing.GroupLayout JPOpcao_32Layout = new javax.swing.GroupLayout(JPOpcao_32);
        JPOpcao_32.setLayout(JPOpcao_32Layout);
        JPOpcao_32Layout.setHorizontalGroup(
            JPOpcao_32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_32Layout.createSequentialGroup()
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPOpcao_32Layout.setVerticalGroup(
            JPOpcao_32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_32Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel83))
        );

        JPOpcao_33.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_33.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_33.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_33MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_33MousePressed(evt);
            }
        });

        tfSenha2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfSenha2.setBorder(null);
        tfSenha2.setPreferredSize(new java.awt.Dimension(209, 27));
        tfSenha2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfSenha2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfSenha2MouseExited(evt);
            }
        });
        tfSenha2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSenha2KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_33Layout = new javax.swing.GroupLayout(JPOpcao_33);
        JPOpcao_33.setLayout(JPOpcao_33Layout);
        JPOpcao_33Layout.setHorizontalGroup(
            JPOpcao_33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfSenha2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );
        JPOpcao_33Layout.setVerticalGroup(
            JPOpcao_33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfSenha2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_32, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(JPOpcao_33, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(JPOpcao_32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JPOpcao_33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.setBackground(new java.awt.Color(221, 219, 242));

        JPOpcao_30.setBackground(new java.awt.Color(221, 219, 242));
        JPOpcao_30.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_30MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_30MousePressed(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("Definir senha");

        javax.swing.GroupLayout JPOpcao_30Layout = new javax.swing.GroupLayout(JPOpcao_30);
        JPOpcao_30.setLayout(JPOpcao_30Layout);
        JPOpcao_30Layout.setHorizontalGroup(
            JPOpcao_30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_30Layout.createSequentialGroup()
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPOpcao_30Layout.setVerticalGroup(
            JPOpcao_30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_30Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel82))
        );

        JPOpcao_31.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_31.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_31.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_31MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_31MousePressed(evt);
            }
        });

        tfSenha1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfSenha1.setBorder(null);
        tfSenha1.setPreferredSize(new java.awt.Dimension(209, 27));
        tfSenha1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfSenha1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfSenha1MouseExited(evt);
            }
        });
        tfSenha1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSenha1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_31Layout = new javax.swing.GroupLayout(JPOpcao_31);
        JPOpcao_31.setLayout(JPOpcao_31Layout);
        JPOpcao_31Layout.setHorizontalGroup(
            JPOpcao_31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfSenha1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );
        JPOpcao_31Layout.setVerticalGroup(
            JPOpcao_31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfSenha1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPOpcao_30, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
            .addComponent(JPOpcao_31, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addComponent(JPOpcao_30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JPOpcao_31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29.setBackground(new java.awt.Color(221, 219, 242));

        JPOpcao_28.setBackground(new java.awt.Color(221, 219, 242));
        JPOpcao_28.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_28MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_28MousePressed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Login (nome de usuário)");

        javax.swing.GroupLayout JPOpcao_28Layout = new javax.swing.GroupLayout(JPOpcao_28);
        JPOpcao_28.setLayout(JPOpcao_28Layout);
        JPOpcao_28Layout.setHorizontalGroup(
            JPOpcao_28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_28Layout.createSequentialGroup()
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPOpcao_28Layout.setVerticalGroup(
            JPOpcao_28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_28Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addComponent(jLabel81))
        );

        JPOpcao_29.setBackground(new java.awt.Color(255, 255, 255));
        JPOpcao_29.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        JPOpcao_29.setPreferredSize(new java.awt.Dimension(284, 27));
        JPOpcao_29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JPOpcao_29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JPOpcao_29MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JPOpcao_29MousePressed(evt);
            }
        });

        tfLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfLogin.setBorder(null);
        tfLogin.setPreferredSize(new java.awt.Dimension(209, 25));
        tfLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfLoginMouseExited(evt);
            }
        });
        tfLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfLoginKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout JPOpcao_29Layout = new javax.swing.GroupLayout(JPOpcao_29);
        JPOpcao_29.setLayout(JPOpcao_29Layout);
        JPOpcao_29Layout.setHorizontalGroup(
            JPOpcao_29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOpcao_29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
        );
        JPOpcao_29Layout.setVerticalGroup(
            JPOpcao_29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPOpcao_29Layout.createSequentialGroup()
                .addComponent(tfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JPOpcao_28, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(JPOpcao_29, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addComponent(JPOpcao_28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JPOpcao_29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpPermitirAcesso7Layout = new javax.swing.GroupLayout(jpPermitirAcesso7);
        jpPermitirAcesso7.setLayout(jpPermitirAcesso7Layout);
        jpPermitirAcesso7Layout.setHorizontalGroup(
            jpPermitirAcesso7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPermitirAcesso7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jpPermitirAcesso7Layout.setVerticalGroup(
            jpPermitirAcesso7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chPermitirAcessar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPermitirAcesso7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chPermitirAcessar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPermitirAcesso7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_internas/ajuda.gif"))); // NOI18N
        jButton7.setText("Opções/Imagens");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton7MousePressed(evt);
            }
        });

        btSalvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens_internas/livroTp.gif"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setPreferredSize(new java.awt.Dimension(185, 31));
        btSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btSalvarMousePressed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home_controle_menus_norte/imagens/exluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setPreferredSize(new java.awt.Dimension(185, 31));
        btExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btExcluirMousePressed(evt);
            }
        });

        javax.swing.GroupLayout PerguntaLayout = new javax.swing.GroupLayout(Pergunta);
        Pergunta.setLayout(PerguntaLayout);
        PerguntaLayout.setHorizontalGroup(
            PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerguntaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp_Padrao_Tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PerguntaLayout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)))
                .addContainerGap())
        );
        PerguntaLayout.setVerticalGroup(
            PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PerguntaLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(PerguntaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jp_Padrao_Tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastrar/Visualizar", Pergunta);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   
    private URL       imgURL; 
    private ImageIcon icon;            
    private URL       imgURL2;
    private ImageIcon icon2;
    private boolean cimabaixo = true; 
    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        
        mostrar_Ocultar_Jp_Padrao_Tabela();
    }//GEN-LAST:event_jLabel3MousePressed

    private void mostrar_Ocultar_Jp_Padrao_Tabela() {                                     
        try{

            if( cimabaixo == false ){
                cimabaixo = true;
                
                jLabel3.setToolTipText( "Ocultar Submenu" );
                jLabel3.setIcon( icon2 );              
                
                jp_Padrao_Tabela.setVisible(true);
            } else if( cimabaixo == true ){
                cimabaixo = false;
                                
                jLabel3.setToolTipText( "Mostrar Submenu" );
                jLabel3.setIcon( icon );  
                
                jp_Padrao_Tabela.setVisible(false);
            }
            
        } catch( Exception e ){ JOPM JOptionPaneMod = new JOPM( 2, "tabJanelaSubmenu, \n"
                + e.getMessage() + "\n", "Alterar_Seta_Submenu" ); }       
    } 
    
    private void JPOpcao_13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_13MouseEntered

    private void JPOpcao_13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_13MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_13MouseExited

    private void JPOpcao_13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_13MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_13MousePressed

    private void JPOpcao_12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_12MouseEntered

    private void JPOpcao_12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_12MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_12MouseExited

    private void JPOpcao_12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_12MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_12MousePressed

    private void JPOpcao_14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_14MouseEntered

    private void JPOpcao_14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_14MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_14MouseExited

    private void JPOpcao_14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_14MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_14MousePressed

    private void JPOpcao_15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_15MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_15MouseEntered

    private void JPOpcao_15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_15MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_15MouseExited

    private void JPOpcao_15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_15MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_15MousePressed

    private void JPOpcao_16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_16MouseEntered

    private void JPOpcao_16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_16MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_16MouseExited

    private void JPOpcao_16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_16MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_16MousePressed

    private void JPOpcao_17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_17MouseEntered

    private void JPOpcao_17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_17MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_17MouseExited

    private void JPOpcao_17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_17MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_17MousePressed

    private void JPOpcao_18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_18MouseEntered

    private void JPOpcao_18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_18MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_18MouseExited

    private void JPOpcao_18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_18MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_18MousePressed

    private void JPOpcao_19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_19MouseEntered

    private void JPOpcao_19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_19MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_19MouseExited

    private void JPOpcao_19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_19MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_19MousePressed

    private void JPOpcao_20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_20MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_20MouseEntered

    private void JPOpcao_20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_20MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_20MouseExited

    private void JPOpcao_20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_20MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_20MousePressed

    private void JPOpcao_21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_21MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_21MouseEntered

    private void JPOpcao_21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_21MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_21MouseExited

    private void JPOpcao_21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_21MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_21MousePressed

    private void jButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MousePressed

        /*new Thread() {   @Override public void run() {*/ try { 
        
        if(status_cadastro.equalsIgnoreCase("Cadastrando...")){
                  
            Exportando = new Exportando("ABRINDO...");
            Exportando.setVisible(true);
            Exportando.pbg.setMinimum(0);
            Exportando.pbg.setMaximum( 100 );
            
            Exportando.pbg.setValue( 50 ); 
            
            Home.ControleTabs.AddTabComControle(jTabbedPane1, "Visualizador Imagens Banco de Dados", "livroTp.gif", 
                        new Visualizador_Banco_de_Dados(Home, 0, this, status_cadastro) ); 
            
            Exportando.fechar();             
        }
        else{
      
            Exportando = new Exportando("ABRINDO...");
            Exportando.setVisible(true);
            Exportando.pbg.setMinimum(0);
            Exportando.pbg.setMaximum( 100 );
            
            Exportando.pbg.setValue( 50 ); 
            
            Home.ControleTabs.AddTabComControle(jTabbedPane1, "Visualizador Imagens Banco de Dados", "livroTp.gif", 
                        new Visualizador_Banco_de_Dados(Home, UsuarioSistema_Recebido.getId(), this, status_cadastro) );   
            
            Exportando.fechar();  
        }      
            
    }catch( Exception e ){ Exportando.fechar(); e.printStackTrace(); }  //} }.start(); 
    }//GEN-LAST:event_jButton7MousePressed

    private void JPOpcao_24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_24MouseEntered

    private void JPOpcao_24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_24MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_24MouseExited

    private void JPOpcao_24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_24MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_24MousePressed

    private void tfCodigoAuxiliarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCodigoAuxiliarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoAuxiliarMouseEntered

    private void tfCodigoAuxiliarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfCodigoAuxiliarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoAuxiliarMouseExited

    private void tfCodigoAuxiliarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCodigoAuxiliarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCodigoAuxiliarKeyReleased

    private void JPOpcao_25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_25MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_25MouseEntered

    private void JPOpcao_25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_25MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_25MouseExited

    private void JPOpcao_25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_25MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_25MousePressed

    private void JPOpcao_26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MouseEntered

    private void JPOpcao_26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MouseExited

    private void JPOpcao_26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_26MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_26MousePressed

    private void tf_EmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_EmailMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EmailMouseEntered

    private void tf_EmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_EmailMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EmailMouseExited

    private void tf_EmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_EmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EmailKeyReleased

    private void JPOpcao_27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MouseEntered

    private void JPOpcao_27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MouseExited

    private void JPOpcao_27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_27MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_27MousePressed

    private void chPermitirAcessarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chPermitirAcessarMousePressed
      
    }//GEN-LAST:event_chPermitirAcessarMousePressed

    private void chPermitirAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chPermitirAcessarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chPermitirAcessarActionPerformed

    private void JPOpcao_32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_32MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_32MouseEntered

    private void JPOpcao_32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_32MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_32MouseExited

    private void JPOpcao_32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_32MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_32MousePressed

    private void tfSenha2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSenha2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenha2MouseEntered

    private void tfSenha2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSenha2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenha2MouseExited

    private void tfSenha2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSenha2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenha2KeyPressed

    private void JPOpcao_33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_33MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_33MouseEntered

    private void JPOpcao_33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_33MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_33MouseExited

    private void JPOpcao_33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_33MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_33MousePressed

    private void JPOpcao_30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_30MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_30MouseEntered

    private void JPOpcao_30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_30MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_30MouseExited

    private void JPOpcao_30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_30MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_30MousePressed

    private void tfSenha1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSenha1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenha1MouseEntered

    private void tfSenha1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfSenha1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenha1MouseExited

    private void tfSenha1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSenha1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSenha1KeyPressed

    private void JPOpcao_31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_31MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_31MouseEntered

    private void JPOpcao_31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_31MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_31MouseExited

    private void JPOpcao_31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_31MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_31MousePressed

    private void JPOpcao_28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_28MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_28MouseEntered

    private void JPOpcao_28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_28MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_28MouseExited

    private void JPOpcao_28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_28MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_28MousePressed

    private void tfLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfLoginMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoginMouseEntered

    private void tfLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfLoginMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoginMouseExited

    private void tfLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfLoginKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfLoginKeyReleased

    private void JPOpcao_29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_29MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_29MouseEntered

    private void JPOpcao_29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_29MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_29MouseExited

    private void JPOpcao_29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPOpcao_29MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPOpcao_29MousePressed

    private void jpIcon1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpIcon1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpIcon1MousePressed

    Exportando Exportando;
    private void btSalvarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSalvarMousePressed
    new Thread() {   @Override public void run() { try { 
        
        if(status_cadastro.equalsIgnoreCase("Cadastrando...")){
            
/* ////// */UsuarioSistema_Recebido = new UsuarioSistema();
      
            Exportando = new Exportando("CADASTRANDO");
            Exportando.setVisible(true);
            Exportando.pbg.setMinimum(0);
            Exportando.pbg.setMaximum( 100 );
            
            Exportando.pbg.setValue( 50 ); 
            
            verificando_se_o_usuario_e_o_Cleilson();  
            
            Exportando.fechar();             
        }
        else{
      
            Exportando = new Exportando("ALTERANDO");
            Exportando.setVisible(true);
            Exportando.pbg.setMinimum(0);
            Exportando.pbg.setMaximum( 100 );
            
            Exportando.pbg.setValue( 50 ); 
            
            verificando_se_o_usuario_e_o_Cleilson();  
            
            Exportando.fechar();  
        }

        /*
        List<UsuarioSistema> UsuarioSistema = null;
        try{ 
            Query q = JPAUtil.em().createNativeQuery("SELECT * FROM JM.USUARIO_SISTEMA WHERE ID = ?", UsuarioSistema.class );
            q.setParameter( 1, UsuarioSistema_Recebido.getId() );
            List<UsuarioSistema> lista_Banco = q.getResultList();   
            UsuarioSistema = lista_Banco;
        }catch( Exception e ){ }
        
        String rbusca = ""; 
        try{ rbusca = UsuarioSistema.get(0).getLogin(); }catch( Exception e ){}
            
        if( !rbusca.equals("") ){
            
                     
        }
        else{
            

        }
        */
      
            
    }catch( Exception e ){ Exportando.fechar(); e.printStackTrace(); }  } }.start(); 
    }//GEN-LAST:event_btSalvarMousePressed

    private void btExcluirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirMousePressed
        try { 
    
            Object[] options = {
                "Confirmar",
                "Cancelar" 
            };
            int n = JOptionPane.showOptionDialog(null,
                    "Confirme a Opção de Excluir o Usuário\n"
                    + "Listado Abaixo.",
                    "Opção de Consulta",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
//////////////////////////////////////////////////////
            if(n==0){
        
                excluir_Usuario_Atual();
            }            
        } catch( Exception e ){} 
    }//GEN-LAST:event_btExcluirMousePressed
      
    private void excluir_Usuario_Atual() {                                       
         new Thread() {   @Override public void run() { try { Thread.sleep( 1 );
        
            Exportando = new Exportando("EXCLUINDO...");
            Exportando.setVisible(true);Exportando.pbg.setMinimum(0);
            Exportando.pbg.setMaximum( 100 );
            Exportando.pbg.setValue( 50 );
            
                if( btExcluir.isEnabled() == true ){
                                                  
                    List<UsuarioSistema> List_2_UsuarioSistema = null;
                    try{
                        Query q2 = JPAUtil.em().createNativeQuery("SELECT * FROM JM.USUARIO_SISTEMA WHERE ID = ?", UsuarioSistema.class );
                        q2.setParameter( 1, UsuarioSistema_Recebido.getId() ); 
                        List_2_UsuarioSistema = q2.getResultList();
                    }catch(Exception e){}
                    
                    String rbusca = ""; try{ rbusca = List_2_UsuarioSistema.get(0).getLogin(); }catch( Exception e ){}
                    if( !rbusca.equals("") ){
                                            
                        //Home.ControleTabs.AddTabComControle(jTabbedPane1, "Alterar Usuário", "livroTp.gif", 
                        //new Usuarios_Do_Sistema_02_Cadastrar_Visualizar( Home, "Alterando...", List_2_UsuarioSistema.get(0) ) );
                        if( rbusca.equalsIgnoreCase("cleilson") ){
                            
                            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                            JOPM JOptionPaneMod = new JOPM( 1, "EXCLUINDO USUÁRIO SELECIONADO\n"
                                + "\nUSUÁRIO: " + rbusca 
                               + "\nVOCÊ NÃO TEM AUTORIZAÇÃO PARA EXCLUIR O USUÁRIO CLEILSON"
                                + "\nOK Para Prosseguir"
                                ,"Class: " + this.getClass().getName(),
                            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );  
                        }
                        else{
                            
                            excluir_Imagens( List_2_UsuarioSistema.get(0) );
                            
                            DAOGenericoJPA DAOGenericoJPA2 = new DAOGenericoJPA( List_2_UsuarioSistema.get(0), JPAUtil.em());
                            DAOGenericoJPA2.excluir();

                            Home.ControleTabs.removerTabSemControleSelecionado(JTabbedPane_Recebido);
                            
                            Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                            JOPM JOptionPaneMod = new JOPM( 1, "EXCLUINDO USUÁRIO SELECIONADO\n"
                                + "\nUSUÁRIO: " + rbusca 
                               + "\nEXCLUIDO COM SUCESSO"
                                + "\nOK Para Prosseguir"
                                ,"Class: " + this.getClass().getName(),
                            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );                        
                        }
                    }
                    
                    Exportando.fechar();
                }
            
        } catch( InterruptedException e ){ Exportando.fechar(); e.printStackTrace(); } } }.start();
    }
    
    private void excluir_Imagens(UsuarioSistema UsuarioSistema_Excluir_Imagens){ 
    /*new Thread() {   @Override public void run() {*/ try { 
             
        List<UsuarioImagens> lista_Banco = null;
        try{ 
            Query q = JPAUtil.em().createNativeQuery("SELECT * FROM JM.USUARIO_IMAGENS WHERE ID_USUARIO_SISTEMA = ?", UsuarioImagens.class );
            q.setParameter( 1, UsuarioSistema_Excluir_Imagens.getId() );
            lista_Banco = q.getResultList();   
        }catch( Exception e ){ }
        
        String rbusca = ""; 
        try{ rbusca = lista_Banco.get(0).getNome(); }catch( Exception e ){}
            
        if( !rbusca.equals("") ){	 
	          
            try{
                
                for (int i=0; i < lista_Banco.size(); i++) {
                    
                    DAOGenericoJPA DAOGenericoJPA2 = new DAOGenericoJPA( lista_Banco.get(i), JPAUtil.em());
                    DAOGenericoJPA2.excluir();
                }
	    }catch(Exception e){ e.printStackTrace(); }  
        }
                            
    } catch( Exception e ){ } //} }.start();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPOpcao_12;
    private javax.swing.JPanel JPOpcao_13;
    private javax.swing.JPanel JPOpcao_14;
    private javax.swing.JPanel JPOpcao_15;
    private javax.swing.JPanel JPOpcao_16;
    private javax.swing.JPanel JPOpcao_17;
    private javax.swing.JPanel JPOpcao_18;
    private javax.swing.JPanel JPOpcao_19;
    private javax.swing.JPanel JPOpcao_20;
    private javax.swing.JPanel JPOpcao_21;
    private javax.swing.JPanel JPOpcao_24;
    private javax.swing.JPanel JPOpcao_25;
    private javax.swing.JPanel JPOpcao_26;
    private javax.swing.JPanel JPOpcao_27;
    private javax.swing.JPanel JPOpcao_28;
    private javax.swing.JPanel JPOpcao_29;
    private javax.swing.JPanel JPOpcao_30;
    private javax.swing.JPanel JPOpcao_31;
    private javax.swing.JPanel JPOpcao_32;
    private javax.swing.JPanel JPOpcao_33;
    private javax.swing.JPanel Pergunta;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    public javax.swing.JCheckBox chPermitirAcessar;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpIcon1;
    private javax.swing.JPanel jpO;
    private javax.swing.JPanel jpPermitirAcesso7;
    private javax.swing.JPanel jp_Padrao_Tabela;
    public javax.swing.JLabel lbImagemPrincipal;
    private javax.swing.JLabel lb_Alterado_Por;
    private javax.swing.JLabel lb_Cadastrado_Por;
    private javax.swing.JLabel lb_Data_Cadastro;
    private javax.swing.JLabel lb_Data_Ultima_Alteracao;
    private javax.swing.JLabel lb_Data_Ultima_Alteracao_Senha;
    public javax.swing.JTextField tfCodigoAuxiliar;
    public javax.swing.JTextField tfLogin;
    public javax.swing.JPasswordField tfSenha1;
    public javax.swing.JPasswordField tfSenha2;
    public javax.swing.JTextField tf_Email;
    // End of variables declaration//GEN-END:variables
    
    private void setar_Visualizacao_Recebida() {                                          
        new Thread() {   @Override public void run() { try { 
        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////          
            try{ lb_Cadastrado_Por.setText( UsuarioSistema_Recebido.getIdUsuarioSistemaCadastro().getLogin() ); }catch(Exception e){} 
            try{ lb_Alterado_Por.setText( UsuarioSistema_Recebido.getIdUsuarioSistemaAlteracao().getLogin() ); }catch(Exception e){}
            
            try{ 
                
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                String dataCadastro = ""; 
                try{ dataCadastro = formatter.format( UsuarioSistema_Recebido.getDataCadastro() ); }catch(Exception e){}
                lb_Data_Cadastro.setText( dataCadastro ); 
            }catch(Exception e){} 
            
            try{ 
                
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                String data_Ultima_Alteracao = ""; 
                try{ data_Ultima_Alteracao = formatter.format( UsuarioSistema_Recebido.getDataAlteracao()); }catch(Exception e){}
                lb_Data_Ultima_Alteracao.setText( data_Ultima_Alteracao ); 
            }catch(Exception e){} 
            
            try{ 
                
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
                String data_Ultima_Alteracao_Senha = ""; 
                try{ data_Ultima_Alteracao_Senha = formatter.format( UsuarioSistema_Recebido.getDataUltimaAlteracaoSenha()); }catch(Exception e){}
                lb_Data_Ultima_Alteracao_Senha.setText( data_Ultima_Alteracao_Senha ); 
            }catch(Exception e){} 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            

            try{ tf_Email.setText( UsuarioSistema_Recebido.getEmailRecuperacao() ); }catch(Exception e){}
            try{ tfCodigoAuxiliar.setText( UsuarioSistema_Recebido.getCodigoAuxiliar()); }catch(Exception e){}
            
            
            try{ 
                if( UsuarioSistema_Recebido.getPermitirAcessoAoSistema().equalsIgnoreCase("SIM") ){
                    
                    chPermitirAcessar.setSelected(true);
                }    
                else{
                    
                    chPermitirAcessar.setSelected(false);
                }
            }catch(Exception e){}
            
            try{ tfLogin.setText( UsuarioSistema_Recebido.getLogin()); }catch(Exception e){}            
            try{ tfSenha1.setText( UsuarioSistema_Recebido.getSenha()); }catch(Exception e){}
            try{ tfSenha2.setText( UsuarioSistema_Recebido.getSenha()); }catch(Exception e){} 
          
        } catch( Exception e ){  } } }.start();        
    }
    
    private void desabilitar_componentes() {                                          
        new Thread() {   @Override public void run() { try {

            try{ 
                
                tf_Email.setEditable(false);
                tfCodigoAuxiliar.setEditable(false);
                tfLogin.setEditable(false);
                tfSenha1.setEditable(false);
                tfSenha2.setEditable(false);
                chPermitirAcessar.setEnabled(false);
            }catch(Exception e){}
          
        } catch( Exception e ){  } } }.start();        
    }
    
/// CADASTRANDO ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void verificando_se_o_usuario_e_o_Cleilson(){ 
        
        try{
            
            if(status_cadastro.equalsIgnoreCase("Cadastrando...")){
                
                setando_os_que_nao_precisam_de_validacao();
            }
            else{
                
                if( UsuarioSistema_Recebido.getLogin().equalsIgnoreCase("cleilson") ){
                
                    Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                    JOPM JOptionPaneMod = new JOPM( 1, "ALTERANDO USUÁRIO SELECIONADO\n"
                            + "\nUSUÁRIO: " + UsuarioSistema_Recebido.getLogin() 
                            + "\nVOCÊ NÃO TEM AUTORIZAÇÃO PARA ALTERAR O USUÁRIO CLEILSON"
                            + "\nOK Para Prosseguir"
                            ,"Class: " + this.getClass().getName(),
                            new ImageIcon( clazzHome.getResource("logocangaco2.png")) );  
                }
                else{
                
                    setando_os_que_nao_precisam_de_validacao();
                }
            }
            
        }catch( Exception e ){}
    }
    
    private void setando_os_que_nao_precisam_de_validacao(){ 
        
        try{
            
            try{ UsuarioSistema_Recebido.setCodigoAuxiliar( tfCodigoAuxiliar.getText().trim().toUpperCase() ); }catch( Exception e ){}
            
            try{
                
                if( chPermitirAcessar.isSelected() == true ){
                    
                    try{ UsuarioSistema_Recebido.setPermitirAcessoAoSistema( "SIM" ); }catch( Exception e ){}
                }
                else{
                    
                    try{ UsuarioSistema_Recebido.setPermitirAcessoAoSistema( "NAO" ); }catch( Exception e ){}
                }
 
            }catch( Exception e ){}
            
            verificar_Usuario_Logado();
            
        }catch( Exception e ){}
    }
    
    private void verificar_Usuario_Logado(){   
        
        String rbusca = ""; 
        try{ rbusca = Login.Usuario_Logado.getLogin(); }catch( Exception e ){}
        
        try{
            
            if( !rbusca.equals("") ){
                
                System.out.println( Login.Usuario_Logado.getLogin() );
                
                verificar_Usuario_Do_Sistema_Que_Cadastrou_E_Alterou();
            }
            else{

                Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
                JOPM JOptionPaneMod = new JOPM( 1, "STATUS DO CADASTRO\n"
                        + "\n"
                        + "\nNÃO HÁ USUÁRIO LOGADO!\n"
                        + "\n"
                        + "\nPARA CADASTRAR É NECESSÁRIO LOGAR!\n"
                        + "\n"
                        + "\nOK PARA PROSSEGUIR"
                        ,"Class: " + this.getClass().getName(), 
                        new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
            }
            
        }catch( Exception e ){ 
            
                e.printStackTrace();
                            
                Class<Imagens_Internas> clazzHome = Imagens_Internas.class;
                JOPM JOptionPaneMod = new JOPM( 1, "USUÁRIO LOGADO\n"
                        + "\n"
                        + "\nUSUÁRIO LOGADO INVÁLIDO!\n"
                        + "\n"
                        + "\nPARA CADASTRAR É NECESSÁRIO LOGAR!\n"
                        + "\n"
                        + "\nOK PARA PROSSEGUIR"
                        ,"Class: " + this.getClass().getName(), 
                        new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
    }
   
    private void verificar_Usuario_Do_Sistema_Que_Cadastrou_E_Alterou(){   
        
        List<UsuarioSistema> UsuarioSistema = null;
        try{ 
            Query q = JPAUtil.em().createNativeQuery("SELECT * FROM JM.USUARIO_SISTEMA WHERE ID = ?", UsuarioSistema.class );
            q.setParameter( 1, UsuarioSistema_Recebido.getId() );
            List<UsuarioSistema> lista_Banco = q.getResultList();   
            UsuarioSistema = lista_Banco;
        }catch( Exception e ){ }
        
        String rbusca = ""; 
        try{ rbusca = UsuarioSistema.get(0).getLogin(); }catch( Exception e ){}
            
        if( !rbusca.equals("") ){
                
            //CADASTRO / ALTERAÇÃO - USUÁRIO         
            //try{ UsuarioSistema_Recebido.setIdUsuarioSistemaCadastro( Login.Usuario_Logado ); }catch( Exception e ){}   
            try{ UsuarioSistema_Recebido.setIdUsuarioSistemaAlteracao( Login.Usuario_Logado ); }catch( Exception e ){}   
             
            //CADASTRO / ALTERAÇÃO - DATA - ALTERAÇÃO 
            try{ 
                
                //GregorianCalendar gc = new GregorianCalendar();
                Calendar gc = Calendar.getInstance();
                Date dataHoje = gc.getTime();
                
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String dataCadastro = ""; 
                try{ dataCadastro = formatter.format( dataHoje );  }catch(Exception e){}
                
                try{
                    
                    Date data = formatter.parse( dataCadastro );
                    
                    //UsuarioSistema_Recebido.setDataCadastro( data ); 
                    
                    UsuarioSistema_Recebido.setDataAlteracao( data ); 
                    
                    //UsuarioSistema_Recebido.setDataUltimaAlteracaoSenha( data );
                    
                }catch(Exception e){}
            }catch(Exception e){}

            System.out.println( "Alterando Usuário: " );
                
            verificar_email();
        }
        else{

            //CADASTRO / ALTERAÇÃO - USUÁRIO 
            try{ UsuarioSistema_Recebido.setIdUsuarioSistemaCadastro( Login.Usuario_Logado ); }catch( Exception e ){}                
            try{ UsuarioSistema_Recebido.setIdUsuarioSistemaAlteracao( Login.Usuario_Logado ); }catch( Exception e ){}
                
            //CADASTRO / ALTERAÇÃO - DATA - CADASTRANDO 
            try{ 
                
                //GregorianCalendar gc = new GregorianCalendar();
                Calendar gc = Calendar.getInstance();
                Date dataHoje = gc.getTime();
                
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String dataCadastro = ""; 
                try{ dataCadastro = formatter.format( dataHoje );  }catch(Exception e){}
                
                try{
                    
                    Date data = formatter.parse( dataCadastro );
                    
                    UsuarioSistema_Recebido.setDataCadastro( data ); 
                    
                    UsuarioSistema_Recebido.setDataAlteracao( data ); 
                    
                    UsuarioSistema_Recebido.setDataUltimaAlteracaoSenha( data );
                    
                }catch(Exception e){}
            }catch(Exception e){} 

            System.out.println(  "Novo Usuário: " );
                
            verificar_email();
        }
    }
    
    private void verificar_email(){   
        
        String rbusca = ""; 
        try{ rbusca = tf_Email.getText().trim(); }catch( Exception e ){}

        if( !rbusca.equals("") ){
            
            if( ValidarEmail.validar( tf_Email.getText().trim() ) == true ){
                                    
                try{ UsuarioSistema_Recebido.setEmailRecuperacao( tf_Email.getText().trim().toUpperCase() ); }catch( Exception e ){}
                
                verificar_Login();
            }
            else{
                   
                ValidarEmail.emailInvalido();
                    
                tf_Email.requestFocus();
            }
        }
        else{
            
            tf_Email.requestFocus();
                    
            Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CAMPO EMAIL\n"
                    + "\n"
                    + "\nO CAMPO EMAIL ESTÁ VAZIO!\n"
                    + "\n"
                    + "\nPARA CADASTRAR É NECESSÁRIO INFORMAR UM EMAIL!\n"
                    + "\n"
                    + "\nOK PARA PROSSEGUIR"
                    ,"Class: " + this.getClass().getName(), 
                    new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
    }
    
    private void verificar_Login(){   
        
        String rbusca = ""; 
        try{ rbusca = tfLogin.getText().trim().toUpperCase(); }catch( Exception e ){}

        if( !rbusca.equals("") ){
            
            String alterada = ""; 
            try{ alterada = rbusca.replace(" ", ""); }catch( Exception e ){}

            try{UsuarioSistema_Recebido.setLogin( alterada ); }catch( Exception e ){}
 
            verificar_Senha1();
        }
        else{
            
            tfLogin.requestFocus();
                    
            Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CAMPO LOGIN\n"
                    + "\n"
                    + "\nO CAMPO LOGIN ESTÁ VAZIO!\n"
                    + "\n"
                    + "\nPARA CADASTRAR É NECESSÁRIO INFORMAR UM LOGIN!\n"
                    + "\n"
                    + "\nOK PARA PROSSEGUIR"
                    ,"Class: " + this.getClass().getName(), 
                    new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
    }
    
    String senha_Atual_1 = "";
    private void verificar_Senha1(){  
        senha_Atual_1 = "";
        
        char[] senhaX  = null; try{ senhaX   = tfSenha1.getPassword();           } catch( Exception e ){}
        String senha   = "";   try{ senha    = Arrays.toString(senhaX);         } catch( Exception e ){}
        String senhaY  = "";   try{ senhaY   = senha.replace("[", "");          } catch( Exception e ){}
        String senhaY2 = "";   try{ senhaY2  = senhaY.replace("]", "");         } catch( Exception e ){}
        String senhaY3 = "";   try{ senhaY3  = senhaY2.replace(" ", "");        } catch( Exception e ){}
        String senhaY4 = "";   try{ senhaY4  = senhaY3.replace(",", "");        } catch( Exception e ){}
        
        String rbusca = ""; 
        try{ rbusca = senhaY4; }catch( Exception e ){}

        if( !rbusca.equals("") ){
            senha_Atual_1 = senhaY4;
            
            verificar_Senha2();                        
        }
        else{
            
            tfSenha1.requestFocus();
                    
            Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CAMPO DEFINIR SENHA\n"
                    + "\n"
                    + "\nO CAMPO DEFINIR SENHA ESTÁ VAZIO!\n"
                    + "\n"
                    + "\nPARA CADASTRAR É NECESSÁRIO PREENCHER O CAMPO DEFINIR SENHA!\n"
                    + "\n"
                    + "\nOK PARA PROSSEGUIR"
                    ,"Class: " + this.getClass().getName(), 
                    new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
    }
    
    String senha_Atual_2 = "";
    private void verificar_Senha2(){  
        senha_Atual_2 = "";
        
        char[] senhaX  = null; try{ senhaX   = tfSenha2.getPassword();           } catch( Exception e ){}
        String senha   = "";   try{ senha    = Arrays.toString(senhaX);         } catch( Exception e ){}
        String senhaY  = "";   try{ senhaY   = senha.replace("[", "");          } catch( Exception e ){}
        String senhaY2 = "";   try{ senhaY2  = senhaY.replace("]", "");         } catch( Exception e ){}
        String senhaY3 = "";   try{ senhaY3  = senhaY2.replace(" ", "");        } catch( Exception e ){}
        String senhaY4 = "";   try{ senhaY4  = senhaY3.replace(",", "");        } catch( Exception e ){}
        
        String rbusca = ""; 
        try{ rbusca = senhaY4; }catch( Exception e ){}

        if( !rbusca.equals("") ){
            senha_Atual_2 = senhaY4;
            
            if( senha_Atual_1.equals(senha_Atual_2) ){
                                 
                try{ UsuarioSistema_Recebido.setSenha( senhaY4 ); } catch( Exception e ){}
                
                verificar_Repeticao_Codigo_Auxiliar();
            }     
            else{
                
                Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
                JOPM JOptionPaneMod = new JOPM( 1, "SENHAS INFORMADAS DIFERENTES\n"
                    + "\n"
                    + "\nO CAMPO REPITA A SENHA ESTÁ DIFERENTE DO CAMPO SENHA!\n"
                    + "\n"
                    + "\nPARA CADASTRAR É NECESSÁRIO PREENCHER OS CAMPOS SENHA E REPITA A SENHA IGUAIS!\n"
                    + "\n"
                    + "\nOK PARA PROSSEGUIR"
                    ,"Class: " + this.getClass().getName(), 
                    new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
            }
        }
        else{
            
            tfSenha2.requestFocus();
                    
            Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CAMPO REPITA A SENHA\n"
                    + "\n"
                    + "\nO CAMPO REPITA A SENHA ESTÁ VAZIO!\n"
                    + "\n"
                    + "\nPARA CADASTRAR É NECESSÁRIO PREENCHER O CAMPO REPITA A SENHA!\n"
                    + "\n"
                    + "\nOK PARA PROSSEGUIR"
                    ,"Class: " + this.getClass().getName(), 
                    new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }
    }
    
    private void verificar_Repeticao_Codigo_Auxiliar(){  
        System.out.println("verificar_Repeticao_Codigo_Auxiliar");
        
        String rbusca = ""; 
        try{ rbusca = UsuarioSistema_Recebido.getCodigoAuxiliar().trim(); }catch( Exception e ){}
        
        int iDbusca = 0; 
        try{ iDbusca = UsuarioSistema_Recebido.getId(); }catch( Exception e ){}
        
        boolean material_ja_Cadastrado = false;
        if( !rbusca.equals("") ){
/////// VERIFICANDO REPETIÇÃO - CÓDIGO AUXILIAR /////////////////////////////////////////////////////////////////////////////////////////////////////////
            try{ 
                Query q2 = JPAUtil.em().createNativeQuery("SELECT * FROM JM.USUARIO_SISTEMA WHERE CODIGO_AUXILIAR = ?", UsuarioSistema.class );
                q2.setParameter( 1, rbusca ); 
                List<UsuarioSistema> list = q2.getResultList();                    
                    
                for (UsuarioSistema list1 : list) {
                        
                    if (list1.getCodigoAuxiliar().equals( rbusca )) {
                            
                        if (list1.getId() == iDbusca ) {
                                                        
                        }
                        else{
                            
                            material_ja_Cadastrado = true;
                            System.out.println("list1.getId() + \" - \" + iDbusca - "+ list1.getId() + " - " + iDbusca );
                            break; 
                        }
                    }
                }
            }catch( Exception e ){}
        } 
/////// VERIFICANDO REPETIÇÃO - CÓDIGO AUXILIAR ////////////////////////////////////////////////////////////////////////////////////////////////////////        
        
        if ( material_ja_Cadastrado == false ) {
            
            try{
                
                verificar_Repeticao_Login();
                
            }catch( Exception e ){
                
                System.out.println("Erro ao cadastrar");
                e.printStackTrace();
            }
        }
        else{
            
            Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CAMPO CÓDIGO AUXILIAR\n"
                    + "\n"
                    + "\nO CAMPO CÓDIGO AUXILIAR JÁ EXISTE!\n"
                    + "\n"
                    + "\nINFORME UM NOVO CÓDIGO AUXILIAR QUE NÃO EXISTA CADASTRADO!\n"
                    + "\n"
                    + "\nOK PARA PROSSEGUIR"
                    ,"Class: " + this.getClass().getName(), 
                    new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }

    }
    
    private void verificar_Repeticao_Login(){  
        System.out.println("verificar_Repeticao_Login");
        
        String rbusca = ""; 
        try{ rbusca = UsuarioSistema_Recebido.getLogin().toUpperCase(); }catch( Exception e ){}
        
        int iDbusca = 0; 
        try{ iDbusca = UsuarioSistema_Recebido.getId(); }catch( Exception e ){}
        
        boolean material_ja_Cadastrado = false;
        if( !rbusca.equals("") ){
/////// VERIFICANDO REPETIÇÃO - CÓDIGO AUXILIAR /////////////////////////////////////////////////////////////////////////////////////////////////////////
            try{ 
                Query q2 = JPAUtil.em().createNativeQuery("SELECT * FROM JM.USUARIO_SISTEMA WHERE LOGIN = ?", UsuarioSistema.class );
                q2.setParameter( 1, rbusca ); 
                List<UsuarioSistema> list = q2.getResultList();                    
                    
                for (UsuarioSistema list1 : list) {
                    
                    if (list1.getLogin().equals( rbusca )) {
                            
                        if (list1.getId() == iDbusca ) {
                                                        
                        }
                        else{
                            
                            material_ja_Cadastrado = true;
                            System.out.println("list1.getId() + \" - \" + iDbusca - "+ list1.getId() + " - " + iDbusca );
                            break; 
                        }
                    }
                }
            }catch( Exception e ){}
        } 
/////// VERIFICANDO REPETIÇÃO - CÓDIGO AUXILIAR ////////////////////////////////////////////////////////////////////////////////////////////////////////        
        
        if ( material_ja_Cadastrado == false ) {
            
            try{
                
                cadastrar_Usuario();
                
            }catch( Exception e ){
                
                System.out.println("Erro ao cadastrar");
                e.printStackTrace();
            }
        }
        else{
            
            Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CAMPO LOGIN\n"
                    + "\n"
                    + "\nO CAMPO LOGIN JÁ EXISTE!\n"
                    + "\n"
                    + "\nINFORME UM NOVO LOGIN QUE NÃO EXISTA CADASTRADO!\n"
                    + "\n"
                    + "\nOK PARA PROSSEGUIR"
                    ,"Class: " + this.getClass().getName(), 
                    new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }

    }
    
    private void cadastrar_Usuario(){  
        try{
            
            DAOGenericoJPA DAOGenericoJPA2 = new DAOGenericoJPA( UsuarioSistema_Recebido, JPAUtil.em());
            UsuarioSistema UsuarioSistema_Cadastrado = (UsuarioSistema) DAOGenericoJPA2.gravanovoOUatualizar();
            
            verificar_lista_de_Endereco_imagemExterna(UsuarioSistema_Cadastrado);
            
            String rbusca = ""; 
            try{ rbusca = UsuarioSistema_Recebido.getLogin().toUpperCase(); }catch( Exception e ){}
        
            Class<br.com.jmary.home.imagens.Imagens_Internas> clazzHome = br.com.jmary.home.imagens.Imagens_Internas.class;
            JOPM JOptionPaneMod = new JOPM( 1, "CADASTRO\n"
                    + "\n"
                    + "\nSTATUS DO CADASTRO\n"
                    + "\n"
                    + "\nUSUÁRIO "+ rbusca +" CADASTRADO COM SUCESSO!\n"
                    + "\n"
                    + "\nOK PARA PROSSEGUIR"
                    ,"Class: " + this.getClass().getName(), 
                    new ImageIcon( clazzHome.getResource("logocangaco2.png")) );
        }catch( Exception e ){
            
            System.out.println("Erro ao cadastrar");
            e.printStackTrace();
        }
    }
    
    private void verificar_lista_de_Endereco_imagemExterna(UsuarioSistema UsuarioSistema_Cadastrado){
        try{
            
            for (int i=0; i < lista_de_Endereco_imagemExterna_.size(); i++) {
                
                File imagem = new File( lista_de_Endereco_imagemExterna_.get(i) ); 
                
                salvar_imagemExterna(UsuarioSistema_Cadastrado, imagem);
            }
        }catch( Exception e ){}
    }
    
    private void salvar_imagemExterna(UsuarioSistema UsuarioSistema_Cadastrado, File imagemExterna_Endereco){ 

        try { 
            
            BufferedImage bufImg = null;
            ImageIcon     icon   = null;
            Image         image  = null;
            try{
                
                bufImg = ImageIO.read( imagemExterna_Endereco );
                icon   = new ImageIcon(bufImg);
                image  = icon.getImage();//ImageIO.read(f);  
            } catch (IOException ex) {}  

            
                String nome = imagemExterna_Endereco.getName();
                String nomeList[] = nome.split(Pattern.quote("."));
                
                UsuarioImagens UsuarioImagens = new UsuarioImagens();
                
                ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
                String extencao = imagemExterna_Endereco.getPath().substring( imagemExterna_Endereco.getPath().lastIndexOf('.') + 1 ); 
                
                ImageIO.write((BufferedImage)image, extencao, bytesImg);//seta a imagem para bytesImg
                bytesImg.flush();//limpa a variável
                byte[] byteArray = bytesImg.toByteArray();//Converte ByteArrayOutputStream para byte[] 
                bytesImg.close();//fecha a conversão
                
                UsuarioImagens.setImagem(byteArray);
                
                try{ UsuarioImagens.setIdUsuarioSistema( UsuarioSistema_Cadastrado.getId() ); }catch( Exception e ){}
                try{ UsuarioImagens.setNome( nomeList[0] ); }catch( Exception e ){}
                
                try{
                    DAOGenericoJPA DAOGenericoJPA2 = new DAOGenericoJPA( UsuarioImagens, JPAUtil.em());
                    UsuarioImagens UsuarioImagens_Cadastrado = (UsuarioImagens) DAOGenericoJPA2.gravanovoOUatualizar();

                }catch( Exception e ){}
                
        } catch( Exception e ){ 
        
            JOPM JOptionPaneMod = new JOPM( 2, "ERRO AO CADASTRAR, 2"
                + "\nNÃO CADASTRADO"
                + "\nNenhum dado CADASTRADO."
                + "\n", "CADASTRAR - salvar_imagemExterna" );
        } 
    }
/// CADASTRANDO ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
       
}