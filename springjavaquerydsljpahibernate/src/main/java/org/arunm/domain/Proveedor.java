package org.arunm.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

@Entity
public class Proveedor {

    private String idProveedor;
    private String razonSocial;

    private List<Empresa> empresas;

    @Id
    @Column(name = "IdProveedor")
    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idEmpresa) {
        this.idProveedor = idEmpresa;
    }

    @Basic
    @Column(name = "RazonSocial")
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ProveedorEmpresa", joinColumns = {
            @JoinColumn(name = "IdProveedor", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "IdEmpresa", nullable = false, updatable = false)
            })
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
    
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

}
