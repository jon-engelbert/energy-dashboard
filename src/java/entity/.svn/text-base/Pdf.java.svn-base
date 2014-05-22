/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Engel-less
 */
@Entity
@Table(name = "pdf")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pdf.findAll", query = "SELECT p FROM Pdf p"),
    @NamedQuery(name = "Pdf.findById", query = "SELECT p FROM Pdf p WHERE p.id = :id"),
    @NamedQuery(name = "Pdf.findByFilename", query = "SELECT p FROM Pdf p WHERE p.filename = :filename"),
    @NamedQuery(name = "Pdf.findByFilesize", query = "SELECT p FROM Pdf p WHERE p.filesize = :filesize"),
    @NamedQuery(name = "Pdf.findByFiletype", query = "SELECT p FROM Pdf p WHERE p.filetype = :filetype")})
public class Pdf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
//    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "filesize")
    private long filesize;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "filetype")
    private String filetype;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "content")
    private byte[] content;

    public Pdf() {
    }

    public Pdf(Integer id) {
        this.id = id;
    }

    public Pdf(Integer id, String filename, long filesize, String filetype, byte[] content) {
        this.id = id;
        this.filename = filename;
        this.filesize = filesize;
        this.filetype = filetype;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
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
        if (!(object instanceof Pdf)) {
            return false;
        }
        Pdf other = (Pdf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pdf[ id=" + id + " ]";
    }
    
}
