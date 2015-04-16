package org.arunm.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@NamedEntityGraph(
        name = "WITH_PROVEEDORES",
        		attributeNodes = {
    @NamedAttributeNode("proveedores")
}
)
public class Empresa {

    private String idEmpresa;
    private String razonSocial;
    private String abreviatura;
    private List<Proveedor> proveedores;

    @Id
    @Column(name = "IdEmpresa")
    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Basic
    @Column(name = "RazonSocial")
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Basic
    @Column(name = "Abreviatura")
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @ManyToMany(mappedBy = "empresas",fetch=FetchType.LAZY)
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return ToStringBuilder.reflectionToString(this);
    }
}