/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios_do_sistema_beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author NewUser
 */
@Entity
@Table(name = "USUARIO_SISTEMA", catalog = "", schema = "JM")
@NamedQueries({
    @NamedQuery(name = "UsuarioSistema.findAll", query = "SELECT u FROM UsuarioSistema u")
    , @NamedQuery(name = "UsuarioSistema.findById", query = "SELECT u FROM UsuarioSistema u WHERE u.id = :id")
    , @NamedQuery(name = "UsuarioSistema.findByCodigoAuxiliar", query = "SELECT u FROM UsuarioSistema u WHERE u.codigoAuxiliar = :codigoAuxiliar")
    , @NamedQuery(name = "UsuarioSistema.findByLogin", query = "SELECT u FROM UsuarioSistema u WHERE u.login = :login")
    , @NamedQuery(name = "UsuarioSistema.findBySenha", query = "SELECT u FROM UsuarioSistema u WHERE u.senha = :senha")
    , @NamedQuery(name = "UsuarioSistema.findByEmailRecuperacao", query = "SELECT u FROM UsuarioSistema u WHERE u.emailRecuperacao = :emailRecuperacao")
    , @NamedQuery(name = "UsuarioSistema.findByPermitirAcessoAoSistema", query = "SELECT u FROM UsuarioSistema u WHERE u.permitirAcessoAoSistema = :permitirAcessoAoSistema")
    , @NamedQuery(name = "UsuarioSistema.findByUltimaChaveRecuperacao", query = "SELECT u FROM UsuarioSistema u WHERE u.ultimaChaveRecuperacao = :ultimaChaveRecuperacao")
    , @NamedQuery(name = "UsuarioSistema.findByDataUltimaAlteracaoSenha", query = "SELECT u FROM UsuarioSistema u WHERE u.dataUltimaAlteracaoSenha = :dataUltimaAlteracaoSenha")
    , @NamedQuery(name = "UsuarioSistema.findByDataCadastro", query = "SELECT u FROM UsuarioSistema u WHERE u.dataCadastro = :dataCadastro")
    , @NamedQuery(name = "UsuarioSistema.findByDataAlteracao", query = "SELECT u FROM UsuarioSistema u WHERE u.dataAlteracao = :dataAlteracao")})
