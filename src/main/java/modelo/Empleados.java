/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AllanRamiro
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e")
    , @NamedQuery(name = "Empleados.findByIdresponsable", query = "SELECT e FROM Empleados e WHERE e.idresponsable = :idresponsable")
    , @NamedQuery(name = "Empleados.findByIdempleado", query = "SELECT e FROM Empleados e WHERE e.idempleado = :idempleado")
    , @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Empleados.findByPrimerApellido", query = "SELECT e FROM Empleados e WHERE e.primerApellido = :primerApellido")
    , @NamedQuery(name = "Empleados.findBySegundoApellido", query = "SELECT e FROM Empleados e WHERE e.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Empleados.findByFechaNacimiento", query = "SELECT e FROM Empleados e WHERE e.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Empleados.findByFechaAlta", query = "SELECT e FROM Empleados e WHERE e.fechaAlta = :fechaAlta")
    , @NamedQuery(name = "Empleados.findByFechaBaja", query = "SELECT e FROM Empleados e WHERE e.fechaBaja = :fechaBaja")
    , @NamedQuery(name = "Empleados.findBySexo", query = "SELECT e FROM Empleados e WHERE e.sexo = :sexo")
    , @NamedQuery(name = "Empleados.findByEstadoCivil", query = "SELECT e FROM Empleados e WHERE e.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "Empleados.findBySalario", query = "SELECT e FROM Empleados e WHERE e.salario = :salario")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresponsable")
    private Short idresponsable;
    @Basic(optional = false)
    @Column(name = "idempleado")
    private short idempleado;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 50)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 50)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;
    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "estado_civil")
    private Character estadoCivil;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private BigDecimal salario;
    
    @OneToMany(mappedBy = "idreposable")
    private List<Salas> salasList;
    
    @JoinColumn(name = "idsociedad", referencedColumnName = "idsociedad")
    @ManyToOne
    private Sociedad idsociedad;
    
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @ManyToOne
    private Sucursal idsucursal;
    
    @OneToMany(mappedBy = "idresponsable")
    private List<Usuario> usuarioList;

    public Empleados() {
    }

    public Empleados(Short idresponsable) {
        this.idresponsable = idresponsable;
    }

    public Empleados(Short idresponsable, short idempleado) {
        this.idresponsable = idresponsable;
        this.idempleado = idempleado;
    }

    public Short getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Short idresponsable) {
        this.idresponsable = idresponsable;
    }

    public short getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(short idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Character getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(Character estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @XmlTransient
    public List<Salas> getSalasList() {
        return salasList;
    }

    public void setSalasList(List<Salas> salasList) {
        this.salasList = salasList;
    }

    public Sociedad getIdsociedad() {
        return idsociedad;
    }

    public void setIdsociedad(Sociedad idsociedad) {
        this.idsociedad = idsociedad;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresponsable != null ? idresponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idresponsable == null && other.idresponsable != null) || (this.idresponsable != null && !this.idresponsable.equals(other.idresponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleados[ idresponsable=" + idresponsable + " ]";
    }
    
}