public class UsuarioSistema implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "CODIGO_AUXILIAR", length = 150)
    private String codigoAuxiliar;
    @Basic(optional = false)
    @Column(name = "LOGIN", nullable = false, length = 200)
    private String login;
    @Basic(optional = false)
    @Column(name = "SENHA", nullable = false, length = 150)
    private String senha;
    @Basic(optional = false)
    @Column(name = "EMAIL_RECUPERACAO", nullable = false, length = 100)
    private String emailRecuperacao;
    @Column(name = "PERMITIR_ACESSO_AO_SISTEMA", length = 3)
    private String permitirAcessoAoSistema;
    @Column(name = "ULTIMA_CHAVE_RECUPERACAO", length = 100)
    private String ultimaChaveRecuperacao;
    @Basic(optional = false)
    @Column(name = "DATA_ULTIMA_ALTERACAO_SENHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracaoSenha;
    @Basic(optional = false)
    @Column(name = "DATA_CADASTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @Basic(optional = false)
    @Column(name = "DATA_ALTERACAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioSistemaAlteracao")
    private List<UsuarioSistema> usuarioSistemaList;
    @JoinColumn(name = "ID_USUARIO_SISTEMA_ALTERACAO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioSistema idUsuarioSistemaAlteracao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioSistemaCadastro")
    private List<UsuarioSistema> usuarioSistemaList1;
    @JoinColumn(name = "ID_USUARIO_SISTEMA_CADASTRO", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioSistema idUsuarioSistemaCadastro;

    public UsuarioSistema() {
    }

    public UsuarioSistema(Integer id) {
        this.id = id;
    }

    public UsuarioSistema(Integer id, String login, String senha, String emailRecuperacao, Date dataUltimaAlteracaoSenha, Date dataCadastro, Date dataAlteracao) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.emailRecuperacao = emailRecuperacao;
        this.dataUltimaAlteracaoSenha = dataUltimaAlteracaoSenha;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getCodigoAuxiliar() {
        return codigoAuxiliar;
    }

    public void setCodigoAuxiliar(String codigoAuxiliar) {
        String oldCodigoAuxiliar = this.codigoAuxiliar;
        this.codigoAuxiliar = codigoAuxiliar;
        changeSupport.firePropertyChange("codigoAuxiliar", oldCodigoAuxiliar, codigoAuxiliar);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        String oldLogin = this.login;
        this.login = login;
        changeSupport.firePropertyChange("login", oldLogin, login);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public String getEmailRecuperacao() {
        return emailRecuperacao;
    }

    public void setEmailRecuperacao(String emailRecuperacao) {
        String oldEmailRecuperacao = this.emailRecuperacao;
        this.emailRecuperacao = emailRecuperacao;
        changeSupport.firePropertyChange("emailRecuperacao", oldEmailRecuperacao, emailRecuperacao);
    }

    public String getPermitirAcessoAoSistema() {
        return permitirAcessoAoSistema;
    }

    public void setPermitirAcessoAoSistema(String permitirAcessoAoSistema) {
        String oldPermitirAcessoAoSistema = this.permitirAcessoAoSistema;
        this.permitirAcessoAoSistema = permitirAcessoAoSistema;
        changeSupport.firePropertyChange("permitirAcessoAoSistema", oldPermitirAcessoAoSistema, permitirAcessoAoSistema);
    }

    public String getUltimaChaveRecuperacao() {
        return ultimaChaveRecuperacao;
    }

    public void setUltimaChaveRecuperacao(String ultimaChaveRecuperacao) {
        String oldUltimaChaveRecuperacao = this.ultimaChaveRecuperacao;
        this.ultimaChaveRecuperacao = ultimaChaveRecuperacao;
        changeSupport.firePropertyChange("ultimaChaveRecuperacao", oldUltimaChaveRecuperacao, ultimaChaveRecuperacao);
    }

    public Date getDataUltimaAlteracaoSenha() {
        return dataUltimaAlteracaoSenha;
    }

    public void setDataUltimaAlteracaoSenha(Date dataUltimaAlteracaoSenha) {
        Date oldDataUltimaAlteracaoSenha = this.dataUltimaAlteracaoSenha;
        this.dataUltimaAlteracaoSenha = dataUltimaAlteracaoSenha;
        changeSupport.firePropertyChange("dataUltimaAlteracaoSenha", oldDataUltimaAlteracaoSenha, dataUltimaAlteracaoSenha);
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        Date oldDataCadastro = this.dataCadastro;
        this.dataCadastro = dataCadastro;
        changeSupport.firePropertyChange("dataCadastro", oldDataCadastro, dataCadastro);
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        Date oldDataAlteracao = this.dataAlteracao;
        this.dataAlteracao = dataAlteracao;
        changeSupport.firePropertyChange("dataAlteracao", oldDataAlteracao, dataAlteracao);
    }

    public List<UsuarioSistema> getUsuarioSistemaList() {
        return usuarioSistemaList;
    }

    public void setUsuarioSistemaList(List<UsuarioSistema> usuarioSistemaList) {
        this.usuarioSistemaList = usuarioSistemaList;
    }

    public UsuarioSistema getIdUsuarioSistemaAlteracao() {
        return idUsuarioSistemaAlteracao;
    }

    public void setIdUsuarioSistemaAlteracao(UsuarioSistema idUsuarioSistemaAlteracao) {
        UsuarioSistema oldIdUsuarioSistemaAlteracao = this.idUsuarioSistemaAlteracao;
        this.idUsuarioSistemaAlteracao = idUsuarioSistemaAlteracao;
        changeSupport.firePropertyChange("idUsuarioSistemaAlteracao", oldIdUsuarioSistemaAlteracao, idUsuarioSistemaAlteracao);
    }

    public List<UsuarioSistema> getUsuarioSistemaList1() {
        return usuarioSistemaList1;
    }

    public void setUsuarioSistemaList1(List<UsuarioSistema> usuarioSistemaList1) {
        this.usuarioSistemaList1 = usuarioSistemaList1;
    }

    public UsuarioSistema getIdUsuarioSistemaCadastro() {
        return idUsuarioSistemaCadastro;
    }

    public void setIdUsuarioSistemaCadastro(UsuarioSistema idUsuarioSistemaCadastro) {
        UsuarioSistema oldIdUsuarioSistemaCadastro = this.idUsuarioSistemaCadastro;
        this.idUsuarioSistemaCadastro = idUsuarioSistemaCadastro;
        changeSupport.firePropertyChange("idUsuarioSistemaCadastro", oldIdUsuarioSistemaCadastro, idUsuarioSistemaCadastro);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioSistema)) {
            return false;
        }
        UsuarioSistema other = (UsuarioSistema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "newpackage.UsuarioSistema[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
